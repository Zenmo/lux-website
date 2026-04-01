package energy.lux.frontend.domains.lux.components.layout

import androidx.compose.runtime.Composable
import energy.lux.frontend.components.layouts.PageLayout
import energy.lux.frontend.domains.lux.sections.nav_header.LuxHeader


@Composable
fun LuxEnergyLayout(
    content: @Composable () -> Unit
) {
    PageLayout(
        header = { LuxHeader() },
        footer = {},
        title = ""
    ) {
        content()
    }
}