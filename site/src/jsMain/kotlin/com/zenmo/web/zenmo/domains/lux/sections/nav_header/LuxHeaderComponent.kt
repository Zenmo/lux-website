package com.zenmo.web.zenmo.domains.lux.sections.nav_header

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.domains.lux.styles.HeaderBottomDividerLineStyle
import com.zenmo.web.zenmo.domains.zenmo.navigation.MenuItem
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.NavHeaderStyle
import com.zenmo.web.zenmo.theme.font.HolonLineTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Header


@Composable
fun LuxHeaderComponent(
    modifier: Modifier = Modifier,
    items: List<MenuItem>,
    content: @Composable () -> Unit,
) {
    Header(
        attrs = NavHeaderStyle.toModifier()
            .then(TextStyle.toModifier(HolonLineTextStyle))
            .boxShadow(spreadRadius = 0.px, color = Color.transparent)
            .then(LuxHeaderPaddingStyle.toModifier())
            .then(HeaderBottomDividerLineStyle.toModifier())
            .then(modifier)
            .toAttrs()
    ) {
        content()

        ActiveMenuIndicator(
            items = items
        )
    }
}