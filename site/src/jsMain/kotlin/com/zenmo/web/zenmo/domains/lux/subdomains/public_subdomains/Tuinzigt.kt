package com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains


import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.hilversum
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.tuinzigt
import com.zenmo.web.zenmo.domains.lux.subdomains.components.SubdomainModelPage
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import org.jetbrains.compose.web.dom.P


@Composable
fun Tuinzigt() {
    LuxSubdomainPageLayout(
        title = tuinzigt.label.nl,
    ) {
        SubdomainModelPage(
            modelId = tuinzigt.modelId,
            introContent = {
                P {
                    LangText(
                        en = """
                            View the model of the neighborhood Tuinzigt in Breda below.
                            The energy twin helps explore choices and policies toward a sustainable energy system.
                            You can take control and explore scenarios yourself.
                            We combine heat, mobility, and electricity, both in demand and generation.
                            You can also explore the potential of smart energy systems with smart charging and smart buffer management.
                        """,
                        nl = """
                            Bekijk hieronder het model van de wijk Tuinzigt in Breda. 
                            De energy twin helpt bij het onderzoeken van keuzes en beleid richting een duurzaam energie systeem. 
                            Je kan zelf aan de knoppen zitten en scenario’s onderzoeken. 
                            Hierbij combineren we warmte, mobiliteit en elektriciteit, in zowel vraag als opwek. 
                            Ook kun je de potentie van slimme energiesystemen met slim laden en slimme aansturing van buffers bekijken. 
                        """,
                    )
                }
            },
            footerContent = {
                ZenmoModellerProfileCard(ZenmoTeam.PETER_HOGEVEEN)
            }
        )
    }
}
