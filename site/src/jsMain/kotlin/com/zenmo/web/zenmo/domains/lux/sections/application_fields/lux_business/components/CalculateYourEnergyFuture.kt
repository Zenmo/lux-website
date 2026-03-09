package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_business.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.functions.clamp
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.components.ApplicationAreaCTAButton
import com.zenmo.web.zenmo.domains.lux.styles.secondaryGradientBackground
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.dom.P

@Composable
fun CalculateYourEnergyFuture() {
    LuxSectionContainer(
        modifier = Modifier
            .secondaryGradientBackground()
    ) {
        Column(
            Modifier
                .textAlign(TextAlign.Center)
                .gap(1.cssRem),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeaderText(
                enText = "Calculate your energy future.",
                nlText = "Bereken je energietoekomst.",
            )

            P(
                Modifier
                    .width(clamp(350.px, 60.vw, 700.px))
                    .toAttrs()
            ) {
                LangText(
                    en = """
                        LUX Business is an interactive tool that allows you to quickly calculate the effects of all kinds 
                        of different energy scenarios based on your own historical energy consumption and your wishes for 
                        the future.
                    """.trimIndent(),
                    nl = """
                        UX Bedrijf is een interactieve tool waarmee je in een handomdraai allerlei verschillende 
                        energiescenario’s doorrekent op basis van jouw eigen historisch energieverbruik en je wensen 
                        voor de toekomst.
                    """.trimIndent()
                )
            }

            ApplicationAreaCTAButton(
                text = LocalizedText(
                    en = "Get in touch",
                    nl = "Neem contact op"
                ),
                bgColor = Colors.Black,
                textColor = Colors.White,
            )
        }
    }
}