package energy.lux.frontend.domains.lux.sections.nav_header.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.ListStyleType
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiExpandMore
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.LinkKind
import com.varabyte.kobweb.silk.components.navigation.LinkStyle
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.style.CssStyleVariant
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.core.models.MenuItem
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.sections.DeEmphasizedTextStyle
import energy.lux.frontend.domains.zenmo.sections.nav_header.components.AnimatedIconStyle
import energy.lux.frontend.domains.zenmo.sections.nav_header.components.isPathActive
import energy.lux.frontend.theme.SitePalette
import energy.lux.frontend.theme.styles.DropdownTriggerStyle
import energy.lux.frontend.theme.styles.IconStyle
import energy.lux.frontend.theme.styles.LuxCornerRadius
import energy.lux.frontend.theme.styles.luxBorderRadius
import energy.lux.frontend.domains.lux.styles.ActiveLinkStyleVariant
import energy.lux.frontend.domains.lux.styles.LuxSubMenuItemParentHoverStyle
import energy.lux.frontend.domains.lux.styles.MenuLinkStyle
import energy.lux.frontend.domains.lux.styles.SubMenuContentStyle
import energy.lux.frontend.domains.lux.styles.SubMenuItemHoverStyle
import energy.lux.frontend.domains.lux.styles.SubmenuContainerStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Ul

@Composable
fun LuxMenuItem(
    href: String,
    menuTitle: LocalizedText,
    subText: LocalizedText? = null,
    showSubText: Boolean = subText != null,
    isActive: Boolean = false,
    activeLinkVariant: CssStyleVariant<LinkKind>? = ActiveLinkStyleVariant,
    linkModifier: Modifier = Modifier,
    modifier: Modifier = Modifier,
) {
    Li(
        Modifier
            .id(menuTitle.en.lowercase())
            .listStyle(ListStyleType.None)
            .position(Position.Relative)
            .then(modifier)
            .fontSize(FontSize.Medium)
            .toAttrs(),
    ) {
        Link(
            path = href,
            modifier = MenuLinkStyle.toModifier().then(linkModifier),
            variant = if (isActive) activeLinkVariant else UncoloredLinkVariant,
        ) {
            Column(
                Modifier.gap(0.25.cssRem)
            ) {
                LangText(
                    en = menuTitle.en,
                    nl = menuTitle.nl,
                )
                if (showSubText && subText != null) {
                    P(
                        Modifier.margin(0.px)
                            .then(DeEmphasizedTextStyle.toModifier())
                            .toAttrs()
                    ) {
                        LangText(
                            en = subText.en,
                            nl = subText.nl,
                        )
                    }
                }
            }
        }
    }
}

val ActiveSubMenuLinkStyleVariant = LinkStyle.addVariant {
    base {
        Modifier
            .color(SitePalette.light.onBackground)
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
fun LuxMenuItemWithSubs(titleText: LocalizedText, subItems: List<MenuItem.Simple>) {
    val isMenuActive = subItems.any { isPathActive(href = it.route.url) }

    Box(
        modifier = DropdownTriggerStyle.toModifier()
            .then(LuxSubMenuItemParentHoverStyle.toModifier())
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.thenIf(
                isMenuActive,
                Modifier.background(SitePalette.light.overlay)
                    .luxBorderRadius()
            )
        ) {
            LuxMenuItem(
                href = "",
                menuTitle = titleText,
                isActive = isMenuActive,
                modifier = Modifier.cursor(cursor = Cursor.None)
            )
            MdiExpandMore(
                modifier = IconStyle.toModifier()
                    .then(AnimatedIconStyle.toModifier())
            )
        }

        Div(
            SubmenuContainerStyle.toModifier()
                .animation(
                    SubMenuAppearanceAnimKeyFrames.toAnimation(
                        duration = 200.ms,
                        timingFunction = AnimationTimingFunction.EaseInOut
                    )
                )
                .toAttrs()
        ) {
            Column(
                modifier = SubMenuContentStyle.toModifier()
            ) {
                Ul(
                    Modifier
                        .padding(1.cssRem)
                        .width(400.px).toAttrs()
                ) {
                    subItems.forEach { subItem ->
                        val isActive = isPathActive(href = subItem.route.url)
                        LuxMenuItem(
                            href = subItem.route.url,
                            menuTitle = subItem.route.label,
                            subText = subItem.descriptionParagraph,
                            isActive = isActive,
                            activeLinkVariant = ActiveSubMenuLinkStyleVariant,
                            modifier = Modifier.fillMaxWidth().padding(0.5.cssRem)
                                .then(SubMenuItemHoverStyle.toModifier())
                                .thenIf(
                                    isActive,
                                    Modifier.background(SitePalette.light.overlay)
                                        .luxBorderRadius(LuxCornerRadius.lg)
                                )
                        )
                    }
                }
            }
        }
    }
}
