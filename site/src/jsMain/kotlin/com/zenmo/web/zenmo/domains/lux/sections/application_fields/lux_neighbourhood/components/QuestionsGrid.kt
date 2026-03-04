package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_neighbourhood.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.icons.mdi.IconStyle
import com.varabyte.kobweb.silk.components.icons.mdi.MdiHelp
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.home.CardGridStyle
import com.zenmo.web.zenmo.domains.lux.styles.mutedWhite
import com.zenmo.web.zenmo.domains.lux.styles.verticalLinearBackground
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.LuxSpecificColorHues
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P

private val questions = listOf(
    LocalizedText(
        en = "How large is the congestion problem really in this neighborhood?",
        nl = "Hoe groot is het congestieprobleem echt in deze buurt?"
    ),
    LocalizedText(
        en = "How much CO₂ do we save if we take this neighborhood off natural gas?",
        nl = "Hoeveel CO₂ besparen we als we deze buurt van het gas halen?"
    ),
    LocalizedText(
        en = "What is the maximum potential of PV, and what share of it would be consumed locally?",
        nl = "Wat is de maximale potentie van PV en welk deel gaat naar lokale consumptie?"
    ),
    LocalizedText(
        en = "Which heating solutions are suitable here, and which are not?",
        nl = "Welke warmteoplossingen passen hier wel en niet?"
    ),
    LocalizedText(
        en = "What would be the grid impact of smart charging control and vehicle-to-grid?",
        nl = "Wat zou de netimpact zijn met slimme aansturing van laden en vehicle-to-grid?"
    ),
    LocalizedText(
        en = "Can we successfully decarbonize this neighborhood using community batteries?",
        nl = "Kunnen we met buurtbatterijen deze buurt wel verduurzamen?"
    )
)


@OptIn(DelicateApi::class)
@Composable
fun QuestionsGrid() {
    val breakpoint = rememberBreakpoint()
    LuxSectionContainer(
        Modifier.alignItems(AlignItems.FlexStart)
            .gap(1.5.cssRem)
            .background(LuxSpecificColorHues().luxBlackRussian)
            .color(Colors.White),
    ) {
        Column {
            Row {
                Box(
                    Modifier
                        .displayIfAtLeast(Breakpoint.MD)
                        .size(48.px)
                        .margin(right = 12.px)
                        .flexShrink(0)
                        .luxBorderRadius()
                        .verticalLinearBackground()
                        .color(Colors.White),
                    contentAlignment = Alignment.Center
                ) { MdiHelp(style = IconStyle.OUTLINED) }
                HeaderText(
                    enText = "What LUX Neighbourhood solves",
                    nlText = "Wat LUX Woonwijk oplost",
                )
            }
            P {
                LangText(
                    en = "LUX Neighborhood has helped municipalities address:",
                    nl = "Typische vragen waar LUX Woonbuurten gemeenten bij heeft geholpen:"
                )
            }
        }
        Div(
            CardGridStyle.toModifier()
                .height(auto)
                .alignSelf(AlignSelf.Stretch)
                .thenIf(
                    breakpoint < Breakpoint.MD,
                    Modifier.display(DisplayStyle.Flex)
                        .flexDirection(FlexDirection.Column)
                )
                .toAttrs()
        ) {
            questions.forEach { question ->
                QuestionItem(question)
            }
        }
    }
}

@Composable
private fun QuestionItem(
    question: LocalizedText
) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(32.px)
            .gap(12.px)
            .background(Colors.White.copyf(alpha = 0.1f))
            .mutedWhite()
            .luxBorderRadius(LuxCornerRadius.lg)
            .borderLeft(4.px, LineStyle.Solid, SitePalette.light.primary)
    ) {
        MdiHelp(Modifier.color(SitePalette.light.primary))
        P(
            Modifier.margin(0.px)
                .toAttrs()
        ) {
            LangText(
                en = question.en,
                nl = question.nl
            )
        }
    }
}
