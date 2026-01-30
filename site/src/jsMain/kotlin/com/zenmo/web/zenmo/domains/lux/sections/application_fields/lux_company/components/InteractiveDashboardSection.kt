package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_company.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiDescription
import com.varabyte.kobweb.silk.components.icons.mdi.MdiElectricBolt
import com.varabyte.kobweb.silk.components.icons.mdi.MdiInsights
import com.varabyte.kobweb.silk.components.icons.mdi.MdiTune
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.styles.HoverBoxShadowStyle
import com.zenmo.web.zenmo.domains.lux.styles.verticalLinearBackground
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P


@Composable
fun InteractiveDashboardSection() {
    LuxSectionContainer(
        modifier = Modifier
            .background(SitePalette.light.overlay)
            .alignItems(AlignItems.Start),
    ) {
        HeaderText(
            enText = "Your Interactive Dashboard",
            nlText = "Uw Interactieve Dashboard",
        )

        P(
            Modifier.margin(0.cssRem).toAttrs()
        ) {
            LangText(
                en = """
                    The interactive dashboard allows you to define the scenario that is ideal for your unique 
                    situation. Then, with a click of your mouse, you can export a report in PowerPoint or PDF to 
                    present the scenario to your management or to request a quote from suppliers, where we offer the 
                    most prominent suppliers as pre-selection options.
                """.trimIndent(),
                nl = """
                    Het interactieve dashboard zorgt ervoor dat jij het scenario kan definiëren dat voor jouw unieke 
                    situatie ideaal is. Vervolgens kan je met een klik van je muis een rapportage exporteren in 
                    PowerPoint of PDF om het scenario te presenteren aan jouw management of om een offerte uit te 
                    vragen bij toeleveranciers, waarbij wij de meest vooraanstaande leveranciers als voorkeuze-opties 
                    aanbieden.
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

            FeatureCard(
                icon = { MdiElectricBolt(Modifier.fontSize(40.px)) },
                title = LocalizedText(
                    en = "Request Supplier Quotes",
                    nl = "Leveranciers Offertes"
                ),
                description = LocalizedText(
                    en = "Request quotes from most prominent suppliers as pre-selection options",
                    nl = "Vraag offertes aan bij vooraf geselecteerde toonaangevende leveranciers"
                )
            )
        }

        Row(
            Modifier
                .fillMaxWidth()
                .gap(16.px)
                .padding(32.px)
                .luxBorderRadius(LuxCornerRadius.lg)
                .verticalLinearBackground()
                .color(Colors.White)
        ) {
            MdiInsights()
            LangText(
                en = """
                    What used to cost many days and many thousands of euros has been reduced to a few hours and 
                    hundreds of euros by LUX company.
                """.trimIndent(),
                nl = """
                    Wat vroeger vele dagen en vele duizenden euro’s kostte is door LUX-bedrijf teruggebracht tot enkele 
                    uren en honderden euro’s.
                """.trimIndent()
            )
        }
    }
}

val FeatureIconStyle = CssStyle {
    cssRule(" .material-icons ") {
        Modifier.fontSize(FontSize.XXLarge)
    }
}

@Composable
private fun FeatureCard(
    icon: @Composable () -> Unit,
    title: LocalizedText,
    description: LocalizedText,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Colors.White)
            .color(SitePalette.light.primary)
            .padding(32.px)
            .gap(1.cssRem)
            .luxBorderRadius(LuxCornerRadius.lg)
            .then(FeatureIconStyle.toModifier())
            .then(HoverBoxShadowStyle.toModifier())
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