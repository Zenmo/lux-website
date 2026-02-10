package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub.components.energy_hub_process

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.silk.components.icons.mdi.MdiOpenInNew
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.InlineLink
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains.empowered.pages.empowered.components.LearnMoreStyle
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun Step01() {
    EnergyHubProcessBlock(
        step = "01",
        title = LocalizedText(
            en = "The Local Hero",
            nl = "De Local Hero"
        ),
        content = {
            P {
                LangText(
                    en = """
                        The use of LUX energy hub always starts with a local person taking the lead. We call such a 
                        person the local hero.
                    """.trimIndent(),
                    nl = """
                        Het gebruik van LUX-energiehub begint altijd met een lokale persoon die het voortouw neemt. Wij 
                        noemen zo iemand de local hero.
                    """.trimIndent()
                )
                Text(" ")
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = LearnMoreStyle.toModifier()
                ) {
                    InlineLink(
                        destinationUrl = "/",
                        enLinkText = "Scientific study on this concept",
                        nlLinkText = "Wetenschappelijke studie over dit begrip"
                    )
                    MdiOpenInNew()
                }
            }

            P {
                LangText(
                    en = """
                        Ideally, the local hero is someone on the business park, but it can also be someone who has 
                        been hired for this purpose by the province or municipality.
                    """.trimIndent(),
                    nl = """
                        Idealiter is de local hero iemand op het bedrijventerrein, maar het kan ook iemand zijn die 
                        voor dit doel is ingehuurd door provincie of gemeente.
                    """.trimIndent()
                )
            }
        }
    )
}

