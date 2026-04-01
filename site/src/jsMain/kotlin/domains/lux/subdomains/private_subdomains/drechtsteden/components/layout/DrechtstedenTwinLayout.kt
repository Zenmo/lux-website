package energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.components.layout

import androidx.compose.runtime.Composable
import energy.lux.frontend.components.layouts.PageLayout
import energy.lux.frontend.domains.lux.sections.nav_header.LuxHeader

@Composable
fun DrechtstedenTwinLayout(
    title: String,
    content: @Composable () -> Unit,
) {
    PageLayout(
        header = { LuxHeader() },
        footer = {},
        title = "Drechtsteden - $title",
    ) {
        content()
    }
}
