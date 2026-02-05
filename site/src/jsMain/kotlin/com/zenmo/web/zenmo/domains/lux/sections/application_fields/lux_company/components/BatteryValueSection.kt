package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_company.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.dom.P

@Composable
fun BatteryValueSection() {
    LuxSectionContainer(
        modifier = Modifier
            .background(SitePalette.light.overlay),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            P {
                LangText(
                    en = """
                        You can also earn money with energy trading and a battery offers security in the event of a 
                        power failure. With LUX company, you get accurate insight into what a battery of what size and 
                        price can bring to your company.
                    """.trimIndent(),
                    nl = """
                        Je kunt bovendien geld verdienen met energiehandel en een batterij biedt zekerheid bij 
                        stroomuitval. Met LUX-bedrijf krijgt je nauwkeurig inzicht in wat een batterij van welke omvang 
                        en prijs jouw bedrijf kan opleveren.
                    """.trimIndent()
                )
            }

            P {
                LangText(
                    en = """
                       LUX takes into account your own energy consumption per quarter of an hour in recent years as 
                       stored at the metering company. Possibly in combination with your existing or planned solar 
                       panels, electric vehicles, heat pumps, et cetera. Based on this, LUX company makes an advanced 
                       analysis.
                    """.trimIndent(),
                    nl = """
                        LUX houdt rekening met jouw eigen energiegebruik per kwartier van de afgelopen jaren zoals 
                        opgeslagen bij het meetbedrijf. Eventueel in combinatie met je bestaande of geplande 
                        zonnepanelen, elektrischevoertuigen, warmtepompen, et cetera. Op basis daarvan maakt 
                        LUX-bedrijf een geavanceerde analyse.
                    """.trimIndent()
                )
            }
        }
    }
}