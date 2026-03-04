package com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains


import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.MediaContentLayout
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.tuinzigt
import com.zenmo.web.zenmo.domains.lux.subdomains.components.SubdomainModelPage
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.dom.P


@Composable
fun Tuinzigt() {
    LuxSubdomainPageLayout(
        title = tuinzigt.label.nl,
    ) {
        SubdomainModelPage(
            modelId = tuinzigt.modelId,
            introContent = {
                MediaContentLayout(
                    imageUrl = tuinzigt.imageUrl,
                    title = {
                        HeaderText(
                            enText = tuinzigt.label.en,
                            nlText = tuinzigt.label.nl,
                            textColor = SitePalette.light.primary,
                        )
                    },
                    description = {

                        P {
                            LangText(
                                en = """
                                    This model of the neighborhood Tuinzigt in Breda was used to explore the value of 
                                    shared grid batteries. It is a closed model as it contains grid-data for all 
                                    transformer stations. Per transformer station the municipality explored how much 
                                    battery capacity would be required in a variety of electrification scenarios.   
                                """.trimIndent(),
                                nl = """
                                    Dit model van de wijk Tuinzigt in Breda is gebruikt om de waarde van gedeelde 
                                    batterijopslag te onderzoeken. Het is een afgeschermd model omdat het netdata bevat 
                                    voor alle transformatorstations. Per transformatorstation heeft de gemeente 
                                    verkend hoeveel batterijcapaciteit er nodig zou zijn in verschillende 
                                    elektrificatiescenario's.
                                """.trimIndent(),
                            )
                        }
                    }
                )
            },
            footerContent = {
                ZenmoModellerProfileCard(ZenmoTeam.PETER_HOGEVEEN)
            }
        )
    }
}
