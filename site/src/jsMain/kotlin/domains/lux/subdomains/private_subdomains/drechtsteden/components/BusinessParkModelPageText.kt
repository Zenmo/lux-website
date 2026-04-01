package energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.components

import androidx.compose.runtime.Composable
import energy.lux.frontend.components.widgets.LangText
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P


@Composable
fun BusinessParkModelPageText() {
    Div {
        P {
            LangText(
                en = """
                    The energy twin for business parks supports businesses in launching energy hubs. With the energy 
                    twin, entrepreneurs and advisors gain insights into renewable energy measures, the implementation 
                    of energy management systems, and the setup of energy hubs. 
                """.trimIndent(),
                nl = """
                    De energy twin voor bedrijventerreinen ondersteunt bedrijven bij het opstarten van energy hubs. Met 
                    de energy twin krijgen ondernemers en adviseurs inzicht in de verduurzaming van bedrijven, de 
                    implementatie van energiemanagementsystemen en de opzet van energy hubs.
                """.trimIndent()
            )
        }

        P {
            LangText(
                en = """
                    Thanks to these energy hubs with collective grid connection contracts, businesses can expand and 
                    become more sustainable, despite grid congestion.
                """.trimIndent(),
                nl = """
                    Dankzij deze energy hubs en groepscontracten kunnen bedrijven uitbreiden en verduurzamen, ondanks 
                    netcongestie.
                """.trimIndent()
            )
        }
    }
}