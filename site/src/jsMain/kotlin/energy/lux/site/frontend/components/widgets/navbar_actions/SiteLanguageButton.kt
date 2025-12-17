package energy.lux.site.frontend.components.widgets.navbar_actions

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.scale
import com.zenmo.web.zenmo.core.services.localization.LanguageManager
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.components.LanguageSwitchButton

@Composable
fun SiteLanguageButton() {
    NavBarActionsMenuItem(
        title = LocalizedText(
            en = "Language",
            nl = "Taal",
        ),
        onClick = { LanguageManager.toggleLanguage() },
    ) {
        Box(
            Modifier.Companion.scale(0.75f)
        ) {
            LanguageSwitchButton()
        }
    }
}