package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.zenmo.web.zenmo.domains.lux.sections.responsiveGap
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.cssRem


@OptIn(DelicateApi::class)
@Composable
fun MediaContentLayout(
    imageUrl: String,
    imageModifier: Modifier = Modifier,
    visualContent: @Composable () -> Unit = {
        ImageContent(
            imageUrl = imageUrl,
            modifier = imageModifier
                .fillMaxWidth()
        )
    },
    title: @Composable (() -> Unit)? = null,
    description: @Composable () -> Unit = {},
    subtitle: @Composable () -> Unit = {},
    actionText: @Composable () -> Unit = {},
    reversed: Boolean = false,
) {
    val breakpoint = rememberBreakpoint()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .responsiveGap()
            .thenIf(
                breakpoint < Breakpoint.MD,
                Modifier.flexWrap(FlexWrap.Wrap)
            )
            .thenIf(
                reversed,
                Modifier.flexDirection(FlexDirection.RowReverse)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            visualContent()
        }
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            TextContent(
                title = title,
                description = description,
                subtitle = subtitle,
                actionText = actionText,
            )
        }
    }
}


@OptIn(DelicateApi::class)
@Composable
private fun TextContent(
    title: @Composable (() -> Unit)? = null,
    subtitle: @Composable () -> Unit,
    description: @Composable () -> Unit,
    actionText: @Composable () -> Unit,
) {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .gap(1.cssRem),
        verticalArrangement =
            if (title == null) Arrangement.Top
            else Arrangement.Center,
        horizontalAlignment =
            if (breakpoint < Breakpoint.MD) Alignment.CenterHorizontally
            else Alignment.Start
    ) {
        subtitle()
        title?.invoke()
        description()
        actionText()
    }
}