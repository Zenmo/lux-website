package energy.lux.site.frontend.domains.lux.sections.home.sections.application_areas

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.sections.home.sections.application_areas.components.ApplicationAreasGrid
import com.zenmo.web.zenmo.domains.lux.sections.home.sections.application_areas.components.LuxApplicationsHeaderText
import com.zenmo.web.zenmo.theme.SitePalette


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