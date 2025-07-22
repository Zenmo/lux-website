package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.LinkStyle
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.selectors.active
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.theme.colors.shifted
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto

@Composable
fun IconLink(
    modifier: Modifier = Modifier,
    href: String,
    content: @Composable () -> Unit,
) {
    Link(
        path = href,
        modifier = modifier,
        variant = IconLinkVariant,
        openExternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
    ) {
        content()
    }
}

val IconLinkVariant = LinkStyle.addVariant {
    base {
        Modifier
            .textDecorationLine(TextDecorationLine.None)
            .width(auto)
            .height(auto)
            .alignContent(AlignContent.Center)
            .justifyContent(JustifyContent.Center)
            .display(DisplayStyle.Flex)
            .padding(0.5.cssRem)
            .borderRadius(50.percent)
            .background(SitePalette.light.onPrimary)
            .color(SitePalette.light.primary)
    }
    hover {
        Modifier.background(SitePalette.light.primary)
            .color(SitePalette.light.onPrimary)
    }
    active {
        Modifier.background(SitePalette.light.primary.shifted(colorMode, 0.2f))
    }
}
