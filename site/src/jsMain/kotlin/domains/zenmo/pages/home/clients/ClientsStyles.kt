package energy.lux.frontend.domains.zenmo.pages.home.clients

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.px

val ClientLogoContainerStyle = CssStyle {
    base {
        Modifier
            .height(48.px)
            .backgroundColor(Colors.White)
            .borderRadius(14.px)
    }
    Breakpoint.ZERO {
        Modifier
            .height(48.px)
    }
    Breakpoint.SM {
        Modifier
            .height(48.px)
    }
    Breakpoint.MD {
        Modifier
            .height(52.px)
    }
    Breakpoint.LG {
        Modifier
            .height(60.px)
    }
    Breakpoint.XL {
        Modifier
            .height(88.px)
    }
    Breakpoint.XXL {
        Modifier
            .height(88.px)
    }
}