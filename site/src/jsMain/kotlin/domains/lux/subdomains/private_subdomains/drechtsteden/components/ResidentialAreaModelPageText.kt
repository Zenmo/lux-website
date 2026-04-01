package energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.silk.components.icons.mdi.MdiBattery0Bar
import com.varabyte.kobweb.silk.components.icons.mdi.MdiElectricCar
import com.varabyte.kobweb.silk.components.icons.mdi.MdiHeatPump
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLocalFireDepartment
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.core.services.localization.LocalizedText
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P


@Composable
fun ResidentialAreaModelPageText() {
    Column {
        Div {
            P {
                LangText(
                    en = """
                    With the energy twin for residential neighborhoods and districts, municipalities can examine their 
                    energy plans and transition visions in detail. The energy twin integrates sustainable mobility, 
                    sustainable heating, and electrification. The neighborhood is simulated in detail with 
                    sustainability options per household, placement of public charging stations, and potential heating 
                    networks.
                """.trimIndent(),
                    nl = """
                    Met de energy twin voor woonwijken en buurten kunnen gemeenten hun energieplannen en 
                    transitievisies in detail doorlichten. De energy twin integreert duurzame mobiliteit, duurzame 
                    warmte en elektrificatie. De wijk wordt gedetailleerd gesimuleerd met verduurzamingsopties per 
                    woning, plaatsing van openbare laadpalen en mogelijke warmtenetten. 
                """.trimIndent()
                )
            }
            P {
                LangText(
                    en = """
                    We also explore unconventional solutions that provide actionable options for neighborhoods facing 
                    grid congestion but lacking heating network opportunities.
                """.trimIndent(),
                    nl = """
                    Ook verkennen we onconventionele oplossingen die handelingsperspectief bieden voor wijken met 
                    netcongestie, maar zonder mogelijkheid voor warmtenetten.
                """.trimIndent()
                )
                Br { }
                LangText(
                    en = """
                        These include neighborhood batteries and smart control of (hybrid) heat pumps, home batteries, 
                        and electric vehicles.
                    """.trimIndent(),
                    nl = """
                        Denk hierbij aan buurtbatterijen en slimme aansturing van (hybride) warmtepompen, 
                        thuisbatterijen en elektrische voertuigen.
                    """.trimIndent()
                )
            }
        }
        UnconventionalSolutions()
    }
}

val BatteryRotationStyle = CssStyle.base {
    Modifier.transform {
        rotate(90.deg)
    }
}

@Composable
private fun UnconventionalSolutions() {
    SimpleGrid(
        numColumns = numColumns(base = 1, sm = 1, md = 2, lg = 4, xl = 4),
        modifier = Modifier.gap(1.5.cssRem)
    ) {
        FeatureItem(
            text = LocalizedText(
                en = "Neighborhood and home batteries",
                nl = "Buurt -en thuisbatterijen"
            ),
            icon = { MdiBattery0Bar(BatteryRotationStyle.toModifier()) },
        )
        FeatureItem(
            text = LocalizedText(
                en = "smart control of (hybrid) heat pumps",
                nl = "slimme aansturing van (hybride) warmtepompen"
            ),
            icon = { MdiHeatPump() }
        )
        FeatureItem(
            text = LocalizedText(
                en = "District heating",
                nl = "Warmtenetten"
            ),
            icon = { MdiLocalFireDepartment() }
        )
        FeatureItem(
            text = LocalizedText(
                en = "Electric vehicles with smart charging and V2G",
                nl = "Elektrische voertuigen met slim laden en V2G"
            ),
            icon = { MdiElectricCar() }
        )
    }
}