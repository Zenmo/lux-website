package energy.lux.frontend.domains.lux.sections.home.faqs

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.domains.lux.sections.LuxSectionContainerStyleVariant


@Composable
fun FaqsSection(
    breakpoint: Breakpoint,
) {
    SectionContainer(
        variant = LuxSectionContainerStyleVariant,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        FaqsHeaderText()
        Faqs(breakpoint)
        FaqFallBack()
    }
}

