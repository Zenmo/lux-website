package energy.lux.frontend.domains.lux.components.layout

import androidx.compose.runtime.Composable
import energy.lux.frontend.components.layouts.PageLayout
import energy.lux.frontend.domains.lux.sections.nav_header.LuxHeader
import energy.lux.frontend.domains.lux.sections.nav_header.luxNavMenu


@Composable
fun LuxEnergyLayout(
    content: @Composable () -> Unit
) {
    PageLayout(
        header = { LuxHeader(luxNavMenu) },
        footer = {},
        title = ""
    ) {
        content()
    }
}