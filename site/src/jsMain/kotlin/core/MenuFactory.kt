package energy.lux.frontend.core

import energy.lux.frontend.core.models.MenuItem
import energy.lux.frontend.domains.lux.core.model.subdomain.PrivateSubdomainModel
import energy.lux.frontend.domains.lux.core.model.subdomain.empowered
import energy.lux.frontend.domains.lux.core.model.subdomain.subdomains
import energy.lux.frontend.domains.lux.sections.nav_header.luxNavMenu
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.drechtstedenNavMenu
import domains.lux.subdomains.private_subdomains.oss.ossNavMenu
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.empoweredMenuItems
import energy.lux.frontend.domains.zenmo.sections.nav_header.zenmoNavMenu
import energy.lux.frontend.pages.SiteGlobals
import kotlinx.browser.window

object MenuFactory {
    fun menuItems(): List<MenuItem> {
        val domain = window.location.host

        return when {
            domain == SiteGlobals.LUX_DOMAIN -> luxNavMenu
            domain == SiteGlobals.ZENMO_DOMAIN -> zenmoNavMenu

            domain.endsWith(".${SiteGlobals.LUX_DOMAIN}") -> {
                val subdomain = domain.substringBefore(".${SiteGlobals.LUX_DOMAIN}")
                val model = subdomains.find {
                    it.subdomain.equals(subdomain, ignoreCase = true)
                }
                when (model) {
                    PrivateSubdomainModel.DRECHTSTEDEN -> drechtstedenNavMenu
                    PrivateSubdomainModel.OSS -> ossNavMenu
                    empowered -> empoweredMenuItems
                    else -> emptyList()
                }
            }

            else -> emptyList()
        }
    }
}
