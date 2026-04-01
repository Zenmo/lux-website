package com.zenmo.web.zenmo.domains.lux.sections.about_us.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.home.CustomPaddingStyle
import com.zenmo.web.zenmo.domains.lux.styles.verticalLinearBackground
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.P

@Composable
fun LuxStoryHeaderText() {
    LuxSectionContainer(
        modifier = CustomPaddingStyle.toModifier()
            .verticalLinearBackground()
            .alignItems(AlignItems.FlexStart)
            .color(Colors.White)
            .gap(0.cssRem)
    ) {
        HeaderText(
            enText = "Our Story",
            nlText = "Ons Verhaal",
        )
        P {
            LangText(
                en = """
                    From academic insight to real-world impact!
                """.trimIndent(),
                nl = """
                    Van academisch inzicht tot impact in de echte wereld!
                """.trimIndent()
            )
        }
    }
}