package com.zenmo.web.zenmo.domains.lux.sections.home.hero

import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.aspectRatio
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius

val WhatIsLuxVideoContainerStyle = CssStyle.base {
    Modifier.Companion
        .fillMaxWidth()
        .luxBorderRadius(LuxCornerRadius.lg)
        .overflow(Overflow.Clip)
        .aspectRatio(16f / 9f)
}