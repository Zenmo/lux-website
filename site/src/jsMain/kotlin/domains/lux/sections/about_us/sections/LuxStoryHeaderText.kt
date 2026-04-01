package energy.lux.frontend.domains.lux.sections.about_us.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.domains.lux.sections.home.StatsSectionContainerStyleVariant
import energy.lux.frontend.domains.lux.styles.verticalLinearBackground
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.P

@Composable
fun LuxStoryHeaderText(breakpoint: Breakpoint) {
    SectionContainer(
        variant = StatsSectionContainerStyleVariant,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.verticalLinearBackground()
            .color(Colors.White)
            .gap(0.cssRem)
    ) {
        HeaderText(
            enText = "Our Story",
            nlText = "Ons Verhaal",
        )
        P(
            Modifier
                .thenIf(breakpoint >= Breakpoint.MD, Modifier.width(50.percent))
                .toAttrs()
        ) {
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