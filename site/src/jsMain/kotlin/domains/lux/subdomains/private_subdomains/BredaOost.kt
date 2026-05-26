package energy.lux.frontend.domains.lux.subdomains.private_subdomains

import androidx.compose.runtime.Composable
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
import org.jetbrains.compose.web.dom.P

@Composable
fun BredaOost() {
    val bredaOost = PrivateSubdomainModel.BREDA_OOST
    LuxSubdomainPageLayout(
        title = bredaOost.label.nl,
    ) {
        PrivateTwinModelPage(
            entryPoint = bredaOost.entryPoint,
            modelId = bredaOost.modelId,
            imageUrl = "/lux/images/models/breda-oost.png",
            introContent = {
                MediaContentLayout(
                    imageUrl = bredaOost.imageUrl,
                    title = {
                        HeaderText(
                            enText = bredaOost.label.en,
                            nlText = bredaOost.label.nl,
                            textColor = SitePalette.light.primary,
                        )
                    },
                    description = {
                        P {
                            LangText(
                                en = """
                                   The Breda-East business parks (3B-O) comprise the areas Moleneind-Oost, 
                                   Baarschot and Hoogeind.
                                """.trimIndent(),
                                nl = """
                                    Bedrijventerreinen Breda-Oost (3B-O) omvatten de gebieden Moleneind-Oost, 
                                    Baarschot en Hoogeind.
                                """.trimIndent()
                            )
                        }
                        TextBlock(
                            title = LocalizedText(
                                en = "The Challenge",
                                nl = "De Uitdaging",
                            ),
                            descriptionContent = {
                                P {
                                    LangText(
                                        en = """
                                            As in the rest of the Netherlands, businesses at 3B-O are now facing major 
                                            challenges due to grid congestion. Many companies are unable to expand their 
                                            grid connection and are therefore stuck in their (further) sustainability and 
                                            expansion plans. This not only delays the energy transition, but also results 
                                            in missed growth and revenue.
                                        """.trimIndent(),
                                        nl = """
                                            Net als in de rest van Nederland kampen de bedrijven op 3B-O inmiddels met 
                                            grote problemen door netcongestie. Veel bedrijven kunnen hun aansluiting niet 
                                            vergroten en lopen daardoor vast in hun (verdere) verduurzamings- en 
                                            uitbreidingsplannen. Dit leidt niet alleen tot vertraging van de 
                                            energietransitie, maar ook tot gemiste groei en omzet.
                                        """.trimIndent()
                                    )
                                }
                            }
                        )
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
                                   The LUX Energy Twin is therefore being deployed to explore collective 
                                   solutions and help entrepreneurs move forward again. Examples include 
                                   collective batteries and GTOs, as well as the potential of collaboration 
                                   with the massive local solar field of 37 MWp. In this way, LUX helps the 
                                   businesses at 3B-O to find ways in which they can continue to grow and 
                                   further improve their sustainability, despite the grid congestion.
                                """.trimIndent(),
                                nl = """
                                    De LUX Energy Twin wordt daarom ingezet om collectieve oplossingen te 
                                    onderzoeken en de ondernemers weer op weg te helpen. Denk hierbij aan 
                                    collectieve batterijen en GTO's, maar ook aan de potentie van samenwerking 
                                    met het gigantische lokale zonneveld van 37 MWp. Zo helpt LUX de 
                                    ondernemers op 3B-O om manieren te vinden waarop zij, ondanks de 
                                    netcongestie, toch kunnen groeien en verder verduurzamen.
                                """.trimIndent()
                            )
                        }
                    }
                )
            },
            footerContent = {
                ZenmoModellerProfileCard(ZenmoTeam.ATE)
            }
        )
    }
}