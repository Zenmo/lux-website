package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.navigation.Router
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.navigation.remove
import com.varabyte.kobweb.silk.defer.DeferringHost
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.DrechtstedenHomePage
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.businessparks.BusinessParksPage
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.municipalities.MunicipalitiesPage
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.municipalities.municipalitiesRouting
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.resregion.ResRegionPage
import kotlinx.browser.window

@Composable
fun DrechtstedenRouting() {
    val router = Router()
    com.varabyte.kobweb.core.init.initKobweb(router) { ctx ->
        ctx.router.register("/") { DrechtstedenHomePage() }
        ctx.router.register("/res-region") { ResRegionPage() }
        ctx.router.register("/municipalities") { MunicipalitiesPage() }
        ctx.router.register("/business-parks") { BusinessParksPage() }

        municipalitiesRouting(ctx)
    }
    router.tryRoutingTo(
        BasePath.remove(window.location.href.removePrefix(window.origin)),
        UpdateHistoryMode.REPLACE
    )
    router.renderActivePage { DeferringHost { it() } }
}

