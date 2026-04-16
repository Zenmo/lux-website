package energy.lux.frontend.domains.lux.subdomains.private_subdomains

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import energy.lux.frontend.components.ZenmoLink
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
import org.jetbrains.compose.web.dom.B
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun KasAlsEnergiebron() {
    val kasAlsEnergiebron = PrivateSubdomainModel.KAS_ALS_ENERGIEBRON
    LuxSubdomainPageLayout(
        title = kasAlsEnergiebron.label.nl,
    ) {
        PrivateTwinModelPage(
            entryPoint = kasAlsEnergiebron.entryPoint,
            modelId = kasAlsEnergiebron.modelId,
            imageUrl = "/lux/images/models/kasals.png",
            introContent = {
                MediaContentLayout(
                    imageUrl = kasAlsEnergiebron.imageUrl,
                    title = {
                        HeaderText(
                            enText = kasAlsEnergiebron.label.en,
                            nlText = kasAlsEnergiebron.label.nl,
                            textColor = SitePalette.light.primary,
                        )
                    },
                    description = {
                        TextBlock(
                            title = LocalizedText(
                                en = "The Challenge",
                                nl = "De Uitdaging",
                            ),
                            descriptionContent = {
                                P {
                                    LangText(
                                        en = """
                                            The Dutch greenhouse horticulture sector faces a major challenge: the 
                                            energy transition.
                                        """.trimIndent(),
                                        nl = """
                                            De Nederlandse glastuinbouw zit met een gigantische opgave: De energie 
                                            transitie.
                                        """.trimIndent()
                                    )
                                    Br { }

                                    LangText(
                                        en = """
                                            For this sector in particular, moving away from natural gas is extremely 
                                            difficult. A large share of their heat currently comes from gas-fired 
                                            combined heat and power installations (CHP). These systems not only produce 
                                            heat, but also generate electricity—so much so that the sector accounts for 
                                            up to 11% of the total annual electricity production in the Netherlands. 
                                            However, part of this electricity is used on-site, meaning greenhouses have 
                                            historically needed very little electricity import. As a result, many 
                                            greenhouses have relatively small contracted grid connections for 
                                            electricity consumption.
                                        """.trimIndent(),
                                        nl = """
                                            Vooral voor deze sector is het namelijk erg lastig om van het gas af te 
                                            gaan. Een groot deel van hun warmte komt van gas gestookte 
                                            WKK-installaties. Hierbij komt er echter niet alleen warmte vrij, maar 
                                            wordt er ook elektriciteit geproduceerd. Dit is zelfs zoveel dat ze 
                                            verantwoordelijk zijn voor tot wel 11%  van de totale jaarlijkse 
                                            elektriciteitsproductie in Nederland. Echter gebruiken ze (een klein deel 
                                            van) deze stroom natuurlijk ook zelf. Hierdoor hebben ze tot nu toe weinig 
                                            elektriciteit import nodig gehad, waardoor veel kassen een erg kleine 
                                            (contractuele) aansluiting hebben voor de afname van stroom. 
                                        """.trimIndent()
                                    )
                                }
                            }
                        )
                    }
                )
                Column {
                    P {
                        LangText(
                            en = """
                                With the energy transition underway, the sector must shift toward a gas-free energy system. 
                                This means not only finding alternative heat sources, but also rethinking how electricity 
                                demand is met. Complicating matters further, heat pumps—the standard sustainable heating 
                                solution—significantly increase electricity consumption. This makes existing grid 
                                connections insufficient in many cases. Simply expanding grid capacity is not a viable 
                                option either, due to grid congestion in the Netherlands.
                            """.trimIndent(),
                            nl = """
                                Door de energie transitie moeten ze toch bewegen naar een gas-loos energie systeem. Dit 
                                betekent dus niet alleen dat ze een nieuwe warmte bron moeten zoeken, maar ook een nieuwe 
                                invulling voor hun stroom verbruik moeten vinden. Hier komt dan ook nog eens bij kijken dat 
                                warmtepompen, de standaard duurzame warmte bron, ook nog eens de elektriciteitsconsumptie 
                                erg zou verhogen, waardoor de huidige aansluiting die de kassen hebben vaak niet toereikend 
                                is. En simpelweg de aansluiting uitbreiden is natuurlijk ook geen optie, want er is 
                                netcongestie in Nederland.
                            """.trimIndent()
                        )
                    }

                    TextBlock(
                        title = LocalizedText(
                            en = "The Solution",
                            nl = "De Oplossing",
                        ),
                        descriptionContent = {
                            P {
                                ZenmoLink()
                                LangText(
                                    en = ", in collaboration with ",
                                    nl = ", heeft samen met ",
                                )
                                B {
                                    Text("Kas Als Energiebron ")
                                }

                                LangText(
                                    en = """
                                        explored whether greenhouses can be modeled within the LUX Energy Twin. 
                                        Using real greenhouse data, they successfully mapped the current situation. 
                                        This model uses the Broekpolder area as an example. Subsequently, the Energy 
                                        Twin was used to analyze a future scenario in which greenhouses operate 
                                        entirely without natural gas. This provided valuable insights into, for 
                                        example, the growth in electricity imports and peak load demand.
                                    """.trimIndent(),
                                    nl = """
                                        verkend of we kassen kunnen modeleren in de LUX Energy Twin. Met behulp van 
                                        echte data van kassen, is het gelukt om de huidige situatie goed in kaart te 
                                        brengen. Dit model gebruikt als voorbeeld het gebied Broekpolder. Vervolgens is 
                                        met behulp van de Energy Twin een toekomst scenario verkend waarin de kassen 
                                        volledig van het gas af zouden gaan. Dit heeft interessante inzichten verschaft 
                                        over bijvoorbeeld de groei in elektriciteit import en piek belasting.
                                    """.trimIndent()
                                )
                            }
                        }
                    )

                }
            },
            footerContent = {
                ZenmoModellerProfileCard(ZenmoTeam.PETER_HOGEVEEN)
            }
        )
    }
}
