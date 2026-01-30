package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_company.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.components.ApplicationAreaVideo
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span

@Composable
fun HowItWorks() {
    LuxSectionContainer {
        HowItWorksContent()
        //todo use LUX Company demo video
        ApplicationAreaVideo(
            videoTitle = LocalizedText(
                en = "Interactive Dashboard Walkthrough",
                nl = "Interactieve Dashboard Walkthrough"
            ),
        )
    }
}

@Composable
private fun HowItWorksContent() {
    Column(
        modifier = Modifier.fillMaxWidth()
            .gap(1.cssRem)
    ) {
        HeaderText(
            enText = "Automated Advisory Process",
            nlText = "Geautomatiseerd Adviesproces",
        )

        P {
            LangText(
                en = """
                    LUX company has automated the now often complex and expensive advisory process and offers an 
                    unprecedentedly thorough and comprehensive analysis at an unprecedentedly low cost.
                """.trimIndent(),
                nl = """
                    LUX-bedrijf heeft het nu vaak nog complexe en dure adviesproces geautomatiseerd en biedt tegen 
                    ongeëvenaard lage kosten een ongekend grondige en uitgebreide analyse.
                """.trimIndent()
            )
        }
        TheProcess()
    }
}

@Composable
private fun TheProcess() {
    Column(
        modifier = Modifier.fillMaxWidth()
            .gap(1.cssRem)
    ) {
        SubHeaderText(
            enText = "The process is simple:",
            nlText = "Het proces is eenvoudig:",
            textColor = SitePalette.light.primary
        )
        StepBlock(
            step = "1",
            text = LocalizedText(
                en = """
                    Our form will help you to provide us with the correct information step by step
                """.trimIndent(),
                nl = """
                   Helpt ons invulformulier je om ons stap voor stap de juiste gegevens teverstrekken.
                """.trimIndent()
            )
        )
        StepBlock(
            step = "2",
            text = LocalizedText(
                en = """
                   You will have access to an interactive dashboard that we briefly demonstrate below
                """.trimIndent(),
                nl = """
                    Krijg je de beschikking over een interactief dashboard dat we hieronder kort demonstreren.
                """.trimIndent()
            )
        )
    }
}


@Composable
private fun StepBlock(
    step: String,
    text: LocalizedText,
) {
    Row(
        Modifier.gap(16.px),
    ) {
        Box(
            Modifier
                .size(32.px)
                .background(SitePalette.light.primary)
                .color(Colors.White)
                .flexShrink(0)
                .luxBorderRadius(),
            contentAlignment = Alignment.Center
        ) {
            SpanText(step)
        }

        Span(
            Modifier.display(DisplayStyle.Flex)
                .alignItems(AlignItems.Center)
                .fillMaxHeight()
                .toAttrs()
        ) {
            LangText(
                en = text.en,
                nl = text.nl
            )
        }
    }
}