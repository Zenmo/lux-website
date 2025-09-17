package com.zenmo.web.zenmo.domains.lux.subdomains

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.components.model.ModelPageContent
import com.zenmo.web.zenmo.domains.lux.components.model.SubdomainModel
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.AukeNaudContactCard
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import kotlin.uuid.Uuid

@Composable
fun RotterdamDenHaagIndex() {
    LuxSubdomainPageLayout(
        title = "Warmte in regio Rotterdam-Den Haag"
    ) {
        ModelPageContent(
            twin = SubdomainModel.RotterdamDenHaag,
            imageUrl = "/lux/images/Mock-up-MRDH.png",
            enDescriptionParagraph = """
                Below is a mock-up of the digital twin for the sustainability of the heat system 
                in the Rotterdam-Den Haag metropolitan region. This tool allows for comparison of 
                different heat systems, examining the integration of smart systems and local ownership, 
                and linking to the WarmtelinQ project.
            """.trimIndent(),
            nlDescriptionParagraph = """
                 Bekijk hieronder de mock-up van de digital twin voor de verduurzaming van het 
                 warmtesysteem in de metropoolregio Rotterdam-Den Haag. Met deze tool kunnen 
                 verschillende warmte-systemen met elkaar vergeleken worden. Zo kijken we naar inpassing 
                 van slimme systemen en lokaal eigenaarschap, en maken we een koppeling met het 
                 WarmtelinQ project.
            """.trimIndent(),
            modelContent = {
                AnyLogicEmbed(
                    modelId = Uuid.parse("92952425-a78a-4e69-a896-6ccea66d4ce6"),
                    apiKey = Uuid.parse("17e0722f-25c4-4549-85c3-d36509f5c710"),
                )
            },
            metaContent = {
                HeaderText(
                    enText = "DISCLAIMER: THIS IS A MOCK-UP VERSION",
                    nlText = "DISCLAIMER: DIT IS EEN MOCK-UP VERSIE",
                    modifier = Modifier.fillMaxWidth()
                        .background(SitePalette.light.overlay)
                        .textAlign(TextAlign.Center)
                        .margin(0.cssRem)
                        .padding(4.cssRem)
                )
            }
        ) {
            AukeNaudContactCard()
        }
    }
}
