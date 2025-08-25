package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.BoxSizing
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ListStyleType
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.HeaderInnerStyle
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.LuxLogo
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.NarrowScreenHeaderComponents
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.WideScreenHeaderComponents
import com.zenmo.web.zenmo.domains.zenmo.navigation.MenuItem
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.components.LanguageSwitchButton
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.components.isPathActive
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.Span

@Composable
fun DrechtstedenHeader() {
    WideScreenHeaderComponents(
        items = MenuItem.drechtstedenMenuItems
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
    }
    NarrowScreenHeaderComponents(MenuItem.drechtstedenMenuItems)
}


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
        MenuItem.drechtstedenMenuItems.forEach { item ->
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