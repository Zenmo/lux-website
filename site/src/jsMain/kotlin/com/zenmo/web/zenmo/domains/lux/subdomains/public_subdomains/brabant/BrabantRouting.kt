package com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains.brabant

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.navigation.remove
import com.varabyte.kobweb.silk.defer.DeferringHost
import com.zenmo.web.zenmo.core.registerLocalizedRoute
import com.zenmo.web.zenmo.domains.lux.core.createLuxRouter
import com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains.brabant.pages.BrabantIndex
import kotlinx.browser.window

@Composable
fun BrabantRouting() {
    val router = createLuxRouter()
    router.registerLocalizedRoute("/") { BrabantIndex() }

    router.tryRoutingTo(
        BasePath.remove(window.location.href.removePrefix(window.origin)),
        UpdateHistoryMode.REPLACE
    )
    router.renderActivePage { DeferringHost { it() } }
}

