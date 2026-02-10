package com.zenmo.backend

import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.ObjectNode
import org.http4k.client.JavaHttpClient
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Uri
import org.http4k.format.Jackson
import org.http4k.routing.RoutingHttpHandler
import org.http4k.routing.bind
import org.http4k.routing.path
import org.http4k.security.openid.IdToken


class AnyLogicProxy(
    private val idTokenProvider: (Request) -> IdToken?
) {
    private val httpClient = JavaHttpClient()
    private val anylogicUpstream = Uri.of("https://anylogic.zenmo.com")
    private val animationStartPathRegex = Regex("api/open/8\\.5\\.0/versions/[^/]+/runs/animation")

    fun routes(): RoutingHttpHandler {
        return "/anylogic-proxy/{path:.*}" bind ::proxyHandler
    }

    private fun proxyHandler(request: Request): Response {
        val path = request.path("path") ?: ""
        val targetUri = anylogicUpstream.path("/$path").query(request.uri.query)

        val forwardReq = when {
            request.method == Method.POST && path.matches(animationStartPathRegex) -> {
                val bodyWithToken = injectTokenAsInputParameter(request.bodyString(), idTokenProvider(request))
                request.uri(targetUri).body(bodyWithToken)
            }

            else -> request.uri(targetUri) // passthrough
        }

        return httpClient(forwardReq)
    }

    /**
     * Injects the user's ID token into the AnyLogic request body if needed.
     *
     * - Parses the JSON,
     * - finds the "inputs" array,
     * - and updates the value of item named "p_userIdToken" with the provided ID token.
     * - If no token or matching input exists, the body is returned unchanged.
     *
     * In short — it makes sure AnyLogic knows who’s running the model without breaking anything else.
     */
    private fun injectTokenAsInputParameter(body: String, idToken: IdToken?): String {
        if (idToken == null || body.isBlank()) {
            return body
        }

        val root = Jackson.parse(body) as ObjectNode
        val inputs = root.get("inputs") as? ArrayNode
            ?: throw IllegalStateException("AnyLogic request body missing 'inputs' array")

        var tokenInjected = false

        inputs.forEach { node ->
            if (node is ObjectNode && node.get("name")?.asText() == "p_userIdToken") {
                node.put("value", idToken.value)
                tokenInjected = true
            }
        }

        return if (tokenInjected) Jackson.asFormatString(root) else body
    }
}
