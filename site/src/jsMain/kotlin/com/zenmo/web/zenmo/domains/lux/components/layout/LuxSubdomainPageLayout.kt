package com.zenmo.web.zenmo.domains.lux.components.layout

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.layouts.PageLayout
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


@Composable
fun LuxSubdomainPageLayout(
    title: String,
    enSubtitle: String = "Design your own energy system",
    nlSubtitle: String = "Ontwerp je eigen energiesysteem",
    content: @Composable ColumnScope.() -> Unit,
) {
    PageLayout(
        header = {
            SectionContainer(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .background(SitePalette.light.primary)
                    .color(SitePalette.light.onPrimary)
                    .then(LayoutHeaderStyle.toModifier()),
            ) {
                val protocol = window.location.protocol
                A(
                    href = "$protocol//${SiteGlobals.LUX_DOMAIN}",
                ) {
                    Image(
                        src = "/lux/logos/lux-sun-logo.svg",
                        width = 60,
                        height = 60,
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
        },
        footer = {},
        title = title
    ) {
        content()
    }
}