package energy.lux.frontend.domains.lux.sections.home.sections.application_areas

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.domains.lux.sections.LuxSectionContainerStyleVariant
import energy.lux.frontend.domains.lux.sections.home.sections.application_areas.components.ApplicationAreasGrid
import energy.lux.frontend.domains.lux.sections.home.sections.application_areas.components.LuxApplicationsHeaderText
import energy.lux.frontend.theme.SitePalette


@Composable
fun LuxApplicationsSection(breakpoint: Breakpoint) {
    SectionContainer(
        variant = LuxSectionContainerStyleVariant,
        modifier = Modifier.background(SitePalette.light.overlay),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LuxApplicationsHeaderText()
        ApplicationAreasGrid(breakpoint = breakpoint)
    }
}