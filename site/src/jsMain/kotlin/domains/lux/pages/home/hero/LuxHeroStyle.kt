package energy.lux.frontend.domains.lux.pages.home.hero

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.maxHeight
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.vh

// height(100.vh) alone lets the hero grow disproportionately tall on wide-but-short
// viewports (e.g. ultra-wide monitors) since page width is capped at the XXL
// breakpoint; cap the hero's height there too so it stays banner-shaped.
val LuxHeroStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .position(Position.Relative)
            .height(100.vh)
    }

    Breakpoint.XXL {
        Modifier.maxHeight(50.cssRem) // 800px
    }
}