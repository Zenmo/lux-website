package energy.lux.frontend.domains.lux.sections.nav_header.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import com.varabyte.kobweb.compose.css.BoxSizing
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.Overflow
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
import energy.lux.frontend.components.SideMenuSlideInAnim
import energy.lux.frontend.components.SideMenuState
import energy.lux.frontend.core.MenuFactory
import energy.lux.frontend.core.models.MenuItem
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.styles.ActiveLinkStyleVariant
import energy.lux.frontend.domains.lux.styles.MenuLinkStyle
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.lux.widgets.headings.SubHeaderText
import energy.lux.frontend.domains.zenmo.sections.nav_header.components.isPathActive
import energy.lux.frontend.theme.SitePalette
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
                    .overflow(
                        overflowY = Overflow.Scroll,
                        overflowX = Overflow.Auto
                    )
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
                    MenuFactory.menuItems().forEach { item ->
                        when (item) {
                            is MenuItem.Simple ->
                                SideMenuItem(
                                    href = item.route.url,
                                    label = item.route.label,
                                    isActive = isPathActive(href = item.route.url),
                                )

                            is MenuItem.WithSubs -> {
                                Column {
                                    SubHeaderText(
                                        enText = item.title.en,
                                        nlText = item.title.nl,
                                        modifier = Modifier.padding(10.px),
                                        textColor = Colors.White
                                    )
                                    Column(
                                        Modifier
                                            .fillMaxWidth()
                                            .gap(1.5.cssRem)
                                            .padding(left = 20.px)
                                    ) {
                                        item.subItems.forEach { subItem ->
                                            SideMenuItem(
                                                href = subItem.route.url,
                                                label = subItem.route.label,
                                                isActive = isPathActive(href = subItem.route.url),
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
    label: LocalizedText,
    isActive: Boolean,
) {
    val color = if (isActive) SitePalette.light.secondary else Colors.White
    Link(
        path = href,
        modifier = MenuLinkStyle.toModifier()
            .fillMaxWidth()
            .color(color),
        variant = if (isActive) ActiveLinkStyleVariant else UncoloredLinkVariant,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            HeaderText(
                enText = label.en,
                nlText = label.nl,
                modifier = Modifier.fontSize(2.cssRem)
            )
            MdiArrowForwardIos(
                modifier = Modifier
                    .fontSize(fontSize = FontSize.XLarge)
                    .color(color)
                    .padding(10.px)
            )
        }
    }
}
