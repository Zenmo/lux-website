package energy.lux.frontend.domains.lux.subdomains.private_subdomains

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.MediaContentLayout
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.components.layout.LuxSubdomainPageLayout
import energy.lux.frontend.domains.lux.core.model.subdomain.PrivateSubdomainModel
import energy.lux.frontend.domains.lux.subdomains.components.TextBlock
import energy.lux.frontend.domains.lux.subdomains.components.ZenmoModellerProfileCard
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.components.PrivateTwinModelPage
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.sections.team.ZenmoTeam
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
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
                        TextBlock(
                            title = LocalizedText(
                                en = "The Context",
                                nl = "De Context",
                            ),
                            descriptionContent = {
                                P {
                                    LangText(
                                        en = """
                                            Waste processor PreZero, located at the Hessenpoort business park in 
                                            Zwolle, had plans to expand its business operations with a new production 
                                            hall. However, the available grid capacity under the existing electricity 
                                            contract proved insufficient for the power required by the planned machines.
                                        """.trimIndent(),
                                        nl = """
                                            Afvalverwerker PreZero, gevestigd op bedrijventerrein Hessenpoort in 
                                            Zwolle, had plannen voor de uitbreiding van haar bedrijfsactiviteiten met 
                                            een nieuwe productiehal. De beschikbare netcapaciteit binnen het bestaande 
                                            elektriciteitscontract bleek echter ontoereikend voor het vermogen dat de 
                                            geplande machines vereisen.
                                        """.trimIndent()
                                    )
                                }
                            },
                        )
                    }
                )
                Column(
                    Modifier.fillMaxWidth().gap(1.cssRem)
                ) {
                    TextBlock(
                        title = LocalizedText(
                            en = "The Challenge",
                            nl = "De Uitdaging",
                        ),
                        descriptionContent = {
                            P {
                                LangText(
                                    en = """
                                       Using the LUX Energy Twin, various scenarios were subsequently analyzed to still 
                                       realize the desired expansion. The model provides insight into various options 
                                       for additional power supply behind the meter, including the integration of solar 
                                       and wind energy installations, the placement of a battery storage system, and 
                                       the deployment of an emergency generator. In addition, alternative contract 
                                       forms can be calculated, such as a Capacity Limiting Contract (CBC), where the 
                                       available delivery capacity varies by day of the week or time of day.
                                   """.trimIndent(),
                                    nl = """
                                       Met behulp van de LUX Energy Twin zijn vervolgens verschillende scenario's 
                                       geanalyseerd om de gewenste uitbreiding alsnog te realiseren. Het model biedt 
                                       inzicht in diverse opties voor aanvullende stroomvoorziening achter de meter, 
                                       waaronder de integratie van zonne- en windenergie-installaties, de plaatsing van 
                                       een batterijopslagsysteem en de inzet van een noodaggregaat. Daarnaast kunnen 
                                       alternatieve contractvormen worden doorgerekend, zoals een Capaciteits Beperkend 
                                       Contract (CBC), waarbij de beschikbare afnamecapaciteit varieert per dag van de 
                                       week of tijdstip.
                                   """.trimIndent()
                                )
                            }
                        }
                    )

                    TextBlock(
                        title = LocalizedText(
                            en = "The Solution",
                            nl = "De Oplossing",
                        ),
                        descriptionContent = {
                            P {
                                LangText(
                                    en = """
                                       The possibility of enabling the new hall to operate flexibly was also 
                                       investigated. The hall consists of eight parallel process flows that can be 
                                       individually switched on or off depending on the energy available at that 
                                       moment. In this way, both the associated costs and operational revenues can be 
                                       calculated for various combinations of power supplies.
                                   """.trimIndent(),
                                    nl = """
                                        Tevens is de mogelijkheid onderzocht om de nieuwe hal flexibel te laten 
                                        opereren. De hal bestaat uit acht parallelle processtromen die, afhankelijk 
                                        van de op dat moment beschikbare energie, individueel in- of uitgeschakeld 
                                        kunnen worden. Op deze wijze kunnen voor uiteenlopende combinaties van 
                                        stroomvoorzieningen zowel de bijbehorende kosten als de operationele 
                                        opbrengsten worden berekend.
                                    """.trimIndent()
                                )
                            }
                        }
                    )
                }
            },
            footerContent = {
                ZenmoModellerProfileCard(ZenmoTeam.LUC)
            }
        )
    }
}