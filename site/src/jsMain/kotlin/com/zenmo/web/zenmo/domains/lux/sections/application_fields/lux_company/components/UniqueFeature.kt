package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_company.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.zenmo.web.zenmo.components.widgets.InlineLink
import com.zenmo.web.zenmo.components.widgets.LangBlock
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.lux.styles.verticalLinearBackground
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@Composable
fun UniqueFeature(
    breakpoint: Breakpoint
) {
    LuxSectionContainer(
        modifier = Modifier
            .background(SitePalette.light.overlay),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .luxBorderRadius(LuxCornerRadius.xl)
                .padding(48.px)
                .verticalLinearBackground(
                    topColor = SitePalette.light.secondary,
                    bottomColor = SitePalette.light.secondary.darkened(0.2f)
                )
                .gap(1.cssRem)
        ) {
            HeaderText(
                enText = "Unique Feature",
                nlText = "Unieke Eigenschap",
            )
            Div(
                Modifier
                    .fillMaxWidth()
                    .thenIf(
                        breakpoint > Breakpoint.MD,
                        Modifier.width(80.percent)
                    )
                    .toAttrs()
            ) {
                P {
                    LangBlock(
                        en = {
                            Text("A unique feature of LUX company is that it can be combined with ")
                            InlineLink(
                                destinationUrl = LuxApplicationArea.LUX_ENERGY_HUB.path,
                                enLinkText = "LUX energy hub",
                                nlLinkText = "LUX energy hub"
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
                      Consider, for example, a group contract (GTO), a common battery, a galvanically isolated cable 
                      between two companies, a localheat network, etc.  
                    """.trimIndent(),
                        nl = """
                        Denk hierbij bijvoorbeeld aan een groepscontract (GTO), een gemeenschappelijke batterij, een 
                        galvanisch gescheiden leiding tussen twee bedrijven, een lokaal warmtenet, et cetera.
                    """.trimIndent()
                    )
                }
            }
        }
    }
}
