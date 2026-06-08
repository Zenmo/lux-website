package energy.lux.frontend.domains.lux.subdomains.public_subdomains.brabant

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.navigation.Router
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.navigation.remove
import com.varabyte.kobweb.silk.defer.DeferringHost
import energy.lux.frontend.core.models.RoutedMenuItem
import energy.lux.frontend.core.models.asRoutes
import energy.lux.frontend.domains.lux.core.createLuxRouter
import energy.lux.frontend.domains.lux.pages.registerRoutesOfMenu
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.brabant.components.BrabantLayout
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.brabant.components.asRoutes
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.brabant.components.brabantModels
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.brabant.components.brabantNavMenu
import kotlinx.browser.window

@Composable
fun BrabantRouting() {
    val router = remember {
        createLuxRouter {
            brabantRouting(brabantNavMenu.asRoutes())
            brabantRouting(brabantModels.asRoutes())
        }
    }

    router.tryRoutingTo(
        BasePath.remove(window.location.href.removePrefix(window.origin)),
        UpdateHistoryMode.REPLACE
    )
    router.renderActivePage { DeferringHost { it() } }
}

private fun Router.brabantRouting(
    routes: List<RoutedMenuItem>
) = this.registerRoutesOfMenu(
    routes = routes,
    layoutWrapper = { title, content ->
        BrabantLayout(
            title = title
        ) { content() }
    }
)