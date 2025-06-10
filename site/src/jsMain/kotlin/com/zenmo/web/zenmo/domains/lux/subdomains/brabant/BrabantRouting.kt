package com.zenmo.web.zenmo.domains.lux.subdomains.brabant

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.navigation.Router
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.navigation.remove
import com.varabyte.kobweb.silk.defer.DeferringHost
import com.zenmo.web.zenmo.domains.lux.subdomains.brabant.pages.BrabantIndex
import kotlinx.browser.window

@Composable
fun BrabantRouting() {
    val router = Router()
    com.varabyte.kobweb.core.init.initKobweb(router) { ctx ->
        ctx.router.register("/") { BrabantIndex() }
    }
    router.tryRoutingTo(
        BasePath.remove(window.location.href.removePrefix(window.origin)),
        UpdateHistoryMode.REPLACE
    )
    router.renderActivePage { DeferringHost { it() } }
}

