package com.zenmo.web.zenmo.protected

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.AppGlobals
import com.zenmo.web.zenmo.components.widgets.ErrorWidget
import com.zenmo.web.zenmo.core.services.localization.LanguageManager
import js.import.importAsync
import web.http.RequestCredentials
import web.http.RequestInit
import web.http.fetch

external interface PrivateTextModule {
    @Composable
    fun ProtectedComponent()
}

sealed class AccessStatus {
    data object Pending : AccessStatus()
    data object NotLoggedIn : AccessStatus()
    data object NotEnoughPrivileges : AccessStatus()
    data class Error(val errorMessage: String) : AccessStatus()
    data object Success : AccessStatus()
}

@Composable
fun ProtectedWrapper(
    entryPoint: String,
    fallbackContent: @Composable (AccessStatus) -> Unit = {
        when (it) {
            AccessStatus.Pending -> Pending()
            AccessStatus.NotLoggedIn -> Login()
            AccessStatus.NotEnoughPrivileges -> NotEnoughPrivileges()
            is AccessStatus.Error -> {
                ErrorWidget(errorMessage = it.errorMessage)
            }

            AccessStatus.Success -> {} // does not happen here, self-contained in the module
        }
    }
) {
    var privateModule by remember { mutableStateOf<PrivateTextModule?>(null) }
    var status by remember { mutableStateOf<AccessStatus>(AccessStatus.Pending) }

    LaunchedEffect(Unit) {
        try {
            privateModule =
                importAsync<PrivateTextModule>("./entrypoints/$entryPoint/ProtectedComponent.export.mjs").await()
            status = AccessStatus.Success
        } catch (e: Throwable) {
            /**
             * We get no status code after import failure.
             * To determine the status code, we do the same request again using AJAX.
             */
            val fileName = e.message?.substringAfterLast('/')
            if (fileName == null) {
                status = AccessStatus.Error(
                    LanguageManager.language.value.translate(
                        en = "Failed to load module.",
                        nl = "Kon de module niet laden."
                    )
                )
                return@LaunchedEffect
            }

            try {
                val response = fetch(
                    AppGlobals.getValue("BACKEND_URL") + "/" + fileName, RequestInit(
                        credentials = RequestCredentials.include
                    )
                )
                status = when (response.status.toInt()) {
                    401 -> AccessStatus.NotLoggedIn
                    403 -> AccessStatus.NotEnoughPrivileges
                    else -> AccessStatus.Error(
                        LanguageManager.language.value.translate(
                            en = "An error occurred while accessing module.",
                            nl = "Er is een fout opgetreden bij het openen van de module."
                        )
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
        when (status) {
            AccessStatus.Success -> privateModule!!.ProtectedComponent()
            else -> fallbackContent(status)
        }
    }
}
