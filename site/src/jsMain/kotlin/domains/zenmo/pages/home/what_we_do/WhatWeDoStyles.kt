package energy.lux.frontend.domains.zenmo.pages.home.what_we_do

import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.hover
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val ServicesGridStyle = CssStyle {
    base { Modifier.fillMaxWidth() }
    Breakpoint.LG { Modifier.width(80.percent) }
}

val ServiceCardStyle = CssStyle {
    base {
        Modifier
            .padding(1.5.cssRem)
            .borderRadius(16.px)
            .border(1.px, LineStyle.Solid, Colors.Black.copyf(alpha = 0.1f))
            .cursor(Cursor.Pointer)
    }
    hover {
        Modifier.border(1.px, LineStyle.Solid, SitePalette.light.primary)
    }
}