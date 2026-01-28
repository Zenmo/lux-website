package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages.businessparks

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.components.DrechtstedenTwinModelPage
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.components.ModelInDevelopmentInfoWidget
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import org.jetbrains.compose.web.dom.P


@Composable
fun DordtseKilIIIPage() {
    ModelInDevelopmentInfoWidget(
        enDescription = "Note, this model is still in development.",
        nlDescription = "Let op, dit model is nog in ontwikkeling.",
    )
    DrechtstedenTwinModelPage(
        twin = dordtseKil34,
        introContent = {
            P {
                LangText(
                    en = """
                Below you can find the digital twin for the sustainability of business park Dordtse Kil 3&4 in 
                Dordrecht. The companies on this business park are investigating whether they can share energy 
                together and invest in sustainable technologies. The digital twin will help in designing these 
                sustainable energy systems and making the right decisions.
            """.trimIndent(),
                    nl = """
                Bekijk hieronder  de digital twin voor de verduurzaming van bedrijventerrein Dordtse Kil 3&4 in 
                Dordrecht. De bedrijven op dit bedrijventerrein zijn aan het onderzoeken of ze samen energie kunnen 
                delen en investeren in duurzame technieken. De digital twin zal helpen bij het ontwerpen van deze 
                duurzame energiesystemen en het maken van de juiste beslissingen.
            """.trimIndent(),
                )
            }
        },
        footerContent = {
            ZenmoModellerProfileCard(ZenmoTeam.ATE)
        }
    )
}