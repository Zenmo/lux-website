package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_neighbourhood.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.ImageContent
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.ResponsiveFlexStyle
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P


@Composable
fun NeighbourhoodHero() {
    LuxSectionContainer {
        Div(
            ResponsiveFlexStyle.toModifier()
                .alignItems(AlignItems.FlexStart)
                .toAttrs()
        ) {
            TextContent()
            Box(Modifier.fillMaxWidth()) {
                ImageContent(
                    imageUrl = "/lux/images/lux_neighbourhood.png",
                    alt = "horizon",
                )
            }
        }
    }
}

@Composable
private fun TextContent() {
    Column(
        modifier = Modifier.fillMaxWidth()
            .gap(1.5.cssRem)
    ) {
        HeaderText(
            enText = LuxApplicationArea.LUX_NEIGHBOURHOOD.areaTitle.en,
            nlText = LuxApplicationArea.LUX_NEIGHBOURHOOD.areaTitle.nl,
        )
        P(
            Modifier.margin(0.px)
                .padding(left = 24.px)
                .borderLeft(4.px, LineStyle.Solid, SitePalette.light.primary)
                .toAttrs()
        ) {
            LangText(
                en = """
                    Municipalities, energy cooperatives, and residents face many challenges related to the energy 
                    transition and grid congestion in residential neighborhoods.
                """.trimIndent(),
                nl = """
                    Gemeenten, energiecooperaties, en bewoners zitten met veel vraagstukken over de verduurzaming en 
                    netcongestie in woonwijken.
                """.trimIndent()
            )
            Br { }
            LangText(
                en = """
                    LUX Neighbourhood simulates real data from a neighborhood’s energy system, including homes, 
                    schools, shops, district heating networks, and more.
                """.trimIndent(),
                nl = """
                    LUX Woonwijk simuleert de echte data van het energiesysteem van een buurt met huizen, scholen, 
                    winkels, warmtenetten, etcetera.
                """.trimIndent()
            )
        }
    }
}
