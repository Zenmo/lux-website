package com.zenmo.web.zenmo.domains.lux.widgets.headings

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.theme.font.HeaderTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.dom.H1

@Composable
fun HeaderText(
    modifier: Modifier = Modifier,
    textColor: CSSColorValue = Color.currentColor,
    fontWeight: FontWeight = FontWeight.Normal,
    enText: String,
    nlText: String,
) {
    H1(
        TextStyle.toModifier(HeaderTextStyle)
            .display(DisplayStyle.InlineBlock)
            .color(textColor)
            .fontWeight(fontWeight)
            .then(modifier)
            .toAttrs()
    ) {
        LangText(
            en = enText,
            nl = nlText,
        )
    }
}