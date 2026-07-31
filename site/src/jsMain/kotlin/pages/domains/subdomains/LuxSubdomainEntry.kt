package energy.lux.frontend.pages.domains.subdomains

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.lux.subdomains.LuxSubdomainRoutingComponent
import energy.lux.site.shared.AccessPolicy

@JsExport
val accessPolicy = AccessPolicy.Public()

@JsExport
@Composable
fun LuxSubdomain(subdomain: String) {
    LuxSubdomainRoutingComponent(subdomain)
}
