package energy.lux.site.frontend.domains.lux.styles

import com.varabyte.kobweb.compose.css.BoxShadow
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.px

val HoverBoxShadowStyle = CssStyle {
    hover {
        Modifier.Companion
            .boxShadow(
                BoxShadow.Companion.of(
                    0.px, 20.px, 25.px, (-5).px, Colors.Black.copyf(alpha = 0.1f)
                ),
                BoxShadow.Companion.of(
                    0.px, 10.px, 10.px, (-5).px, Colors.Black.copyf(alpha = 0.04f)
                ),
            )
    }
}