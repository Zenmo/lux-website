package energy.lux.site.frontend.domains.lux.subdomains.drechtsteden

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.navigation.Router
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.navigation.remove
import com.varabyte.kobweb.silk.defer.DeferringHost
import com.zenmo.web.zenmo.domains.lux.components.model.DrechtstedenResRegion
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.DrechtstedenHomePage
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.businessparks.BusinessParksPage
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.businessparks.businessParksRouting
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.municipalities.municipalitiesRouting
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.resneighborhoods.ResNeighborhoodsPage
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.resneighborhoods.resNeighborhoodsRouting
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.resregion.DrechtstedenPage
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.resregion.ResRegionPage
import kotlinx.browser.window

@Composable
fun DrechtstedenRouting() {
    val router = Router()
    com.varabyte.kobweb.core.init.initKobweb(router) { ctx ->
        ctx.router.register("/") { DrechtstedenHomePage() }
        ctx.router.register("/res-region") { ResRegionPage() }
        ctx.router.register("/res-neighborhoods") { ResNeighborhoodsPage() }
        ctx.router.register("/business-parks") { BusinessParksPage() }
        ctx.router.register("/res-region/${DrechtstedenResRegion.DrechtstedenRes.name}") { DrechtstedenPage() }
        resNeighborhoodsRouting(ctx)
        municipalitiesRouting(ctx)
        businessParksRouting(ctx)
    }
    router.tryRoutingTo(
        BasePath.remove(window.location.href.removePrefix(window.origin)),
        UpdateHistoryMode.REPLACE
    )
    router.renderActivePage { DeferringHost { it() } }
}

