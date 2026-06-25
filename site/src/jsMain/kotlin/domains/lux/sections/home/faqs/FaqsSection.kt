package energy.lux.frontend.domains.lux.sections.home.faqs

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import energy.lux.frontend.components.widgets.SectionContainer


@Composable
fun FaqsSection(
    breakpoint: Breakpoint,
) {
    SectionContainer(
        verticalArrangement = Arrangement.Center,
    ) {
        FaqsHeaderText()
        Faqs(breakpoint)
        FaqFallBack()
    }
}