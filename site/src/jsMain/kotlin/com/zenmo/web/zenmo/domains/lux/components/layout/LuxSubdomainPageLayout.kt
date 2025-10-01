package com.zenmo.web.zenmo.domains.lux.components.layout

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.layouts.PageLayout
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.HeaderInnerStyle
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.LuxLogo
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.components.LuxHeaderPaddingStyle
import com.zenmo.web.zenmo.domains.lux.styles.HeaderBottomDividerLineStyle
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.NavHeaderStyle
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.components.LanguageSwitchButton
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Header


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
    content: @Composable ColumnScope.() -> Unit,
) {
    PageLayout(
        header = {
            LayoutHeader(title = title)
        },
        footer = {},
        title = title
    ) {
        content()
    }
}

@Composable
private fun LayoutHeader(
    title: String,
) {
    Header(
        attrs = NavHeaderStyle.toModifier()
            .boxShadow(spreadRadius = 0.px, color = Color.transparent)
            .then(LuxHeaderPaddingStyle.toModifier())
            .then(HeaderBottomDividerLineStyle.toModifier())
            .toAttrs()
    ) {
        Row(
            HeaderInnerStyle.toModifier()
                .fillMaxWidth().gap(1.cssRem),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(contentAlignment = Alignment.CenterStart) {
                LuxLogo(asLink = true)
            }

            Box(modifier = Modifier.flex(1), contentAlignment = Alignment.Center) {
                SubHeaderText(
                    enText = title,
                    nlText = title,
                    modifier = Modifier
                        .margin(0.cssRem)
                )
            }

            Box(modifier = Modifier.displayIfAtLeast(Breakpoint.MD), contentAlignment = Alignment.CenterEnd) {
                LanguageSwitchButton()
            }
        }
    }
}