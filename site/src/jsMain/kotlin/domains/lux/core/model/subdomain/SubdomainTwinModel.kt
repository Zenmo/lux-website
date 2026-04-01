package energy.lux.frontend.domains.lux.core.model.subdomain

import energy.lux.frontend.core.services.localization.localizedUrl
import energy.lux.frontend.domains.lux.core.TwinModelCard
import energy.lux.frontend.pages.SiteGlobals


/**
 * A digital twin that is addressed via its own subdomain (e.g. drechtsteden.lux.energy).
 * Combines routing, presentation, and application-area classification.
 */
sealed interface SubdomainTwinModel : Subdomain, TwinModelCard {
    override val url: String
        get() = localizedUrl("${subdomain}.${SiteGlobals.LUX_DOMAIN}", "/")
}
