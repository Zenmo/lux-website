package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_business.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiDescription
import com.varabyte.kobweb.silk.components.icons.mdi.MdiElectricBolt
import com.varabyte.kobweb.silk.components.icons.mdi.MdiTune
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.styles.HoverBoxShadowStyle
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
            enText = "Your Interactive Model",
            nlText = "Uw Interactieve Model",
        )

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