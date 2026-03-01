package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.MediaContentLayout
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.PrivateSubdomainModel
import com.zenmo.web.zenmo.domains.lux.subdomains.components.TextBlock
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.components.PrivateTwinModelPage
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Div
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
                MediaContentLayout(
                    imageUrl = hessenpoort.imageUrl,
                    title = {
                        HeaderText(
                            enText = "Hessenpoort Business Park",
                            nlText = "Bedrijventerrein Hessenpoort",
                        )
                    },
                    description = {
                        TextBlock(
                            title = LocalizedText(
                                en = "The Context",
                                nl = "De Context",
                            ),
                            descriptionContent = {
                                Div {
                                    P {
                                        LangText(
                                            en = """
                                               Hessenpoort Business Park in Zwolle is a large and diverse industrial 
                                               area. It is home to large transport warehouses, distribution centers, 
                                               factories, retail businesses, and waste processing companies.  
                                            """.trimIndent(),
                                            nl = """
                                                Bedrijventerrein Hessenpoort in Zwolle is een groot en divers 
                                                bedrijventerrein. Er bevinden zich onder meer grote transporthallen, 
                                                distributiecentra, fabrieken, winkels en afvalverwerkers. 
                                            """.trimIndent()
                                        )
                                    }
                                    P {
                                        LangText(
                                            en = """
                                                In addition, the site is already well advanced in terms of the energy 
                                                transition. Alongside large amounts of rooftop solar installations, 
                                                there are also solar fields and nearby wind turbines. Recently, the 
                                                area has even added a hydrogen electrolyzer, and there are plans for a 
                                                future battery system.   
                                            """.trimIndent(),
                                            nl = """
                                                Daarnaast is het terrein al ver gevorderd op het gebied van de 
                                                energietransitie. Zo zijn er, naast grote hoeveelheden zonne-energie op 
                                                daken, ook zonnevelden en nabijgelegen windmolens. Sinds kort beschikt 
                                                het terrein zelfs over een waterstofelektrolyser en zijn er plannen 
                                                voor een toekomstige batterij.
                                            """.trimIndent()
                                        )
                                    }
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
                                    Unfortunately, like the rest of the Netherlands, Hessenpoort Business Park is now 
                                    also facing major challenges due to grid congestion. Many companies are unable to 
                                    increase their grid connection capacity and are therefore encountering obstacles in 
                                    their (further) sustainability and expansion plans. This not only delays the energy 
                                    transition but also results in missed growth opportunities and lost revenue.
                                """.trimIndent(),
                                    nl = """
                                    Helaas kampt bedrijventerrein Hessenpoort, net als de rest van Nederland, inmiddels 
                                    ook met grote problemen door netcongestie. Veel bedrijven kunnen hun aansluiting 
                                    niet vergroten en lopen daardoor vast in hun (verdere) verduurzamings- en 
                                    uitbreidingsplannen. Dit leidt niet alleen tot vertraging van de energietransitie, 
                                    maar ook tot het mislopen van groei en omzet.
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
                            Div {
                                P {
                                    LangText(
                                        en = """
                                    The Hessenpoort business association has therefore collected as much data as 
                                    possible in collaboration with Zenmo. This data was subsequently used in the LUX 
                                    Energy Twin to map the situation at Hessenpoort as accurately as possible. This 
                                    makes it possible to explore the impact of the companies’ future plans, understand 
                                    how the grid infrastructure at Hessenpoort is structured (thereby clarifying which 
                                    companies could effectively collaborate), and assess how congestion might be 
                                    reduced through smart asset control and the deployment of, for example, a battery 
                                    system.
                                """.trimIndent(),
                                        nl = """
                                    De ondernemersvereniging van Hessenpoort heeft daarom, in samenwerking met Zenmo, 
                                    zoveel mogelijk data verzameld. Deze data zijn vervolgens gebruikt in de LUX Energy 
                                    Twin om de situatie op Hessenpoort zo goed mogelijk in kaart te brengen. Dit maakt 
                                    het mogelijk om te verkennen wat het effect is van de toekomstplannen van de 
                                    verschillende bedrijven, hoe de netstructuur op Hessenpoort is ingericht (waardoor 
                                    inzichtelijk wordt welke bedrijven goed met elkaar zouden kunnen samenwerken) en 
                                    hoe de congestie mogelijk kan worden verminderd door slimme aansturing van assets 
                                    en de inzet van bijvoorbeeld een batterij.
                                """.trimIndent()
                                    )
                                }
                                P {
                                    LangText(
                                        en = """
                                        The LUX Energy Twin thus helps entrepreneurs at Hessenpoort explore solutions 
                                        that enable them to continue growing and further advancing their sustainability 
                                        efforts, despite grid congestion.
                                    """.trimIndent(),
                                        nl = """
                                        De LUX Energy Twin helpt ondernemers op Hessenpoort daarmee om oplossingen te 
                                        onderzoeken waarmee zij, ondanks de netcongestie, toch kunnen groeien en verder 
                                        kunnen verduurzamen.
                                    """.trimIndent()
                                    )
                                }
                            }
                        }
                    )
                }
            },
            footerContent = {
                ZenmoModellerProfileCard(ZenmoTeam.ATE)
            }
        )
    }
}