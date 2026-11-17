package energy.lux.frontend.domains.lux.core.model.subdomain

import energy.lux.frontend.pages.SiteGlobals

interface Subdomain {
    val subdomain: String

    val fullDomain: String
        get() = subdomain + SiteGlobals.luxSubdomainSuffix
}
