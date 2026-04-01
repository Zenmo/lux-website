package energy.lux.frontend.domains.lux.sections.application_fields.lux_enegy_hub.components.energy_hub_process

import androidx.compose.runtime.Composable
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.core.services.localization.LocalizedText
import org.jetbrains.compose.web.dom.P

@Composable
fun Step04() {
    EnergyHubProcessBlock(
        step = "04",
        title = LocalizedText(
            en = "Explore and design realistic scenario’s",
            nl = "Verken haalbare toekomstplannen voor de energiehub",
        ),
        content = {
            P {
                LangText(
                    en = """
                        Now all data is implemented LUX Energy Hub can be used to gain insight in the energy profiles 
                        of the companies, explore what current or expected problems may come up and find smart 
                        solutions in the form of collaborations, smart management of consumption, heating, charging, 
                        batteries, etcetera.  
                    """.trimIndent(),
                    nl = """
                        Nu alle data in de tool zit kan LUX Energy Hub gebruikt worden om inzicht te krijgen in alle 
                        energiedynamieken van de bedrijven, om te verkennen wat huidige of verwachte (net)problemen er 
                        zijn, en om slimme oplossingen daarvoor te vinden in de vorm van bijvoorbeeld groepscontracten 
                        of slimme sturing van verbruik, verwarming, laden, batterijen, etcetera. 
                    """.trimIndent()
                )
            }
        }
    )
}