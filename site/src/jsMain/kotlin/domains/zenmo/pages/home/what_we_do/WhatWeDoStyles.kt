package energy.lux.frontend.domains.zenmo.pages.home.what_we_do

import com.varabyte.kobweb.compose.css.BoxShadow
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val ServiceCardStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .padding(topBottom = 1.25.cssRem)
    }
    cssRule(" .service-icon-box") {
        Modifier
            .size(48.px)
            .borderRadius(12.px)
            .color(SitePalette.light.primary)
            .backgroundColor(Colors.White)
            .boxShadow(
                BoxShadow.of(
                    0.px,
                    2.px,
                    8.px,
                    0.px,
                    Colors.Black.copyf(alpha = 0.08f)
                )
            )
            .flexShrink(0)
            .transition(
                Transition.of(TransitionProperty.All, 200.ms),
            )
    }
    cssRule(":hover .service-icon-box") {
        Modifier
            .backgroundColor(SitePalette.light.primary)
            .color(Colors.White)
    }
    cssRule(" .service-chevron") {
        Modifier
            .opacity(0.3)
            .transition(Transition.of(TransitionProperty.All, 200.ms))
    }
    cssRule(":hover .service-chevron") {
        Modifier
            .opacity(1)
            .transform { translateX(2.px) }
    }
}