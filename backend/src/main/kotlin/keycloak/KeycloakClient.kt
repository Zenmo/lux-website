package com.zenmo.backend.keycloak

import com.zenmo.backend.Config
import org.http4k.security.AccessToken
import org.keycloak.authorization.client.AuthzClient
import org.keycloak.authorization.client.Configuration
import org.keycloak.representations.idm.authorization.AuthorizationRequest

class KeycloakAuthClient(
    serverUrl: String = "https://keycloak.zenmo.com",
    realm: String = "zenmo",
    clientId: String = Config().clientId, // maybe im wrong
    clientSecret: String = Config().clientSecret
) {
    private val authzClient: AuthzClient

    init {
        val config = Configuration(
            serverUrl,
            realm,
            clientId,
            mapOf("secret" to clientSecret),
            null
        )
        authzClient = AuthzClient.create(config)
    }


    fun hasAccess(accessToken: AccessToken, modelResourceId: String): Boolean {
        return try {
            val request = AuthorizationRequest().apply {
                addPermission(modelResourceId)
            }
            val response = authzClient.authorization(accessToken.value).authorize(request)
            response.token != null
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}