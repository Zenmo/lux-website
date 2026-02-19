package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_res_area.components.get_lux_neighbourhood

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub.components.energy_hub_process.EnergyHubProcessBlock
import org.jetbrains.compose.web.dom.P

@Composable
fun Step03() {
    EnergyHubProcessBlock(
        step = "03",
        title = LocalizedText(
            en = "Explore scenarios and determine strategies",
            nl = "Verken scenario’s en bepaal beleid",
        ),
        content = {
            P {
                LangText(
                    en = """
                        The model is now ready to interactively explore current energy dynamics, grid usage, and 
                        bottlenecks. Assess numerous scenarios and quantify their outcomes in terms of emissions, grid 
                        congestion, energy dynamics, seasonal variations, and more. Use the results to engage in 
                        discussions with colleagues and other stakeholders, and jointly determine the policy and/or 
                        strategy for the neighborhood.
                    """.trimIndent(),
                    nl = """
                        Het model is nu geschikt om zelf op interactieve wijze de huidige energiedynamieken, 
                        netgebruik, en bottlenecks te verkennen. Bekijk talloze toekomstscneario’s en kwantificieer de 
                        uitkomsten van de scenario’s in termen van uitstoot, netcongestie, energiedynamieken,
                        seizoensverschillen, en meer. Gebruik de uitkomsten om in gesprek te gaan met collega’s en 
                        bepaal met andere stakeholders gezamelijk het beleid en/of strategie voor de buurt.
                    """.trimIndent()
                )
            }
        }
    )
}