package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub.components.energy_hub_process

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.borderLeft
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.P

@Composable
fun Step03() {
    EnergyHubProcessBlock(
        step = "03",
        title = LocalizedText(
            en = "Gathering company data",
            nl = "Verzamelen van energie gegevens",
        ),
        content = {
            P {
                LangText(
                    en = """
                        The local hero identifies and gathers the energy dynamics of the involved stakeholders. Crucial 
                        in this step is to identify the largest energy players of the area and gather their measurement 
                        data and future scenario’s.
                    """.trimIndent(),
                    nl = """
                        The Local Hero verzamelt meetdata en overige informatie van het energiesysteem. Belangrijk is 
                        dat eerst de grote energiespelers binnen de energiehub geidentificeerd worden zodat de 
                        dataverzameling zich op die partijen kan focussen.
                    """.trimIndent()
                )
                Br { }
                Br { }
                LangText(
                    en = """
                        The data can easily be loaded into the LUX data portal that is directly connected to the energy 
                        twin. Any data uploaded their will show up immediately in the model and exploration can begin!
                    """.trimIndent(),
                    nl = """
                        De toekomstplannen van die bedrijven worden ook meegenomen, die koment terug via de scenario’s 
                        in het dashboard van LUX. Alle verzamelde input kan in een online portal geladen worden voor 
                        automatiscshe koppelingen met LUX Energy Hub. 
                    """.trimIndent()
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(SitePalette.light.secondary.lightened(0.65f))
                    .padding(24.px)
                    .luxBorderRadius(LuxCornerRadius.lg)
                    .borderLeft(4.px, LineStyle.Solid, SitePalette.light.secondary)
            ) {
                P {
                    LangText(
                        en = """
                           A key objective of this phase is to get companies to sign an authorization form to use their 
                           energy usage data (confidentially, of course) so that Zenmo can replace assumptions about 
                           companies' usage with real data.
                        """.trimIndent(),
                        nl = """
                            Een belangrijke doelstelling van deze fase is om bedrijven een machtigingsformulier te 
                            laten ondertekenen voor het (uiteraard vertrouwelijk) gebruiken van hun 
                            energiegebruiksgegevens zodat Zenmo aannames over het gebruik van bedrijven kan vervangen 
                            door echte gegevens.
                        """.trimIndent()
                    )
                }
            }
        }
    )
}