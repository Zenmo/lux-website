package com.zenmo.web.zenmo.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.AppGlobals
import com.varabyte.kobweb.core.Page
import com.zenmo.web.zenmo.components.widgets.UnknownDomain
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.subdomains
import com.zenmo.web.zenmo.domains.lux.pages.LuxRoutingComponent
import com.zenmo.web.zenmo.domains.lux.subdomains.LuxSubdomainRoutingComponent
import com.zenmo.web.zenmo.domains.zenmo.pages.ZenmoRoutingComponent
import com.zenmo.web.zenmo.utils.setDomainFavicon
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
