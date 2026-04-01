package energy.lux.frontend.domains.lux.widgets

import androidx.compose.runtime.Composable
import energy.lux.frontend.core.services.localization.LocalLanguage
import kotlin.js.Date

@Composable
fun Date.localizedDateText(
    options: Date.LocaleOptions = js("{month: 'short', year: 'numeric'}")
): String {
    val currentLanguage = LocalLanguage.current
    return this.toLocaleString(currentLanguage.shortCode, options)
}