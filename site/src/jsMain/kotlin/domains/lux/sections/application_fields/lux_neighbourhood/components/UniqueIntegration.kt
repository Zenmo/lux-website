package energy.lux.frontend.domains.lux.sections.application_fields.lux_neighbourhood.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.functions.clamp
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLink
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.widgets.InlineLink
import energy.lux.frontend.components.widgets.LangBlock
import energy.lux.frontend.domains.lux.sections.ResponsiveFlexStyle
import energy.lux.frontend.domains.lux.sections.application_fields.LuxApplicationArea
import energy.lux.frontend.domains.lux.styles.secondaryGradientBackground
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.theme.styles.LuxCornerRadius
import energy.lux.frontend.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@Composable
fun UniqueIntegration() {
    Div(
        ResponsiveFlexStyle.toModifier()
            .gap(24.px)
            .alignItems(AlignItems.FlexStart)
            .luxBorderRadius(LuxCornerRadius.xl)
            .padding(clamp(32.px, 5.vw, 64.px))
            .secondaryGradientBackground()
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
                                    A unique possibility of LUX Neighbourhood is that it can be combined with 
                                """.trimIndent()
                        )
                        Text(" ")
                        InlineLink(
                            destinationUrl = LuxApplicationArea.LUX_REGION.url,
                            enLinkText = LuxApplicationArea.LUX_REGION.areaTitle.en,
                            nlLinkText = LuxApplicationArea.LUX_REGION.areaTitle.nl,
                        )
                        Text(" ")

                        Text(
                            """
                                    to get an overview at the level of province or RES region. This allows you to 
                                    compare neighborhoods and determine which ones should get priority when making 
                                    policy decisions such as when rolling out district heating.
                                """.trimIndent()
                        )
                    },
                    nl = {
                        Text("Een unieke mogelijkheid van LUX Woonwijk is de combinatie met ")
                        InlineLink(
                            destinationUrl = LuxApplicationArea.LUX_REGION.url,
                            enLinkText = LuxApplicationArea.LUX_REGION.areaTitle.en,
                            nlLinkText = LuxApplicationArea.LUX_REGION.areaTitle.nl,
                        )
                        Text(", ")

                        Text(
                            """
                                    waarmee je een overzicht krijgt op het niveau van provincie of RES Regio. Zo kun je 
                                    buurten vergelijken en bepalen welke buurt prioriteit moeten krijgen bij 
                                    beleidsbeslissingen, bijvoorbeeld bij de uitrol van stadsverwarming.
                                """.trimIndent()
                        )
                    }
                )
            }
        }
    }
}
