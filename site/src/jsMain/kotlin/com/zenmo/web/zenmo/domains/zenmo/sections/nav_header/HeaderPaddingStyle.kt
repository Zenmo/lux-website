package com.zenmo.web.zenmo.domains.zenmo.sections.nav_header

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.px

val HeaderPaddingStyle = CssStyle {
    Breakpoint.ZERO {
        Modifier.padding(leftRight = 16.px, topBottom = 10.px)
    }
    Breakpoint.SM {
        Modifier.padding(leftRight = 28.px, topBottom = 10.px)
    }
    Breakpoint.MD {
        Modifier.padding(leftRight = 48.px, topBottom = 15.px)
    }
    Breakpoint.LG {
        Modifier.padding(leftRight = 94.px, topBottom = 15.px)
    }
    Breakpoint.XL {
        Modifier.padding(leftRight = 134.px, topBottom = 15.px)
    }
}