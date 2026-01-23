package com.zenmo.web.zenmo.domains.lux.subdomains


import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.nederland
import com.zenmo.web.zenmo.domains.lux.subdomains.components.SubdomainModelPage
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import org.jetbrains.compose.web.dom.P


@Composable
fun NederlandIndex() {
    LuxSubdomainPageLayout(
        title = nederland.label.nl,
    ) {
        SubdomainModelPage(
            modelId = nederland.modelId,
            introContent = {
                P {
                    LangText(
                        en = "Below is a mock-up of the digital twin for the Netherlands",
                        nl = "Bekijk hieronder de mock-up van de digital twin voor Nederland",
                    )
                }
            },
            footerContent = {
                ZenmoModellerProfileCard(ZenmoTeam.NAUD_LOOMANS)
            }
        )
    }
}
