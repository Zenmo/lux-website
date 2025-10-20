package com.zenmo.backend

import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.ObjectNode
import org.http4k.client.JavaHttpClient
import org.http4k.core.HttpHandler
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Uri
import org.http4k.format.Jackson
import org.http4k.routing.RoutingHttpHandler
import org.http4k.routing.bind
import org.http4k.routing.path
import org.http4k.security.openid.IdToken


fun AnyLogicProxy(idTokenProvider: (Request) -> IdToken?): RoutingHttpHandler {
    val httpClient = JavaHttpClient()
    val anylogicUpstream = Uri.of("https://anylogic.zenmo.com")

    fun injectTokenIfPresent(body: String, idToken: IdToken?): String? {
        if (idToken == null || body.isBlank()) return null

        val root = Jackson.parse(body) as ObjectNode
        val inputs = root.get("inputs") as? ArrayNode

        var tokenInjected = false
        inputs?.forEach { node ->
            if (node is ObjectNode && node.get("name")?.asText() == "p_userIdToken") {
                node.put("value", idToken.toString())
                tokenInjected = true
            }
        }

        return if (tokenInjected) Jackson.asFormatString(root) else null
    }

    val proxyHandler: HttpHandler = { req ->
        val path = req.path("path") ?: ""
        val targetUri = anylogicUpstream.path("/$path").query(req.uri.query)

        val forwardReq = when {
            req.method == Method.POST &&
                    path.matches(Regex("api/open/8\\.5\\.0/versions/[^/]+/runs/animation")) -> {
                val bodyWithToken = injectTokenIfPresent(req.bodyString(), idTokenProvider(req))
                if (bodyWithToken != null) {
                    req.uri(targetUri)
                        .header("Content-Type", "application/json")
                        .body(bodyWithToken)
                } else {
                    req.uri(targetUri)
                }
            }

            else -> req.uri(targetUri) // passthrough
        }

        httpClient(forwardReq)
    }

    return "/anylogic-proxy/{path:.*}" bind proxyHandler
}