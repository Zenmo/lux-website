package com.zenmo.backend.anylogic

import com.anylogic.cloud.clients.client_8_5_0.AnyLogicCloudClient
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.ObjectNode
import com.zenmo.backend.Config
import com.zenmo.backend.keycloak.KeycloakAuthClient
import org.http4k.client.JavaHttpClient
import org.http4k.core.*
import org.http4k.format.Jackson
import org.http4k.routing.RoutingHttpHandler
import org.http4k.routing.bind
import org.http4k.routing.path
import org.http4k.security.AccessToken
import org.http4k.security.openid.IdToken

class AnyLogicProxy(
    private val idTokenProvider: (Request) -> IdToken?,
    private val accessTokenProvider: (Request) -> AccessToken?,
    private val keycloakAuthClient: KeycloakAuthClient,
    private val anylogicApiKey: String = Config().anylogicApiKey,
    private val anylogicCloudClient: AnyLogicCloudClient = AnyLogicCloudClient(Config().anylogicApiKey)
) {
    private val httpClient = JavaHttpClient()
    private val anylogicUpstream = Uri.of("https://anylogic.zenmo.com")
    private val animationStartPathRegex = Regex("api/open/8\\.5\\.0/versions/[^/]+/runs/animation")

    fun routes(): RoutingHttpHandler {
        return "/anylogic-proxy/{path:.*}" bind ::proxyHandler
    }

    private fun proxyHandler(request: Request): Response {
        val path = request.path("path") ?: return Response(Status.BAD_REQUEST).body("Missing path")

        val versionId = Regex("api/open/8\\.5\\.0/versions/([^/]+)/runs").find(path)
            ?.groupValues?.get(1)
            ?: return Response(Status.BAD_REQUEST).body("Missing version ID in path")

        val modelId = resolveModelId(versionId)
            ?: return Response(Status.BAD_REQUEST).body("Unable to resolve model ID for version $versionId")

        val accessToken = accessTokenProvider(request)

        // if access token exists, check authorization via Keycloak
        if (accessToken != null && !keycloakAuthClient.hasAccess(accessToken, modelId)) {
            return Response(Status.FORBIDDEN).body("Access denied to model $modelId")
        }

        val targetUri = anylogicUpstream.path("/$path").query(request.uri.query)

        val forwardReq = when {
            request.method == Method.POST && path.matches(animationStartPathRegex) -> {
                val bodyWithToken = injectTokenAsInputParameter(request.bodyString(), idTokenProvider(request))
                request
                    .uri(targetUri)
                    .header("Authorization", "Bearer $anylogicApiKey")
                    .header("Content-Type", "application/json")
                    .body(bodyWithToken)
            }

            else -> request.uri(targetUri)
                .header("Authorization", "Bearer $anylogicApiKey")
        }

        return httpClient(forwardReq)
    }


    /**
     * Resolves modelId from versionId by querying AnyLogic Cloud API
     */
    private fun resolveModelId(versionId: String): String? {
        return try {
            anylogicCloudClient.models.firstNotNullOfOrNull { model ->
                model.modelVersions.find { it == versionId }?.let { model.id }
            }
        } catch (e: Exception) {
            println("Error resolving modelId for version $versionId: ${e.message}")
            null
        }
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
                node.put("value", idToken.toString())
                tokenInjected = true
            }
        }

        return if (tokenInjected) Jackson.asFormatString(root) else body
    }
}