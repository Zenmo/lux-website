package com.zenmo.web.zenmo.domains.lux.styles

import com.varabyte.kobweb.compose.css.Background
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.css.functions.toImage
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.after
import com.varabyte.kobweb.silk.style.selectors.before
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vw

val LuxDividerModifier = Modifier
    .width(100.vw)
    .height(1.px)
    .display(DisplayStyle.Block)
    .background(
        Background.of(
            image = linearGradient(LinearGradient.Direction.ToLeft) {
                add(Colors.Transparent)
                add(Color.rgba(0x00000027))
                add(Colors.Transparent)
            }.toImage()
        )
    )

val DividerBaseModifier = LuxDividerModifier
    .content("")
    .fillMaxWidth()
    .position(Position.Absolute)


val HeaderBottomDividerLineStyle = CssStyle {
    after {
        DividerBaseModifier
            .bottom(0.px)
            .left(0.px)
    }
}

val TopDividerLineStyle = CssStyle {
    before {
        DividerBaseModifier
            .top(0.px)
            .left(0.px)
    }
}