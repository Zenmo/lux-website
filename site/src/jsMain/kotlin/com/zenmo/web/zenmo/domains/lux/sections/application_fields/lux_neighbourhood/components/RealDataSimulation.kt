package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_neighbourhood.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.*
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.ResponsiveFlexStyle
import com.zenmo.web.zenmo.domains.lux.sections.home.CardGridStyle
import com.zenmo.web.zenmo.domains.lux.styles.mutedWhite
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.LuxSpecificColorHues
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span

@Composable
fun RealDataSimulation() {
    LuxSectionContainer(
        Modifier
            .background(LuxSpecificColorHues().luxBlackRussian)
            .color(Colors.White),
    ) {
        Div(
            ResponsiveFlexStyle.toModifier()
                .alignItems(AlignItems.FlexStart)
                .toAttrs()
        ) {
            EnergySystemFeatureText()
            EnergySystemFeatureGrid()
        }
    }
}

@Composable
private fun EnergySystemFeatureText() {
    Column(
        modifier = Modifier.fillMaxWidth()
            .gap(1.cssRem)
    ) {
        HeaderText(
            enText = "Real Data Simulation",
            nlText = "Simulatie met echte data",
        )

        P {
            LangText(
                en = """
                            The essence of LUX Neighbourhoud is simulating real data from the neighborhood’s energy 
                            system. This includes the grid lay-out, household characteristics, actual installed solar 
                            panels, charging stations, district heating, electricity demand profiles from schools, 
                            shops, and much more.  
                        """.trimIndent(),
                nl = """
                            De essentie van LUX Neighbourhoud is het simuleren van echte data uit het energiesysteem 
                            van de wijk. Dit omvat de lay-out van het elektriciteitsnet, kenmerken van huishoudens, 
                            daadwerkelijk geïnstalleerde zonnepanelen, laadstations, stadsverwarming, 
                            elektriciteitsvraagprofielen van scholen, winkels en nog veel meer.
                        """.trimIndent()
            )
        }
    }
}

@Composable
private fun EnergySystemFeatureGrid() {
    Div(
        Modifier.fillMaxWidth()
            .toAttrs()
    ) {
        Div(
            CardGridStyle.toModifier()
                .toAttrs()
        ) {
            EnergySystemFeatureCard(
                title = LocalizedText(
                    en = "Grid Layout",
                    nl = "Net Lay-out"
                ),
                description = LocalizedText(
                    en = "Network topology",
                    nl = "Netwerktopologie"
                ),
                icon = { MdiLan() }
            )
            EnergySystemFeatureCard(
                title = LocalizedText(
                    en = "Households",
                    nl = "Huishoudens"
                ),
                description = LocalizedText(
                    en = "Household characteristics",
                    nl = "Kenmerken van huishoudens"
                ),
                icon = { MdiApartment() }
            )
            EnergySystemFeatureCard(
                title = LocalizedText(
                    en = "Solar Panels",
                    nl = "Zonnepanelen"
                ),
                description = LocalizedText(
                    en = "Installed solar systems",
                    nl = "Geïnstalleerde zonnestroomsystemen"
                ),
                icon = { MdiSolarPower() }
            )
            EnergySystemFeatureCard(
                title = LocalizedText(
                    en = "EV Charging",
                    nl = "EV Laden"
                ),
                description = LocalizedText(
                    en = "Charging stations",
                    nl = "Laadstations"
                ),
                icon = { MdiHeatPump() }
            )
            EnergySystemFeatureCard(
                title = LocalizedText(
                    en = "District Heating",
                    nl = "Stadsverwarming"
                ),
                description = LocalizedText(
                    en = "Heating networks",
                    nl = "Warmtenetten"
                ),
                icon = { MdiLocalFireDepartment() }
            )
            EnergySystemFeatureCard(
                title = LocalizedText(
                    en = "Demand Profiles",
                    nl = "Vraagprofielen"
                ),
                description = LocalizedText(
                    en = "Schools, shops & more",
                    nl = "Scholen, winkels & meer"
                ),
                icon = { MdiLocationCity() }
            )
        }
    }
}

@Composable
private fun EnergySystemFeatureCard(
    title: LocalizedText,
    description: LocalizedText,
    icon: @Composable () -> Unit,
) {
    Column(
        Modifier
            .fillMaxWidth()
            .background(Colors.White.copyf(alpha = 0.1f))
            .mutedWhite()
            .padding(18.px)
            .luxBorderRadius(LuxCornerRadius.lg)
            .gap(8.px)
    ) {
        Span(
            Modifier
                .color(SitePalette.light.secondary)
                .toAttrs()
        ) {
            icon()
        }
        HeaderText(
            enText = title.en,
            nlText = title.nl,
            textColor = Colors.White,
            modifier = Modifier.fontSize(1.25.cssRem)
        )
        P(
            Modifier
                .margin(0.cssRem)
                .toAttrs()
        ) {
            LangText(
                en = description.en,
                nl = description.nl
            )
        }
    }
}
