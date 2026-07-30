package energy.lux.frontend.pages.domains.lux

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.lux.pages.LuxRoutingComponent
import energy.lux.site.shared.AccessPolicy

@JsExport
val accessPolicy = AccessPolicy.Public()

@JsExport
@Composable
fun LuxDomain() {
    LuxRoutingComponent()
}
