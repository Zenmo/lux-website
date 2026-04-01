package energy.lux.frontend.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.LinkStyle
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.selectors.hover
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Span

@Composable
fun InlineLink(
    destinationUrl: String,
    enLinkText: String,
    nlLinkText: String,
    textColor: CSSColorValue = SitePalette.light.primary,
) {
    Span {
        Link(
            path = destinationUrl,
            variant = InlineLinkTextStyle,
            modifier = Modifier.color(textColor)
        ) {
            LangText(
                en = enLinkText,
                nl = nlLinkText,
            )
        }
    }
}

val BorderBottomModifier =
    Modifier
        .display(DisplayStyle.InlineBlock)
        .borderBottom(2.px, LineStyle.Solid)

val InlineLinkTextStyle = LinkStyle.addVariant {
    base {
        BorderBottomModifier
            .transform { skewX((-10).deg) }
//            .color(SitePalette.light.primary)
    }
    hover {
        Modifier.textDecorationLine(TextDecorationLine.None)
    }
}