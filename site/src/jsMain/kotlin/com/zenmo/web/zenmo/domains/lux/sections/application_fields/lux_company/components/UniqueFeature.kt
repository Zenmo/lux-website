package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_company.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.functions.clamp
import com.varabyte.kobweb.compose.css.functions.min
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.zenmo.web.zenmo.components.widgets.InlineLink
import com.zenmo.web.zenmo.components.widgets.LangBlock
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.lux.styles.secondaryGradientBackground
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@Composable
fun UniqueFeature() {
    LuxSectionContainer {
        Column(
            modifier = Modifier.fillMaxWidth()
                .luxBorderRadius(LuxCornerRadius.xl)
                .padding(48.px)
                .secondaryGradientBackground()
                .gap(1.cssRem)
        ) {
            HeaderText(
                enText = "Unique Feature",
                nlText = "Unieke Eigenschap",
            )
            Div(
                Modifier
                    // ensures that the content never overflows the parent (100%),
                    // while staying between 300px and 800px, scaling with the viewport width (80vw).
                    .width(min(100.percent, clamp(300.px, 80.vw, 800.px)))
                    .toAttrs()
            ) {
                P {
                    LangBlock(
                        en = {
                            Text("A unique feature of LUX company is that it can be combined with ")
                            InlineLink(
                                destinationUrl = LuxApplicationArea.LUX_ENERGY_HUB.path,
                                enLinkText = LuxApplicationArea.LUX_ENERGY_HUB.label.en,
                                nlLinkText = LuxApplicationArea.LUX_ENERGY_HUB.label.nl
                            )
                            Text(" to see how different companies can help each other.")
                        },
                        nl = {
                            Text(
                                "Een unieke eigenschap van LUX company is dat het gecombineerd kan worden met "
                            )
                            InlineLink(
                                destinationUrl = LuxApplicationArea.LUX_ENERGY_HUB.path,
                                enLinkText = "LUX energy hub",
                                nlLinkText = "LUX energy hub"
                            )
                            Text(" om te zien hoe verschillende bedrijven elkaar kunnen helpen.")
                        }
                    )
                }

                P {
                    LangText(
                        en = """
                      Consider, for example, a group contract (GTO), a common battery, power cable between two 
                      companies (CDS), a local heat network, etc.  
                    """.trimIndent(),
                        nl = """
                        Denk hierbij bijvoorbeeld aan een groepscontract (GTO), een gemeenschappelijke batterij, een 
                        stroomkabel tussen twee bedrijven (GDS), een lokaal warmtenet, et cetera.
                    """.trimIndent()
                    )
                }
            }
        }
    }
}
