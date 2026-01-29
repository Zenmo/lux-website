package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.PrivateSubdomainModel
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.components.PrivateTwinModelPage
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import org.jetbrains.compose.web.dom.P

@Composable
fun PreZero() {
    val prezero = PrivateSubdomainModel.PREZERO
    LuxSubdomainPageLayout(
        title = prezero.label.nl,
    ) {
        PrivateTwinModelPage(
            entryPoint = prezero.entryPoint,
            imageUrl = "/lux/images/models/prezero.png",
            introContent = {
                P {
                    LangText(
                        nl = """
                            Afvalverwerker PreZero op bedrijventerrein Hessenpoort wilde uitbreiden.
                            De bestaande aansluiting op het elektriciteitsnet had niet genoeg capaciteit 
                            om de geplande machines aan te sluiten.
                        """,
                        en = """
                            Waste processor PreZero on the Hessenpoort business park wanted to expand.
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
            },
            footerContent = {
                ZenmoModellerProfileCard(ZenmoTeam.LUC)
            }
        )
    }
}
