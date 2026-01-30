package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub.components.energy_hub_process

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.zenmo.web.zenmo.components.widgets.LangBlock
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.B
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun Step02() {
    EnergyHubProcessBlock(
        step = "02",
        title = LocalizedText(
            en = "Initial Dashboard Setup",
            nl = "Initiële Dashboardopstelling",
        ),
        content = {
            P {
                LangBlock(
                    en = {
                        Text("For a modest amount (depending on the size and complexity of the area),")
                        B {
                            Text(" Zenmo ")
                        }
                        Text("loads all public data about the area with LUX energy hub.")
                    },
                    nl = {
                        Text(
                            """
                            Voor een bescheiden bedrag (afhankelijk van de omvang en complexiteit van het gebied) laadt
                        """.trimIndent()
                        )
                        B {
                            Text(" Zenmo ")
                        }
                        Text(
                            """
                            met LUX-energiehub alle publieke gegevens rond het gebied in.
                        """.trimIndent()
                        )
                    }
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Colors.White)
                    .padding(24.px)
                    .luxBorderRadius(LuxCornerRadius.lg)
                    .border(1.px, LineStyle.Solid, Colors.LightGrey)
            ) {
                B {
                    LangText(
                        en = "Public Data Includes:",
                        nl = "Het gaat daarbij om:",
                    )
                }

                P {
                    LangText(
                        en = """
                            [List of public data] and data from the network operator (at Alliander, for example, the 
                            Energy Neighbourhood Scan).
                        """.trimIndent(),
                        nl = """
                            [Lijst publieke gegevens] en gegevens netbeheerder (bijAlliander bijvoorbeeld de Energie 
                            Buurtscan).
                            """.trimIndent()
                    )
                }
            }

            P {
                LangText(
                    en = """
                        With this, we set up an interactive dashboard of the energy hub together with a number of basic 
                        scenarios. However, keep in mind: without company-specific data, these scenarios are still 
                        mainly illustrative.
                    """.trimIndent(),
                    nl = """
                        Daarmee stellen wij een interactief dashboard van de energiehub samen met aantal 
                        basisscenario’s in. Bedenkt echter wel: zonder bedrijfsspecifieke gegevens zijn deze scenario’s 
                        nog vooral illustratief.
                    """.trimIndent()
                )
            }
        }
    )
}