package com.zenmo.web.zenmo.domains.lux.sections.nav_header

import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import com.varabyte.kobweb.compose.css.BoxSizing
import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.css.functions.saturate
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiArrowForwardIos
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.SideMenuSlideInAnim
import com.zenmo.web.zenmo.components.SideMenuState
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.navigation.MenuItem
import com.zenmo.web.zenmo.domains.zenmo.navigation.asNavLinkPath
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.components.isPathActive
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.font.HolonBlockHeaderTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.Ul


val FrostedNavStyle = CssStyle.base {
    Modifier
        .styleModifier {
            property("-webkit-backdrop-filter", "saturate(150%) blur(12px)")
        }
        .backdropFilter(saturate(150.percent), blur(15.px))
}

val MobileNavStyle = CssStyle {
    base {
        Modifier
            .position(Position.Fixed)
            .top(70.px)
            .right(0.percent)
            .bottom(0.percent)
            .left(0.percent)
            .backgroundColor(Colors.Black.copyf(alpha = 0.4f))
            .boxSizing(BoxSizing.BorderBox)
            .fillMaxWidth()
    }
}

@Composable
fun SideMenu(
    menuState: SideMenuState,
    menuItems: List<MenuItem> = MenuItem.luxMenuItems,
    close: () -> Unit,
    onAnimationEnd: () -> Unit
) {
    Box(
        Modifier
            .position(Position.Fixed)
            .top(0.px)
            .zIndex(50)
            .onClick { close() },
        contentAlignment = Alignment.TopStart
    ) {
        key(menuState) { // force recompute animation parameters when close button is clicked
            Nav(
                MobileNavStyle.toModifier()
                    .animation(
                        SideMenuSlideInAnim.toAnimation(
                            duration = 200.ms,
                            timingFunction = if (menuState == SideMenuState.OPEN) AnimationTimingFunction.EaseOut else AnimationTimingFunction.EaseIn,
                            direction = if (menuState == SideMenuState.OPEN) AnimationDirection.Normal else AnimationDirection.Reverse,
                            fillMode = AnimationFillMode.Forwards
                        )
                    )
                    .then(FrostedNavStyle.toModifier())
                    .alignItems(AlignItems.Stretch)
                    .onAnimationEnd { onAnimationEnd() }
                    .toAttrs()
            ) {
                Ul(
                    Modifier
                        .display(DisplayStyle.Flex)
                        .flexDirection(FlexDirection.Column)
                        .gap(1.5.cssRem)
                        .margin(topBottom = 30.px)
                        .paddingInline {
                            start(20.px)
                            end(20.px)
                        }
                        .fillMaxWidth()
                        .toAttrs()
                ) {
                    menuItems.forEach { item ->
                        when (item) {
                            is MenuItem.Simple ->
                                SideMenuItem(
                                    href = item.getPath,
                                    enTitle = item.title.en,
                                    nlTitle = item.title.nl,
                                    isActive = isPathActive(href = item.getPath),
                                )

                            is MenuItem.WithSubs -> {
                                Column {
                                    SubHeaderText(
                                        enText = item.title.en,
                                        nlText = item.title.nl,
                                        modifier = Modifier.margin(0.px).padding(10.px).color(Colors.White)
                                    )
                                    Column(
                                        Modifier
                                            .fillMaxWidth()
                                            .gap(1.5.cssRem)
                                            .padding(left = 20.px)
                                    ) {
                                        item.subItems.forEach { subItem ->
                                            SideMenuItem(
                                                href = subItem.en.asNavLinkPath(item.title.en),
                                                enTitle = subItem.en,
                                                nlTitle = subItem.nl,
                                                isActive = isPathActive(href = subItem.en.asNavLinkPath(item.title.en)),
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SideMenuItem(
    href: String,
    enTitle: String,
    nlTitle: String,
    isActive: Boolean,
) {
    val color = if (isActive) SitePalette.light.secondary else Colors.White
    Link(
        path = href,
        modifier = TextStyle.toModifier(HolonBlockHeaderTextStyle)
            .then(MenuLinkStyle.toModifier())
            .fillMaxWidth()
            .color(color),
        variant = if (isActive) ActiveLinkStyleVariant else UncoloredLinkVariant,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            LangText(
                en = enTitle,
                nl = nlTitle,
            )
            MdiArrowForwardIos(
                modifier = Modifier
                    .fontSize(fontSize = com.varabyte.kobweb.compose.css.FontSize.XLarge)
                    .color(color)
                    .padding(10.px)
            )
        }
    }
}