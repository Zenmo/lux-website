package energy.lux.site.frontend.domains.lux.styles

import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.navigation.LinkStyle
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.selectors.hover
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val MenuLinkStyle = CssStyle {
    base {
        Modifier.Companion
            .fillMaxHeight()
            .display(DisplayStyle.Companion.Flex)
            .padding(10.px)
            .textDecorationLine(TextDecorationLine.Companion.None)
    }
}

val ActiveLinkStyleVariant = LinkStyle.addVariant {
    base {
        Modifier.Companion
            .color(SitePalette.Companion.light.onBackground)
            .background(SitePalette.Companion.light.overlay)
            .luxBorderRadius()
    }
}
val SubMenuItemHoverStyle = com.varabyte.kobweb.silk.style.CssStyle {
    hover {
        Modifier.Companion
            .background(SitePalette.Companion.light.overlay)
            .color(SitePalette.Companion.light.primary)
            .luxBorderRadius(LuxCornerRadius.lg)
            .transition(Transition.Companion.of("background-color", duration = 200.ms))
    }
}