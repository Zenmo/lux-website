package com.zenmo.web.zenmo.domains.lux.components.layout

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.StyleVariable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.pages.SiteGlobals
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.font.HolonBlockHeaderTextStyle
import com.zenmo.web.zenmo.theme.font.HolonLineTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import kotlinx.browser.window
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Span


val LayoutHeaderStyle = CssStyle {
    base {
        Modifier
            .padding(3.5.cssRem)
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Row)
            .gap(1.cssRem)
    }
    Breakpoint.ZERO {
        Modifier
            .padding(1.5.cssRem, 2.cssRem)
    }
    Breakpoint.SM {
        Modifier
            .padding(1.5.cssRem, 2.cssRem)
    }
}

private val DomainHeaderBackgroundColorVar by StyleVariable<Color>()
private val DomainHeaderFontColorVar by StyleVariable<Color>()
val LayoutSectionContainerColorStyle = CssStyle.base {
    Modifier
        .background(DomainHeaderBackgroundColorVar.value())
        .color(DomainHeaderFontColorVar.value())
}

@Composable
fun LuxSubdomainPageLayout(
    title: String,
    enSubtitle: String = "Design your own energy system",
    nlSubtitle: String = "Ontwerp je eigen energiesysteem",
    backgroundColor: Color = SitePalette.light.primary,
    fontColor: Color = SitePalette.light.onPrimary,
    content: @Composable () -> Unit,
) {
    Column(Modifier.fillMaxSize()) {
        SectionContainer(
            horizontalAlignment = Alignment.Start,
            modifier = LayoutSectionContainerColorStyle.toModifier()
                .setVariable(DomainHeaderBackgroundColorVar, backgroundColor)
                .setVariable(DomainHeaderFontColorVar, fontColor)
                .then(LayoutHeaderStyle.toModifier()),
        ) {
            val protocol = window.location.protocol
            A(
                href = "$protocol//${SiteGlobals.LUX_DOMAIN}",
            ) {
                Image(
                    src = "/lux/logos/lux-sun-logo.png",
                    width = 60,
                    height = 60,
                    modifier = Modifier
                        .styleModifier {
                            // using `fill` with svg didn't work, so using `mask` instead
                            property("mask", "url(/lux/logos/lux-sun-logo.png) no-repeat center")
                            property("mask-size", "contain")
                            property(
                                "background-color", when (backgroundColor) {
                                    SitePalette.light.primary -> SitePalette.light.secondary
                                    else -> SitePalette.light.primary
                                }
                            )
                        }
                )
            }
            Column {
                HeaderText(
                    enText = title,
                    nlText = title,
                    modifier = TextStyle.toModifier(HolonBlockHeaderTextStyle)
                        .margin(0.cssRem)
                )
                Span(
                    TextStyle.toModifier(HolonLineTextStyle)
                        .margin(0.cssRem).toAttrs()
                ) {
                    LangText(
                        en = enSubtitle,
                        nl = nlSubtitle,
                    )
                }
            }
        }
        content()
    }
}