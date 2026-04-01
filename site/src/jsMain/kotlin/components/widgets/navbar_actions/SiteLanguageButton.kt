package energy.lux.frontend.components.widgets.navbar_actions

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.scale
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.zenmo.sections.nav_header.components.LanguageToggleButton

@Composable
fun SiteLanguageButton() {
    NavBarActionsMenuItem(
        title = LocalizedText(
            en = "Language",
            nl = "Taal",
        ),
        onClick = {},
    ) {
        Box(
            Modifier.scale(0.75f)
        ) {
            LanguageToggleButton()
        }
    }
}
