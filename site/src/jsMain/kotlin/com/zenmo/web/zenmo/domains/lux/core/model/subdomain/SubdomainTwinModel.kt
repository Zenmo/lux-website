package com.zenmo.web.zenmo.domains.lux.core.model.subdomain

import com.zenmo.web.zenmo.domains.lux.core.TwinModelCard
import com.zenmo.web.zenmo.pages.SiteGlobals
import kotlinx.browser.window


/**
 * A digital twin that is addressed via its own subdomain (e.g. drechtsteden.lux.energy).
 * Combines routing, presentation, and application-area classification.
 */
sealed interface SubdomainTwinModel : Subdomain, TwinModelCard {
    override val url: String
        get() = "//${subdomain}.${SiteGlobals.LUX_DOMAIN}"
}
