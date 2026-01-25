package com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains


import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.bunderbuurten
import com.zenmo.web.zenmo.domains.lux.subdomains.components.SubdomainModelPage
import com.zenmo.web.zenmo.domains.lux.subdomains.components.ZenmoModellerProfileCard
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import org.jetbrains.compose.web.dom.P


@Composable
fun BunderbuurtenIndex() {
    LuxSubdomainPageLayout(
        title = "Bunderbuurten Veghel",
    ) {
        SubdomainModelPage(
            modelId = bunderbuurten.modelId,
            introContent = {
                P {
                    LangText(
                        en = """
                                Below you can find the mock-up of the digital twin for the sustainability of the 
                                Bunderbuurten in Veghel. The digital twin helps to investigate choices and policies 
                                towards a sustainable energy system. You can play around with it and explore scenarios. 
                                Here we combine heat, mobility, and electricity, both in demand and generation. You can 
                                also explore the potential of smart energy systems with smart charging and smart control 
                                of buffers.
                            """.trimIndent(),
                        nl = """
                                Bekijk hieronder de mock-up van de digital twin voor de verduurzaming van de 
                                Bunderbuurten in Veghel. De digital twin helpt bij het onderzoeken van keuzes en beleid 
                                richting een duurzaam energie systeem. Je kan zelf aan de knoppen zitten en scenario’s 
                                onderzoeken. Hierbij combineren we warmte, mobiliteit en elektriciteit, in zowel vraag 
                                als opwek. Ook kun je de potentie van slimme energiesystemen met slim laden en slimme 
                                aansturing van buffers bekijken.
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
