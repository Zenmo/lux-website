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
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
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
        .display(DisplayStyle.Flex)
        .justifyContent(JustifyContent.Center)
        .alignItems(AlignItems.Center)
        .gap(10.px)
        .position(Position.Relative)
}


@Composable
fun NavBar(
    sectionInView: String,
) {
    Nav {
        Ul(
            NavListStyle.toModifier().toAttrs()
        ) {
            LuxSection.entries.forEach { section ->
                val isActive = sectionInView == section.id

                MenuSectionItem(
                    href = section.href,
                    enTitle = section.title.en,
                    nlTitle = section.title.nl,
                    isActive = isActive,
                )
            }
        }
    }
}

@Composable
fun BookADemoButton() {
    A(
        href = "/book-demo",
        attrs = TextStyle.toModifier(HolonLineTextStyle)
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