package com.zenmo.web.zenmo.domains.lux.subdomains

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.zenmo.web.zenmo.components.widgets.ZenmoInlineLink
import com.zenmo.web.zenmo.domains.lux.components.ModelPageContent
import com.zenmo.web.zenmo.domains.lux.components.VerticalProfileContactCard
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.loenen
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import kotlin.uuid.Uuid

@Composable
fun LoenenIndex() {
    LuxSubdomainPageLayout(
        title = loenen.label.nl,
    ) {
        ModelPageContent(
            modelLabel = loenen.label,
            pageImageSrc = "/lux/images/Digital-twin-Loenen.png",
            enDescriptionParagraph = """
                    Below is a mock-up of the digital twin for the sustainability project in the village 
                    of Loenen. In Loenen, the energy cooperative is working on a smart energy system with a 
                    Community Virtual Power Plant. The digital twin will assist in designing these sustainable 
                    energy systems and making the right decisions.
            """.trimIndent(),
            nlDescriptionParagraph = """
                    Bekijk hieronder de mock-up van de digital twin voor de verduurzaming van het dorp 
                    Loenen. In Loenen werkt de energie coöperatie aan een slim energiesysteem met een 
                    Community Virtual Power Plant. De digital twin zal helpen bij het ontwerpen van deze 
                    duurzame energiesystemen en het maken van de juiste beslissingen.
            """.trimIndent(),
            modelContent = {
                AnyLogicEmbed(
                    modelId = loenen.modelId,
                    apiKey = Uuid.parse("17e0722f-25c4-4549-85c3-d36509f5c710"),
                )
            }
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().gap(1.cssRem),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                HeaderText(
                    enText = "Contact and info",
                    nlText = "Contact en info",
                    modifier = Modifier.margin(0.cssRem)
                )
                SubHeaderText(
                    enText = "Website and model development",
                    nlText = "Website en model ontwikkeling",
                    modifier = Modifier.margin(0.cssRem)
                )

                SimpleGrid(
                    numColumns = numColumns(base = 1, md = 2, lg = 2, xl = 2),
                    modifier = Modifier.gap(2.cssRem).margin(top = 4.cssRem)
                ) {
                    VerticalProfileContactCard(
                        name = ZenmoTeam.NAUD_LOOMANS.memberName,
                        imageUrl = ZenmoTeam.NAUD_LOOMANS.image,
                        email = ZenmoTeam.NAUD_LOOMANS.email,
                        organization = { ZenmoInlineLink() },
                    )

                    VerticalProfileContactCard(
                        name = "Ariadne Renteria Castaneda",
                        imageUrl = "avatars/blank.png",
                        email = "a.renteria.castaneda@student.tue.nl",
                        organization = {
                            Span(
                                Modifier.fontWeight(FontWeight.Bold).toAttrs()
                            ) {
                                Text("TU Eindhoven")
                            }
                        },
                    )
                }
            }
        }
    }
}
