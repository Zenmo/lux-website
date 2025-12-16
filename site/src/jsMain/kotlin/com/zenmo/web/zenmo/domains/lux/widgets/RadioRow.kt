package com.zenmo.web.zenmo.domains.lux.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

val SelectableItemStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .padding(0.25.cssRem, 0.5.cssRem)
        .textAlign(TextAlign.Center)
        .border(1.px, LineStyle.Solid, Colors.LightGrey)
        .color(SitePalette.light.onBackground)
        .borderRadius(12.px)
        .cursor(Cursor.Pointer)
        .justifyContent(JustifyContent.Center)
}

val ActiveSelectableItemStyle = CssStyle.base {
    Modifier
        .border(1.px, LineStyle.None, Colors.LightGrey)
        .background(SitePalette.light.primary)
        .color(SitePalette.light.onPrimary)
}


@OptIn(ExperimentalComposeWebApi::class)
@Composable
fun <T> RadioRow(
    value: T,
    options: Map<T, String>,
    onChange: (T) -> Unit,
    content: @Composable (T, String) -> Unit = { _, displayName ->
        Text(displayName)
    }
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.Companion.gap(0.5.cssRem).fillMaxHeight()
    ) {
        options.forEach { (optionValue, displayName) ->
            val isSelected = optionValue == value
            RadioItem(
                onClick = { onChange(optionValue) },
                isSelected = isSelected,
                content = { content(optionValue, displayName) }
            )
        }
    }
}

@Composable
fun RadioItem(
    onClick: () -> Unit,
    isSelected: Boolean,
    content: @Composable () -> Unit
) {
    Div(
        SelectableItemStyle.toModifier()
            .thenIf(
                isSelected,
                ActiveSelectableItemStyle.toModifier()
            )
            .luxBorderRadius()
            .onClick { onClick() }
            .padding(0.75.cssRem)
            .toAttrs()
    ) { content() }
}