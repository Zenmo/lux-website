package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_business.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.ResponsiveFlexStyle
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P


@Composable
fun SmarterEnergyUse() {
    LuxSectionContainer(
        modifier =
            Modifier
                .background(SitePalette.light.overlay),
    ) {
        Div(
            ResponsiveFlexStyle.toModifier()
                .alignItems(AlignItems.FlexStart)
                .toAttrs(),
        ) {
            HeaderText(
                enText = "Smarter energy usage",
                nlText = "Slimmer gebruik van energie",
                modifier = Modifier
                    .fillMaxWidth()
            )
            Column(
                Modifier
                    .fillMaxWidth()
            ) {
                P {
                    LangText(
                        en = """
                            Many companies can also make better use of their existing grid connection. For example, electric 
                            vehicles can be charged smartly, heating and cooling can often be switched off briefly, heat can be 
                            stored, some energy-intensive processes can be shifted to the night, and so on. 
                        """.trimIndent(),
                        nl = """
                            Veel bedrijven kunnen ook hun bestaande netaansluiting beter inzetten. Zo kunnen elektrische 
                            voertuigen slim opladen, kan verwarming en koeling in veel gevallen kort worden uitgeschakeld, kan 
                            warmte worden opgeslagen, kunnen sommige energie-intensieve processen naar de nacht worden 
                            verschoven, enzovoort.
                        """.trimIndent()
                    )
                }

                P(
                    Modifier
                        .fillMaxWidth()
                        .background(Colors.White)
                        .padding(24.px)
                        .luxBorderRadius(LuxCornerRadius.lg)
                        .border(1.px, LineStyle.Solid, Colors.LightGrey)
                        .borderLeft(4.px, LineStyle.Solid, SitePalette.light.primary)
                        .toAttrs()
                ) {
                    LangText(
                        en = "With LUX Business, you can quickly see the effects of these kinds of measures.",
                        nl = "Met LUX Bedrijf zie je snel wat dit soort maatregelen opleveren. "
                    )
                }
            }
        }

    }
}