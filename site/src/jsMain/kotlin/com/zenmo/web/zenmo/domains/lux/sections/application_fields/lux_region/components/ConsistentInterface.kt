package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_region.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.functions.clamp
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiBarChart
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLayers
import com.varabyte.kobweb.silk.components.icons.mdi.MdiMap
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.shapes.Circle
import com.varabyte.kobweb.silk.theme.shapes.clip
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.styles.HoverBoxShadowStyle
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.theme.LuxSpecificColorHues
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.dom.P


@Composable
fun ConsistentInterface() {
    LuxSectionContainer(
        modifier = Modifier
            .background(SitePalette.light.overlay)
    ) {
        HeaderText(
            enText = "Consistent Interface",
            nlText = "Consistente Interface"
        )
        LangText(
            en = "For recognizability, the setup is always the same:",
            nl = "Voor de herkenbaarheid is de opzet steeds hetzelfde:"
        )

        SimpleGrid(
            numColumns = numColumns(base = 1, sm = 1, md = 2, lg = 3, xl = 3),
            modifier = Modifier.gap(1.5.cssRem)
        ) {
            ScenarioInputsCard(
                title = LocalizedText(
                    en = "Left Panel",
                    nl = "Linker Paneel"
                ),
                description = LocalizedText(
                    en = "Adjust the inputs for the what-if scenarios",
                    nl = "Pas jij de input’s voor de wat als scenario’s aan"
                ),
                icon = { MdiBarChart(Modifier.fontSize(32.px)) },
                color = LuxSpecificColorHues().luxBlue
            )
            ScenarioInputsCard(
                title = LocalizedText(
                    en = "Middle",
                    nl = "Midden"
                ),
                description = LocalizedText(
                    en = "A map on which the impact in the room is visualized",
                    nl = "Een kaartje waarop de impact in de ruimte wordt gevisualiseerd"
                ),
                icon = { MdiMap(Modifier.fontSize(32.px)) },
                color = LuxSpecificColorHues().luxGreen
            )
            ScenarioInputsCard(
                title = LocalizedText(
                    en = "Right Panel",
                    nl = "Rechter Paneel"
                ),
                description = LocalizedText(
                    en = """
                        The outputs based on a large number of key performance indicators (KPIs) that can be 
                        supplemented for you if desired
                    """.trimIndent(),
                    nl = """
                        de output’s gebaseerd op een groot aantal kritieke prestatie indicatoren (KPI’s) die desgewenst 
                        voor jou aangevuld kunnen worden
                    """.trimIndent()
                ),
                icon = { MdiLayers(Modifier.fontSize(32.px)) },
                color = LuxSpecificColorHues().luxYellow
            )
        }
    }
}

@Composable
private fun ScenarioInputsCard(
    title: LocalizedText,
    description: LocalizedText,
    icon: @Composable () -> Unit,
    color: Color
) {
    Column(
        Modifier
            .background(Colors.White)
            .luxBorderRadius(LuxCornerRadius.xl)
            .then(HoverBoxShadowStyle.toModifier()),
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(clamp(120.px, 2.vw, 225.px)),
            contentAlignment = Alignment.Center
        ) {
            Box(
                Modifier
                    .size(64.px)
                    .background(color.lightened(0.85f))
                    .color(color)
                    .clip(shape = Circle()),
                contentAlignment = Alignment.Center
            ) {
                icon()
            }
        }
        Column(
            Modifier
                .gap(24.px)
                .fillMaxWidth()
                .padding(
                    leftRight = clamp(32.px, 5.vw, 64.px),
                    bottom = 32.px,
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SubHeaderText(
                enText = title.en,
                nlText = title.nl,
                textColor = SitePalette.light.primary
            )
            P(
                Modifier
                    .margin(0.px)
                    .textAlign(TextAlign.Center)
                    .toAttrs()
            ) {
                LangText(
                    en = description.en,
                    nl = description.nl
                )
            }
        }
    }
}