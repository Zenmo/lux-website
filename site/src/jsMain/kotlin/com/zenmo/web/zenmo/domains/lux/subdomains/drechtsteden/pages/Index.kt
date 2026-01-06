package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.model.DrechtstedenMunicipality
import com.zenmo.web.zenmo.domains.lux.components.model.DrechtstedenResNeighborhood
import com.zenmo.web.zenmo.domains.lux.components.model.DrechtstedenResRegion
import com.zenmo.web.zenmo.domains.lux.components.model.SimpleTwin
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.layout.DrechtstedenTwinLayout
import com.zenmo.web.zenmo.domains.lux.widgets.ModelCard
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.pages.SiteGlobals
import kotlinx.browser.window
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.P

@OptIn(DelicateApi::class)
@Composable
fun DrechtstedenHomePage() {
    DrechtstedenTwinLayout(
        title = "Home",
    ) {
        SectionContainer(
            variant = LuxSectionContainerStyleVariant
        ) {
            HeaderText(
                enText = "Digital Twins Drechtsteden",
                nlText = "Digital Twins Drechtsteden",
                modifier = Modifier.margin(0.cssRem).fillMaxWidth()
            )
            P {
                LangText(
                    en = """
                        We work closely with the Drechtsteden region to gain more insight into the sustainability of the
                         energy system, provide concrete action perspectives for business parks and residential areas, 
                         and develop new future scenarios for strategy and policy.
                    """.trimIndent(),
                    nl = """
                        We werken intensief samen met de Drechtsteden om meer inzicht te krijgen in de verduurzaming van
                         het energiesysteem, concreet handelingsperspectief te bieden aan bedrijventerreinen en 
                         woonwijken, en nieuwe toekomst scenario’s te ontwikkelen voor strategie en beleid.

                    """.trimIndent()
                )
                Br { }
                Br { }
                LangText(
                    en = """
                            The digital twins developed for the Drechtsteden are focused on different areas and levels. 
                            For example, the digital twin of the RES region is focused on policy and strategy for the 
                            entire region. Those of the residential neighborhoods are used in the elaboration of the 
                            neighborhood implementation programs for heat, and the business parks form the basis for 
                            establishing EnergyHubs, investments in batteries, and group contracts.
                    """.trimIndent(),
                    nl = """
                            De digital twins die zijn ontwikkeld voor de Drechtsteden zijn gericht op verschillende 
                            gebieden en niveaus. Zo is de digital twin van de RES-regio gericht op beleid en strategie 
                            van de hele regio. Die van de woonwijken worden gebruikt bij de uitwerking van de 
                            wijkuitvoeringsprogramma’s warmte, en de bedrijventerreinen staan aan de basis van het 
                            oprichten van EnergieHubs, investeringen in batterijen en groepscontracten.
                    """.trimIndent()
                )
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
                    .gap(1.5.cssRem)
            ) {

                ModelCard(
                    url = DrechtstedenResRegion.DrechtstedenRes.url(
                        path = "res-region",
                        protocol = window.location.protocol,
                        luxDomain = SiteGlobals.LUX_DOMAIN
                    ),
                    model = SimpleTwin(
                        modelTitle = "RES-Regio",
                        modelImage = DrechtstedenResRegion.DrechtstedenRes.image,
                    ),
                )

                ModelCard(
                    url = "/res-neighborhoods",
                    model = SimpleTwin(
                        modelTitle = "Woonwijken",
                        modelImage = DrechtstedenResNeighborhood.OverTSpoor.image,
                    ),
                )

                ModelCard(
                    url = "/business-parks",
                    model = SimpleTwin(
                        modelTitle = "Bedrijventerreinen",
                        modelImage = DrechtstedenMunicipality.Dordrecht.image,
                    ),
                )
            }
        }
    }
}