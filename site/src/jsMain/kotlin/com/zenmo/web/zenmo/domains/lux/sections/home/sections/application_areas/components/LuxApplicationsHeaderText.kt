package com.zenmo.web.zenmo.domains.lux.sections.home.sections.application_areas.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.P


@Composable
fun LuxApplicationsHeaderText() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.textAlign(TextAlign.Center)
    ) {
        HeaderText(
            enText = "What can you use LUX for?",
            nlText = "Waar kunt u LUX voor gebruiken?",
        )
        P(
            Modifier.margin(0.cssRem)
                .toAttrs()
        ) {
            LangText(
                en = "Tailored solutions for every stakeholder in the energy transition.",
                nl = "Op maat gemaakte oplossingen voor elke belanghebbende in de energietransitie."
            )
        }
    }
}