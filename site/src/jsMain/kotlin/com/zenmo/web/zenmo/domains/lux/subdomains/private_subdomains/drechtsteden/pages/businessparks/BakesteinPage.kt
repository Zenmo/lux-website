package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages.businessparks

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.components.DrechtstedenTwinModelPage
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.components.ModelInDevelopmentInfoWidget
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import org.jetbrains.compose.web.dom.P


@Composable
fun BakesteinPage() {
    ModelInDevelopmentInfoWidget(
        enDescription = "Note, this model is still in development.",
        nlDescription = "Let op, dit model is nog in ontwikkeling.",
    )
    DrechtstedenTwinModelPage(
        twin = bakestein,
        introContent = {
            P {
                LangText(
                    en = """
                Below you can view the digital twin for the sustainability of the Bakestein business park in Zwijndrecht. 
                The companies on this business park are exploring whether they can share energy and invest in sustainable 
                technologies together. The digital twin will assist in designing these sustainable energy systems and 
                making the right decisions.
            """.trimIndent(),
                    nl = """
                Bekijk hieronder  de digital twin voor de verduurzaming van bedrijventerrein Bakestein in Zwijndrecht. 
                De bedrijven op dit bedrijventerrein onderzoeken of ze samen energie kunnen delen en investeren in 
                duurzame technieken. De digital twin zal helpen bij het ontwerpen van deze duurzame energiesystemen en 
                het maken van de juiste beslissingen.
            """.trimIndent(),
                )
            }
        },
        footerContent = {
            ZenmoModellerProfileCard(ZenmoTeam.GILLIS)
        }
    )
}