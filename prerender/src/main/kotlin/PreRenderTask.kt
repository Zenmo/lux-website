package energy.lux.prerender

import com.microsoft.playwright.BrowserContext
import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright
import com.microsoft.playwright.Route
import com.microsoft.playwright.options.LoadState
import energy.lux.prerender.impl.PlaywrightInstaller
import energy.lux.prerender.persistence.PagePersistence
import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.Nested
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction
import org.http4k.core.Uri
import org.http4k.core.relative
import org.jsoup.Jsoup
import java.io.File
import java.net.URI

/**
 * Renders pages in a headless browser and saves the resulting HTML.
 *
 * The site decides which (sub)domain to render from `window.location.host`,
 * so pages must be visited under their real host name.
 * When [staticDir] is set, requests for the hosts in [urls] (and their subdomains)
 * are answered from the built static files instead of the network,
 * and requests under [jsBaseUrl] are answered from [jsDir] (the Rollup output).
 * This means no web server or backend has to run during pre-rendering.
 *
 * Parts of this are copied from KobwebExportTask.
 */
abstract class PreRenderTask: DefaultTask() {
    /** Pages to render, e.g. `http://lux.localhost:8080/nl/` */
    @get:Input
    val urls: ListProperty<String> = project.objects.listProperty(String::class.java)

    /** Also render pages that are linked from rendered pages. */
    @get:Input
    val followLinks: Property<Boolean> = project.objects.property(Boolean::class.java).convention(true)

    /** Built static site (index.html and assets). */
    @get:Optional
    @get:InputDirectory
    @get:PathSensitive(PathSensitivity.RELATIVE)
    val staticDir: DirectoryProperty = project.objects.directoryProperty()

    /** Built JavaScript, normally served by the backend. */
    @get:Optional
    @get:InputDirectory
    @get:PathSensitive(PathSensitivity.RELATIVE)
    val jsDir: DirectoryProperty = project.objects.directoryProperty()

    /** The URL index.html loads the JavaScript from, i.e. BACKEND_URL. */
    @get:Optional
    @get:Input
    val jsBaseUrl: Property<String> = project.objects.property(String::class.java)

    /** Max milliseconds to wait for one page to finish rendering. */
    @get:Input
    val renderTimeoutMillis: Property<Long> = project.objects.property(Long::class.java).convention(20_000L)

    @get:OutputDirectory
    val outputDir: DirectoryProperty = project.objects.directoryProperty()

    @get:Nested
    val persistence: Property<PagePersistence> = project.objects.property(PagePersistence::class.java)

    /** Initialize in action() as per Gradle best practices */
    private lateinit var pagesDone: MutableSet<Uri>

    @TaskAction
    fun action() {
        pagesDone = mutableSetOf()
        val seeds = urls.get().map { Uri.of(it).normalized() }
        require(seeds.isNotEmpty()) { "No urls configured for $name" }

        PlaywrightInstaller().install()
        Playwright.create(
            Playwright.CreateOptions().setEnv(
                mapOf(
                    // Should have been downloaded above
                    "PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD" to "1"
                )
            )
        ).use { playwright ->
            // Use Firefox because running inlineProgrammaticStyles()
            // in Chromium produces @scope styles which are not supported in Firefox
            playwright.firefox().launch().use { browser ->
                browser.newContext().use { context ->
                    context.setDefaultTimeout(renderTimeoutMillis.get().toDouble())
                    serveBuildOutput(context, siteHosts = seeds.map { it.host }.toSet())
                    val page = context.newPage()
                    page.onPageError {
                        logger.error("Error while pre-rendering ${page.url()}. Probably something is wrong with the page. Details: $it")
                    }
                    seeds.forEach { render(page, it) }
                }
            }
        }

        logger.lifecycle("Pre-rendered ${pagesDone.size} page(s) into ${outputDir.get().asFile}")
    }

    private fun render(page: Page, url: Uri) {
        if (url in pagesDone) {
            return
        }

        logger.info("Pre-rendering $url")
        page.navigate(url.query("_kobwebIsExporting=true").toString())
        waitUntilRendered(page)

        // The page may have redirected client-side, e.g. / -> /nl/
        val finalUrl = Uri.of(page.url()).query("").fragment("").normalized()
        if (finalUrl != url) {
            logger.info("$url redirected to $finalUrl")
            pagesDone.add(url)
            if (finalUrl in pagesDone) {
                return
            }
        }

        inlineProgrammaticStyles(page)
        val parsedHtml = Jsoup.parse(page.content())
        persistence.get().save(finalUrl, parsedHtml.toString())
        pagesDone.add(finalUrl)

        if (!followLinks.get()) {
            return
        }

        parsedHtml.select("a[href]")
            .map { finalUrl.relative(it.attr("href")).fragment("").query("").normalized() }
            .distinct()
            .forEach { link ->
                if (link.shouldFollowLink(finalUrl) && link !in pagesDone) {
                    logger.info("Following $link from $finalUrl")
                    render(page, link)
                }
            }
    }

