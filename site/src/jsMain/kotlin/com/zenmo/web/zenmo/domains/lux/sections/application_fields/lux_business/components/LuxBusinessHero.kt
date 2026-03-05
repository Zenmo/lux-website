package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_business.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.fa.FaMagnifyingGlass
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.ResponsiveFlexStyle
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.LuxSpecificColorHues
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.B
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P

@Composable
fun LuxBusinessHero() {
    LuxSectionContainer(
        modifier = Modifier.alignItems(AlignItems.FlexStart)
    ) {
        HeaderText(
            enText = LuxApplicationArea.LUX_BUSINESS.label.en,
            nlText = LuxApplicationArea.LUX_BUSINESS.label.nl,
        )
        Column {
            Row(
                Modifier.gap(8.px)
                    .color(LuxSpecificColorHues().luxRed),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FaMagnifyingGlass()
                LangText(
                    en = "The Problem",
                    nl = "Het Probleem"
                )
            }
            Div(
                ResponsiveFlexStyle.toModifier()
                    .alignItems(AlignItems.FlexStart)
                    .toAttrs()
            ) {
                Div(
                    Modifier.fillMaxWidth()
                        .toAttrs()
                ) {
                    P {
                        LangText(
                            en = """
                            Businesses are rapidly electrifying, but they are also increasingly being told by grid 
                            operators that they won't be able to get the power they need in the short term because 
                            there is insufficient transmission capacity.
                        """.trimIndent(),
                            nl = """
                            Bedrijven elektrificeren in hoog tempo maar tegelijkertijd krijgen ze steeds vaker van de 
                            netbeheerder te horen dat ze op korte termijn niet de stroom kunnen krijgen die ze nodig 
                            hebben, omdat er onvoldoende transportcapaciteit beschikbaar is.
                        """.trimIndent()
                        )
                    }
                    P {
                        LangText(
                            en = "This problem is called ",
                            nl = "Dit probleem noemen we "
                        )
                        B {
                            LangText(
                                en = "grid congestion.",
                                nl = "netcongestie."
                            )
                        }
                    }
                }

                Div(
                    Modifier.fillMaxWidth()
                        .toAttrs()
                ) {
                    P {
                        LangText(
                            en = """
                            As a result, businesses are often unable to expand, electrify, or settle in the designated 
                            areas. In some cases, this leads to companies generating their own electricity with diesel 
                            generators.
                        """.trimIndent(),
                            nl = """
                            In sommige gevallen leidt dit er toe dat bedrijven stroom gaan opwekken met 
                            dieselaggregaten.  
                        """.trimIndent()
                        )
                    }
                    P(
                        Modifier.margin(0.px)
                            .padding(left = 24.px)
                            .fontWeight(FontWeight.Bold)
                            .borderLeft(4.px, LineStyle.Solid, SitePalette.light.secondary)
                            .toAttrs()
                    ) {
                        LangText(
                            en = """
                            An expensive "solution" that runs counter to sustainability.
                        """.trimIndent(),
                            nl = """
                            Dit is een dure “oplossing” die haaks staat op de verduurzaming waar we in Nederland naar 
                            streven. 
                        """.trimIndent()
                        )
                    }
                }
            }
        }
    }
}