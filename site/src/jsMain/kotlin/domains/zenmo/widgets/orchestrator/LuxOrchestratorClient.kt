@file:JsModule("@zenmo/lux-orchestrator-client")

package energy.lux.frontend.domains.zenmo.widgets.orchestrator

import js.promise.Promise
import org.w3c.dom.HTMLElement

/**
 * Kotlin declarations for the LUX Orchestrator client library. Incomplete: only what this site uses.
 *
 * The orchestrator runs LUX models in containers. This library starts a session for a model
 * and mounts the model's user interface into an element on our page.
 *
 * Logging in uses a cookie the orchestrator sets, so there is no access token to pass along.
 *
 * See https://github.com/Zenmo/lux-orchestrator/tree/main/client-library
 */
external fun startModelSession(options: StartModelSessionOptions): Promise<ActiveModelSession>

external interface StartModelSessionOptions {
    /** Base URL of the orchestrator, for example https://orchestrator.lux.energy */
    var orchestratorUrl: String

    /** Model identifier as configured in the orchestrator, usually the container image name */
    var modelId: String
    var versionId: String

    /** Element that the model renders its user interface into */
    var element: HTMLElement

    /** Called after the session has been ended, for example by a button inside the model */
    var onSessionEnded: (() -> Unit)?
}

external interface ActiveModelSession {
    val sessionId: String

    /** URL on the orchestrator that proxies requests to this session's container */
    val baseUrl: String

    /** Remove the model's user interface and stop its container on the orchestrator. */
    fun endSession(): Promise<Nothing?>

    /** Remove the model's user interface but leave the container running. */
    fun unmount()
}

/**
 * User logged in to the orchestrator. The login is stored in a cookie that is
 * only sent from this site, so a login on another site does not count here.
 */
external interface AuthenticatedUserSession {
    val subject: String
    val username: String
    val name: String?
    val givenName: String?
    val familyName: String?
    val email: String?
}

/** Resolves to the logged in user, or to null when nobody is logged in to the orchestrator from this site. */
external fun fetchAuthenticatedUserSession(orchestratorUrl: String): Promise<AuthenticatedUserSession?>

/**
 * Open a Keycloak login popup and log in to the orchestrator.
 * Call this directly from a click handler, otherwise the browser blocks the popup.
 */
external fun loginWithKeycloakPopup(orchestratorUrl: String): Promise<AuthenticatedUserSession>

external fun logoutOrchestratorSession(orchestratorUrl: String): Promise<Nothing?>
