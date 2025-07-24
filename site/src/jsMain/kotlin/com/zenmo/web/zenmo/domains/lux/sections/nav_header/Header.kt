package com.zenmo.web.zenmo.domains.lux.sections.nav_header

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.graphics.FitWidthImageVariant
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.CloseIcon
import com.varabyte.kobweb.silk.components.icons.HamburgerIcon
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import com.varabyte.kobweb.silk.style.extendedBy
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.zenmo.web.zenmo.components.SideMenuState
import com.zenmo.web.zenmo.domains.lux.styles.HeaderBottomDividerLineStyle
import com.zenmo.web.zenmo.domains.zenmo.navigation.MenuItem
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.NavHeaderStyle
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.components.LanguageSwitchButton
import com.zenmo.web.zenmo.domains.zenmo.widgets.button.IconButton
import com.zenmo.web.zenmo.pages.SiteGlobals
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.IconStyle
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Header


val HeaderInnerStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .justifyContent(JustifyContent.SpaceBetween)
            .alignItems(AlignItems.Center)
            .margin(0.px, autoLength)
            .position(Position.Relative)
            .zIndex(5)
    }
}


@OptIn(DelicateApi::class)
@Composable
fun LuxHeader() {
    val breakpoint = rememberBreakpoint()
    var menuState by remember { mutableStateOf(SideMenuState.CLOSED) }

    Header(
        attrs = NavHeaderStyle.toModifier()
            .boxShadow(spreadRadius = 0.px, color = Color.transparent)
            .then(LuxHeaderPaddingStyle.toModifier())
            .then(HeaderBottomDividerLineStyle.toModifier())
            .thenIf(
                breakpoint < Breakpoint.MD,
                Modifier.height(70.px)
            )
            .toAttrs()
    ) {
        Row(
            HeaderInnerStyle.toModifier()
                .fillMaxWidth()
                .displayIfAtLeast(Breakpoint.MD),
        ) {
            LuxLogo()
            NavBar()
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier.gap(1.cssRem)
            ) {
                BookADemoButton()
                LanguageSwitchButton()
            }
        }

        Box(
            Modifier.displayIfAtLeast(Breakpoint.MD)
        ) {
            ActiveMenuIndicator(
                items = MenuItem.luxMenuItems
            )
        }
        Row(
            Modifier.fillMaxWidth().displayUntil(Breakpoint.MD),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.flex(1), contentAlignment = Alignment.CenterStart) {
                LuxLogo()
            }
            Box(modifier = Modifier.flex(1), contentAlignment = Alignment.CenterEnd) {
                HamburgerButton(
                    onClick = {
                        menuState = when (menuState) {
                            SideMenuState.OPEN -> menuState.close()
                            else -> SideMenuState.OPEN
                        }
                    }, menuState = menuState
                )
            }
        }
    }
    if (menuState != SideMenuState.CLOSED) {
        SideMenu(
            menuState = menuState,
            close = { menuState = menuState.close() },
            onAnimationEnd = {
                if (menuState == SideMenuState.CLOSING)
                    menuState = SideMenuState.CLOSED
            }
        )
    }
}

@Composable
private fun HamburgerButton(
    onClick: () -> Unit, menuState: SideMenuState = SideMenuState.CLOSED
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.background(SitePalette.light.secondary)
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

val LuxLogoImageVariant = FitWidthImageVariant.extendedBy {
    base {
        Modifier
            .display(DisplayStyle.Block)
            .boxSizing(BoxSizing.BorderBox)
    }

    Breakpoint.ZERO {
        Modifier
            .width(120.px)
            .height(50.px)
    }

    Breakpoint.SM {
        Modifier
            .width(120.px)
            .height(50.px)
    }

    Breakpoint.MD {
        Modifier
            .width(120.px)
            .height(60.px)
    }
    Breakpoint.LG {
        Modifier
            .width(200.px)
            .height(80.px)
    }

    Breakpoint.XL {
        Modifier
            .width(200.px)
            .height(80.px)
    }
}

@Composable
fun LuxLogo(
    asLink: Boolean = false,
    domain: String = SiteGlobals.LUX_DOMAIN
) {
    val protocol = window.location.protocol
    A(
        href = if (asLink) "$protocol//$domain" else null,
        attrs = Modifier
            .cursor(
                if (asLink) Cursor.Pointer
                else Cursor.Default
            )
            .toAttrs()

    ) {
        Image(src = "/lux/logos/lux-energy-twin.png", variant = LuxLogoImageVariant)
    }
}