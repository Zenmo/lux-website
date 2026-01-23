package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.resregion

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.DrechtstedenTwinModelPage
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.ModelInDevelopmentInfoWidget
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.AukeNaudContactCard
import org.jetbrains.compose.web.dom.P

@Composable
fun DrechtstedenRegioIndex() {
    ModelInDevelopmentInfoWidget()
    DrechtstedenTwinModelPage(
        twin = drechtstedenRes,
        introContent = {
            Column {
                P {
                    LangText(
                        en = """
                                Below is a mock-up of the digital twin for the sustainability of the Drechtsteden. 
                                This area is working on a smart energy system. The digital twin will assist in 
                                designing these sustainable energy systems and making the right decisions.
                        """.trimIndent(),
                        nl = """
                                Bekijk hieronder de mock-up van de digital twin voor de verduurzaming van de 
                                Drechtsteden. In dit gebied wordt gewerkt aan een slim energiesysteem. De digital twin 
                                zal helpen bij het ontwerpen van deze duurzame energiesystemen en het maken van de 
                                juiste beslissingen.
                        """.trimIndent(),
                    )
                }
            }

        },
        footerContent = { AukeNaudContactCard() }
    )
}


