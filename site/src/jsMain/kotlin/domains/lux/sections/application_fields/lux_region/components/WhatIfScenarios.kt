package domains.lux.sections.application_fields.lux_region.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiHelp
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.components.LuxSectionContainer
import energy.lux.frontend.domains.lux.styles.HoverBoxShadowStyle
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.theme.SitePalette
import energy.lux.frontend.theme.styles.LuxCornerRadius
import energy.lux.frontend.theme.styles.luxBorderRadius
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
        en = """
            What if we implement small-scale low-temperature heat networks, will that result in a more balanced heat 
            vision with less grid impact?
        """.trimIndent(),
        nl = """
            Wat als we in deze wijken kleinschalige warmtenetten met WKO's toepassen, levert dat een robustere 
            warmtevisie op?
        """.trimIndent()
    ),
    LocalizedText(
        en = """
            What if we install neighborhood batteries alongside the existing transformers in these neighborhoods, how 
            much can we reduce grid congestion?
        """.trimIndent(),
        nl = """
            Wat als we in deze buurten buurtbatterijen bij de bestaande trafo's plaatsen, kunnen we dan minder 
            verzwaren?
        """.trimIndent()
    ),
    LocalizedText(
        en = "What if business parks become energy hubs, and what is the effect on the regional energy vision?",
        nl = "Wat als bedrijventerreinen energiehubs worden, wat is het effect op de regionale energievisie?"
    ),
    LocalizedText(
        en = "What if we directly link large-scale generation, storage, and demand?",
        nl = "Wat als we grootschalige opwek, opslag en vraag direct aan elkaar koppelen?"
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
            nl = "We zetten het model vaak in voor 'wat-als' scenario's",
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