package com.zenmo.web.zenmo.domains.lux.sections.nav_header

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.core.MenuFactory
import com.zenmo.web.zenmo.core.models.MenuItem
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.components.LuxMenuItem
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.components.LuxMenuItemWithSubs
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.components.isPathActive
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.Ul

val NavListStyle = CssStyle.base {
    Modifier
        .fillMaxHeight()
        .display(DisplayStyle.Flex)
        .justifyContent(JustifyContent.Center)
        .alignItems(AlignItems.Center)
        .gap(10.px)
        .position(Position.Relative)
}


@Composable
fun NavBar() {
    Nav(
        Modifier
            .fillMaxHeight()
            .toAttrs()
    ) {
        Ul(
            NavListStyle.toModifier().toAttrs()
        ) {
            MenuFactory.menuItems().forEach { menuItem ->
                when (menuItem) {
                    is MenuItem.Simple -> {
                        LuxMenuItem(
                            href = menuItem.nav.path,
                            menuTitle = menuItem.nav.label,
                            isActive = isPathActive(href = menuItem.nav.path),
                        )
                    }

                    is MenuItem.WithSubs -> {
                        LuxMenuItemWithSubs(
                            titleText = menuItem.title,
                            subItems = menuItem.subItems,
                        )
                    }
                }
            }
        }
    }
}