    /**
     * Wait until the app has rendered something other than a loading spinner.
     * Content is loaded lazily (LazyModule), so the load event fires too early.
     */
    private fun waitUntilRendered(page: Page) {
        page.waitForLoadState(LoadState.NETWORKIDLE)
        // language=javascript
        page.waitForFunction(
            """
                () => {
                    const root = document.getElementById("_kobweb-root")
                    // The test page has no kobweb root, it is rendered as soon as it loads
                    if (root == null) return true
                    return root.childElementCount > 0 && root.querySelector(".spinner") == null
                }
            """.trimIndent()
        )
    }

    /**
     * Answer requests for the site and its JavaScript from the build output,
     * so the browser sees the real host name without anything listening on it.
     * Other requests (fonts, CDNs) go to the network as usual.
     */
    private fun serveBuildOutput(context: BrowserContext, siteHosts: Set<String>) {
        val static = staticDir.orNull?.asFile ?: return
        val js = jsDir.orNull?.asFile
        val jsBase = jsBaseUrl.orNull?.trimEnd('/')

        context.route("**/*") { route ->
            val url = route.request().url()
            val uri = URI(url)
            when {
                js != null && jsBase != null && url.startsWith("$jsBase/") -> serveJs(route, js, uri)
                siteHosts.any { uri.host == it || uri.host.endsWith(".$it") } -> serveStatic(route, static, uri)
                else -> route.resume()
            }
        }
    }

    /** Like the Caddyfile: serve the file if it exists, else index.html. */
    private fun serveStatic(route: Route, root: File, uri: URI) {
        val file = resolveInside(root, uri.path)
        val target = if (file != null && file.isFile) file else File(root, "index.html")
        if (target != file && uri.path.substringAfterLast('/').contains('.')) {
            // a missing asset, not a page
            route.fulfill(Route.FulfillOptions().setStatus(404))
            return
        }
        route.fulfill(
            Route.FulfillOptions()
                .setStatus(200)
                .setContentType(contentType(target))
                .setBodyBytes(target.readBytes())
        )
    }

    /**
     * Serve the Rollup output like the backend does for public files.
     * Anything else under the backend URL (APIs, protected JS) gets a 404,
     * so pre-rendering always sees the site as an anonymous visitor.
     */
    private fun serveJs(route: Route, root: File, uri: URI) {
        val origin = route.request().headers()["origin"]
        val cors = buildMap {
            if (origin != null) {
                put("Access-Control-Allow-Origin", origin)
                put("Access-Control-Allow-Credentials", "true")
            }
        }
        if (route.request().method() == "OPTIONS") {
            route.fulfill(Route.FulfillOptions().setStatus(204).setHeaders(cors))
            return
        }
        val file = resolveInside(root, uri.path)
        if (file == null || !file.isFile || !(file.name.endsWith(".mjs") || file.name.endsWith(".mjs.map"))) {
            route.fulfill(Route.FulfillOptions().setStatus(404).setHeaders(cors))
            return
        }
        route.fulfill(
            Route.FulfillOptions()
                .setStatus(200)
                .setHeaders(cors)
                .setContentType(contentType(file))
                .setBodyBytes(file.readBytes())
        )
    }

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

    /**
     * Compose HTML creates empty style nodes and then adds styles to them programmatically.
     * These nodes would render as empty without this intervention.
     */
    private fun inlineProgrammaticStyles(page: Page) {
        // language=javascript
        page.evaluate(
            """
                for (let s = 0; s < document.styleSheets.length; s++) {
                    var stylesheet = document.styleSheets[s]
                    stylesheet = stylesheet instanceof CSSStyleSheet ? stylesheet : null;

                    // Trying to peek at external stylesheets causes a security exception so step over them
                    if (stylesheet != null && stylesheet.href == null) {
                        var styleNode = stylesheet.ownerNode
                        styleNode = styleNode instanceof Element ? styleNode : null
                        if (styleNode != null && styleNode.innerHTML == '') {
                            const rules = []
                            for (let r = 0; r < stylesheet.cssRules.length; ++r) {
                                rules.push(stylesheet.cssRules[r].cssText.replace(/(\n)/gm, ''))
                            }
                            styleNode.innerHTML = rules.join('')
                        }
                    }
                }
            """.trimIndent()
        )
    }

    private fun Uri.shouldFollowLink(originPage: Uri): Boolean {
        if (this == originPage) {
            return false
        }

        // Ignore download links
        if (hasFileExtension()) {
            return false
        }

        // Ignore mailto links etc
        if (originPage.scheme != scheme) {
            return false
        }

        if (originPage.host == host) {
            return true
        }

        if (isSubdomain(originPage)) {
            return true
        }

        return false
    }

    /** Browsers report http://host as http://host/ */
    private fun Uri.normalized(): Uri = if (path.isEmpty()) path("/") else this

    private fun Uri.hasFileExtension(): Boolean =
        path.substringAfterLast('/').contains('.')

    private fun Uri.isSubdomain(origin: Uri) =
        host.endsWith(origin.host)
}
