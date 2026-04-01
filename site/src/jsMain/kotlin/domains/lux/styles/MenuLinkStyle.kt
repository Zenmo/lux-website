package energy.lux.frontend.domains.lux.styles

import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.navigation.LinkStyle
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.selectors.hover
import energy.lux.frontend.theme.SitePalette
import energy.lux.frontend.theme.styles.LuxCornerRadius
import energy.lux.frontend.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val MenuLinkStyle = CssStyle {
    base {
        Modifier
            .fillMaxHeight()
            .display(DisplayStyle.Flex)
            .padding(10.px)
            .textDecorationLine(TextDecorationLine.None)
    }
}

val ActiveLinkStyleVariant = LinkStyle.addVariant {
    base {
        Modifier
            .color(SitePalette.light.onBackground)
            .background(SitePalette.light.overlay)
            .luxBorderRadius()
    }
}
val SubMenuItemHoverStyle = com.varabyte.kobweb.silk.style.CssStyle {
    hover {
        Modifier
            .background(SitePalette.light.overlay)
            .color(SitePalette.light.primary)
            .luxBorderRadius(LuxCornerRadius.lg)
            .transition(Transition.of("background-color", duration = 200.ms))
    }
}