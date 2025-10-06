package com.zenmo.web.zenmo.domains.lux.sections.nav_header.components

import MenuItemParentStyle
import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.*
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.LinkKind
import com.varabyte.kobweb.silk.components.navigation.LinkStyle
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.CssStyleVariant
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.zenmo.navigation.MenuLanguage
import com.zenmo.web.zenmo.domains.zenmo.navigation.asNavLinkPath
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.components.isPathActive
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Li

val MenuLinkStyle = CssStyle {
    base {
        Modifier
            .fillMaxHeight()
            .display(DisplayStyle.Flex)
            .padding(10.px)
            .textDecorationLine(TextDecorationLine.None)
    }
}

val ActiveLinkStyleVariant = LinkStyle.addVariant {
    base {
        Modifier
            .color(SitePalette.light.primary)
            .fontWeight(FontWeight.Bold)
    }
}

@Composable
fun LuxMenuItem(
    href: String,
    enTitle: String,
    nlTitle: String,
    isActive: Boolean = false,
    activeLinkVariant: CssStyleVariant<LinkKind>? = ActiveLinkStyleVariant,
    linkModifier: Modifier = Modifier,
    modifier: Modifier = Modifier,
) {
    Li(
        Modifier
            .id(enTitle.lowercase())
            .listStyle(ListStyleType.None)
            .position(Position.Relative)
            .then(modifier)
            .toAttrs(),
    ) {
        Link(
            path = href,
            modifier = MenuLinkStyle.toModifier().then(linkModifier),
            variant = if (isActive) activeLinkVariant else UncoloredLinkVariant,
        ) {
            LangText(
                en = enTitle,
                nl = nlTitle,
            )
        }
    }
}

val SubMenuStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Block)
            .position(Position.Absolute)
            .top(100.percent)
            .left((-16).px)
            .width(240.px)
            .zIndex(222)
            .transformOrigin(TransformOrigin.of(50.percent, 0.percent))
            .background(SitePalette.light.background)
            .border(
                width = 0.3.px,
                style = LineStyle.Solid,
                color = Colors.LightGrey
            )
            .borderRadius(0.5.cssRem)
            .overflow(Overflow.Hidden)
            .boxShadow(0.px, 0.px, 15.px, 1.px, rgba(0, 0, 0, 0.3f))
            .styleModifier {
                property("display", "var(--dropdown-visibility, none)")
            }
    }
}

val SubMenuItemHoverStyle = CssStyle {
    hover {
        Modifier
            .background(SitePalette.light.overlay)
            .color(SitePalette.light.primary)
            .transition(Transition.of("background-color", duration = 200.ms))
    }
}

val ActiveSubMenuLinkStyleVariant = LinkStyle.addVariant {
    base {
        Modifier
            .color(SitePalette.light.onPrimary)
    }
    hover {
        Modifier
            .fontWeight(FontWeight.Normal)
    }
}

val SubMenuAppearanceAnimKeyFrames = Keyframes {
    0.percent {
        Modifier
            .opacity(0)
            .transform {
                translateY((10).px)
            }
            .scale(0.95)
    }
    100.percent {
        Modifier
            .opacity(1)
            .transform {
                translateY(0.px)
            }
            .scale(1.0)
    }
}

@Composable
fun LuxMenuItemWithSubs(titleText: MenuLanguage, subItems: List<MenuLanguage>) {
    val isMenuActive = subItems.any { isPathActive(href = it.en.asNavLinkPath(titleText.en)) }

    Box(
        modifier = MenuItemParentStyle.toModifier()
    ) {
        LuxMenuItem(
            href = subItems.first().en.asNavLinkPath(titleText.en),
            enTitle = titleText.en,
            nlTitle = titleText.nl,
            isActive = isMenuActive,
            modifier = Modifier.cursor(cursor = Cursor.None)
        )

        Column(
            modifier = SubMenuStyle.toModifier()
                .animation(
                    SubMenuAppearanceAnimKeyFrames.toAnimation(
                        duration = 200.ms,
                        timingFunction = AnimationTimingFunction.EaseInOut
                    )
                )
        ) {
            subItems.forEach { subItem ->
                val isActive = isPathActive(href = subItem.en.asNavLinkPath(titleText.en))
                Box(
                    modifier = Modifier.fillMaxSize().padding(8.px)
                        .then(SubMenuItemHoverStyle.toModifier())
                        .thenIf(
                            isActive,
                            Modifier.background(SitePalette.light.primary)
                        ),
                    contentAlignment = Alignment.CenterStart
                ) {
                    LuxMenuItem(
                        href = subItem.en.asNavLinkPath(titleText.en),
                        enTitle = subItem.en,
                        nlTitle = subItem.nl,
                        isActive = isActive,
                        activeLinkVariant = ActiveSubMenuLinkStyleVariant,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}