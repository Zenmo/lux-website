package energy.lux.frontend.domains.zenmo.sections.nav_header.components

import com.varabyte.kobweb.compose.css.BoxShadow
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.navigation.LinkStyle
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.hover
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.*

val SideMenuStyle = CssStyle {
    base {
        Modifier
            .fillMaxHeight()
            .width(33.percent)
            .padding(topBottom = 1.5.cssRem, leftRight = 1.5.cssRem)
            .gap(1.5.cssRem)
            .backgroundColor(SitePalette.light.background)
            .borderRadius(topLeft = 30.px, bottomLeft = 30.px)
            .boxShadow(BoxShadow.of(0.px, 8.px, 32.px, 0.px, Colors.Black.copyf(alpha = 0.15f)))
    }
    Breakpoint.ZERO {
        Modifier.width(85.percent)
    }
    Breakpoint.SM {
        Modifier.width(60.percent)
    }
    Breakpoint.MD {
        Modifier.width(30.percent)
    }
}


val SideMenuLinkVariant = LinkStyle.addVariant {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .fillMaxWidth()
            .textDecorationLine(TextDecorationLine.None)
            .color(SitePalette.light.onBackground)
            .padding(topBottom = 0.6.cssRem, leftRight = 0.75.cssRem)
            .borderRadius(0.75.cssRem)
            .transition(
                Transition.of(
                    property = "background-color",
                    duration = 200.ms,
                    timingFunction = AnimationTimingFunction.Ease
                )
            )
    }
    hover {
        Modifier
            .color(SitePalette.light.primary)
            .backgroundColor(SitePalette.light.overlay)
    }
}

val ActiveSideMenuLinkVariant = LinkStyle.addVariant {
    base {
        Modifier
            .color(SitePalette.light.primary)
            .fontWeight(FontWeight.Bold)
            .backgroundColor(SitePalette.light.primary.lightened(0.95f))
    }
}