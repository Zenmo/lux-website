package com.zenmo.server.js

import com.zenmo.server.Config
import com.zenmo.server.InMemorySessionOAuthPersistence
import com.zenmo.server.JavaScriptFileSource
import com.zenmo.server.decode
import com.zenmo.server.js.loader.CachingJsLoader
import com.zenmo.server.js.loader.DefaultJsLoader
import com.zenmo.server.js.loader.JsLoader
import com.zenmo.server.js.loader.JsResult
import com.zenmo.server.js.loader.JsResultGeneric
import energy.lux.site.shared.AccessPolicy
import org.http4k.core.Filter
import org.http4k.core.HttpHandler
import org.http4k.core.Request
import java.time.format.DateTimeFormatter.RFC_1123_DATE_TIME
import java.time.ZoneOffset
import org.http4k.core.Response
import org.http4k.core.Status.Companion.FORBIDDEN
import org.http4k.core.Status.Companion.NOT_FOUND
import org.http4k.core.Status.Companion.NOT_MODIFIED
import org.http4k.core.Status.Companion.OK
import org.http4k.core.Status.Companion.UNAUTHORIZED
import org.http4k.routing.ResourceLoader
import java.net.URL

/**
 * Serve JS files or else pass to the next handler.
 */
class JsServerFilter(
    private val jsServer: JsServer,
): Filter {
    override fun invoke(next: HttpHandler): HttpHandler = { request ->
        val path = request.uri.path
        if (path.endsWith(".mjs") || path.endsWith(".mjs.map")) {
            jsServer(request)
        } else {
            next(request)
        }
    }
}

/**
 * Check if the user is allowed to access the JavaScript file and serve it if so.
 * Does not check user roles yet.
 */
class JsServer(
    val jsLoader: JsLoader,
    val resourceLoader: ResourceLoader,
    val oAuthSessions: InMemorySessionOAuthPersistence,
    val clientId: String,
): HttpHandler {
    companion object {
        fun create(config: Config, oAuthSessions: InMemorySessionOAuthPersistence): JsServer {
            val resourceLoader = when (config.javaScriptFileSource) {
                JavaScriptFileSource.CLASSPATH -> ResourceLoader.Classpath()
                JavaScriptFileSource.DIRECTORY -> ResourceLoader.Directory("../site/build/rollup")
            }

            val jsLoader = DefaultJsLoader(resourceLoader)
            val cachingJsLoader = CachingJsLoader(resourceLoader, jsLoader)

            return JsServer(
                jsLoader = cachingJsLoader,
                resourceLoader = resourceLoader,
                oAuthSessions = oAuthSessions,
                clientId = config.clientId,
            )
        }
    }

    override fun invoke(request: Request): Response {
        val path = request.uri.path.removePrefix("/")
        val jsPath = path.removeSuffix(".map")
        val jsResult = jsLoader.load(jsPath)
        if (jsResult == null) {
            return Response(NOT_FOUND).header("Content-Type", "text/javascript")
        }

        if (request.header("If-None-Match") == jsResult.eTag) {
            return Response(NOT_MODIFIED)
        }

        return when (jsResult.accessPolicy) {
            is AccessPolicy.Public -> serveAllowedFile(jsResult, path)
            is AccessPolicy.RoleBased -> serveProtectedFile(request, jsResult as JsResultGeneric<AccessPolicy.RoleBased>)
        }
    }

    private fun serveProtectedFile(request: Request, jsResult: JsResultGeneric<AccessPolicy.RoleBased>): Response {
        val idToken = oAuthSessions.retrieveIdToken(request)
        if (idToken == null) {
            return Response(UNAUTHORIZED).header("Content-Type", "text/javascript")
        }

        val userRoles = idToken.decode().getRoles(clientId)
        println("User roles: $userRoles")
        return if (jsResult.accessPolicy.requiredRole in userRoles) {
            serveAllowedFile(jsResult, request.uri.path)
        } else {
            Response(FORBIDDEN).header("Content-Type", "text/javascript")
        }
    }

    private fun serveAllowedFile(jsResult: JsResult, path: String): Response {
        val isSourceMap = path.endsWith(".map")
        return if (isSourceMap) {
            serveAllowedSourceMap(path)
        } else {
            serveAllowedJs(jsResult)
        }
    }

    /**
     * Serve the source map after determining the access is allowed.
     */
    private fun serveAllowedSourceMap(path: String): Response {
        val resource = resourceLoader.load(path)
        if (resource == null) {
            return Response(NOT_FOUND)
        }

        return Response(OK)
            .header("Content-Type", "application/json")
            .body(resource.openStream())
    }

    /**
     * Serve the JavaScript after determining the access is allowed.
     */
    private fun serveAllowedJs(jsResult: JsResult): Response {
        return Response(OK)
            .header("Content-Type", "text/javascript")
            .header("ETag", jsResult.eTag)
            .header(
                "Last-Modified",
                RFC_1123_DATE_TIME.format(
                    jsResult.lastModified.atOffset(ZoneOffset.UTC)
                )
            )
            .body(jsResult.content.inputStream())
    }
}

