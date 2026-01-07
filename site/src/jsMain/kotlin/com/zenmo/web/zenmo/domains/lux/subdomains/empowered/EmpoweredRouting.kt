package com.zenmo.web.zenmo.domains.lux.subdomains.empowered

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.navigation.Router
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.navigation.remove
import com.varabyte.kobweb.silk.defer.DeferringHost
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.DrechtstedenHomePage
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.resneighborhoods.ResNeighborhoodsPage
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.resregion.ResRegionPage
import com.zenmo.web.zenmo.domains.lux.subdomains.empowered.pages.Bronckhorst
import com.zenmo.web.zenmo.domains.lux.subdomains.empowered.pages.EmpoweredIndex
import com.zenmo.web.zenmo.domains.lux.subdomains.empowered.pages.NijmegenHengstdal
import com.zenmo.web.zenmo.domains.zenmo.navigation.MenuItem
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.Text

@Composable
fun EmpoweredRouting() {
    EmpoweredLayout {
        val router = Router()
        com.varabyte.kobweb.core.init.initKobweb(router) { ctx ->
            ctx.router.register("/") { EmpoweredIndex() }
            ctx.router.register("/bronckhorst") { Bronckhorst() }
            ctx.router.register("/nijmegen-hengstdal") { NijmegenHengstdal() }
        }
        router.tryRoutingTo(
            BasePath.remove(window.location.href.removePrefix(window.origin)),
            UpdateHistoryMode.REPLACE
        )
        router.renderActivePage { DeferringHost { it() } }
    }
}

val empoweredMenuItems = listOf(
    MenuItem.Simple(path = "/", title = LocalizedText("EmPowerED", "EmPowerED")),
    MenuItem.Simple(path = "/bronckhorst", title = LocalizedText("Bronckhorst", "Bronckhorst")),
    MenuItem.Simple(path = "/nijmegen-hengstdal", title = LocalizedText("Nijmegen Hengstdal", "Nijmegen Hengstdal")),
)
