package com.zenmo.web.zenmo.domains.lux.styles

import com.varabyte.kobweb.compose.css.TransformOrigin
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.*

val SubMenuContentStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Block)
            .padding(0.5.cssRem)
            .transformOrigin(TransformOrigin.of(50.percent, 0.percent))
            .background(SitePalette.light.background)
            .border(
                width = 0.3.px,
                style = LineStyle.Solid,
                color = Colors.LightGrey
            )
            .luxBorderRadius(LuxCornerRadius.lg)
    }
}
val SubmenuContainerStyle = CssStyle {
    base {
        Modifier
            .position(Position.Absolute)
            .top(100.percent)
            .left(0.percent)
            .padding(top = 0.5.cssRem)
            .zIndex(20)
            .styleModifier {
                property("display", "var(--dropdown-visibility, none)")
            }
    }
}