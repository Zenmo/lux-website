package com.zenmo.web.zenmo.domains.zenmo.widgets

import DropdownContainerStyle
import MenuItemParentStyle
import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.core.models.MenuItem
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.components.NavBarLink
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.components.isPathActive


val MainMenuItemHoverStyle = CssStyle {
    hover {
        Modifier.cursor(cursor = Cursor.Auto)
    }
}

@Composable
fun MenuItemWithSubs(
    menu: MenuItem.WithSubs,
) {
    val isMenuActive = menu.subItems.any { isPathActive(href = it.route.path) }
    Box(
        modifier = MenuItemParentStyle.toModifier()
    ) {
        NavBarLink(
            href = "/",
            label = menu.title,
            isActive = isMenuActive,
            modifier = MainMenuItemHoverStyle.toModifier()
        )

        Column(
            modifier = DropdownContainerStyle.toModifier()
        ) {
            menu.subItems.forEach { sub ->
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    NavBarLink(
                        href = sub.route.path,
                        label = sub.route.label,
                        isActive = isPathActive(href = sub.route.path),
                    )
                }
            }
        }
    }
}