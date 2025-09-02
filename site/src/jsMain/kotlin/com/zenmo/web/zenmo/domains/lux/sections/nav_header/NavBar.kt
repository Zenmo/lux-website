package com.zenmo.web.zenmo.domains.lux.sections.nav_header

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.zenmo.navigation.MenuItem
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.components.isPathActive
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.font.HolonLineTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.Ul

val NavListStyle = CssStyle.base {
    Modifier
        .fillMaxHeight()
        .display(DisplayStyle.Flex)
        .justifyContent(JustifyContent.Center)
        .alignItems(AlignItems.Center)
        .gap(10.px)
        .position(Position.Relative)
}


@Composable
fun NavBar() {
    Nav(
        Modifier
            .fillMaxHeight()
            .toAttrs()
    ) {
        Ul(
            NavListStyle.toModifier().toAttrs()
        ) {
            MenuItem.luxMenuItems.forEach { item ->
                when (item) {
                    is MenuItem.Simple -> {
                        LuxMenuItem(
                            href = item.getPath,
                            enTitle = item.title.en,
                            nlTitle = item.title.nl,
                            isActive = isPathActive(href = item.getPath),
                        )
                    }

                    is MenuItem.WithSubs -> {
                        LuxMenuItemWithSubs(
                            titleText = item.title,
                            subItems = item.subItems,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BookADemoButton() {
    A(
        href = "/book-demo",
        attrs = TextStyle.toModifier(HolonLineTextStyle)
            .displayIfAtLeast(Breakpoint.LG)
            .fontSize(1.25.cssRem)
            .borderRadius(16.px)
            .backgroundImage(
                linearGradient(
                    SitePalette.light.primary, SitePalette.light.secondary,
                    LinearGradient.Direction.ToRight
                )
            )
            .color(SitePalette.light.onPrimary)
            .padding(leftRight = 1.5.cssRem, topBottom = 0.65.cssRem)
            .textDecorationLine(TextDecorationLine.None)
            .toAttrs()
    ) {
        LangText(
            en = "Book a demo",
            nl = "Boek een demo",
        )
    }
}