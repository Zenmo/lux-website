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
fun Hessenpoort() {
    val hessenpoort = PrivateSubdomainModel.HESSENPOORT
    LuxSubdomainPageLayout(
        title = hessenpoort.label.nl,
    ) {
        PrivateTwinModelPage(
            entryPoint = hessenpoort.entryPoint,
            imageUrl = "/lux/images/models/hessenpoort.png",
            introContent = {
                P {
                    LangText(
                        nl = """
                            Hessenpoort is vanuit energie-perspectief een complex bedrijventerrein. 
                            Er is veel lokale opwek en er wordt groene waterstof geproduceerd.
                            Zenmo heeft in kaart gebracht hoe de verschillende actoren kunnen samenwerken
                            om de lokale opwek en de netcapaciteit beter te benutten.
                        """,
                        en = """
                            Hessenpoort is a complex business park from an energy perspective.
                            There is significant local generation and production of green hydrogen.
                            Zenmo has mapped out how the various stakeholders can collaborate to 
                            improve the effectiveness of local generation and reduce the need to expand 
                            the capacity of the grid.
                        """,
                    )
                }
            },
            footerContent = {
                ZenmoModellerProfileCard(ZenmoTeam.ATE)
            }
        )
    }
}
