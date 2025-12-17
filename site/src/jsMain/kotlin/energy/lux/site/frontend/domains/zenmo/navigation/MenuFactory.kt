package energy.lux.site.frontend.domains.zenmo.navigation

import com.zenmo.web.zenmo.domains.lux.components.model.SubdomainModel
import com.zenmo.web.zenmo.pages.SiteGlobals
import kotlinx.browser.window

object MenuFactory {
    fun menuItems(): List<MenuItem> {
        val domain = window.location.host

        return when {
            domain == SiteGlobals.LUX_DOMAIN -> LuxMenu.items
            domain == SiteGlobals.ZENMO_DOMAIN -> ZenmoMenu.items

            domain.endsWith(".${SiteGlobals.LUX_DOMAIN}") -> {
                val subdomain = domain.substringBefore(".${SiteGlobals.LUX_DOMAIN}")
                val model = SubdomainModel.Companion.allModels.find {
                    it.title.equals(subdomain, ignoreCase = true)
                }
                when (model) {
                    SubdomainModel.Drechtsteden -> DrechtstedenMenu.items
                    else -> emptyList()
                }
            }

            else -> emptyList()
        }
    }
}