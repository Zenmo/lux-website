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
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P

@Composable
fun PreZero() {
    val prezero = PrivateSubdomainModel.PREZERO
    LuxSubdomainPageLayout(
        title = prezero.label.nl,
    ) {
        PrivateTwinModelPage(
            entryPoint = prezero.entryPoint,
            modelId = prezero.modelId,
            imageUrl = "/lux/images/models/prezero.png",
            introContent = {
                MediaContentLayout(
                    imageUrl = prezero.imageUrl,
                    title = {
                        HeaderText(
                            enText = prezero.label.en,
                            nlText = prezero.label.nl,
                            textColor = SitePalette.light.primary,
                        )
                    },
                    description = {
                        Div {
                            P {
                                LangText(
                                    nl = """
                            Afvalverwerker PreZero op bedrijventerrein Hessenpoort in Zwolle wilde uitbreiden.
                            De bestaande aansluiting op het elektriciteitsnet had niet genoeg capaciteit 
                            om de geplande machines aan te sluiten.
                        """,
                                    en = """
                            Waste processor PreZero on the Hessenpoort business park in Zwolle wanted to expand.
                            The existing connection to the electricity grid had insufficient capacity 
                            to connect the planned machines.
                        """,
                                )
                            }
                            P {
                                LangText(
                                    nl = """
                            Als oplossing is er onder andere een gesloten distributiesysteem aangelegd
                            om de stroom van een lokale zonnepark rechtstreeks te transporteren naar het bedrijf.
                        """,
                                    en = """
                            One of the things that helped close the gap was to set up 
                            a closed distribution system to transport electricity
                            directly from a local solar park.
                        """,
                                )
                            }
                        }
                    }
                )
            },
            footerContent = {
                ZenmoModellerProfileCard(ZenmoTeam.LUC)
            }
        )
    }
}
