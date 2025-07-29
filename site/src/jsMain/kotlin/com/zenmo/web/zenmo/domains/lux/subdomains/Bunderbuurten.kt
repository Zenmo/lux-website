package com.zenmo.web.zenmo.domains.lux.subdomains


import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.MediaContentLayout
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import kotlin.uuid.Uuid


@Composable
fun BunderbuurtenIndex() {
    LuxSubdomainPageLayout(
        title = "Zero - Bunderbuurten Veghel",
    ) {
        Column(
            modifier = Modifier
                .gap(5.cssRem).margin(topBottom = 5.cssRem),
        ) {
            SectionContainer {
                MediaContentLayout(
                    imageUrl = "/lux/images/Bunderbuurten-Veghel.png",
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
                                Below you can find the mock-up of the digital twin for the sustainability of the 
                                Bunderbuurten in Veghel. The digital twin helps to investigate choices and policies 
                                towards a sustainable energy system. You can play around with it and explore scenarios. 
                                Here we combine heat, mobility, and electricity, both in demand and generation. You can 
                                also explore the potential of smart energy systems with smart charging and smart control 
                                of buffers.
                            """.trimIndent(),
                                nl = """
                                Bekijk hieronder de mock-up van de digital twin voor de verduurzaming van de 
                                Bunderbuurten in Veghel. De digital twin helpt bij het onderzoeken van keuzes en beleid 
                                richting een duurzaam energie systeem. Je kan zelf aan de knoppen zitten en scenario’s 
                                onderzoeken. Hierbij combineren we warmte, mobiliteit en elektriciteit, in zowel vraag 
                                als opwek. Ook kun je de potentie van slimme energiesystemen met slim laden en slimme 
                                aansturing van buffers bekijken.
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
                    modelId = Uuid.parse("da90dd57-a9fb-47b2-9496-345255fda37a"),
                    apiKey = Uuid.parse("17e0722f-25c4-4549-85c3-d36509f5c710"),
                    modifier = Modifier.maxWidth(90.cssRem).margin(topBottom = 5.cssRem)
                )
            }
            SectionContainer {
                ProfileContactCard(
                    name = ZenmoTeam.NAUD_LOOMANS.memberName,
                    imageUrl = ZenmoTeam.NAUD_LOOMANS.image,
                    email = ZenmoTeam.NAUD_LOOMANS.email,
                    enSubtitle = "Website and model development",
                    nlSubtitle = "Website en model ontwikkeling",
                )
            }
        }
    }
}
