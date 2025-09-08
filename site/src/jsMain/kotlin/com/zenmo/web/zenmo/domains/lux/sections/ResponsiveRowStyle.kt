package com.zenmo.web.zenmo.domains.lux.sections

import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.cssRem

val ResponsiveRowStyle = CssStyle {
    base {
        Modifier.Companion
            .fillMaxWidth()
            .display(DisplayStyle.Companion.Flex)
            .alignItems(AlignItems.Companion.Center)
    }

    Breakpoint.ZERO {
        Modifier.Companion
            .flexDirection(FlexDirection.Companion.Column)
            .gap(3.cssRem)
    }

    Breakpoint.SM {
        Modifier.Companion
            .flexDirection(FlexDirection.Companion.Column)
            .gap(3.cssRem)
    }
    Breakpoint.MD {
        Modifier.Companion
            .flexDirection(FlexDirection.Companion.Row)
            .gap(3.cssRem)
    }

    Breakpoint.LG {
        Modifier.Companion
            .flexDirection(FlexDirection.Companion.Row)
            .justifyContent(JustifyContent.Companion.SpaceBetween)
            .gap(7.cssRem)
    }

    Breakpoint.XL {
        Modifier.Companion
            .flexDirection(FlexDirection.Companion.Row)
            .justifyContent(JustifyContent.Companion.SpaceBetween)
            .gap(7.cssRem)
    }
}