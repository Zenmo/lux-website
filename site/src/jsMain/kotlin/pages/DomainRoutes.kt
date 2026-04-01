package energy.lux.frontend.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.AppGlobals
import com.varabyte.kobweb.core.Page
import energy.lux.frontend.components.widgets.UnknownDomain
import energy.lux.frontend.domains.lux.core.model.subdomain.subdomains
import energy.lux.frontend.domains.lux.pages.LuxRoutingComponent
import energy.lux.frontend.domains.lux.subdomains.LuxSubdomainRoutingComponent
import energy.lux.frontend.domains.zenmo.pages.ZenmoRoutingComponent
import energy.lux.frontend.utils.setDomainFavicon
import kotlinx.browser.window

object SiteGlobals {
    val LUX_DOMAIN: String = AppGlobals.getValue("LUX_DOMAIN")
    val ZENMO_DOMAIN: String = AppGlobals.getValue("ZENMO_DOMAIN")
}

@Page("{...catch-all}")
@Composable
fun DomainRoutes() {
    val domain = window.location.host
    val luxSubdomainSuffix = ".${SiteGlobals.LUX_DOMAIN}"

    when {
        domain == SiteGlobals.LUX_DOMAIN -> LuxRoutingComponent()
        domain == SiteGlobals.ZENMO_DOMAIN -> ZenmoRoutingComponent()
        domain.endsWith(luxSubdomainSuffix) -> {
            val sub = domain.substringBefore(luxSubdomainSuffix)

            subdomains
                .find { it.subdomain.equals(sub, ignoreCase = true) }
                ?.let { LuxSubdomainRoutingComponent(it.subdomain) }
                ?: UnknownDomain(sub)
        }

        else -> UnknownDomain(domain)
    }
    setDomainFavicon()
}


fun isLocalOrPreviewEnvironment() =
    listOf("preview", "local").any { it in window.location.host }
