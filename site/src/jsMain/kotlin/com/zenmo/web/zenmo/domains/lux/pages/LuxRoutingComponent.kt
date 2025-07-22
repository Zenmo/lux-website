package com.zenmo.web.zenmo.domains.lux.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.navigation.Router
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.navigation.remove
import com.varabyte.kobweb.silk.defer.DeferringHost
import com.zenmo.web.zenmo.components.widgets.CatchAllPage
import kotlinx.browser.window

@Composable
fun LuxRoutingComponent() {
    val router = Router()
    com.varabyte.kobweb.core.init.initKobweb(router) { ctx ->
        ctx.router.register("/") { LuxEnergy() }
        if (window.location.host != "lux.energy") {
            ctx.router.register("/component-demo") { ComponentDemoPage() }
        }
        ctx.router.register("/{...catch-all}") { CatchAllPage() }
        ctx.router.register("/book-demo") { BookADemoPage() }
    }

    router.tryRoutingTo(
        BasePath.remove(window.location.href.removePrefix(window.origin)),
        UpdateHistoryMode.REPLACE
    )
    router.renderActivePage { DeferringHost { it() } }
}

