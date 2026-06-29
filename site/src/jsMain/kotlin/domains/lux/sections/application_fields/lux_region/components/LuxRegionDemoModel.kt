package domains.lux.sections.application_fields.lux_region.components

import androidx.compose.runtime.Composable
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.domains.lux.widgets.VisualContentPlaceholder
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText


@Composable
fun LuxRegionDemoModel() {
    SectionContainer {
        HeaderText(
            enText = "See the dashboard",
            nlText = "Bekijk het dashboard",
        )

        VisualContentPlaceholder()
    }
}