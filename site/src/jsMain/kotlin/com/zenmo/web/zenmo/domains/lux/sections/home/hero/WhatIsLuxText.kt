package com.zenmo.web.zenmo.domains.lux.sections.home.hero

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.JustifySelf
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.theme.font.BodyTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P

@Composable
fun WhatIsLuxText(
    breakpoint: Breakpoint
) {
    Div(
        Modifier.Companion
            .display(DisplayStyle.Flex)
            .fillMaxWidth()
            .padding(0.px, 32.px)
            .thenIf(breakpoint < Breakpoint.MD, Modifier.padding(topBottom = 18.px, leftRight = 18.px))
            .alignItems(AlignItems.Center)
            .alignSelf(AlignSelf.Stretch)
            .justifySelf(JustifySelf.Stretch)
            .luxBorderRadius(LuxCornerRadius.lg)
            .border(1.px, LineStyle.Solid, Colors.White.copyf(alpha = 0.1f))
            .background(Colors.Black.copyf(alpha = 0.25f))
            .toAttrs()
    ) {
        P(
            TextStyle.toModifier(BodyTextStyle)
                .opacity(0.9)
                .toAttrs()
        ) {
            LangText(
                en = """
                        The open source LUX tooling supports local communities or business areas with interactive 
                        digital twins. LUX lights the way to an energy system that is clean and affordable and puts the 
                        power in the hands of users.
                    """.trimIndent(),
                nl = """
                        De open-source LUX-tool ondersteunt lokale gemeenschappen of bedrijventerreinen met 
                        interactieve digital twins. LUX wijst de weg naar een energiesysteem dat schoon en betaalbaar 
                        is en de gebruikers de regie geeft.
                    """.trimIndent()
            )
        }
    }
}