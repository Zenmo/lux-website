package com.zenmo.web.zenmo.domains.zenmo.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.navigation.*
import com.varabyte.kobweb.silk.defer.DeferringHost
import com.zenmo.web.zenmo.components.widgets.CatchAllPage
import com.zenmo.web.zenmo.core.models.asRoutes
import com.zenmo.web.zenmo.core.registerLocalizedRoute
import com.zenmo.web.zenmo.domains.lux.core.createLuxRouter
import com.zenmo.web.zenmo.domains.lux.pages.registerRoutesOfMenu
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.zenmoNavMenu
import com.zenmo.web.zenmo.domains.zenmo.widgets.ComponentDemoPage
import kotlinx.browser.window

@Composable
fun ZenmoRoutingComponent() {
    val router = createLuxRouter()

    router.registerRoutesOfMenu(
        routes = zenmoNavMenu.asRoutes()
            // remove component demo to avoid registering its route twice
            .dropLast(1),
        )

    if (window.location.host != "zenmo.com") {
        router.registerLocalizedRoute("/component-demo") { ComponentDemoPage() }
    }

    router.tryRoutingTo(
        BasePath.remove(window.location.href.removePrefix(window.origin)),
        UpdateHistoryMode.REPLACE
    )

    router.renderActivePage { DeferringHost { it() } }
}
