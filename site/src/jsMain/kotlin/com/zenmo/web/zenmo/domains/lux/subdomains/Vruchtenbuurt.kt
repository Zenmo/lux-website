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
import com.zenmo.web.zenmo.domains.lux.components.VerticalProfileContactCard
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.components.model.ModelPageContent
import com.zenmo.web.zenmo.domains.lux.components.model.SubdomainModel
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import kotlin.uuid.Uuid

@Composable
fun VruchtenbuurtIndex() {
    LuxSubdomainPageLayout(
        title = "Digital twin Vruchtenbuurt"
    ) {
        ModelPageContent(
            twin = SubdomainModel.Vruchtenbuurt,
            imageUrl = "/lux/images/Digital-twin-Vruchtenbuurt.png",
            enDescriptionParagraph = """
                See below the mock-up of the digital twin for the sustainability of the Vruchtenbuurt in 
                The Hague. In the Vruchtenbuurt, the energy cooperative Sterk Op Stroom is working on a 
                smart energy system. The digital twin will assist in designing these sustainable energy 
                systems and making the right decisions.
            """.trimIndent(),
            nlDescriptionParagraph = """
                Bekijk hieronder de mock-up van de digital twin voor de verduurzaming van het de 
                Vruchtenbuurt in den Haag. In de Vruchtenbuurt werkt de energie coöperatie Sterk Op 
                Stroom aan een slim energiesysteem. De digital twin zal helpen bij het ontwerpen van 
                deze duurzame energiesystemen en het maken van de juiste beslissingen.
            """.trimIndent(),
            modelContent = {
                AnyLogicEmbed(
                    modelId = Uuid.parse("cca6eb2b-fb91-4825-bee2-d5e12d0a3880"),
                    apiKey = Uuid.parse("17e0722f-25c4-4549-85c3-d36509f5c710"),
                )
            }
        ) {
            Column(
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

                SimpleGrid(
                    numColumns = numColumns(base = 1, md = 2, lg = 2, xl = 2),
                    modifier = Modifier.gap(4.cssRem).margin(topBottom = 3.cssRem)
                ) {
                    VerticalProfileContactCard(
                        name = ZenmoTeam.NAUD_LOOMANS.memberName,
                        imageUrl = ZenmoTeam.NAUD_LOOMANS.image,
                        email = ZenmoTeam.NAUD_LOOMANS.email,
                        organization = { ZenmoInlineLink() }
                    )

                    VerticalProfileContactCard(
                        name = "Teodora Lazăr",
                        imageUrl = "avatars/blank.png",
                        email = "t.lazar@student.tue.nl",
                        organization = {
                            Span(
                                Modifier.fontWeight(FontWeight.Bold).toAttrs()
                            ) {
                                Text("TU Eindhoven")
                            }
                        }
                    )
                }
            }
        }
    }
}
