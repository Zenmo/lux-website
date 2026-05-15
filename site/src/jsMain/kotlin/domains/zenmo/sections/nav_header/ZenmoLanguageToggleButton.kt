package energy.lux.frontend.domains.zenmo.sections.nav_header

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.theme.font.LabelTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import energy.lux.frontend.components.widgets.navbar_actions.LanguageOptionButton
import energy.lux.frontend.core.services.localization.Language
import energy.lux.frontend.core.services.localization.LocalLanguage
import energy.lux.frontend.core.services.localization.rememberLanguageChangeHandler
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.*

val ZenmoLanguageToggleButtonStyle = CssStyle(
    extraModifier = { TextStyle.toModifier(LabelTextStyle) }
) {
    base {
        Modifier
            .borderRadius(30.px)
            .border(1.px, LineStyle.Solid, Colors.LightGrey)
            .padding(0.35.cssRem, 0.85.cssRem)
            .transition(
                Transition.of(
                    property = "all",
                    duration = 300.ms,
                    timingFunction = AnimationTimingFunction.Ease
                )
            )
    }
}

val ActiveLanguageOptionStyle = CssStyle.base {
    Modifier
        .backgroundColor(Colors.Transparent)
        .color(SitePalette.light.primary)
        .fontWeight(FontWeight.Bold)
        .border(2.px, LineStyle.Solid, SitePalette.light.primary)
}

@Composable
fun ZenmoLanguageToggleButton() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.gap(0.5.cssRem)
    ) {
        val languageHandler = rememberLanguageChangeHandler()
        val language = LocalLanguage.current
        LanguageOptionButton(
            label = "EN",
            onSelect = { languageHandler.setLanguage(Language.English) },
            isSelected = language == Language.English,
            modifier = ZenmoLanguageToggleButtonStyle.toModifier(),
            selectedModifier = ActiveLanguageOptionStyle.toModifier()
        )
        LanguageOptionButton(
            label = "NL",
            onSelect = { languageHandler.setLanguage(Language.Dutch) },
            isSelected = language == Language.Dutch,
            modifier = ZenmoLanguageToggleButtonStyle.toModifier(),
            selectedModifier = ActiveLanguageOptionStyle.toModifier()
        )
    }
}