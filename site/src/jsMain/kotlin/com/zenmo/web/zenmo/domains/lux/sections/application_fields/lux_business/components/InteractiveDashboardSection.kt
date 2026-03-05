package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_business.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiDescription
import com.varabyte.kobweb.silk.components.icons.mdi.MdiInsights
import com.varabyte.kobweb.silk.components.icons.mdi.MdiTune
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.InlineLink
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.lux.styles.HoverBoxShadowStyle
import com.zenmo.web.zenmo.domains.lux.styles.verticalLinearBackground
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P


@Composable
fun InteractiveDashboardSection() {
    LuxSectionContainer(
        modifier = Modifier
            .background(SitePalette.light.overlay)
            .alignItems(AlignItems.Start)
            .gap(1.cssRem),
    ) {
        HeaderText(
            enText = "Your Interactive Model",
            nlText = "Uw Interactieve Model",
        )
        P {
            LangText(
                en = """
                    If you have developed a scenario yourself, you can export it as a PowerPoint or PDF to convince 
                    others, for example your manager or the bank. This export option also makes LUX Business ideal 
                    for energy experts who advise a company. 
                """.trimIndent(),
                nl = """
                    Heb je zelf een scenario ontwikkeld? Dan kun je het exporteren als PowerPoint of PDF om anderen 
                    te overtuigen, bijvoorbeeld je manager of de bank. Deze exportoptie maakt LUX Bedrijf ook 
                    ideaal voor energie-experts die een bedrijf adviseren.  
                """.trimIndent()
            )
            Br {}
            LangText(
                en = """
                    They can develop scenarios with LUX company and export the best scenarios and present them to 
                    their business customer. 
                """.trimIndent(),
                nl = """
                    Zij kunnen met LUX company scenario's ontwikkelen en de beste scenario's exporteren en 
                    presenteren aan hun zakelijke klant.
                """.trimIndent()
            )
        }

        SimpleGrid(
            numColumns = numColumns(base = 1, sm = 1, md = 2, lg = 3, xl = 3),
            modifier = Modifier.gap(1.5.cssRem)
        ) {
            FeatureCard(
                icon = { MdiTune(Modifier.fontSize(40.px)) },
                title = LocalizedText(
                    en = "Define Your Scenario",
                    nl = "Definieer jouw scenario"
                ),
                description = LocalizedText(
                    en = "Define the scenario that is ideal for your unique situation",
                    nl = "Definieer het scenario dat ideaal is voor jouw unieke situatie"
                )
            )

            FeatureCard(
                icon = { MdiDescription(Modifier.fontSize(40.px)) },
                title = LocalizedText(
                    en = "Export Reports Instantly",
                    nl = "Exporteer rapportages direct"
                ),
                description = LocalizedText(
                    en = "Export your scenario to PowerPoint or PDF with one click",
                    nl = "Exporteer jouw scenario met één klik naar PowerPoint of PDF"
                )
            )

            Column(
                modifier = FeatureCardStyle.toModifier()
                    .then(HoverBoxShadowStyle.toModifier())
                    .verticalLinearBackground()
                    .color(Colors.White),
            ) {
                MdiInsights(Modifier.fontSize(40.px))
                P(
                    Modifier
                        .margin(0.cssRem)
                        .toAttrs()
                ) {
                    LangText(
                        en = """
                            Often even more space is created on the electricity grid when you start working together 
                            with other companies. That is why we also developed  
                        """.trimIndent(),
                        nl = """
                            Vaak wordt er zelfs nog meer ruimte op het elektriciteitsnet gecreëerd wanneer je gaat 
                            samenwerken met andere bedrijven. Daarom hebben we ook 
                        """.trimIndent(),
                    )
                    InlineLink(
                        destinationUrl = LuxApplicationArea.LUX_ENERGY_HUB.url,
                        enLinkText = "LUX Energy Hub.",
                        nlLinkText = "LUX Energie Hub",
                        textColor = Colors.White,
                    )
                    LangText(
                        en = "",
                        nl = " ontwikkeld."
                    )
                }
            }
        }
    }
}

val FeatureCardStyle = CssStyle.base {
    Modifier
        .fillMaxWidth()
        .background(Colors.White)
        .color(SitePalette.light.primary)
        .padding(32.px)
        .gap(1.cssRem)
        .luxBorderRadius(LuxCornerRadius.lg)

}

@Composable
private fun FeatureCard(
    icon: @Composable () -> Unit,
    title: LocalizedText,
    description: LocalizedText,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = FeatureCardStyle.toModifier()
            .then(HoverBoxShadowStyle.toModifier())
            .then(modifier),
    ) {
        icon()
        H3(
            Modifier
                .fontWeight(FontWeight.Normal)
                .toAttrs()
        ) {
            LangText(
                en = title.en,
                nl = title.nl,
            )
        }
        P(
            Modifier
                .margin(0.cssRem)
                .color(Colors.Black).toAttrs()
        ) {
            LangText(
                en = description.en,
                nl = description.nl,
            )
        }
    }
}