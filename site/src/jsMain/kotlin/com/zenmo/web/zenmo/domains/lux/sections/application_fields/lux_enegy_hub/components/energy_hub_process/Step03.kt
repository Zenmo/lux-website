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
import org.jetbrains.compose.web.dom.P

@Composable
fun Step03() {
    EnergyHubProcessBlock(
        step = "03",
        title = LocalizedText(
            en = "Gathering Company Data",
            nl = "Verzamelen Bedrijfsgegevens",
        ),
        content = {
            P {
                LangText(
                    en = """
                        Armed with the interactive LUX dashboard, the local hero explores possible options and 
                        approaches other entrepreneurs or the business association.
                    """.trimIndent(),
                    nl = """
                        Gewapend met het interactieve LUX dashboard verkent de local hero mogelijke opties en benadert 
                        hij of zij andere ondernemers of de bedrijfsvereniging.
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

            P {
                LangText(
                    en = """
                     Our form can streamline that process considerably, but it is up to the local hero to find a point 
                     of contact for each company who agrees.
                    """.trimIndent(),
                    nl = """
                        Ons invulformulier kan dat proces vergaand stroomlijnen maar het is aan de local hero om per 
                        bedrijf een aanspreekpunt te vinden die akkoord geeft.
                    """.trimIndent()
                )
            }
        }
    )
}