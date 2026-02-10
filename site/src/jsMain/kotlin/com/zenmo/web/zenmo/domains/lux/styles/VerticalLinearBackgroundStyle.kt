package com.zenmo.web.zenmo.domains.lux.styles

import com.varabyte.kobweb.compose.css.Background
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.css.functions.toImage
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.percent


fun Modifier.verticalLinearBackground(
    topColor: Color = SitePalette.light.primary,
    bottomColor: Color = SitePalette.light.primary.darkened(0.2f)
): Modifier = this.then(
    Modifier.background(
        Background.of(
            image = linearGradient(180.deg) {
                add(topColor, 0.percent)
                add(bottomColor, 100.percent)
            }.toImage()
        )
    )
)


