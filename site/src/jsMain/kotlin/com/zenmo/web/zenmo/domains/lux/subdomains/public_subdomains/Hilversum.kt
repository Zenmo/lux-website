package com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains


import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.hilversum
import com.zenmo.web.zenmo.domains.lux.subdomains.components.SubdomainModelPage
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import org.jetbrains.compose.web.dom.P


@Composable
fun HilversumIndex() {
    LuxSubdomainPageLayout(
        title = hilversum.label.nl,
    ) {
        SubdomainModelPage(
            modelId = hilversum.modelId,
            introContent = {
                P {
                    LangText(
                        en = """
                            View the digital twin for the Werfgebied Hilversum sustainability project. 
                            The digital twin assists in designing these sustainable energy systems and making the 
                            right decisions.
                        """.trimIndent(),
                        nl = """
                            Bekijk de digitale tweeling voor het Werfgebied Hilversum duurzaamheid project.
                            De digitale tweeling helpt bij het ontwerpen van deze duurzame energiesystemen en het maken
                            van de juiste beslissingen.
                        """.trimIndent(),
                    )
                }
            },
            footerContent = {
                ZenmoModellerProfileCard(ZenmoTeam.NAUD_LOOMANS)
            }
        )
    }
}
