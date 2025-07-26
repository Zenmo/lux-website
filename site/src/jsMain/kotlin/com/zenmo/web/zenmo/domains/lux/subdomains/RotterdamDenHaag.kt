package com.zenmo.web.zenmo.domains.lux.subdomains

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.MediaContentLayout
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.components.widgets.ZenmoInlineLink
import com.zenmo.web.zenmo.domains.lux.components.VerticalProfileContactCard
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import kotlin.uuid.Uuid

@Composable
fun RotterdamDenHaagIndex() {
    LuxSubdomainPageLayout(
        title = "Warmte in regio Rotterdam-Den Haag"
    ) {
        Column(
            modifier = Modifier
                .gap(5.cssRem).margin(bottom = 5.cssRem),
        ) {
            HeaderText(
                enText = "DISCLAIMER: THIS IS A MOCK-UP VERSION",
                nlText = "DISCLAIMER: DIT IS EEN MOCK-UP VERSIE",
                modifier = Modifier.fillMaxWidth()
                    .background(SitePalette.light.surfaceContainerLow)
                    .textAlign(TextAlign.Center)
                    .margin(0.cssRem)
                    .padding(4.cssRem)
            )
            SectionContainer {
                MediaContentLayout(
                    imageUrl = "/lux/images/Mock-up-MRDH.png",
                    imageModifier = Modifier
                        .borderRadius(30.px).border(
                            width = 2.px,
                            color = SitePalette.light.primary,
                            style = LineStyle.Solid
                        ),
                    reversed = true,
                    keepImageAsIs = true,
                    description = {
                        P {
                            LangText(
                                en = """
                                Below is a mock-up of the digital twin for the sustainability of the heat system 
                                in the Rotterdam-Den Haag metropolitan region. This tool allows for comparison of 
                                different heat systems, examining the integration of smart systems and local ownership, 
                                and linking to the WarmtelinQ project.
                            """.trimIndent(), nl = """
                                Bekijk hieronder de mock-up van de digital twin voor de verduurzaming van het 
                                warmtesysteem in de metropoolregio Rotterdam-Den Haag. Met deze tool kunnen 
                                verschillende warmte-systemen met elkaar vergeleken worden. Zo kijken we naar inpassing 
                                van slimme systemen en lokaal eigenaarschap, en maken we een koppeling met het 
                                WarmtelinQ project.
                            """.trimIndent()
                            )
                        }
                    }
                )
            }
            SectionContainer(
                Modifier
                    .background(Color.white)
                    .width(100.percent)
                    .maxWidth(130.cssRem),
                variant = null
            ) {
                AnyLogicEmbed(
                    modelId = Uuid.parse("92952425-a78a-4e69-a896-6ccea66d4ce6"),
                    apiKey = Uuid.parse("17e0722f-25c4-4549-85c3-d36509f5c710"),
                    modifier = Modifier.maxWidth(90.cssRem).margin(topBottom = 5.cssRem)
                )
            }

            SectionContainer(
                modifier = Modifier.fillMaxWidth().gap(1.cssRem),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                HeaderText(
                    enText = "Contact and info", nlText = "Contact en info", modifier = Modifier.margin(0.cssRem)
                )
                SubHeaderText(
                    enText = "Website and model development",
                    nlText = "Website en model ontwikkeling",
                    modifier = Modifier.margin(0.cssRem)
                )
                ZenmoInlineLink()

                SimpleGrid(
                    numColumns = numColumns(base = 1, md = 2, lg = 2, xl = 2),
                    modifier = Modifier.gap(4.cssRem).margin(topBottom = 3.cssRem)
                ) {
                    VerticalProfileContactCard(
                        name = ZenmoTeam.NAUD_LOOMANS.memberName,
                        imageUrl = ZenmoTeam.NAUD_LOOMANS.image,
                        email = ZenmoTeam.NAUD_LOOMANS.email,
                        telephoneNumber = "+31 (6) 1524 9535",
                    )

                    VerticalProfileContactCard(
                        name = ZenmoTeam.AUKE.memberName,
                        imageUrl = ZenmoTeam.AUKE.image,
                        email = ZenmoTeam.AUKE.email,
                        telephoneNumber = "+31 (6) 5161 4294",
                    )
                }
            }
        }
    }
}
