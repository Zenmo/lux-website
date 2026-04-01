package energy.lux.frontend.domains.lux.sections.application_fields.lux_enegy_hub.components.energy_hub_process

import androidx.compose.runtime.Composable
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.core.services.localization.LocalizedText
import org.jetbrains.compose.web.dom.P

@Composable
fun Step01() {
    EnergyHubProcessBlock(
        step = "01",
        title = LocalizedText(
            en = "The Local Hero - You!",
            nl = "De Local Hero - Jij!"
        ),
        content = {
            P {
                LangText(
                    en = """
                        The use of LUX Energy Hub always starts with a local person taking the lead. We call such a 
                        person the local hero.  
                        The local hero can be anyone, for example a business park manager, a company operating as a 
                        front-runner, a consultant or a public official. But since you are here on this page, the local 
                        hero for your project is probably you! 
                    """.trimIndent(),
                    nl = """
                        Het gebruik van LUX Energy Hub start altijd met een lokale kartrekker, zo iemand noemen we de 
                        Local Hero. Iedereen zou die rol kunnen pakken, een ondernemersvereniging, een bedrijf dat het 
                        voortouw neemt, een adviseur, of een gemeenteambtenaar. Maar gezien jij hier op deze pagina 
                        bent, ben jij waarschaanlijk de Local Hero voor jou project! 
                    """.trimIndent()
                )
            }
        }
    )
}

