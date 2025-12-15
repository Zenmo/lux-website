package com.zenmo.web.zenmo.domains.lux.sections.home

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.css.px

val CardGridStyle = CssStyle.Companion.base {
    Modifier.Companion
        .display(DisplayStyle.Companion.Grid)
        .height(460.px)
        .rowGap(24.px)
        .columnGap(24.px)
        .flexGrow(1)
        .gridTemplateRows { repeat(2) { size(1.fr) } }
        .gridTemplateColumns { repeat(2) { size(1.fr) } }
}