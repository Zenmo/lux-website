package energy.lux.frontend.components.widgets.navbar_actions

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.scale
import energy.lux.frontend.core.services.localization.Language
import energy.lux.frontend.core.services.localization.LanguageManager
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.zenmo.sections.nav_header.components.LanguageToggleButton
import energy.lux.frontend.domains.zenmo.sections.nav_header.components.rememberLanguageChangeHandler

@Composable
fun SiteLanguageButton() {
    val language = Language.toggleLanguage(LanguageManager.language.value)
    val onChange = rememberLanguageChangeHandler()
    NavBarActionsMenuItem(
        title = LocalizedText(
            en = "Language",
            nl = "Taal",
        ),
        onClick = {
            onChange(language)
        },
    ) {
        Box(
            Modifier.scale(0.75f)
        ) {
            LanguageToggleButton()
        }
    }
}