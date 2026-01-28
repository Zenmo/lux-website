package com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains.empowered.pages.empowered.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.P

@Composable
fun EmpoweredHeader() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        HeaderText(
            enText = "EmPowerED",
            nlText = "EmPowerED",
            modifier = Modifier.margin(0.cssRem)
        )
        P {
            LangText(
                en = """
               EmPowerED is a research project on Positive Energy Districts led by Eindhoven University of Technology, 
               aiming to accelerate socially supported, affordable, and locally appropriate energy transitions in Dutch 
               neighborhoods. 
            """.trimIndent(),
                nl = """
                EmPowerED is een onderzoeksproject naar ‘Positive Energy Districts’, geleid door de Technische 
                Universiteit Eindhoven, met als doel om sociaal gedragen, betaalbare en lokaal passende oplossingen 
                voor duurzame energie in Nederlandse wijken en buurten te ontwikkelen. 
            """.trimIndent()
            )
        }
    }
}