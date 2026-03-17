package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.styles.HoverBoxShadowStyle
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P


@Composable
fun EnergyHubExampleFeatures() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .textAlign(TextAlign.Center)
            .gap(1.cssRem)
    ) {
        SubHeaderText(
            enText = "Example features to explore with LUX Energy Hub",
            nlText = "Voorbeelden van wat je eenvoudig kunt verkennen met LUX Energy Hub",
        )
        EnergyCollaborationGrid()
    }
}


@Composable
private fun EnergyCollaborationGrid() {
    SimpleGrid(
        numColumns = numColumns(base = 1, sm = 1, md = 2, lg = 4, xl = 4),
        modifier = Modifier.gap(1.5.cssRem)
    ) {
        EnergyCollaborationCard(
            title = LocalizedText(
                en = "Battery storage",
                nl = "Installeer batterijen"
            ),
            description = LocalizedText(
                en = "Shared or individual with many different algorithms.",
                nl = "Collectieve of private batterijpakketten met verschillende vormen van aansturing."
            ),
            titleColor = SitePalette.light.primary
        )
        EnergyCollaborationCard(
            title = LocalizedText(
                en = "Group contract (GTO)",
                nl = "Groepscontract (GTO)"
            ),
            description = LocalizedText(
                en = "Administratively sharing connections to have higher limits in times of need.",
                nl = "Verken de potentie van groepscontracten met je netburen."
            ),
            titleColor = SitePalette.light.secondary
        )
        EnergyCollaborationCard(
            title = LocalizedText(
                en = "Electric vehicles",
                nl = "Elektrische voertuigen"
            ),
            description = LocalizedText(
                en = "Add electric vehicles and various forms of smart charging.",
                nl = "Elektrische je vloot en verken de impact van allerlei vormen (slim) laden."
            ),
            titleColor = SitePalette.light.primary
        )
        EnergyCollaborationCard(
            title = LocalizedText(
                en = "Smart heating",
                nl = "Slimme ruimteverwarming"
            ),
            description = LocalizedText(
                en = "Optimize heating systems.",
                nl = "Elektrificeer warmte en stuur daar slim op."
            ),
            titleColor = SitePalette.light.secondary
        )
    }
}


@Composable
private fun EnergyCollaborationCard(
    title: LocalizedText,
    description: LocalizedText,
    titleColor: CSSColorValue
) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(24.px)
            .gap(12.px)
            .background(Colors.White)
            .luxBorderRadius(LuxCornerRadius.lg)
            .borderLeft(4.px, LineStyle.Solid, titleColor)
            .then(HoverBoxShadowStyle.toModifier())
    ) {
        H3(
            Modifier
                .color(titleColor)
                .fontWeight(FontWeight.Normal)
                .toAttrs()
        ) {
            LangText(
                en = title.en,
                nl = title.nl
            )
        }
        P {
            LangText(
                en = description.en,
                nl = description.nl
            )
        }
    }
}