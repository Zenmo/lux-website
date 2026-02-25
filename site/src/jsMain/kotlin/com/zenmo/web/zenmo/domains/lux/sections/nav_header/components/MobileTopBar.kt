package com.zenmo.web.zenmo.domains.lux.sections.nav_header.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.CloseIcon
import com.varabyte.kobweb.silk.components.icons.HamburgerIcon
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.SideMenuState
import com.zenmo.web.zenmo.components.widgets.navbar_actions.NavBarActionsMenuWidget
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.LuxLogo
import com.zenmo.web.zenmo.domains.zenmo.widgets.button.IconButton
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.IconStyle
import org.jetbrains.compose.web.css.cssRem

@Composable
fun MobileTopBar(
    onMenuClick: () -> Unit,
    menuState: SideMenuState = SideMenuState.CLOSED
) {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(modifier = Modifier.flex(1), contentAlignment = Alignment.CenterStart) {
            LuxLogo()
        }
        Box(modifier = Modifier.flex(1), contentAlignment = Alignment.CenterEnd) {
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.gap(0.5.cssRem)
            ) {
                NavBarActionsMenuWidget()
                HamburgerButton(
                    onClick = onMenuClick,
                    menuState = menuState
                )
            }
        }
    }
}

@Composable
private fun HamburgerButton(
    onClick: () -> Unit, menuState: SideMenuState = SideMenuState.CLOSED
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.background(Colors.Transparent)
    ) {
        when (menuState) {
            SideMenuState.OPEN -> {
                CloseIcon(
                    modifier = IconStyle.toModifier().color(SitePalette.light.onBackground)
                )
            }

            else -> {
                HamburgerIcon(
                    modifier = IconStyle.toModifier().color(SitePalette.light.onBackground)
                )
            }
        }
    }
}