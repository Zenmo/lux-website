package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_region.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.functions.clamp
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiCategory
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.ResponsiveFlexStyle
import com.zenmo.web.zenmo.domains.lux.styles.secondaryGradientBackground
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P


@Composable
fun MoreThanAMap() {
    LuxSectionContainer(
        modifier = Modifier
            .background(SitePalette.light.overlay)
            .alignItems(AlignItems.FlexStart),
    ) {
        HeaderText(
            enText = "More than a map",
            nlText = "Meer dan een kaart",
        )
        Div(
            ResponsiveFlexStyle.toModifier()
                .alignItems(AlignItems.FlexStart)
                .toAttrs()
        ) {
            BeyondStaticMaps()
            AgentBasedApproach()
        }
    }
}


@Composable
private fun BeyondStaticMaps() {
    Column(
        modifier = Modifier.fillMaxWidth()
            .gap(1.cssRem)
    ) {
        P {
            LangText(
                en = """
                 LUX municipality, LUX-RES and LUX province is at first glance mainly a map comparable to the PBL start 
                 analysis that indicates ....   
                """.trimIndent()
            )
        }
        Column(
            Modifier
                .fillMaxWidth()
                .padding(clamp(32.px, 5.vw, 64.px))
                .gap(1.cssRem)
                .luxBorderRadius(LuxCornerRadius.xl)
                .secondaryGradientBackground()
        ) {
            HeaderText(
                enText = "However, LUX goes much further",
                nlText = "LUX gaat echter veel verder",
                modifier = Modifier.fontSize(2.cssRem)
            )
            P {
                LangText(
                    en = """
                        It is a dynamic simulation in which all these neighbourhoods are 'agents' with which 
                        different scenarios can be calculated.
                    """.trimIndent(),
                    nl = """
                        Het is een dynamische simulatie waarin al deze buurten ‘agents’ zijn waarmee verschillende wat 
                        als scenario’s kunnen worden doorgerekend.
                    """.trimIndent()
                )
            }
        }
    }
}

@Composable
private fun AgentBasedApproach() {
    Column(
        Modifier.fillMaxWidth()
            .luxBorderRadius(LuxCornerRadius.xl)
            .background(Colors.White)
            .border(1.px, LineStyle.Solid, Colors.LightGrey)
            .padding(32.px)
            .gap(1.cssRem)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            MdiCategory(
                Modifier.fontSize(48.px)
                    .color(SitePalette.light.primary)
            )

            Column(
                Modifier.margin(left = 16.px)
            ) {
                LangText(
                    en = "Approach",
                    nl = "Aanpak"
                )
                SubHeaderText(
                    enText = "Agent-Based",
                    nlText = "Agent-Based",
                    textColor = SitePalette.light.primary,
                    modifier = Modifier.fontSize(1.5.cssRem)
                )
            }
        }

        P {
            LangText(
                en = """
                    Each neighborhood acts as an autonomous agent, allowing for realistic bottom-up modeling of 
                    regional energy systems.
                    """.trimIndent(),
                nl = """
                    Elke buurt fungeert als een autonome agent, wat realistische bottom-up modellering van regionale 
                    energiesystemen mogelijk maakt.
                    """.trimIndent()
            )
        }
    }
}