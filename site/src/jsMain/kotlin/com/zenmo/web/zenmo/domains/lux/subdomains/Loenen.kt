package com.zenmo.web.zenmo.domains.lux.subdomains

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.loenen
import com.zenmo.web.zenmo.domains.lux.sections.responsiveGap
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ProfileCardArrangementDirection
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.subdomains.components.SubdomainModelPage
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import org.jetbrains.compose.web.dom.P

@Composable
fun LoenenIndex() {
    LuxSubdomainPageLayout(
        title = loenen.label.nl,
    ) {
        SubdomainModelPage(
            modelId = loenen.modelId,
            introContent = {
                P {
                    LangText(
                        en = """
                            Below is a mock-up of the digital twin for the sustainability project in the village 
                            of Loenen. In Loenen, the energy cooperative is working on a smart energy system with a 
                            Community Virtual Power Plant. The digital twin will assist in designing these sustainable 
                            energy systems and making the right decisions.
                        """.trimIndent(),
                        nl = """
                            Bekijk hieronder de mock-up van de digital twin voor de verduurzaming van het dorp 
                            Loenen. In Loenen werkt de energie coöperatie aan een slim energiesysteem met een 
                            Community Virtual Power Plant. De digital twin zal helpen bij het ontwerpen van deze 
                            duurzame energiesystemen en het maken van de juiste beslissingen.
                        """.trimIndent(),
                    )
                }
            },
            footerContent = {
                SimpleGrid(
                    numColumns = numColumns(base = 1, md = 2, lg = 2, xl = 2),
                    modifier = Modifier.responsiveGap()
                ) {
                    ZenmoModellerProfileCard(
                        ZenmoTeam.NAUD_LOOMANS,
                        ProfileCardArrangementDirection.VERTICAL
                    )
                    ProfileContactCard(
                        name = "Ariadne Renteria Castaneda",
                        imageUrl = "avatars/blank.png",
                        email = "a.renteria.castaneda@student.tue.nl",
                        cardArrangementDirection = ProfileCardArrangementDirection.VERTICAL
                    )
                }
            }
        )
    }
}
