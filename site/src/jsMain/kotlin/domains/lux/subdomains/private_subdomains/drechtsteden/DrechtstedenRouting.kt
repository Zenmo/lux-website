package energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.navigation.Router
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.navigation.remove
import com.varabyte.kobweb.silk.defer.DeferringHost
import energy.lux.frontend.core.models.RoutedMenuItem
import energy.lux.frontend.core.models.asRoutes
import energy.lux.frontend.core.services.localization.LocalLanguage
import energy.lux.frontend.domains.lux.core.createLuxRouter
import energy.lux.frontend.domains.lux.pages.registerRoutesOfMenu
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.components.layout.DrechtstedenTwinLayout
import kotlinx.browser.window

@Composable
fun DrechtstedenRouting() {
    val router = remember {
        createLuxRouter {
            drechtstedenRouting(drechtstedenRoutes())
        }
    }

    router.tryRoutingTo(
        BasePath.remove(window.location.href.removePrefix(window.origin)),
        UpdateHistoryMode.REPLACE
    )
    router.renderActivePage { DeferringHost { it() } }
}

/** All pages of the Drechtsteden subdomain. Also used to list the pages to pre-render. */
fun drechtstedenRoutes(): List<RoutedMenuItem> =
    (drechtstedenNavMenu.asRoutes() + drechtstedenModels.map { it.asRoutedMenuItem() })
        // A project that is the only one in its area can have the area's path. Keep the menu's route.
        .distinctBy { it.path }

private fun Router.drechtstedenRouting(
    routes: List<RoutedMenuItem>
) = this.registerRoutesOfMenu(
    routes = routes,
    layoutWrapper = { title, content ->
        DrechtstedenTwinLayout(
            title = LocalLanguage.current.translate(
                title.en,
                title.nl
            )
        ) { content() }
    }
)
