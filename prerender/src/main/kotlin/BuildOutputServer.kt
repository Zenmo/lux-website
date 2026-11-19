package energy.lux.prerender

import com.microsoft.playwright.BrowserContext
import com.microsoft.playwright.Request
import com.microsoft.playwright.Route
import java.io.File
import java.net.URI

/**
 * Answers the browser's requests from the build output, so no web server or backend has to run.
 *
 * Why not a web server: the site picks the domain from the host name, so every page must be opened
 * under its real host (lux.energy, oss.lux.energy, zenmo.com, ...). A web server would need all
 * those host names to point to it, through DNS or /etc/hosts. Only *.localhost does that
 * by itself, and the real domains point to the live site. Answering inside the browser works for any
 * host name, with nothing to set up, and the backend does not have to run either.
 *
 * - Requests for a site host (and its subdomains) get the static site, like the Caddyfile.
 * - Requests under [jsBaseUrl] get the JavaScript, like the backend does for a visitor who is not logged in:
 *   public chunks are served, protected chunks get 401, anything else (APIs) gets 404.
 * - Everything else (fonts, CDNs) goes to the network as usual.
 */
class BuildOutputServer(
    private val staticDir: File,
    private val jsDir: File,
    jsBaseUrl: String,
    private val publicChunks: PublicChunks = PublicChunks(),
    private val log: (String) -> Unit = {},
) {
    private val jsBaseUrl = jsBaseUrl.trimEnd('/')
    private val siteHosts = mutableSetOf<String>()

    fun addSiteHosts(hosts: Collection<String>) {
        siteHosts += hosts
    }

    fun installOn(context: BrowserContext) {
        context.route("**/*") { route ->
            val url = route.request().url()
            // Some third-party URLs are not valid for java.net.URI, e.g. Google Fonts uses '|'
            val uri = runCatching { URI(url) }.getOrNull()
            when {
                uri == null -> route.resume()
                url.startsWith("$jsBaseUrl/") -> serveJs(route, uri)
                isSiteHost(uri.host) -> serveStatic(route, uri)
                else -> route.resume()
            }
        }
    }

    private fun isSiteHost(host: String) =
        siteHosts.any { host == it || host.endsWith(".$it") }

    /** Serve the file if it exists, otherwise index.html (the app routes on the client). */
    private fun serveStatic(route: Route, uri: URI) {
        val file = resolveInside(staticDir, uri.path)
        if (file != null && file.isFile) {
            route.fulfill(ok(file))
            return
        }
        val looksLikeAsset = uri.path.substringAfterLast('/').contains('.')
        if (looksLikeAsset) {
            route.fulfill(Route.FulfillOptions().setStatus(404))
            return
        }
        route.fulfill(ok(File(staticDir, "index.html")))
    }

    private fun serveJs(route: Route, uri: URI) {
        val cors = corsHeaders(route.request())
        if (route.request().method() == "OPTIONS") {
            route.fulfill(Route.FulfillOptions().setStatus(204).setHeaders(cors))
            return
        }

        val file = resolveInside(jsDir, uri.path)
        val isJsOrSourceMap = file != null && file.isFile && (file.name.endsWith(".mjs") || file.name.endsWith(".mjs.map"))
        if (!isJsOrSourceMap) {
            route.fulfill(Route.FulfillOptions().setStatus(404).setHeaders(cors))
            return
        }

        val chunk = File(file.path.removeSuffix(".map"))
        if (!publicChunks.isPublic(chunk)) {
            log("Not serving protected ${chunk.name}")
            route.fulfill(Route.FulfillOptions().setStatus(401).setHeaders(cors))
            return
        }
        route.fulfill(ok(file).setHeaders(cors))
    }

    /** The site and the JavaScript are on different hosts, and the site sends credentials. */
    private fun corsHeaders(request: Request): Map<String, String> {
        val origin = request.headers()["origin"] ?: return emptyMap()
        return mapOf(
            "Access-Control-Allow-Origin" to origin,
            "Access-Control-Allow-Credentials" to "true",
        )
    }

    private fun ok(file: File) = Route.FulfillOptions()
        .setStatus(200)
        .setContentType(contentType(file))
        .setBodyBytes(file.readBytes())

    /** Null if the path points outside [root], e.g. with "../". */
    private fun resolveInside(root: File, path: String): File? {
        val file = File(root, path.removePrefix("/")).canonicalFile
        return if (file.toPath().startsWith(root.canonicalFile.toPath())) file else null
    }

    private fun contentType(file: File): String = when (file.extension.lowercase()) {
        "html" -> "text/html; charset=utf-8"
        "mjs", "js" -> "text/javascript; charset=utf-8"
        "map", "json" -> "application/json"
        "css" -> "text/css; charset=utf-8"
        "svg" -> "image/svg+xml"
        "png" -> "image/png"
        "jpg", "jpeg" -> "image/jpeg"
        "webp" -> "image/webp"
        "gif" -> "image/gif"
        "ico" -> "image/x-icon"
        "woff2" -> "font/woff2"
        "woff" -> "font/woff"
        "ttf" -> "font/ttf"
        "mp4" -> "video/mp4"
        "webm" -> "video/webm"
        else -> "application/octet-stream"
    }
}