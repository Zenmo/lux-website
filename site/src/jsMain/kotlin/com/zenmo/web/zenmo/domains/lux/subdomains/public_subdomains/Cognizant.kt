package com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.silk.components.graphics.Image
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.cognizant
import com.zenmo.web.zenmo.domains.lux.subdomains.components.SubdomainModelPage
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.P

@Composable
fun Cognizant() {
    LuxSubdomainPageLayout(
        title = cognizant.label.nl,
    ) {
        SubdomainModelPage(
            modelId = cognizant.modelId,
            introContent = {
                Image(
                    src = "/lux/images/cognizant-immersive-room.jpg",
                    alt = "cognizant immersive room",
                    modifier = Modifier.maxWidth(70.cssRem)
                )
                Column (
                    modifier = Modifier.maxWidth(50.cssRem)
                ) {
                    P {
                        LangText(
                            nl = """
                            Cognizant helpt bedrijven hun processen te elektrificeren.
                            Zenmo heeft een interactief model met een verhaallijn gemaakt 
                            om uit te leggen waar de kansen en knelpunten zitten 
                            en wat het handelingsperspectief is van een bedrijf. 
                        """,
                            en = """
                            Cognizant helps companies to electrify their processes.
                            Zenmo has created an interactive case with a story line
                            to explain the opportunities and bottlenecks 
                            and to offer actionable insights.
                        """,
                        )
                    }
                    P {
                        LangText(
                            nl = """
                            Dit simulatiemodel laat de impact zien van elektrificatie met daarbij 
                            eigen opwek met zon en wind. Duidelijk wordt hoe batterijen kunnen helpen 
                            bij bedrijfsuitbreiding.
                        """,
                            en = """
                            This simulation model shows the impact of electrification with on-site 
                            generation from solar and wind. It becomes clear how batteries can help 
                            when expanding a site.
                        """,
                        )
                    }
                    P {
                        LangText(
                            nl = "Dit simulatiemodel is ontworpen om te projecteren in een 270° immersive room.",
                            en = "This model is designed to be projected in a 270° immersive room.",
                        )
                    }
                }
            },
            footerContent = {
                ZenmoModellerProfileCard(ZenmoTeam.PETER_HOGEVEEN)
            }
        )
    }
}
