package com.zenmo.web.zenmo.domains.lux.sections

import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.functions.clamp
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.*

val ResponsiveRowStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .display(DisplayStyle.Flex)
            .alignItems(AlignItems.Center)
    }

    Breakpoint.ZERO {
        Modifier
            .flexDirection(FlexDirection.Column)
            .gap(3.cssRem)
    }

    Breakpoint.SM {
        Modifier
            .flexDirection(FlexDirection.Column)
            .gap(3.cssRem)
    }
    Breakpoint.MD {
        Modifier
            .flexDirection(FlexDirection.Row)
            .gap(3.cssRem)
    }

    Breakpoint.LG {
        Modifier
            .flexDirection(FlexDirection.Row)
            .justifyContent(JustifyContent.SpaceBetween)
            .gap(7.cssRem)
    }

    Breakpoint.XL {
        Modifier
            .flexDirection(FlexDirection.Row)
            .justifyContent(JustifyContent.SpaceBetween)
            .gap(7.cssRem)
    }
}

fun Modifier.responsiveGap() = this.gap(clamp(2.cssRem, 5.vw, 5.cssRem))