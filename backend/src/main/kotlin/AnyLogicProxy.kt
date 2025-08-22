package com.zenmo.backend

import org.http4k.client.JavaHttpClient
import org.http4k.core.HttpHandler
import org.http4k.core.Uri
import org.http4k.routing.RoutingHttpHandler
import org.http4k.routing.bind
import org.http4k.routing.path
import org.http4k.routing.routes

fun AnyLogicProxy(): RoutingHttpHandler {
    val httpClient = JavaHttpClient()

    val anylogicUpstream = Uri.of("https://anylogic.zenmo.com")

    val proxyHandler: HttpHandler = { req ->

        val path = req.path("path") ?: ""
        val targetUri = anylogicUpstream.path("/$path").query(req.uri.query)

        httpClient(req.uri(targetUri))
    }

    return routes(
        "/anylogic-proxy/{path:.*}" bind proxyHandler
    )
}
