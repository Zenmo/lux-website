package energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.pages.empowered.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import energy.lux.frontend.components.widgets.LangBlock
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import org.jetbrains.compose.web.dom.B
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun EmpoweredHeader() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        HeaderText(
            enText = "EmPowerED",
            nlText = "EmPowerED",
        )
        P {
            LangBlock(
                en = {
                    Text("EmPowerED is a research project on ")
                    B { Text("Positive Energy Districts") }
                    Text(", led by ")
                    B { Text("Eindhoven University of Technology. ") }
                    Text(
                        """
                        The goal of the project is to develop socially supported, affordable, and locally appropriate solutions and
                        tools for the heat transition of Dutch neighborhoods.
                    """.trimIndent()
                    )
                },
                nl = {
                    Text("EmPowerED is een onderzoeksproject naar ")
                    B {
                        Text("Positive Energy Districts")
                    }
                    Text(",  geleid door de ")
                    B {
                        Text("Technische Universiteit Eindhoven. ")
                    }
                    Text(
                        """
                        Het doel van het project is om sociaal gedragen, betaalbare en lokaal passende oplossingen en 
                        tools voor de warmtetransitie van Nederlandse buurten te ontwikkelen.
                    """.trimIndent()
                    )
                }
            )
        }
    }
}