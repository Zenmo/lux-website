package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_region.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiHelp
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.styles.HoverBoxShadowStyle
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P


@Composable
fun WhatIfScenarios() {
    LuxSectionContainer(
        modifier = Modifier
            .background(SitePalette.light.overlay)
            .alignItems(AlignItems.FlexStart),
    ) {
        HeaderText(
            enText = "What-if scenarios",
            nlText = "Wat-als scenario's",
        )

        ExampleScenariosList()
    }
}

private val exampleScenarios = listOf(
    LocalizedText(
        en = "What if we choose a heat network in this neighborhood and heat pumps in this neighborhood?",
        nl = "Wat als we in deze buurt een warmtenet kiezen en in deze buurt warmtepompen?"
    ),
    LocalizedText(
        en = """
            What if we provide this new housing estate with smartly controlled home or neighbourhood batteries so that 
            3x as many houses fit on the existing electricity grid?
        """.trimIndent(),
        nl = """
            Wat als we deze nieuwbouwwijk voorzien van slim aangestuurde thuis- of buurtbatterijen zodat er 3x zoveel 
            huizen op het bestaande elektriciteitsnet passen?
        """.trimIndent()
    ),
    LocalizedText(
        en = """
            What if we move this wind farm from here to there? To what extent does this relieve the electricity grid in 
            such a way that more new construction and activity is possible?
        """.trimIndent(),
        nl = """
            Wat als we dit windpark verplaatsen van hier naar daar? In hoeverre ontlast dit het elektriciteitsnet 
            zodanig dat er meer nieuwbouw en bedrijvigheid mogelijk is?
        """.trimIndent()
    ),
    LocalizedText(
        en = """
            What if we transform this business park into an energy hub? To what extent is more activity possible on the 
            existing network? Companies in this energy hub are massively installing batteries behind the meter?
        """.trimIndent(),
        nl = """
            Wat als we dit bedrijventerrein omvormen tot energiehub? In hoeverre is er dan op het bestaande netwerk 
            meer bedrijvigheid mogelijk? bedrijven in deze energiehub massaal batterijen achter de meter plaatsen?
        """.trimIndent()
    ),
)

@Composable
private fun ExampleScenariosList() {
    Column(
        modifier = Modifier.fillMaxWidth()
            .gap(1.cssRem)
    ) {
        LangText(
            en = "You can calculate, for example:",
            nl = "Je kunt bijvoorbeeld doorrekenen:",
        )

        for (scenario in exampleScenarios) {
            ScenarioExampleItem(scenarioText = scenario)
        }
    }
}

@Composable
private fun ScenarioExampleItem(
    scenarioText: LocalizedText
) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(32.px)
            .gap(12.px)
            .background(Colors.White)
            .luxBorderRadius(LuxCornerRadius.lg)
            .borderLeft(4.px, LineStyle.Solid, SitePalette.light.primary)
            .then(HoverBoxShadowStyle.toModifier())
    ) {
        MdiHelp(Modifier.color(SitePalette.light.primary))
        P(
            Modifier.margin(0.px)
                .toAttrs()
        ) {
            LangText(
                en = scenarioText.en,
                nl = scenarioText.nl
            )
        }
    }
}