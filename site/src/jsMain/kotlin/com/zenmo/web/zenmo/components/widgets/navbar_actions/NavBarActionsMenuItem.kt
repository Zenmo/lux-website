package com.zenmo.web.zenmo.components.widgets.navbar_actions

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.ms

val ActionsMenuItemStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .padding(leftRight = 1.25.cssRem, topBottom = 0.75.cssRem)
            .cursor(Cursor.Pointer)
    }
    hover {
        Modifier.background(SitePalette.light.overlay)
            .color(SitePalette.light.primary)
            .transition(Transition.of("background-color", duration = 200.ms))
    }
}

@Composable
fun NavBarActionsMenuItem(
    modifier: Modifier = Modifier,
    title: LocalizedText,
    onClick: () -> Unit,
    trailingContent: @Composable () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = ActionsMenuItemStyle.toModifier()
            .onClick { onClick() }
            .then(modifier)
    ) {
        LangText(
            en = title.en,
            nl = title.nl,
        )
        trailingContent()
    }
}