package domains.lux.sections.application_fields.lux_region.components

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.lux.components.LuxSectionContainer
import energy.lux.frontend.domains.lux.widgets.VisualContentPlaceholder
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText


@Composable
fun LuxRegionDemoModel() {
    LuxSectionContainer {
        HeaderText(
            enText = "See the dashboard",
            nlText = "Bekijk het dashboard",
        )

        VisualContentPlaceholder()
    }
}