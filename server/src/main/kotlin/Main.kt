package com.zenmo.server

import com.zenmo.server.contact.ContactController
import com.zenmo.server.contact.MailService
import com.zenmo.server.js.JsServer
import com.zenmo.server.js.JsServerFilter
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
        .then(routes(oAuthRoutes, contactRoute))

    val port = 9000
    val server = app.asServer(Undertow(port)).start()
    println("Listening on port $port")
}

