package energy.lux.frontend.domains.lux.sections.home.hero

import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.aspectRatio
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import energy.lux.frontend.theme.styles.LuxCornerRadius
import energy.lux.frontend.theme.styles.luxBorderRadius

val WhatIsLuxVideoContainerStyle = CssStyle.base {
    Modifier
        .fillMaxWidth()
        .luxBorderRadius(LuxCornerRadius.lg)
        .overflow(Overflow.Clip)
        .aspectRatio(16f / 9f)
}