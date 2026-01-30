package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.functions.clamp
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiArrowForward
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.ResponsiveRowStyle
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.components.ApplicationAreaCTAButton
import com.zenmo.web.zenmo.domains.lux.styles.mutedWhite
import com.zenmo.web.zenmo.domains.lux.styles.verticalLinearBackground
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P


@Composable
fun EfficientSupport() {
    LuxSectionContainer(
        modifier = Modifier
            .background(SitePalette.light.overlay),
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .gap(1.cssRem)
                .luxBorderRadius(LuxCornerRadius.xl)
                .padding(clamp(32.px, 5.vw, 64.px))
                .verticalLinearBackground()
                .color(Colors.White)
        ) {
            HeaderText(
                enText = "Efficient Support",
                nlText = "Efficiënte Ondersteuning",
            )
            Div {
                P {
                    LangText(
                        en = """
                        In this way, LUX energy hub provides particularly efficient support to the process that 
                        attracts the local hero.
                    """.trimIndent(),
                        nl = """
                        Op deze manier levert LUX-energiehub bijzonder efficient ondersteuning aan het proces dat
                        de local hero trekt.
                    """.trimIndent()
                    )
                }
                P {
                    LangText(
                        en = """
                        If requested, Zenmo is also happy to support the local hero in a more personalized way, whether 
                        or not through one of the many experts who use LUX energy hub and LUX company in your region.
                    """.trimIndent(),
                        nl = """
                        Zenmo is desgevraagd ook graag bereid om de local hero meer gepersonaliseerd te ondersteunen, 
                        al of niet via één van de vele deskundigen die LUX-energiehub en LUX-bedrijf in jouw regio 
                        gebruiken.
                    """.trimIndent()
                    )
                }
            }

            Div(
                ResponsiveRowStyle
                    .toModifier()
                    .justifyContent(JustifyContent.Center)
                    .fillMaxWidth()
                    .gap(16.px)
                    .toAttrs(),
            ) {
                ApplicationAreaCTAButton(
                    content = {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.gap(8.px)
                        ) {
                            LangText(
                                en = "Learn more",
                                nl = "Meer informatie"
                            )
                            MdiArrowForward(Modifier.fontSize(18.px))
                        }
                    },
                    bgColor = SitePalette.light.secondary,
                    textColor = Colors.Black,
                    path = "/" //todo link to correct page
                )

                ApplicationAreaCTAButton(
                    text = LocalizedText(
                        en = "Contact Zenmo",
                        nl = "Contacteer Zenmo"
                    ),
                    modifier = Modifier.mutedWhite()
                )
            }
        }
    }
}