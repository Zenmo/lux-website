package energy.lux.frontend.domains.lux.subdomains

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.lux.core.model.subdomain.subdomains


@Composable
fun LuxSubdomainRoutingComponent(subdomain: String) =
    subdomains
        .first { it.subdomain == subdomain }
        .subdomainComponent()
