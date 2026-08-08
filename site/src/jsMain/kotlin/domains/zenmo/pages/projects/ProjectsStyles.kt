package energy.lux.frontend.domains.zenmo.pages.projects

import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val ProjectRowReverseStyle = CssStyle {
    base {
        Modifier
            .flexDirection(FlexDirection.Column)
    }
    Breakpoint.LG {
        Modifier
            .flexDirection(FlexDirection.RowReverse)
    }
}


val ProjectImageStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .height(400.px)
            .objectFit(ObjectFit.Cover)
            .overflow(Overflow.Clip)
            .background(SitePalette.light.overlay)
    }
    Breakpoint.LG {
        Modifier
            .width(50.percent)
            .flexShrink(0)
            .height(460.px)
    }
}