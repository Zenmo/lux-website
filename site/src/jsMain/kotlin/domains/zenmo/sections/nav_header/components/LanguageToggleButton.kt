package energy.lux.frontend.domains.zenmo.sections.nav_header.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.theme.font.HeaderTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import energy.lux.frontend.core.services.localization.Language
import energy.lux.frontend.core.services.localization.LanguageChangeHandler
import energy.lux.frontend.core.services.localization.LocalLanguage
import energy.lux.frontend.core.services.localization.rememberLanguageChangeHandler
import energy.lux.frontend.domains.lux.styles.verticalLinearBackground
import energy.lux.frontend.theme.SitePalette
import energy.lux.frontend.theme.isZenmoDomain
import energy.lux.frontend.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text


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

@Composable
private fun LanguageOptionButton(
    label: String,
    onSelect: () -> Unit,
    isSelected: Boolean,
) {
    Div(
        TextStyle.toModifier(HeaderTextStyle)
            .fontSize(1.cssRem)
            .role(ButtonType.Button.str)
            .padding(0.5.cssRem)
            .thenIf(
                isSelected,
                Modifier.verticalLinearBackground()
                    .color(Colors.White)
            )
            .cursor(Cursor.Pointer)
            .onClick {
                onSelect()
                it.stopPropagation()
            }
            .toAttrs()
    ) {
        Text(label)
    }
}