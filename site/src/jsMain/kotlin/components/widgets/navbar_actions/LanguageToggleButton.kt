package energy.lux.frontend.components.widgets.navbar_actions

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import energy.lux.frontend.core.services.localization.Language
import energy.lux.frontend.core.services.localization.LanguageChangeHandler
import energy.lux.frontend.core.services.localization.LocalLanguage
import energy.lux.frontend.core.services.localization.rememberLanguageChangeHandler
import energy.lux.frontend.theme.SitePalette
import energy.lux.frontend.theme.isZenmoDomain
import energy.lux.frontend.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px


@Composable
fun LanguageToggleButton(
    languageHandler: LanguageChangeHandler = rememberLanguageChangeHandler()
) {
    Row(
        modifier = Modifier
            .overflow(Overflow.Clip)
            .border(
                1.px,
                LineStyle.Solid,
                SitePalette.light.primary
            )
            .borderRadius(30.px)
            .thenIf(
                !isZenmoDomain,
                Modifier.luxBorderRadius()
            )
    ) {
        val language = LocalLanguage.current
        LanguageOptionButton(
            label = "EN",
            onSelect = { languageHandler.setLanguage(Language.English) },
            isSelected = language == Language.English,
        )
        LanguageOptionButton(
            label = "NL",
            onSelect = { languageHandler.setLanguage(Language.Dutch) },
            isSelected = language == Language.Dutch,
        )
    }
}