package com.zenmo.web.zenmo.domains.lux.subdomains.empowered.pages

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun EmpoweredIndex() {
    SectionContainer {
        P {
            LangText(
                nl = "EmPowerED staat voor Enabling Positive Energy Districts.",
                en = "EmPowerED stands for Enabling Positive Energy Districts."
            )
        }
        P {
            LangText(
                nl = """
                    In 2025 is dit project gestart om te onderzoeken hoe lokaal
                    op een duurzame manier in de warmtebehoefte kan worden voorzien.
                """,
                en = """
                    In 2025 this project was started to discover how the demand for heat 
                    can be generated met locally and sustainably.
                """,
            )
        }
    }
}
