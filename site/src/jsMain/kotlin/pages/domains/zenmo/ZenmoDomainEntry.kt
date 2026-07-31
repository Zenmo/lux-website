package energy.lux.frontend.pages.domains.zenmo

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.pages.ZenmoRoutingComponent
import energy.lux.site.shared.AccessPolicy

@JsExport
val accessPolicy = AccessPolicy.Public()

@JsExport
@Composable
fun ZenmoDomain() {
    ZenmoRoutingComponent()
}
