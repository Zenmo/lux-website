package energy.lux.frontend.domains.lux.subdomains.public_subdomains.brabant.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.domains.lux.core.toTwinModelCardItem
import energy.lux.frontend.domains.lux.subdomains.components.SubdomainModelPage
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.brabant.components.brabantModels
import energy.lux.frontend.domains.lux.widgets.TwinModelsGrid
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import kotlin.uuid.Uuid

@Composable
fun Brabant() {
    SubdomainModelPage(
        modelId = Uuid.NIL,
        anylogicRender = {},
        introContent = {
            Div {
                LangText(
                    en = """
                        Explore how sustainable choices at neighbourhood level affect the wider energy system in 
                        Brabant.
                    """.trimIndent(),
                    nl = """
                        Ontdek hoe duurzame keuzes op buurtniveau doorwerken in het bredere energiesysteem van Brabant.
                    """
                )
                P {
                    LangText(
                        en = """
                            With the neighbourhood model and the province model, you can explore different energy 
                            scenarios and gain insight into the relationship between heat demand, grid capacity, 
                            and available heat sources. From individual neighbourhoods to the provincial system, the 
                            models make it possible to understand how decisions interact across different scales.
                    """.trimIndent(),
                        nl = """
                            Met het buurtmodel en het provinciaal model kun je verschillende energiescenario’s 
                            verkennen en inzicht krijgen in de samenhang tussen warmtevraag, netcapaciteit en 
                            beschikbare warmtebronnen. Van individuele buurten tot het provinciale systeem: de modellen 
                            helpen om de effecten van keuzes op verschillende schaalniveaus zichtbaar te maken.
                        """.trimIndent()
                    )
                }

                LangText(
                    en = """
                        Use the models to compare scenarios, investigate spatial differences, and better understand how 
                        local choices influence the broader energy system. 
                    """.trimIndent(),
                    nl = """
                        Gebruik de modellen om scenario’s te vergelijken, ruimtelijke verschillen te onderzoeken en 
                        beter te begrijpen hoe lokale keuzes invloed hebben op het grotere energiesysteem.
                    """.trimIndent()
                )
            }
        },
        mediaContent = {},
        extraContent = {},
        footerContent = {
            Column(
                modifier = Modifier.fillMaxWidth().gap(0.5.cssRem),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HeaderText(
                    enText = "Explore the Models",
                    nlText = "Verken de Modellen",
                )
                P {
                    LangText(
                        en = "Go directly to the neighborhood model or the province model.",
                        nl = "Ga direct naar het buurtmodel of het provinciemodel."
                    )
                }
                TwinModelsGrid(
                    models = brabantModels.map {
                        it.toTwinModelCardItem()
                    }
                )
            }
        },
    )
}