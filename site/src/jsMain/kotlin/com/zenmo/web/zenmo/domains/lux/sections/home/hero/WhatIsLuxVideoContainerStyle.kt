package com.zenmo.web.zenmo.domains.lux.sections.home.hero

import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.px

val WhatIsLuxVideoContainerStyle = CssStyle {
    base {
        Modifier.Companion
            .fillMaxWidth()
            .height(225.px)
            .luxBorderRadius(LuxCornerRadius.lg)
            .overflow(Overflow.Clip)
    }
    Breakpoint.LG {
        Modifier.height(250.px)
    }
    Breakpoint.XL {
        Modifier.height(300.px)
    }
}