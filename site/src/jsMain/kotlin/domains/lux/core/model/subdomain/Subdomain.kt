package energy.lux.frontend.domains.lux.core.model.subdomain

import androidx.compose.runtime.Composable
import energy.lux.frontend.pages.SiteGlobals

interface Subdomain {
    val subdomain: String
    val subdomainComponent: @Composable () -> Unit

    val fullDomain: String
        get() = subdomain + SiteGlobals.luxSubdomainSuffix
}
