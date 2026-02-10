package com.zenmo.backend

import com.zenmo.backend.contact.ContactController
import com.zenmo.backend.contact.MailService
import com.zenmo.backend.js.JsServer
import com.zenmo.backend.js.JsServerFilter
import org.http4k.core.Filter
import org.http4k.core.HttpHandler
import org.http4k.core.Request
import org.http4k.core.then
import org.http4k.filter.DebuggingFilters
import org.http4k.filter.ServerFilters
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.Undertow
import org.http4k.server.asServer

fun main() {
    startServer()
}

fun startServer() {
    val config = Config()

    val oAuthSessions = InMemorySessionOAuthPersistence()
    val oAuthRoutes = OAuthHandler(
        baseUrl = config.baseUrl,
        clientId = config.clientId,
        clientSecret = config.clientSecret,
        oAuthSessions,
    )

    val contactRoute = routes(
        "/api/contact" bind org.http4k.core.Method.POST to ContactController(MailService.create(config))::handler,
    )

    val idTokenRoute = IdTokenController(oAuthSessions).route()

    val anyLogicProxyRoutes = AnyLogicProxy(oAuthSessions::retrieveIdToken).routes()

    val app: HttpHandler = printShortAccessLog
        .then(corsFilter)
        // Catch errors must come after CORS Filter
        // so that the error reaches the client
        .then(ServerFilters.CatchAll())
        .then(
            JsServerFilter(
                JsServer.create(config, oAuthSessions)
            )
        )
        .then(
            routes(
                oAuthRoutes,
                contactRoute,
                anyLogicProxyRoutes,
                idTokenRoute,
            )
        )

    val port = config.port
    val server = app.asServer(Undertow(port)).start()
    println("Listening on port $port")
}

/**
 * Logs a short line for every request like "200 GET /main.mjs"
 */
val printShortAccessLog: Filter = Filter { next -> { request: Request ->
        val response = next(request)
        val statusCode = response.status.code
        val method = request.method.name
        val path = request.uri.path

        println("$statusCode $method $path")
        response
    }
}

