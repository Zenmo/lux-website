package energy.lux.frontend.domains.zenmo.widgets.orchestrator

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.BoxShadow
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.autoLength
import com.varabyte.kobweb.compose.dom.ref
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.AppGlobals
import com.varabyte.kobweb.core.isExporting
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.widgets.LoadingSpinner
import energy.lux.frontend.components.widgets.registerPageUnloadHandlers
import energy.lux.frontend.domains.lux.widgets.headings.SubHeaderText
import energy.lux.frontend.domains.zenmo.widgets.button.PrimaryButton
import js.objects.unsafeJso
import js.promise.catch
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLElement

val OrchestratorEmbedWrapperStyle = CssStyle {
    base {
        Modifier
            .width(100.percent)
            .alignSelf(AlignSelf.Stretch)
            .padding(leftRight = 0.5.cssRem)
    }
}

val OrchestratorEmbedStyle = CssStyle {
    base {
        Modifier
            .aspectRatio(8, 5)
            .maxWidth(100.percent)
            // Reserve space for the site header.
            .maxHeight(80.vh)
            // Center if it is less wide than the parent.
            .margin(leftRight = autoLength)
            .boxShadow(
                BoxShadow.of(0.px, 4.px, 8.px, 0.px, rgba(0, 0, 0, 0.2f)),
                BoxShadow.of(0.px, 6.px, 20.px, 0.px, rgba(0, 0, 0, 0.19f))
            )
    }
}

/**
 * The element the model renders into. Compose never adds children to it, because the model owns its content.
 */
val OrchestratorModelMountStyle = CssStyle {
    base {
        Modifier
            .fillMaxSize()
            .position(Position.Relative)
            .overflow(Overflow.Auto)
            // Models use `position: fixed` for maps and panels. A transform makes this element
            // their containing block, so they stay inside the frame instead of covering the page.
            .styleModifier {
                property("transform", "translateZ(0)")
                // LUX models size their window from these variables.
                property("--lux-window-w", "100%")
                property("--lux-window-h", "100%")
            }
    }
}

enum class OrchestratorModelStatus {
    IDLE,
    LOADING,
    RUNNING,
    ENDED,
    /** The model is private and nobody is logged in to the orchestrator from this site */
    LOGIN_REQUIRED,
    /** The Keycloak login popup is open */
    LOGGING_IN,
    /** The user is logged in but may not run this model */
    FORBIDDEN,
    FAILED,
}

/**
 * Run a model on the LUX Orchestrator and show its user interface on this page.
 *
 * The orchestrator starts a container for the model while it is shown. The session is ended
 * when this component leaves the page or the user closes the tab, which stops the container.
 *
 * Private models need a login on the orchestrator. When the orchestrator asks for one,
 * a button opens the Keycloak login popup and the model is started again afterwards.
 *
 * @param modelId Model identifier as configured in the orchestrator, usually the container image name
 * @param versionId Model version as configured in the orchestrator, usually the image tag
 * @param orchestratorUrl Base URL of the orchestrator for the current environment
 */
