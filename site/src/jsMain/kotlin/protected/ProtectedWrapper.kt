package energy.lux.frontend.protected

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.AppGlobals
import energy.lux.frontend.components.widgets.ErrorWidget
import energy.lux.frontend.core.services.localization.LanguageManager
import js.import.importAsync
import web.http.RequestCredentials
import web.http.RequestInit
import web.http.fetch

typealias ProtectedComponent<P> = @Composable (props: P) -> Unit

external interface PrivateTextModule<P> {
    val ProtectedComponent: ProtectedComponent<P>
}

sealed class AccessStatus<out P> {
    data object Pending : AccessStatus<Nothing>()
    data object NotLoggedIn : AccessStatus<Nothing>()
    data object NotEnoughPrivileges : AccessStatus<Nothing>()
    data class Error(val errorMessage: String) : AccessStatus<Nothing>()
    data class Success<P>(val protectedComponent: ProtectedComponent<P>, val props: P) : AccessStatus<P>()
}

typealias ProtectedDisplayComponent<P> = @Composable (
    status: AccessStatus<P>
) -> Unit

@Composable
fun <P> DefaultProtectedDisplay(status: AccessStatus<P>) {
    when (status) {
        AccessStatus.Pending -> Pending()
        AccessStatus.NotLoggedIn -> Login()
        AccessStatus.NotEnoughPrivileges -> NotEnoughPrivileges()
        is AccessStatus.Error -> {
            ErrorWidget(errorMessage = status.errorMessage)
        }
        is AccessStatus.Success -> {
            status.protectedComponent(status.props)
        }
    }
}

@Composable
fun <P> ProtectedWrapper(
    entryPoint: String,
    props: P,
    display: ProtectedDisplayComponent<P> = { DefaultProtectedDisplay(it) }
) {
    var status by remember { mutableStateOf<AccessStatus<P>>(AccessStatus.Pending) }

    LaunchedEffect(Unit) {
        try {
            val entryPointParts = entryPoint.split("/")
            val privateModule =
                when (entryPointParts.size) {
                    2 -> importAsync<PrivateTextModule<P>>("./entrypoints/${entryPointParts[0]}/${entryPointParts[1]}/ProtectedComponent.export.mjs").await()
                    3 -> importAsync<PrivateTextModule<P>>("./entrypoints/${entryPointParts[0]}/${entryPointParts[1]}/${entryPointParts[2]}/ProtectedComponent.export.mjs").await()
                    else -> importAsync<PrivateTextModule<P>>("./entrypoints/$entryPoint/ProtectedComponent.export.mjs").await()
                }
            status = AccessStatus.Success(
                protectedComponent = privateModule.ProtectedComponent,
                props = props
            )
        } catch (e: Throwable) {
            val resolvedModule = getModuleNameFromException(e)
            /**
             * We get no status code after import failure.
             * To determine the status code, we do the same request again using AJAX.
             */
            if (resolvedModule == null) {
                status = AccessStatus.Error(
                    LanguageManager.language.value.translate(
                        en = "Error when doing dynamic import of module. Details: ${e.message}",
                        nl = "Fout bij dynamische import van de module. Details: ${e.message}"
                    )
                )
                return@LaunchedEffect
            }

            try {
                val response = fetch(
                    AppGlobals.getValue("BACKEND_URL") + "/" + resolvedModule, RequestInit(
                        credentials = RequestCredentials.include
                    )
                )
                status = when (response.status.toInt()) {
                    401 -> AccessStatus.NotLoggedIn
                    403 -> AccessStatus.NotEnoughPrivileges
                    else -> AccessStatus.Error(
                        LanguageManager.language.value.translate(
                            en = "An error occurred while doing dynamic import of $resolvedModule.",
                            nl = "Er is een fout opgetreden bij de dynamic import $resolvedModule."
                        ) + " HTTP status ${response.status}. Import message: ${e.message}"
                    )
                }
            } catch (e: Throwable) {
                status = AccessStatus.Error(
                    LanguageManager.language.value.translate(
                        en = e.message,
                        nl = e.message
                    )
                )
            }
        }
    }

    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        display(status)
    }
}

fun getModuleNameFromException(e: Throwable): String? {
    /**
     * `resolvedModule` is the module name after bundling.
     * It is set through rollup.config.mjs
     */
    var resolvedModule: String? = e.asDynamic().resolvedModule
    if (resolvedModule == null && e.message != null) {
        // Fallback to get the module name from the error message.
        // Does not work in Safari.
        val regex = Regex("[^/]*\\.mjs")
        resolvedModule = regex.find(e.message ?: "")?.value
    }
    return resolvedModule
}
