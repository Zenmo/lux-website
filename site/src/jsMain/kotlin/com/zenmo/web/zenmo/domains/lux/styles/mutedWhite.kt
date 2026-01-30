package com.zenmo.web.zenmo.domains.lux.styles

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.color

fun Modifier.mutedWhite(): Modifier = this.color(Colors.White.copyf(alpha = 0.8f))