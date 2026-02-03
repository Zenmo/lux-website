package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_region.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Background
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.clamp
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.css.functions.toImage
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiHome
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLayers
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLocationOn
import com.varabyte.kobweb.silk.components.icons.mdi.MdiMap
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.before
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.ResponsiveFlexStyle
import com.zenmo.web.zenmo.domains.lux.styles.TopDividerLineStyle
import com.zenmo.web.zenmo.domains.lux.styles.verticalLinearBackground
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P


@Composable
fun MultiScaleAnalysis() {
    LuxSectionContainer(
        modifier = Modifier
            .alignItems(AlignItems.FlexStart),
    ) {
        HeaderText(
            enText = "Multi-scale Analysis",
            nlText = "Multi-schaal Analyse",
        )
        Div(
            ResponsiveFlexStyle.toModifier()
                .alignItems(AlignItems.Center)
                .toAttrs()
        ) {
            TextContent()
            LevelOfAnalysis()
        }
    }
}

@Composable
private fun TextContent() {
    Column(Modifier.fillMaxWidth()) {
        P {
            LangText(
                en = """
                    If you select a specific neighbourhood, you will end up in LUX residential area or LUX energy hub 
                    in which buildings and appliances (such as solar panels and electric vehicles) are modelled 
                    separately to make the scenarios much more detailed.
                """.trimIndent(),
                nl = """
                    Als je een specifieke buurt selecteert komt u terecht in LUX-woonwijk of LUX-energiehub waarin 
                    gebouwen en apparaten (zoals zonnepanelen en elektrische voertuigen) apart gemodelleerd worden om 
                    de scenario’s veel gedetailleerder te maken.
                """.trimIndent()
            )
        }

        P {
            LangText(
                en = """
                    The results of the LUX residential area or LUX energy hub are then used to improve the results for 
                    the entire area when you zoom out again.
                """.trimIndent(),
                nl = """
                    De resultaten van LUX-woonwijk of LUX-energiehub worden vervolgens gebruikt om als je terug 
                    uitzoomt de uitkomsten voor het gehele gebied te verbeteren.
                """.trimIndent()
            )
        }
    }
}

val LevelOfAnalysisDividerStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .position(Position.Relative)
    }

    before {
        Modifier
            .background(
                Background.of(
                    image = linearGradient(LinearGradient.Direction.ToLeft) {
                        add(Colors.Transparent)
                        add(Colors.White.copyf(alpha = 0.35f))
                        add(Colors.Transparent)
                    }.toImage()
                )
            )
    }
}

@Composable
private fun AnalysisDivider() = Div(
    TopDividerLineStyle.toModifier()
        .then(LevelOfAnalysisDividerStyle.toModifier())
        .toAttrs()
)


@Composable
private fun LevelOfAnalysis() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(clamp(24.px, 5.vw, 40.px))
            .gap(1.cssRem)
            .luxBorderRadius(LuxCornerRadius.xl)
            .verticalLinearBackground()
    ) {

        LevelOfAnalysisRow(
            level = LocalizedText(
                en = "Province Level",
                nl = "Provincie Niveau"
            ),
            icon = { MdiMap() },
        )
        AnalysisDivider()
        LevelOfAnalysisRow(
            level = LocalizedText(
                en = "Municipality Level",
                nl = "Gemeente Niveau"
            ),
            icon = { MdiLocationOn() },
            paddingLeft = 24.px
        )
        AnalysisDivider()
        LevelOfAnalysisRow(
            level = LocalizedText(
                en = "Neighborhood Level",
                nl = "Buurt Niveau"
            ),
            icon = { MdiHome() },
            paddingLeft = 48.px
        )
        AnalysisDivider()
        LevelOfAnalysisRow(
            level = LocalizedText(
                en = "Building Level",
                nl = "Gebouw Niveau"
            ),
            icon = { MdiLayers() },
            paddingLeft = 64.px
        )
    }
}

@Composable
private fun LevelOfAnalysisRow(
    level: LocalizedText,
    icon: @Composable () -> Unit,
    paddingLeft: CSSLengthOrPercentageNumericValue = 0.px
) {
    Row(
        Modifier.fillMaxWidth()
            .padding(left = paddingLeft)
            .gap(16.px)
            .color(Colors.White),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        icon()
        LangText(
            en = level.en,
            nl = level.nl
        )
    }
}