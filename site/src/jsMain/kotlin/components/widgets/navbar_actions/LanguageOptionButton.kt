package energy.lux.frontend.components.widgets.navbar_actions

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.theme.font.HeaderTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import energy.lux.frontend.domains.lux.styles.verticalLinearBackground
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

val LanguageOptionButtonStyle = CssStyle(
    extraModifier = { TextStyle.toModifier(HeaderTextStyle) }
) {
    base {
        Modifier
            .fontSize(1.cssRem)
            .padding(0.5.cssRem)
            .cursor(Cursor.Pointer)
    }
}


@Composable
fun LanguageOptionButton(
    label: String,
    onSelect: () -> Unit,
    isSelected: Boolean,
    modifier: Modifier = LanguageOptionButtonStyle.toModifier(),
    selectedModifier: Modifier = Modifier.verticalLinearBackground()
        .color(Colors.White)
) {
    Div(
        modifier
            .thenIf(isSelected, selectedModifier)
            .role(ButtonType.Button.str)
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