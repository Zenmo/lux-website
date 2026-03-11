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
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*


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
                    alt = "lux neighbourhood",
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
        Div {
            P(
                Modifier
                    .margin(0.px)
                    .padding(left = 18.px)
                    .borderLeft(4.px, LineStyle.Solid, SitePalette.light.secondary)
                    .toAttrs()
            ) {
                I {
                    LangText(
                        en = """
                            Grid congestion and electrification pose significant challenges for stakeholders in 
                            residential neighbourhoods, such as municipalities and energy cooperatives.
                        """.trimIndent(),
                        nl = """
                            Netcongestie en elektrificatie vormen aanzienlijke uitdagingen voor belanghebbenden in 
                            woonwijken, zoals gemeenten en energiecoöperaties. 
                        """.trimIndent()
                    )
                }
            }

            P {
                LangText(
                    en = """
                        LUX Neighbourhood enables these stakeholders to identify energy- and grid-related issues and 
                        explore potential solutions. Examples of such solutions include: 
                    """.trimIndent(),
                    nl = """
                        LUX Woonwijk stelt deze belanghebbenden in staat om energie- en netgerelateerde problemen te 
                        identificeren en mogelijke oplossingen te onderzoeken. Voorbeelden van dergelijke oplossingen
                        zijn: 
                    """.trimIndent()
                )
            }
            Ul(
                Modifier
                    .display(DisplayStyle.Flex)
                    .flexDirection(FlexDirection.Column)
                    .gap(8.px)
                    .toAttrs()
            ) {
                Li {
                    LangText(
                        en = "grid reinforcement,",
                        nl = "netverzwaring,"
                    )
                }
                Li {
                    LangText(
                        en = "shared energy storage,",
                        nl = "gedeelde energieopslag,"
                    )
                }
                Li {
                    LangText(
                        en = "increasing self-consumption, and",
                        nl = "het verhogen van het eigen verbruik en"
                    )
                }
                Li {
                    LangText(
                        en = "the use of flexible assets.",
                        nl = "het gebruik van flexibele activa."
                    )
                }
            }
            P {
                LangText(
                    en = """
                        The main purpose for this application area of LUX is to arm stakeholders with quantified and 
                        data-based insights that allow them to discuss accelerate the energy transition of 
                        neighborhoods.
                    """.trimIndent(),
                    nl = """
                        Het belangrijkste doel van dit toepassingsgebied van LUX is om belanghebbenden te voorzien van 
                        gekwantificeerde en op data gebaseerde inzichten waarmee ze de energietransitie in woonwijken 
                        kunnen bespreken en versnellen.
                    """.trimIndent()
                )
            }
        }
    }
}
