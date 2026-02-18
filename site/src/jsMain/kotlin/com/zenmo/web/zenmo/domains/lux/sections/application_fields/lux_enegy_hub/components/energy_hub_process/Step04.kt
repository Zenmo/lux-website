package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub.components.energy_hub_process

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiDescription
import com.varabyte.kobweb.silk.components.icons.mdi.MdiDocumentScanner
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLan
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.B
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

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

            SimpleGrid(
                numColumns = numColumns(base = 1, sm = 1, md = 2, lg = 4, xl = 4),
                modifier = Modifier.gap(1.5.cssRem)
            ) {
                ScenarioCard(
                    icon = { MdiDescription() },
                    title = LocalizedText(
                        en = "Legal Analysis",
                        nl = "Juridische Analyse",
                    ),
                    description = LocalizedText(
                        en = "Shows that it has to be done now",
                        nl = "Laat zien dat het nu al moet",
                    ),
                )

                ScenarioCard(
                    icon = { MdiLan() },
                    title = LocalizedText(
                        en = "LAN Plan",
                        nl = "Plan van het LAN",
                    ),
                    description = LocalizedText(
                        en = "Shows that it is on the schedule",
                        nl = "Laat zien dat het op de planning staat",
                    ),
                )

                ScenarioCard(
                    icon = { MdiDocumentScanner() },
                    title = LocalizedText(
                        en = "Alliander Scan",
                        nl = "Buurtscan van Alliander",
                    ),
                    description = LocalizedText(
                        en = "Already contains exactly the right data",
                        nl = "Bevat al precies de goede gegevens",
                    ),
                )
            }
        }
    )
}

@Composable
private fun ScenarioCard(
    icon: @Composable () -> Unit,
    title: LocalizedText,
    description: LocalizedText,
) {
    Column(
        Modifier
            .fillMaxWidth()
            .gap(12.px)
            .background(Colors.White)
            .padding(18.px)
            .luxBorderRadius(LuxCornerRadius.lg)
    ) {
        Span(
            Modifier
                .color(SitePalette.light.primary).toAttrs()
        ) {
            icon()
        }
        B {
            LangText(
                en = title.en,
                nl = title.nl
            )
        }

        P(
            Modifier.margin(0.px)
                .toAttrs()
        ) {
            LangText(
                en = description.en,
                nl = description.nl
            )
            Text(" ")
        }
    }
}