package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_neighbourhood.components.get_lux_neighbourhood

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub.components.energy_hub_process.EnergyHubProcessBlock
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P

@Composable
fun Step02() {
    EnergyHubProcessBlock(
        step = "02",
        title = LocalizedText(
            en = "Gathering detailed data",
            nl = "Verzamel detail data",
        ),
        content = {
            Div {

                P {
                    LangText(
                        en = """
                        Collect data on residential heating systems, energy consumption data of schools, shops, and 
                        businesses, CDR data from EV charging stations, and measurement data from low-voltage 
                        substations. All of this data is optional—the more data that is collected, the more accurate 
                        the simulation will be. Feed the data to the model by putting it in the format of the input 
                        files.            
                    """.trimIndent(),
                        nl = """
                        Verzamel data over verwarmingsystemen van de huizen, verbruiksdata van scholen, winkels en 
                        bedrijven, CDR data van de laadpalen, en meetdata van de laagspanningsstations. Al deze data zijn 
                        optioneel, hoe meer er verzameld wordt hoe accurater de simulatie. Voed de data aan het model 
                        door het in het formaat van de input-bestanden te zetten.
                    """.trimIndent()
                    )
                }
            }
        }
    )
}
