package com.zenmo.web.zenmo.domains.lux.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.navigation.remove
import com.varabyte.kobweb.silk.defer.DeferringHost
import com.zenmo.web.zenmo.core.models.asRoutes
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxEnergyLayout
import com.zenmo.web.zenmo.domains.lux.core.createLuxRouter
import com.zenmo.web.zenmo.domains.lux.sections.home.HomePage
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.luxNavMenu
import kotlinx.browser.window

@Composable
fun LuxRoutingComponent() {
    val router = createLuxRouter()
    com.varabyte.kobweb.core.init.initKobweb(router) { ctx ->
        ctx.router.register("/") { LuxEnergyLayout { HomePage() } }

        ctx.registerRoutesOfMenu(
            routes = luxNavMenu.asRoutes(),
            layoutWrapper = { _, content -> LuxEnergyLayout { content() } }
        )

        if (window.location.host != "lux.energy") {
            ctx.router.register("/component-demo") { ComponentDemoPage() }
        }
        ctx.router.register("/book-demo") { BookADemoPage() }
    }

    router.tryRoutingTo(
        BasePath.remove(window.location.href.removePrefix(window.origin)),
        UpdateHistoryMode.REPLACE
    )
    router.renderActivePage { DeferringHost { it() } }
}
