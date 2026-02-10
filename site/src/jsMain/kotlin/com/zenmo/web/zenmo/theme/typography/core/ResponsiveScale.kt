package com.zenmo.web.zenmo.theme.typography.core

import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.cssRem

data class ResponsiveScale(
    val sm: Double,
    val md: Double,
    val lg: Double,
    val xl: Double,
    val xxl: Double = xl,
) {
    fun at(bp: Breakpoint) = when (bp) {
        Breakpoint.ZERO, Breakpoint.SM -> sm
        Breakpoint.MD -> md
        Breakpoint.LG -> lg
        Breakpoint.XL -> xl
        Breakpoint.XXL -> xxl
    }.cssRem
}
