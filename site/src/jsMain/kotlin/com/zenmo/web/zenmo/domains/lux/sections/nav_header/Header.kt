package com.zenmo.web.zenmo.domains.lux.sections.nav_header

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.functions.RadialGradient
import com.varabyte.kobweb.compose.css.functions.radialGradient
import com.varabyte.kobweb.compose.css.functions.toImage
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.FitWidthImageVariant
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.CloseIcon
import com.varabyte.kobweb.silk.components.icons.HamburgerIcon
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import com.varabyte.kobweb.silk.style.extendedBy
import com.varabyte.kobweb.silk.style.selectors.before
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.domains.lux.styles.HeaderBottomDividerLineStyle
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.NavHeaderStyle
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.components.LanguageSwitchButton
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.components.SideMenuState
import com.zenmo.web.zenmo.domains.zenmo.widgets.button.IconButton
import com.zenmo.web.zenmo.pages.SiteGlobals
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.IconStyle
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Header
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLAnchorElement


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

val ActiveIndicatorWidthStyleVar by StyleVariable<CSSLengthOrPercentageNumericValue>()
val ActiveIndicatorLeftStyleVar by StyleVariable<CSSLengthOrPercentageNumericValue>()

val LuxActiveMenuIndicatorStyle = CssStyle {
    base {
        Modifier
            .position(Position.Absolute)
            .width(ActiveIndicatorWidthStyleVar.value())
            .height(3.px)
            .backgroundColor(SitePalette.light.primary)
            .borderRadius(1.px)
            .left(ActiveIndicatorLeftStyleVar.value())
            .bottom(0.px)
            .boxSizing(BoxSizing.BorderBox)
            .transition(
                Transition.group(
                    properties = listOf("left", "width"),
                    0.3.s,
                )
            )
    }
    before {
        Modifier
            .content("")
            .height(60.px)
            .width(200.percent)
            .background(
                Background.of(
                    image = radialGradient(RadialGradient.Shape.Ellipse, CSSPosition.Bottom) {
                        add(SitePalette.light.primary, 10.percent)
                        add(Colors.Transparent, 60.percent)
                    }.toImage(),
                    repeat = BackgroundRepeat.NoRepeat,
                    position = BackgroundPosition.of(CSSPosition.Bottom)
                )
            )
            .display(DisplayStyle.Block)
            .position(Position.Absolute)
            .bottom(100.percent)
            .left((-50).percent)
            .opacity(0.1)
    }
}


@Composable
fun LuxHeader() {
    var sectionInView by remember { mutableStateOf(LuxSection.HOME.id) }

    LaunchedEffect(Unit) {
        window.onscroll = {
            val scrollY = window.scrollY
            LuxSection.entries.forEach { section ->
                document.getElementById(section.id)?.let { element ->
                    val elementTop = element.getBoundingClientRect().top + window.scrollY
                    val elementHeight = element.clientHeight
                    if (scrollY >= elementTop - 100 && scrollY < elementTop + elementHeight - 100) {
                        sectionInView = section.id
                        return@forEach
                    }
                }
            }
        }
    }
    Header(
        attrs = NavHeaderStyle.toModifier()
            .boxShadow(spreadRadius = 0.px, color = Color.transparent)
            .then(LuxHeaderPaddingStyle.toModifier())
            .then(HeaderBottomDividerLineStyle.toModifier())
            .toAttrs()
    ) {
        Row(
            HeaderInnerStyle.toModifier()
                .fillMaxWidth()
                .displayIfAtLeast(Breakpoint.MD),
        ) {
            LuxLogo()
            NavBar(sectionInView)


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
            var indicatorWidth by remember { mutableStateOf(0.px) }
            var indicatorLeft by remember { mutableStateOf(0.px) }

            LaunchedEffect(sectionInView) {
                val activeAnchor = document.querySelector("a[href='#$sectionInView']") as? HTMLAnchorElement
                if (activeAnchor != null) {
                    val anchorRect = activeAnchor.getBoundingClientRect()
                    indicatorWidth = anchorRect.width.px
                    indicatorLeft = (anchorRect.left).px
                }
            }


            // needs a bit of fixing:
            // this indicator abandons the active header when window is resized,
            Span(
                attrs = LuxActiveMenuIndicatorStyle.toModifier()
                    .setVariable(ActiveIndicatorWidthStyleVar, indicatorWidth)
                    .setVariable(ActiveIndicatorLeftStyleVar, indicatorLeft).toAttrs()
            )
        }

        Row(
            Modifier.fillMaxWidth().displayUntil(Breakpoint.MD),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            var menuState by remember { mutableStateOf(SideMenuState.CLOSED) }
            Box(modifier = Modifier.flex(1), contentAlignment = Alignment.CenterStart) {
                LuxLogo()
            }

            Box(modifier = Modifier.flex(1), contentAlignment = Alignment.CenterEnd) {
                HamburgerButton(
                    onClick = {
                        menuState = when (menuState) {
                            SideMenuState.OPEN -> SideMenuState.CLOSED
                            else -> SideMenuState.OPEN
                        }
                    }, menuState = menuState
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
        onClick = onClick
    ) {
        when (menuState) {
            SideMenuState.OPEN -> {
                CloseIcon(
                    modifier = IconStyle.toModifier().color(SitePalette.light.onPrimary)
                )
            }

            else -> {
                HamburgerIcon(
                    modifier = IconStyle.toModifier().color(SitePalette.light.onPrimary)
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