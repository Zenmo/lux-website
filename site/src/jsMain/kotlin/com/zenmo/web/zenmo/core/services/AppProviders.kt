package com.zenmo.web.zenmo.core.services

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.core.services.localization.LanguageProvider

@Composable
fun AppProviders(content: @Composable () -> Unit) {
    LanguageProvider {
        ModelsViewModelProvider {
            content()
        }
    }
}