package energy.lux.site.frontend.domains.lux.sections.about_us.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.home.StatsSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.styles.verticalLinearBackground
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.P

@Composable
fun LuxStoryHeaderText(breakpoint: Breakpoint) {
    SectionContainer(
        variant = StatsSectionContainerStyleVariant,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.Companion.verticalLinearBackground()
            .color(Colors.White)
            .gap(0.cssRem)
    ) {
        HeaderText(
            enText = "Our Story",
            nlText = "Ons Verhaal",
            modifier = Modifier.Companion.margin(0.cssRem)
        )
        P(
            Modifier.Companion
                .thenIf(breakpoint >= Breakpoint.MD, Modifier.Companion.width(50.percent))
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