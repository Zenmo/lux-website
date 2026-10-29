package energy.lux.frontend.domains.zenmo.sections.footer

import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.autoLength
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.navigation.LinkStyle
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.domains.lux.styles.DeEmphasizedTextStyle
import energy.lux.frontend.theme.SitePalette
import energy.lux.frontend.utils.PublicRes
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.css.ms

val FooterContentStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Grid)
            .gap(3.cssRem)
            .fillMaxWidth()
            .maxWidth(80.cssRem)
            .margin(leftRight = autoLength)
    }
    Breakpoint.MD {
        Modifier.gridTemplateColumns { size(0.85.fr); size(1.15.fr) }
    }
}

val FooterColumnsStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Grid)
            .gap(2.5.cssRem)
    }
    Breakpoint.SM {
        Modifier.gridTemplateColumns { repeat(2) { size(1.fr) } }
    }
}

val FooterLinkStyle = LinkStyle.addVariant{
    base {
        Modifier
            .color(
                SitePalette.light.onBackground.lightened(0.5f)
            )
            .transition(Transition.of("color", 200.ms))
    }
    hover {
        Modifier.color(Colors.White)
    }
}

val FooterEmailStyle = CssStyle {
    base {
        Modifier
            .color(Colors.White)
            .textDecorationLine(TextDecorationLine.None)
            .transition(Transition.of("color", 200.ms))
    }
    hover {
        Modifier.color(SitePalette.light.primary.lightened(0.2f))
    }
}