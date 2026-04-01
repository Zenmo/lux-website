package energy.lux.frontend.domains.lux.subdomains.public_subdomains

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.domains.lux.components.layout.LuxSubdomainPageLayout
import energy.lux.frontend.domains.lux.core.model.subdomain.rotterdamDenHaag
import energy.lux.frontend.domains.lux.subdomains.components.SubdomainModelPage
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.pages.AukeNaudContactCard
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.P

@Composable
fun RotterdamDenHaagIndex() {
    LuxSubdomainPageLayout(
        title = rotterdamDenHaag.label.nl,
    ) {
        HeaderText(
            enText = "DISCLAIMER: THIS IS A MOCK-UP VERSION",
            nlText = "DISCLAIMER: DIT IS EEN MOCK-UP VERSIE",
            modifier = Modifier.fillMaxWidth()
                .background(SitePalette.light.overlay)
                .textAlign(TextAlign.Center)
                .padding(4.cssRem)
        )
        SubdomainModelPage(
            modelId = rotterdamDenHaag.modelId,
            introContent = {
                P {
                    LangText(
                        en = """
                            Below is a mock-up of the digital twin for the sustainability of the heat system 
                            in the Rotterdam-Den Haag metropolitan region. This tool allows for comparison of 
                            different heat systems, examining the integration of smart systems and local ownership, 
                            and linking to the WarmtelinQ project.
                        """.trimIndent(),
                        nl = """
                             Bekijk hieronder de mock-up van de digital twin voor de verduurzaming van het 
                             warmtesysteem in de metropoolregio Rotterdam-Den Haag. Met deze tool kunnen 
                             verschillende warmte-systemen met elkaar vergeleken worden. Zo kijken we naar inpassing 
                             van slimme systemen en lokaal eigenaarschap, en maken we een koppeling met het 
                             WarmtelinQ project.
                        """.trimIndent(),
                    )
                }
            },
            footerContent = { AukeNaudContactCard() }
        )
    }
}
