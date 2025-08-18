package com.zenmo.web.zenmo.domains.lux.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.navigation.Router
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.navigation.remove
import com.varabyte.kobweb.silk.defer.DeferringHost
import com.zenmo.web.zenmo.components.widgets.CatchAllPage
import com.zenmo.web.zenmo.domains.lux.sections.home.HomePage
import com.zenmo.web.zenmo.domains.lux.sections.luxmodels.LuxModels
import com.zenmo.web.zenmo.domains.lux.sections.products.LuxCompany
import com.zenmo.web.zenmo.domains.lux.sections.products.LuxEnergyHub
import com.zenmo.web.zenmo.domains.lux.sections.products.LuxMunicipality
import com.zenmo.web.zenmo.domains.lux.sections.products.LuxResidentialArea
import kotlinx.browser.window

@Composable
fun LuxRoutingComponent() {
    val router = Router()
    com.varabyte.kobweb.core.init.initKobweb(router) { ctx ->
        ctx.router.register("/") { LuxEnergyLayout { HomePage() } }
        ctx.router.register("/application-fields/lux-company") { LuxEnergyLayout { LuxCompany() } }
        ctx.router.register("/application-fields/lux-residential-area") { LuxEnergyLayout { LuxResidentialArea() } }
        ctx.router.register("/application-fields/lux-energy-hub") { LuxEnergyLayout { LuxEnergyHub() } }
        ctx.router.register("/application-fields/lux-region") { LuxEnergyLayout { LuxMunicipality() } }
        ctx.router.register("/models") { LuxEnergyLayout { LuxModels() } }

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

