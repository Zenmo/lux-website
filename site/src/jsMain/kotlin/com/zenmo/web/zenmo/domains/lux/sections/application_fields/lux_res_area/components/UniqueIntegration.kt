package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_res_area.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.functions.clamp
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLink
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.InlineLink
import com.zenmo.web.zenmo.components.widgets.LangBlock
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.ResponsiveRowStyle
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.lux.styles.verticalLinearBackground
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@Composable
fun UniqueIntegration() {
    LuxSectionContainer {
        Div(
            ResponsiveRowStyle.toModifier()
                .gap(24.px)
                .alignItems(AlignItems.FlexStart)
                .fillMaxWidth()
                .luxBorderRadius(LuxCornerRadius.xl)
                .padding(clamp(32.px, 5.vw, 64.px))
                .verticalLinearBackground(
                    topColor = SitePalette.light.secondary,
                    bottomColor = SitePalette.light.secondary.darkened(0.2f)
                )
                .toAttrs()
        ) {
            MdiLink(
                Modifier
                    .fontSize(48.px)
                    .flexShrink(0)
                    .transform { rotate(125.deg) }
            )

            Column(
                modifier = Modifier.gap(1.cssRem)
            ) {
                HeaderText(
                    enText = "Unique Integration",
                    nlText = "Unieke Integratie",
                )

                P {
                    LangBlock(
                        en = {
                            Text(
                                """
                                    A unique possibility of LUX residential is that it can be combined with 
                                """.trimIndent()
                            )
                            Text(" ")
                            InlineLink(
                                destinationUrl = LuxApplicationArea.LUX_REGION.path,
                                enLinkText = LuxApplicationArea.LUX_REGION.areaTitle.en,
                                nlLinkText = LuxApplicationArea.LUX_REGION.areaTitle.nl,
                            )
                            Text(", ")
                            SpanText(
                                text = "LUX-RES",
                                modifier = Modifier.textDecorationLine(TextDecorationLine.Underline),
                            )
                            Text(" or ")
                            SpanText(
                                text = "LUX province ",
                                modifier = Modifier.textDecorationLine(TextDecorationLine.Underline),
                            )

                            Text(
                                """
                                    to get an in-depth overview of how different neighborhoods differ from each other 
                                    and where the priority should lie for solutions such as heat networks.
                                """.trimIndent()
                            )
                        },
                        nl = {
                            Text(
                                """
                                   Een unieke mogelijkheid van LUX-woonwijk is dat het gecombineerd kan worden met 
                                """.trimIndent()
                            )
                            Text(" ")
                            InlineLink(
                                destinationUrl = LuxApplicationArea.LUX_REGION.path,
                                enLinkText = LuxApplicationArea.LUX_REGION.areaTitle.en,
                                nlLinkText = LuxApplicationArea.LUX_REGION.areaTitle.nl,
                            )
                            Text(", ")
                            SpanText(
                                text = "LUX-RES",
                                modifier = Modifier.textDecorationLine(TextDecorationLine.Underline),
                            )
                            Text(" of ")
                            SpanText(
                                text = "LUX provincie ",
                                modifier = Modifier.textDecorationLine(TextDecorationLine.Underline),
                            )

                            Text(
                                """
                                    om een diepgaand totaaloverzicht te krijgen van hoe verschillende buurten van 
                                    elkaar verschillen en waar de prioriteit moet liggen van oplossingen zoals 
                                    warmtenetten.
                                """.trimIndent()
                            )
                        }
                    )
                }
            }
        }
    }
}