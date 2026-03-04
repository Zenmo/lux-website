package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.MediaContentLayout
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.PrivateSubdomainModel
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.components.PrivateTwinModelPage
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.dom.P

@Composable
fun Borchwerf() {
    val borchwerf = PrivateSubdomainModel.BORCHWERF
    LuxSubdomainPageLayout(
        title = borchwerf.label.nl,
    ) {
        PrivateTwinModelPage(
            entryPoint = borchwerf.entryPoint,
            imageUrl = "/lux/images/models/borchwerf.png",
            introContent = {
                MediaContentLayout(
                    imageUrl = borchwerf.imageUrl,
                    title = {
                        HeaderText(
                            enText = borchwerf.label.en,
                            nlText = borchwerf.label.nl,
                            textColor = SitePalette.light.primary,
                        )
                    },
                    description = {
                        P {
                            LangText(
                                en = """
                                    Borchwerf is a large business park in Roosendaal. This LUX Energy Twin assists the 
                                    municipality and energie-check.nl in supporting the businesses in Borchwerf in 
                                    launching an energy hub. The entrepreneurs and advisors gain insights into renewable 
                                    energy measures, the implementation of energy management systems, and the setup of 
                                    an energy hub. 
                                """.trimIndent(),
                                nl = """
                                    Borchwerf is een groot bedrijventerrein in Roosendaal. Deze LUX Energy Twin 
                                    ondersteunt de gemeente en energiecheck.nl bij het begeleiden van de bedrijven in 
                                    Borchwerf bij het opzetten van een energiehub. Ondernemers en adviseurs krijgen 
                                    inzicht in duurzame energiemaatregelen, de implementatie van 
                                    energiemanagementsystemen en de inrichting van een energiehub.
                                """.trimIndent()
                            )
                        }
                    }
                )
            },
            footerContent = {
                ZenmoModellerProfileCard(ZenmoTeam.PETER_HOGEVEEN)
            }
        )
    }
}
