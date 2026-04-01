package energy.lux.frontend.domains.lux.sections.application_fields.lux_enegy_hub.components.energy_hub_process

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import energy.lux.frontend.components.widgets.LangBlock
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.theme.styles.LuxCornerRadius
import energy.lux.frontend.theme.styles.luxBorderRadius
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
            en = "Initialize the tool",
            nl = " Initialiseer de tool",
        ),
        content = {
            P {
                LangBlock(
                    en = {
                        Text(
                            """
                            To initialize LUX energy hub, public data is loaded into LUX and some base scenario’s can 
                            be defined. This can done by yourself or
                        """.trimIndent()
                        )
                        B {
                            Text(" Zenmo ")
                        }
                        Text("can help you with that.")
                    },
                    nl = {
                        Text(
                            """
                            Om LUX Energy Hub te initialiseren, publieke data wordt ingeladen en een aantal scenario’s 
                            kunnen gedefinieerd worden. Dit kan gedaan worden door de Local Hero, maar
                        """.trimIndent()
                        )
                        B {
                            Text(" Zenmo ")
                        }
                        Text("kan hier ook goed bij helpen.")
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
                        en = "Public data includes:",
                        nl = "Het gaat daarbij om:",
                    )
                }

                P {
                    LangText(
                        en = """
                           Geographical data of buildings, locations of chargers, public energy data, and public grid 
                           and transformer data.
                        """.trimIndent(),
                        nl = """
                            Geografische data van gebouwen, locaties van laders, publieke energiedata, publieke 
                            netdata (ligging kabels en trafostations) 
                            """.trimIndent()
                    )
                }
            }
        }
    )
}