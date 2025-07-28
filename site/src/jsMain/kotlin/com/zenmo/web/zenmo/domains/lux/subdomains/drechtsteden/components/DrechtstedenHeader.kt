package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.*
import com.zenmo.web.zenmo.domains.lux.styles.HeaderBottomDividerLineStyle
import com.zenmo.web.zenmo.domains.zenmo.navigation.MenuItem
import com.zenmo.web.zenmo.domains.zenmo.navigation.MenuLanguage
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.NavHeaderStyle
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.components.LanguageSwitchButton
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.components.isPathActive
import com.zenmo.web.zenmo.theme.SitePalette
import kotlinx.browser.document
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.dom.Header
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLElement

@Composable
fun DrechtstedenHeader() {
    Header(
        attrs = NavHeaderStyle.toModifier()
            .boxShadow(spreadRadius = 0.px, color = Color.transparent)
            .then(LuxHeaderPaddingStyle.toModifier())
            .then(HeaderBottomDividerLineStyle.toModifier())
            .toAttrs()
    ) {
        Row(
            HeaderInnerStyle.toModifier()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            LuxLogo(asLink = true)
            NavBar()
            LanguageSwitchButton()
        }

        Box(
            Modifier.displayIfAtLeast(Breakpoint.MD)
        ) {
            var indicatorWidth by remember { mutableStateOf(0.px) }
            var indicatorLeft by remember { mutableStateOf(0.px) }
            val activeItem = drechtstedenMenuItems.first { isPathActive(it.getPath) } as MenuItem.Simple

            LaunchedEffect(activeItem) {
                val element = document.getElementById(activeItem.title.en.lowercase()) as HTMLElement?
                if (element != null) {
                    val elementRect = element.getBoundingClientRect()
                    indicatorWidth = elementRect.width.px
                    indicatorLeft = elementRect.left.px
                }
            }

            Span(
                attrs = LuxActiveMenuIndicatorStyle.toModifier()
                    .transition(Transition.None)
                    .setVariable(ActiveIndicatorWidthStyleVar, indicatorWidth)
                    .setVariable(ActiveIndicatorLeftStyleVar, indicatorLeft).toAttrs()
            )
        }
    }
}

val drechtstedenMenuItems = listOf(
    MenuItem.Simple(
        path = "/",
        title = MenuLanguage(
            en = "Home",
            nl = "Thuis",
        )
    ),
    MenuItem.Simple(
        path = "/res-region",
        title = MenuLanguage(
            en = "RES Region",
            nl = "RES Regio",
        )
    ),
    MenuItem.Simple(
        path = "/municipalities",
        title = MenuLanguage(
            en = "Municipalities",
            nl = "Gemeentes",
        )
    ),
    MenuItem.Simple(
        path = "/business-parks",
        title = MenuLanguage(
            en = "Business Parks",
            nl = "Bedrijventerreinen",
        )
    ),
)

@Composable
private fun NavBar() {
    Nav(
        attrs = Modifier
            .boxSizing(BoxSizing.BorderBox)
            .borderRadius(30.px)
            .listStyle(ListStyleType.None)
            .display(DisplayStyle.Flex)
            .justifyContent(JustifyContent.Center)
            .gap(1.cssRem)
            .toAttrs()
    ) {
        drechtstedenMenuItems.forEach { item ->
            Link(
                path = item.getPath,
                modifier = Modifier
                    .id(item.title.en.lowercase())
                    .textDecorationLine(TextDecorationLine.None)
                    .color(SitePalette.light.onBackground)
            ) {
                Span(
                    Modifier
                        .display(DisplayStyle.Block)
                        .thenIf(
                            isPathActive(href = item.getPath),
                            Modifier
                                .color(SitePalette.light.primary)
                                .fontWeight(FontWeight.Bold)
                        )
                        .padding(8.px)
                        .toAttrs()
                ) {
                    LangText(en = item.title.en, nl = item.title.nl)
                }
            }
        }
    }
}