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
            drechtstedenRouting(drechtstedenNavMenu.asRoutes())
            drechtstedenRouting(
                routes = drechtstedenModels
                    /*
                     * If a project's [projectPath] is blank, it means it uses the same path as the project area.
                     * This is possible when there is only one project in that area.
                     * In that case, we skip registering the route to avoid duplicate route registrations.
                     * For example, [drechtstedenRes] is the only project in RES_REGION area so its [projectPath] is blank.
                     * */
                    .filter { it.projectPath.isNotBlank() }
                    .map { it.asRoutedMenuItem() },
            )
        }
    }

    router.tryRoutingTo(
        BasePath.remove(window.location.href.removePrefix(window.origin)),
        UpdateHistoryMode.REPLACE
    )
    router.renderActivePage { DeferringHost { it() } }
}

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
