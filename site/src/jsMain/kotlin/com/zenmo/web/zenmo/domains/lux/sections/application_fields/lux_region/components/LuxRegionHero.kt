package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_region.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.functions.clamp
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.zenmo.web.zenmo.components.widgets.InlineLink
import com.zenmo.web.zenmo.components.widgets.LangBlock
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.ResponsiveFlexStyle
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.components.ApplicationAreaCTAButton
import com.zenmo.web.zenmo.domains.lux.styles.mutedWhite
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.LuxSpecificColorHues
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@Composable
fun LuxRegionHero() {
    LuxSectionContainer {
        Div(
            ResponsiveFlexStyle.toModifier()
                .alignItems(AlignItems.FlexStart)
                .toAttrs()
        ) {
            TextContent()
            ProvenAtScaleCard()
        }
    }
}


@Composable
private fun TextContent() {
    Column(
        Modifier.fillMaxWidth()
            .gap(1.cssRem)
    ) {
        HeaderText(
            enText = LuxApplicationArea.LUX_REGION.areaTitle.en,
            nlText = LuxApplicationArea.LUX_REGION.areaTitle.nl,
        )
        P {
            LangBlock(
                en = {
                    Text("Provinces and municipalities have ")
                    //todo link to resources page
                    InlineLink(
                        destinationUrl = "/",
                        enLinkText = "received resources",
                        nlLinkText = "middelen gekregen",
                    )
                    Text(" ")
                    Text(
                        """
                         to form energy hubs. The aim is to increase activity and sustainability in times of grid 
                         congestion.
                    """.trimIndent()
                    )
                },
                nl = {
                    Text("Provincies en gemeenten hebben ")
                    InlineLink(
                        destinationUrl = "/",
                        enLinkText = "received resources",
                        nlLinkText = "middelen gekregen",
                    )
                    Text(" ")
                    Text(
                        """
                            om energiehubs te vormen. Het doel is meer bedrijvigheid en verduurzaming in tijden van 
                            netcongestie.
                        """.trimIndent()
                    )
                }
            )

        }
        ProvenInPractice()
        ApplicationAreaCTAButton(
            text = LocalizedText(
                en = "Request Demo",
                nl = "Demo Aanvragen"
            )
        )
    }
}


@Composable
private fun ProvenInPractice() {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(24.px)
            .gap(16.px)
            .background(SitePalette.light.primary.lightened(0.85f))
            .luxBorderRadius(LuxCornerRadius.lg)
            .borderLeft(4.px, LineStyle.Solid, SitePalette.light.primary)
    ) {
        P {
            InlineLink(
                destinationUrl = LuxApplicationArea.LUX_ENERGY_HUB.path,
                enLinkText = LuxApplicationArea.LUX_ENERGY_HUB.label.en,
                nlLinkText = LuxApplicationArea.LUX_ENERGY_HUB.label.nl,
            )
            Text(" ")
            LangText(
                en = """
                    has already been applied in 30 energy hubs with 50 more in the pipeline and in combination with LUX 
                    municipality, LUX-RES or LUX province, it is the ideal tool to support provinces and municipalities 
                    in realizing energy hubs.
                """.trimIndent(),
                nl = """
                    is al in 30 energiehubs toegepast met 50 meer in de pijplijn en in combinatie met LUX-gemeente, 
                    LUX-RES of LUX-provincie is het de ideale tool om provincies en gemeenten te ondersteunen bij het 
                    realiseren van energiehubs.
                """.trimIndent()
            )
        }
    }
}


@OptIn(DelicateApi::class)
@Composable
private fun ProvenAtScaleCard() {
    val breakpoint = rememberBreakpoint()
    Row(
        Modifier.fillMaxWidth()
            .flexWrap(FlexWrap.Wrap)
            .thenIf(
                breakpoint >= Breakpoint.MD,
                Modifier.flexWrap(FlexWrap.Nowrap)
            )
            .alignItems(AlignItems.FlexStart)
            .gap(24.px)
            .background(LuxSpecificColorHues().luxBlackRussian)
            .color(Colors.White)
            .padding(clamp(24.px, 5.vw, 38.px))
            .luxBorderRadius(LuxCornerRadius.xl)
    ) {
        HeaderText(
            enText = "Proven at scale",
            nlText = "Bewezen op schaal",
            modifier = Modifier.fillMaxWidth()
        )
        Column(
            Modifier.fillMaxWidth()
                .gap(1.cssRem)
        ) {
            ScaleItem(
                value = "30+",
                description = LocalizedText(
                    en = "Energy hubs completed",
                    nl = "Energiehubs opgeleverd"
                )
            )
            ScaleItem(
                value = "50+",
                description = LocalizedText(
                    en = "Currently in pipeline",
                    nl = "Momenteel in de pijplijn"
                )
            )
        }
    }
}

@Composable
private fun ScaleItem(
    value: String,
    description: LocalizedText
) {
    Column(
        Modifier
            .fillMaxWidth()
            .background(Colors.White.copyf(alpha = 0.1f))
            .mutedWhite()
            .padding(24.px)
            .luxBorderRadius(LuxCornerRadius.lg)
    ) {
        HeaderText(
            enText = value,
            nlText = value,
            textColor = SitePalette.light.secondary
        )
        P {
            LangText(
                en = description.en,
                nl = description.nl
            )
        }
    }
}