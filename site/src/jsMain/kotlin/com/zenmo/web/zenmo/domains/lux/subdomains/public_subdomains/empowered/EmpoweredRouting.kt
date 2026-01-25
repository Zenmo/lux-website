package com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains.empowered

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.init.initKobweb
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.navigation.Router
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.navigation.remove
import com.varabyte.kobweb.silk.defer.DeferringHost
import com.zenmo.web.zenmo.core.models.MenuItem
import com.zenmo.web.zenmo.core.models.RoutedMenuItem
import com.zenmo.web.zenmo.core.models.asRoutes
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.pages.registerRoutesOfMenu
import com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains.empowered.pages.Bronckhorst
import com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains.empowered.pages.EmpoweredIndex
import com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains.empowered.pages.NijmegenHengstdal
import kotlinx.browser.window

@Composable
fun EmpoweredRouting() {
    val router = Router()
    initKobweb(router) { ctx ->
        ctx.registerRoutesOfMenu(
            routes = empoweredMenuItems.asRoutes(),
            layoutWrapper = { _, content -> EmpoweredLayout { content() } }
        )
    }
    router.tryRoutingTo(
        BasePath.remove(window.location.href.removePrefix(window.origin)),
        UpdateHistoryMode.REPLACE
    )
    router.renderActivePage { DeferringHost { it() } }
}

val empoweredMenuItems = listOf(
    MenuItem.Simple(
        RoutedMenuItem(
            path = "/", label = LocalizedText("EmPowerED", "EmPowerED"),
            pageComponent = { EmpoweredIndex() })
    ),
    MenuItem.Simple(
        RoutedMenuItem(
            label = LocalizedText("Bronckhorst", "Bronckhorst"),
            pageComponent = { Bronckhorst() })
    ),
    MenuItem.Simple(
        RoutedMenuItem(
            label = LocalizedText("Nijmegen Hengstdal", "Nijmegen Hengstdal"),
            pageComponent = { NijmegenHengstdal() })
    ),
)
