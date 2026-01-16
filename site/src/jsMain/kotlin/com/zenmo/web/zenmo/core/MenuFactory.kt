package com.zenmo.web.zenmo.core

import com.zenmo.web.zenmo.core.models.MenuItem
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.drechtsteden
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.empowered
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.subdomainModels
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.luxNavMenu
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.drechtstedenNavMenu
import com.zenmo.web.zenmo.domains.lux.subdomains.empowered.empoweredMenuItems
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.zenmoNavMenu
import com.zenmo.web.zenmo.pages.SiteGlobals
import kotlinx.browser.window

object MenuFactory {
    fun menuItems(): List<MenuItem> {
        val domain = window.location.host

        return when {
            domain == SiteGlobals.LUX_DOMAIN -> luxNavMenu
            domain == SiteGlobals.ZENMO_DOMAIN -> zenmoNavMenu

            domain.endsWith(".${SiteGlobals.LUX_DOMAIN}") -> {
                val subdomain = domain.substringBefore(".${SiteGlobals.LUX_DOMAIN}")
                val model = subdomainModels.find {
                    it.subdomain.equals(subdomain, ignoreCase = true)
                }
                when (model) {
                    drechtsteden -> drechtstedenNavMenu
                    empowered -> empoweredMenuItems
                    else -> emptyList()
                }
            }

            else -> emptyList()
        }
    }
}
