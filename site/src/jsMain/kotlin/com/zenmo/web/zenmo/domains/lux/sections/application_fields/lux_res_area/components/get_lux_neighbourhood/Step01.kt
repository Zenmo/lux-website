package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_res_area.components.get_lux_neighbourhood

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.ZenmoLink
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub.components.energy_hub_process.EnergyHubProcessBlock
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.P

@Composable
fun Step01() {
    EnergyHubProcessBlock(
        step = "01",
        title = LocalizedText(
            en = "Initialise LUX Neighbourhood",
            nl = "Initializatie LUX Woonbuurt "
        ),
        content = {
            P {
                LangText(
                    en = """
                        Set up LUX Woonbuurten by collecting the required (open) GIS data and implementing it in the 
                        open-source model. This includes, among other things, building data, energy consumption data 
                        (gas and electricity) at Postcode6 level, transformer locations, rooftop PV installations, building 
                        age, and EV charging station locations. 
                    """.trimIndent(),
                    nl = """
                        Zet LUX Woonbuurt op door de benodigde (open) GIS data te verzamelen en in te voeren in het 
                        open source model. Dit is o.a. panden data, verbruiksdata (gas en elektra) op Postcode6 niveau, 
                        locatie trafo’s, PV op dak, bouwjaar huizen en locaties laadpalen.
                    """.trimIndent()
                )
                Br { }
                LangText(
                    en = "If needed, ",
                    nl = "Indien nodig, kan "
                )
                ZenmoLink()
                LangText(
                    en = " can provide support in this process.",
                    nl = " hier bij helpen."
                )
            }
        }
    )
}

