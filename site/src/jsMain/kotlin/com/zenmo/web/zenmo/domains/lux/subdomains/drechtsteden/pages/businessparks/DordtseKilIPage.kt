package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.businessparks

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.DrechtstedenTwinModelPage
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.ModelInDevelopmentInfoWidget
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import org.jetbrains.compose.web.dom.P


@Composable
fun DordtseKilIPage() {
    ModelInDevelopmentInfoWidget(
        enDescription = "Note, this model is still in development.",
        nlDescription = "Let op, dit model is nog in ontwikkeling.",
    )
    DrechtstedenTwinModelPage(
        twin = dordtseKil12AmstelwijckWest,
        introContent = {
            P {
                LangText(
                    en = """
                Below you can find the digital twin for the sustainability of business parks Dordtse Kil 1&2 and 
                Amstelwijck West in Dordrecht. The companies on these business parks are exploring whether they can 
                share energy and invest in sustainable technologies together. The digital twin will assist in designing 
                these sustainable energy systems and making the right decisions.
            """.trimIndent(),
                    nl = """
                Bekijk hieronder  de digital twin voor de verduurzaming van bedrijventerreinen Dordtse Kil 1&2 en 
                Amstelwijck West in Dordrecht. De bedrijven op deze bedrijventerreinen zijn aan het onderzoeken of ze 
                samen energie kunnen delen en investeren in duurzame technieken. De digital twin zal helpen bij het 
                ontwerpen van deze duurzame energiesystemen en het maken van de juiste beslissingen.
            """.trimIndent(),
                )
            }
        },
        footerContent = {
            ZenmoModellerProfileCard(ZenmoTeam.ATE)
        }
    )
}