@Composable
fun OrchestratorModelEmbed(
    modelId: String,
    versionId: String,
    orchestratorUrl: String = AppGlobals.getValue("ORCHESTRATOR_URL"),
    modifier: Modifier = Modifier,
) {
    var mountElement by remember { mutableStateOf<HTMLElement?>(null) }
    var status by remember { mutableStateOf(OrchestratorModelStatus.IDLE) }
    // Incremented to start the model again, for example after logging in.
    var startAttempt by remember { mutableStateOf(0) }

    DisposableEffect(modelId, versionId, orchestratorUrl, mountElement, startAttempt) {
        val element = mountElement ?: return@DisposableEffect onDispose {}
        // The prerender task opens every public page in a browser. Don't start a container for it.
        if (AppGlobals.isExporting) return@DisposableEffect onDispose {}

        var activeSession: ActiveModelSession? = null
        // Starting a model takes a while. When the user has left before it is ready,
        // end the session as soon as it arrives so the container doesn't keep running.
        var isDisposed = false

        status = OrchestratorModelStatus.LOADING
        startModelSession(unsafeJso {
            this.orchestratorUrl = orchestratorUrl
            this.modelId = modelId
            this.versionId = versionId
            this.element = element
            onSessionEnded = { status = OrchestratorModelStatus.ENDED }
        }).then { startedSession ->
            if (isDisposed) {
                startedSession.endSession()
            } else {
                activeSession = startedSession
                status = OrchestratorModelStatus.RUNNING
            }
        }.catch { error ->
            if (isDisposed) return@catch
            status = when (httpStatusOf(error)) {
                401 -> OrchestratorModelStatus.LOGIN_REQUIRED
                403 -> OrchestratorModelStatus.FORBIDDEN
                else -> {
                    console.error("Failed to start model $modelId $versionId on the orchestrator", error)
                    OrchestratorModelStatus.FAILED
                }
            }
        }

        val removePageUnloadHandlers = registerPageUnloadHandlers {
            activeSession?.endSession()
        }

        onDispose {
            isDisposed = true
            removePageUnloadHandlers()
            activeSession?.endSession()
        }
    }

    Div(attrs = OrchestratorEmbedWrapperStyle.toModifier().toAttrs()) {
        // Box stacks its children, so the status message is shown on top of the model's area.
        Box(
            modifier = OrchestratorEmbedStyle.toModifier().then(modifier),
            contentAlignment = Alignment.Center,
        ) {
            Box(
                modifier = OrchestratorModelMountStyle.toModifier(),
                ref = ref { mountElement = it },
            )
            when (status) {
                OrchestratorModelStatus.IDLE, OrchestratorModelStatus.RUNNING -> Unit
                OrchestratorModelStatus.LOADING -> LoadingSpinner()
                OrchestratorModelStatus.ENDED -> SubHeaderText(
                    enText = "The simulation has ended. Reload the page to start again.",
                    nlText = "De simulatie is beëindigd. Herlaad de pagina om opnieuw te starten.",
                )
                OrchestratorModelStatus.LOGIN_REQUIRED, OrchestratorModelStatus.LOGGING_IN -> LoginPrompt(
                    isLoggingIn = status == OrchestratorModelStatus.LOGGING_IN,
                    onLoginClick = {
                        status = OrchestratorModelStatus.LOGGING_IN
                        loginWithKeycloakPopup(orchestratorUrl).then {
                            startAttempt++
                        }.catch { error ->
                            // Also happens when the user closes the popup.
                            console.warn("Login to the orchestrator did not complete", error)
                            status = OrchestratorModelStatus.LOGIN_REQUIRED
                        }
                    },
                )
                OrchestratorModelStatus.FORBIDDEN -> SubHeaderText(
                    enText = "You don't have access to this model.",
                    nlText = "Je hebt geen toegang tot dit model.",
                )
                OrchestratorModelStatus.FAILED -> SubHeaderText(
                    enText = "Failed to load model",
                    nlText = "Laden van model mislukt",
                )
            }
        }
    }
}

@Composable
private fun LoginPrompt(isLoggingIn: Boolean, onLoginClick: () -> Unit) {
    Column(
        modifier = Modifier.gap(1.cssRem).padding(1.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SubHeaderText(
            enText = "Log in to start this model.",
            nlText = "Log in om dit model te starten.",
        )
        PrimaryButton(
            enText = "Log in",
            nlText = "Inloggen",
            enabled = !isLoggingIn,
            // The popup must be opened from the click, otherwise the browser blocks it.
            onClick = { onLoginClick() },
        )
    }
}

/**
 * The HTTP status of a failed [startModelSession], or null when it failed for another reason.
 *
 * The client library only puts the status in the error message, as "(HTTP 401)".
 * Replace this when the library exposes the status itself.
 */
private fun httpStatusOf(error: Any?): Int? {
    val message = error?.asDynamic()?.message as? String ?: return null
    return Regex("""\(HTTP (\d{3})\)""").find(message)?.groupValues?.get(1)?.toInt()
}
