package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.zenmo.web.zenmo.components.widgets.InlineLink
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.HorizontalLine
import com.zenmo.web.zenmo.domains.lux.core.TwinModelCardItem
import com.zenmo.web.zenmo.domains.lux.core.isPrivate
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.DrechtstedenProjectArea
import com.zenmo.web.zenmo.domains.lux.subdomains.components.SubdomainModelPage
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages.municipalities.dordrecht
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages.resneighborhoods.overTSpoor
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages.resregion.drechtstedenResRegion
import com.zenmo.web.zenmo.domains.lux.widgets.ModelCard
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import kotlin.uuid.Uuid

@OptIn(DelicateApi::class)
@Composable
fun DrechtstedenHomePage() {
    val modeller = ZenmoTeam.NAUD_LOOMANS
    SubdomainModelPage(
        modelId = Uuid.NIL,
        introContent = {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .gap(1.5.cssRem)
            ) {
                HeaderText(
                    enText = "Drechtsteden",
                    nlText = "Drechtsteden",
                )
                Div {
                    P {
                        LangText(
                            en = """
                                We closely collaborate with the Drechtsteden region to gain more insight into the sustainability of 
                                the energy system, provide concrete action perspectives for business parks and residential areas, 
                                and develop new future scenarios for strategy and policy.
                            """.trimIndent(),
                            nl = """
                                We werken intensief samen met de Drechtsteden om meer inzicht te krijgen in de verduurzaming van 
                                het energiesysteem, concreet handelingsperspectief te bieden aan bedrijventerreinen en woonwijken, 
                                en nieuwe toekomst scenario’s te ontwikkelen voor strategie en beleid.
                            """.trimIndent()
                        )
                    }
                    P {
                        LangText(
                            en = """
                                The energy twins developed for the Drechtsteden are focused on different areas and 
                                levels. For example, the digital twin of the RES region is focused on policy and 
                                strategy for the entire region. Those of the residential neighborhoods are used in the 
                                elaboration of the neighborhood implementation programs for heat, and the business 
                                parks form the basis for establishing Energy Hubs, investments in batteries, and group 
                                contracts.
                            """.trimIndent(),
                            nl = """
                                De energy twins die zijn ontwikkeld voor de Drechtsteden zijn gericht op verschillende 
                                gebieden en niveaus. Zo is de digital twin van de RES-regio gericht op beleid en 
                                strategie van de hele regio. Die van de woonwijken worden gebruikt bij de uitwerking 
                                van de wijkuitvoeringsprogramma’s warmte, en de bedrijventerreinen staan aan de basis 
                                van het oprichten van Energy Hubs, investeringen in batterijen en groepscontracten.
                            """.trimIndent()
                        )
                    }
                }
            }
        },
        mediaContent = { DrechtstedenAreas() },
        anylogicRender = {},
        extraContent = {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                HorizontalLine()
                HeaderText(
                    enText = "Get access",
                    nlText = "Krijg toegang",
                )
                P {
                    LangText(
                        en = "The energy twins are accessible with user accounts.",
                        nl = "De energy twins zijn toegankelijk via gebruikersaccounts."
                    )
                    Br { }
                    LangText(
                        en = "If you want access send an email to ",
                        nl = "als je toegang wilt stuur dan een email to "
                    )
                    InlineLink(
                        destinationUrl = "mailto:${modeller.email}",
                        enLinkText = modeller.email,
                        nlLinkText = modeller.email,
                    )
                }
            }
        },
        footerContent = {
            ZenmoModellerProfileCard(modeller)
        },
    )
}

@Composable
private fun DrechtstedenAreas() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .gap(1.5.cssRem)
    ) {
        ModelCard(
            model = TwinModelCardItem(
                label = LocalizedText(
                    nl = "RES Regio",
                    en = "RES Region"
                ),
                url = DrechtstedenProjectArea.RES_REGION.url,
                applicationArea = DrechtstedenProjectArea.RES_REGION,
                imageUrl = drechtstedenResRegion.imageUrl,
                isPrivate = drechtstedenResRegion.isPrivate,
            ),
            showLock = drechtstedenResRegion.isPrivate
        )

        ModelCard(
            model = TwinModelCardItem(
                label = LocalizedText(
                    nl = "Woonwijken",
                    en = "Residential Areas",
                ),
                url = DrechtstedenProjectArea.RESIDENTIAL_AREAS.url,
                applicationArea = DrechtstedenProjectArea.RESIDENTIAL_AREAS,
                imageUrl = overTSpoor.imageUrl,
                isPrivate = overTSpoor.isPrivate,
            ),
            showLock = overTSpoor.isPrivate
        )

        ModelCard(
            model = TwinModelCardItem(
                label = LocalizedText(
                    nl = "Bedrijventerreinen",
                    en = "Business Parks",
                ),
                url = DrechtstedenProjectArea.BUSINESS_PARKS.url,
                applicationArea = DrechtstedenProjectArea.BUSINESS_PARKS,
                imageUrl = dordrecht.imageUrl,
                isPrivate = dordrecht.isPrivate,
            ),
            showLock = dordrecht.isPrivate
        )
    }
}
