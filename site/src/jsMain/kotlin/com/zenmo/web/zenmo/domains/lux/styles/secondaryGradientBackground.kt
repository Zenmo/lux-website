package com.zenmo.web.zenmo.domains.lux.styles

import com.varabyte.kobweb.compose.ui.Modifier
import com.zenmo.web.zenmo.theme.SitePalette

fun Modifier.secondaryGradientBackground(): Modifier =
    verticalLinearBackground(
        topColor = SitePalette.light.secondary,
        bottomColor = SitePalette.light.secondary.darkened(0.2f)
    )