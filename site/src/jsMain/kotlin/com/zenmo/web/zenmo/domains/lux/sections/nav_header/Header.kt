package com.zenmo.web.zenmo.domains.lux.sections.nav_header

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.functions.RadialGradient
import com.varabyte.kobweb.compose.css.functions.radialGradient
import com.varabyte.kobweb.compose.css.functions.toImage
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.*
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.before
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.styles.HeaderBottomDividerLineStyle
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.NavHeaderStyle
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.components.LanguageSwitchButton
import com.zenmo.web.zenmo.theme.SitePalette
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLAnchorElement


val HeaderInnerStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .justifyContent(JustifyContent.SpaceBetween)
            .alignItems(AlignItems.Center)
            .width(80.percent)
            .margin(0.px, autoLength)
            .position(Position.Relative)
            .zIndex(5)
    }
    cssRule("* > a") {
        Modifier
            .textDecorationLine(TextDecorationLine.None)
    }
}

private val ActiveIndicatorWidthStyleVar by StyleVariable<CSSLengthOrPercentageNumericValue>()
private val ActiveIndicatorLeftStyleVar by StyleVariable<CSSLengthOrPercentageNumericValue>()

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


val LuxNavStyle = CssStyle {
    cssRule(" ul.main-menu") {
        Modifier
            .display(DisplayStyle.Flex)
            .justifyContent(JustifyContent.Center)
            .alignItems(AlignItems.Center)
            .gap(10.px)
            .position(Position.Relative)
    }

    cssRule(" ul.main-menu > li") {
        Modifier
            .listStyle(ListStyleType.None)
            .position(Position.Relative)
    }

    cssRule(" ul.main-menu > li > a") {
        Modifier
            .padding(10.px)
            .color(SitePalette.light.onBackground)
    }
}

val ActiveMenuStyle = CssStyle {
    base {
        Modifier
            .color(SitePalette.light.primary)
            .fontWeight(FontWeight.Bold)
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
            .then(HeaderBottomDividerLineStyle.toModifier())
            .toAttrs()
    ) {
        Row(
            HeaderInnerStyle.toModifier()
        ) {
            A(
                href = "",
            ) {
                Image(
                    src = "/lux/logos/lux-sun-logo.svg",
                    modifier = Modifier.attrsModifier {
                        attr("width", "50px")
                        attr("height", "50px")
                    }
                )
            }

            Nav(
                LuxNavStyle.toModifier().toAttrs()
            ) {
                Ul(
                    Modifier
                        .classNames("main-menu")
                        .toAttrs()
                ) {
                    LuxSection.entries.forEach { section ->
                        Li {
                            val isActive = sectionInView == section.id
                            A(
                                href = section.href,
                                attrs = Modifier
                                    .thenIf(isActive, ActiveMenuStyle.toModifier())
                                    .toAttrs()
                            ) {
                                LangText(
                                    en = section.title.en,
                                    nl = section.title.nl,
                                )
                            }
                        }
                    }
                }
            }


            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.gap(1.cssRem)
            ) {
                A(
                    href = "",
                    attrs = Modifier
                        .borderRadius(16.px)
                        .background(SitePalette.light.primary)
                        .color(SitePalette.light.onPrimary)
                        .padding(leftRight = 1.5.cssRem, topBottom = 0.65.cssRem)
                        .textDecorationLine(TextDecorationLine.None)
                        .toAttrs()
                ) {
                    LangText(
                        en = "BOOK A DEMO NOW!",
                        nl = "BOEK NU EEN DEMO!"
                    )
                }

                LanguageSwitchButton()
            }
        }

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
                .setVariable(ActiveIndicatorLeftStyleVar, indicatorLeft)
                .toAttrs()
        )
    }
}