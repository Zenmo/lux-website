package energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered

import androidx.compose.runtime.Composable
import energy.lux.frontend.components.layouts.PageLayout
import energy.lux.frontend.domains.lux.sections.nav_header.LuxHeader

@Composable
fun EmpoweredLayout(
    content: @Composable () -> Unit,
) {
    PageLayout(
        header = { LuxHeader() },
        footer = {},
        title = "EmPowerED",
    ) {
        content()
    }
}
