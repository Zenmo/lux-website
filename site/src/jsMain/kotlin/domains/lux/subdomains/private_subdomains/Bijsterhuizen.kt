package energy.lux.frontend.domains.lux.subdomains.private_subdomains

import androidx.compose.runtime.Composable
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.MediaContentLayout
import energy.lux.frontend.domains.lux.components.layout.LuxSubdomainPageLayout
import energy.lux.frontend.domains.lux.core.model.subdomain.PrivateSubdomainModel
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.components.PrivateTwinModelPage
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.sections.team.ZenmoTeam
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.P

@Composable
fun Bijsterhuizen() {
    val bijsterhuizen = PrivateSubdomainModel.BIJSTERHUIZEN
    LuxSubdomainPageLayout(
        title = bijsterhuizen.label.nl,
    ) {
        PrivateTwinModelPage(
            entryPoint = bijsterhuizen.entryPoint,
            imageUrl = "/lux/images/models/bijsterhuizen.png",
            modelId = bijsterhuizen.modelId,
            introContent = {
                MediaContentLayout(
                    imageUrl = bijsterhuizen.imageUrl,
                    title = {
                        HeaderText(
                            enText = bijsterhuizen.label.en,
                            nlText = bijsterhuizen.label.nl,
                            textColor = SitePalette.light.primary,
                        )
                    },
                    description = {
                        P {
                            LangText(
                                en = """
                            For the Bijsterhuizen Business Park, located on the border of the municipalities of 
                            Nijmegen and Wijchen, Zenmo has developed a LUX Energy Twin in collaboration with Energieke 
                            Regio.
                        """.trimIndent(),
                                nl = """
                           Voor het Bedrijventerrein Bijsterhuizen, gelegen op de grens van de gemeenten Nijmegen en 
                           Wijchen, heeft Zenmo in samenwerking met Energieke Regio een LUX Energy Twin ontwikkeld. 
                        """.trimIndent()
                            )
                            Br { }
                            Br { }
                            LangText(
                                en = """
                            With this Energy Twin, entrepreneurs and advisors gain insights into renewable energy 
                            measures, the implementation of energy management systems, and the potential of energy hubs 
                            and collective grid connection contracts. Thanks to these energy hubs and collective grid 
                            connection contracts, businesses can expand and become more sustainable, despite grid 
                            congestion.
                        """.trimIndent(),
                                nl = """
                            Met deze Energy Twin krijgen ondernemers en adviseurs inzicht in de verduurzaming van 
                            bedrijven, de implementatie van energiemanagementsystemen en de potentie van energiehubs en 
                            groepscontracten. Dankzij deze energiehubs en groepscontracten kunnen bedrijven uitbreiden 
                            en verduurzamen, ondanks netcongestie.
                        """.trimIndent()
                            )
                        }
                    }
                )
            },
            footerContent = {
                ZenmoModellerProfileCard(ZenmoTeam.ATE)
            },
        )
    }
}
