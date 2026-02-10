package com.zenmo.backend

import org.http4k.core.Method
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.core.Status.Companion.UNAUTHORIZED
import org.http4k.routing.RoutingHttpHandler
import org.http4k.routing.bind

/**
 * Quick debug endpoint to get your own ID token.
 * To be replaced with a more comprehensive solution to get full profile information.
 *
 * TODO: move to UserInfoController
 */
class IdTokenController(
    private val oAuthSessions: InMemorySessionOAuthPersistence
) {
    fun route(): RoutingHttpHandler {
        return "/my-id-token" bind Method.GET to { request ->
            val token = this.oAuthSessions.retrieveIdToken(request)
            if (token == null) {
                Response(UNAUTHORIZED)
            } else {
                Response(OK).body(token.value)
            }
        }
    }
}
