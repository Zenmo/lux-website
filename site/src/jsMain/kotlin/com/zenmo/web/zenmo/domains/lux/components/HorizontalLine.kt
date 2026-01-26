package com.zenmo.web.zenmo.domains.lux.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.domains.lux.styles.TopDividerLineStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Div

@Composable
fun HorizontalLine(modifier: Modifier = Modifier) {
    Div(
        TopDividerLineStyle.toModifier()
            .fillMaxWidth()
            .margin(bottom = 2.5.cssRem)
            .position(Position.Relative)
            .then(modifier)
            .toAttrs()
    )
}