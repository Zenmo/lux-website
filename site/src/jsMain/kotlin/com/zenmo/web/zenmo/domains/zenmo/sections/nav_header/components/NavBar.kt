package com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ListStyleType
import com.varabyte.kobweb.compose.css.autoLength
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import com.zenmo.web.zenmo.core.MenuFactory
import com.zenmo.web.zenmo.core.models.MenuItem
import com.zenmo.web.zenmo.domains.zenmo.widgets.MenuItemWithSubs
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Nav


val NavBarStyle = CssStyle {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .size(autoLength)
            .background(colorPalette.overlay)
            .borderRadius(30.px)
            .listStyle(ListStyleType.None)
            .display(DisplayStyle.Flex)
            .justifyContent(JustifyContent.Center)
            .flex(1)
    }
}

@Composable
fun NavBar(
    modifier: Modifier = NavBarStyle.toModifier(),
) {
    Nav(
        attrs = modifier.toAttrs()
    ) {
        MenuFactory.menuItems().forEach { item ->
            when (item) {
                is MenuItem.Simple -> {
                    NavBarLink(
                        href = item.route.path,
                        label = item.route.label,
                        isActive = isPathActive(href = item.route.path),
                    )
                }

                is MenuItem.WithSubs -> MenuItemWithSubs(item)
            }
        }
    }
}


