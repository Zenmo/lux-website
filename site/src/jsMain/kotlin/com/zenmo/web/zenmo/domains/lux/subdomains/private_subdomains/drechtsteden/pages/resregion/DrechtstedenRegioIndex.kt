package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages.resregion

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.components.DrechtstedenTwinModelPage
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P

@Composable
fun DrechtstedenRegioIndex() {
    DrechtstedenTwinModelPage(
        twin = drechtstedenResRegion,
        introContent = {
            Div {
                P {
                    LangText(
                        en = """
                            The energy twin at regional level connects insights from individual neighborhoods and 
                            business parks, translating them to a higher level. This demonstrates the contribution of 
                            local optimization to the regional energy system. Additionally, this level enables mapping 
                            the need for large-scale infrastructure such as heating networks and substations for 
                            electricity grids.
                        """.trimIndent(),
                        nl = """
                            De energy twin op regionaal niveau verbindt inzichten van individuele woonwijken en 
                            bedrijventerreinen, en vertaalt deze naar een bovenliggend niveau. Hiermee tonen wij de 
                            bijdrage van lokale optimalisatie aan het energiesysteem op regionaal niveau. Daarnaast 
                            biedt dit niveau de mogelijkheid om de behoefte aan grootschalige infrastructuur zoals 
                            warmtenetten en onderstations voor elektriciteitsnetten in kaart te brengen. 
                        """.trimIndent()
                    )
                }
                P {
                    LangText(
                        en = """
                            The energy twin is used in this way for policy studies and documents such as the Regional 
                            Energy Strategy (RES), the provincial Multi-Year Program Infrastructure Energy and Climate 
                            (pMIEK), and the Heat Transition Visions (TVW). 
                        """.trimIndent(),
                        nl = """
                            Op deze manier wordt de energy twin ingezet voor beleidsstudies en documenten zoals de 
                            Regionale Energiestrategie (RES), het provinciaal Meerjarenprogramma Infrastructuur 
                            Energie en Klimaat (pMIEK) en de Transitievisies Warmte (TVW). 
                        """.trimIndent()
                    )
                }
                P {
                    LangText(
                        en = """
                        We are currently working with Stedin on a project to develop a broadly supported energy vision.
                    """.trimIndent(),
                        nl = """
                       Momenteel werken we samen met Stedin aan een traject om tot een breed gedragen energievisie te 
                       komen. 
                    """.trimIndent()
                    )
                }
            }
        },
        footerContent = { ZenmoModellerProfileCard(ZenmoTeam.NAUD_LOOMANS) }
    )
}
