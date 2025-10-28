package com.zenmo.backend

import com.zenmo.backend.contact.ContactController
import com.zenmo.backend.contact.MailService
import com.zenmo.backend.js.JsServer
import com.zenmo.backend.js.JsServerFilter
import org.http4k.core.HttpHandler
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

    val anyLogicProxyRoutes = AnyLogicProxy(oAuthSessions::retrieveIdToken).routes()

    val app: HttpHandler = DebuggingFilters.PrintRequestAndResponse()
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
            )
        )

    val port = config.port
    val server = app.asServer(Undertow(port)).start()
    println("Listening on port $port")
}

