package energy.lux.frontend.core.services

import androidx.compose.runtime.Composable
import energy.lux.frontend.core.services.anyLogicModels.ModelsViewModelProvider
import energy.lux.frontend.core.services.localization.LanguageProvider

@Composable
fun AppProviders(content: @Composable () -> Unit) {
    LanguageProvider {
        ModelsViewModelProvider {
            content()
        }
    }
}