package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.navigation.Router
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.navigation.remove
import com.varabyte.kobweb.silk.defer.DeferringHost
import com.zenmo.web.zenmo.domains.lux.pages.registerRoutesOfMenu
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.DrechtstedenProjectArea
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.DrechtstedenHomePage
import kotlinx.browser.window

@Composable
fun DrechtstedenRouting() {
    val router = Router()
    com.varabyte.kobweb.core.init.initKobweb(router) { ctx ->
        ctx.router.register("/") { DrechtstedenHomePage() }
        DrechtstedenProjectArea.entries.forEach { area ->
            ctx.router.register(area.path) { area.pageComponent() }
        }
        ctx.registerRoutesOfMenu(
            routes = drechtstedenModels
                /*
                 * drop projects that have the same paths as the drechtsteden project areas
                 * to avoid duplicate route registrations
                 * for example, both the RES_REGION area and [drechtstedenRes] twin model use "/region"
                 * */
                .filter { model ->
                    DrechtstedenProjectArea.entries.any { it.path == model.projectPath }
                }
                .map { it.asRoutedMenuItem() }
        )
    }

    router.tryRoutingTo(
        BasePath.remove(window.location.href.removePrefix(window.origin)),
        UpdateHistoryMode.REPLACE
    )
    router.renderActivePage { DeferringHost { it() } }
}