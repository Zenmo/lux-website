package com.zenmo.web.zenmo.domains.lux.sections

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.zenmo.web.zenmo.components.widgets.SectionContainerStyle
import org.jetbrains.compose.web.css.px

val LuxSectionContainerStyleVariant = SectionContainerStyle.addVariant {
    base {
        Modifier.Companion.padding(leftRight = 15.px, topBottom = 50.px)
    }
    Breakpoint.MD {
        Modifier.Companion.padding(leftRight = 134.px, topBottom = 100.px)
    }
    Breakpoint.LG {
        Modifier.Companion.padding(leftRight = 250.px, topBottom = 120.px)
    }
    Breakpoint.XL {
        Modifier.Companion.padding(leftRight = 250.px, topBottom = 120.px)
    }
}

