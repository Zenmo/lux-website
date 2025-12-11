package com.zenmo.web.zenmo.domains.lux.sections.nav_header.components

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.px

val LuxHeaderPaddingStyle = CssStyle {
    Breakpoint.ZERO {
        Modifier.padding(leftRight = 15.px)
    }
    Breakpoint.SM {
        Modifier.padding(leftRight = 15.px)
    }
    Breakpoint.MD {
        Modifier.padding(leftRight = 100.px)
    }
    Breakpoint.LG {
        Modifier.padding(leftRight = 200.px)
    }
    Breakpoint.XL {
        Modifier.padding(leftRight = 250.px)
    }
}