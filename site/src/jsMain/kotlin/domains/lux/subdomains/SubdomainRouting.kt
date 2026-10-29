package energy.lux.frontend.domains.lux.subdomains

import androidx.compose.runtime.Composable
import energy.lux.frontend.components.widgets.UnknownDomain
import energy.lux.frontend.domains.lux.core.model.subdomain.subdomains


@Composable
fun LuxSubdomainRoutingComponent(subdomain: String) =
    subdomains
        .find { it.subdomain.equals(subdomain, ignoreCase = true) }
        ?.subdomainComponent()
        ?: UnknownDomain(subdomain)
