package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.navigation.Router
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.navigation.remove
import com.varabyte.kobweb.silk.defer.DeferringHost
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.PrivateSubdomainModel
import com.zenmo.web.zenmo.domains.lux.pages.registerRoutesOfMenu
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.DrechtstedenProjectArea
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.DrechtstedenHomePage
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.resregion.DrechtstedenPage
import kotlinx.browser.window

@Composable
fun DrechtstedenRouting() {
    val router = Router()
    com.varabyte.kobweb.core.init.initKobweb(router) { ctx ->
        ctx.router.register("/") { DrechtstedenHomePage() }
        DrechtstedenProjectArea.entries.forEach { area ->
            ctx.router.register(area.path) { area.pageComponent() }
        }
        ctx.router.register(
            "${DrechtstedenProjectArea.RES_REGION.path}/${PrivateSubdomainModel.DRECHTSTEDEN.subdomain}"
        ) { DrechtstedenPage() }
        ctx.registerRoutesOfMenu(
            routes = drechtstedenModels.map { it.asRoutedMenuItem() }
        )
    }

    router.tryRoutingTo(
        BasePath.remove(window.location.href.removePrefix(window.origin)),
        UpdateHistoryMode.REPLACE
    )
    router.renderActivePage { DeferringHost { it() } }
}