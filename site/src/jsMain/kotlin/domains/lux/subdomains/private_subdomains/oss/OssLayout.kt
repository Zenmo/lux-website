package domains.lux.subdomains.private_subdomains.oss

import androidx.compose.runtime.Composable
import energy.lux.frontend.components.layouts.PageLayout
import energy.lux.frontend.domains.lux.sections.nav_header.LuxHeader

@Composable
fun OssLayout(
    title: String,
    content: @Composable () -> Unit,
) {
    PageLayout(
        header = { LuxHeader() },
        footer = {},
        title = "Oss - $title",
    ) {
        content()
    }
}