package com.zenmo.web.zenmo.domains.lux.sections

import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.functions.clamp
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.vw

val ResponsiveFlexStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .display(DisplayStyle.Flex)
            .alignItems(AlignItems.Center)
            .responsiveGap()
    }

    Breakpoint.ZERO {
        Modifier
            .flexDirection(FlexDirection.Column)
    }

    Breakpoint.SM {
        Modifier
            .flexDirection(FlexDirection.Column)
    }
    Breakpoint.MD {
        Modifier
            .flexDirection(FlexDirection.Column)
    }

    Breakpoint.LG {
        Modifier
            .flexDirection(FlexDirection.Row)
    }

    Breakpoint.XL {
        Modifier
            .flexDirection(FlexDirection.Row)
    }
}

fun Modifier.responsiveGap() = this.gap(clamp(2.5.cssRem, 5.vw, 5.5.cssRem))