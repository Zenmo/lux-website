package energy.lux.frontend.domains.lux.subdomains.private_subdomains.regiofoodvalley

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.navigation.Router
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.navigation.remove
import com.varabyte.kobweb.silk.defer.DeferringHost
import energy.lux.frontend.components.layouts.PageLayout
import energy.lux.frontend.core.models.RoutedMenuItem
import energy.lux.frontend.core.models.asRoutes
import energy.lux.frontend.core.services.localization.LocalLanguage
import energy.lux.frontend.domains.lux.core.createLuxRouter
import energy.lux.frontend.domains.lux.pages.registerRoutesOfMenu
import energy.lux.frontend.domains.lux.sections.nav_header.LuxHeader
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.regiofoodvalley.pages.regio.regioFoodValleyModels
import kotlinx.browser.window

@Composable
fun RegioFoodValleyRouting() {
    val router = remember {
        createLuxRouter {
            regioFoodValleyRouting(regiofoodvalleyMenu.asRoutes())
            regioFoodValleyRouting(
                regioFoodValleyModels
                    .filter { it.projectPath.isNotBlank() }
                    .map { it.asRoutedMenuItem() }
            )
        }
    }

    router.tryRoutingTo(
        BasePath.remove(window.location.href.removePrefix(window.origin)),
        UpdateHistoryMode.REPLACE
    )
    router.renderActivePage { DeferringHost { it() } }
}

private fun Router.regioFoodValleyRouting(
    routes: List<RoutedMenuItem>
) = this.registerRoutesOfMenu(
    routes = routes,
    layoutWrapper = { title, content ->
        val pageTitle = LocalLanguage.current.translate(
            title.en,
            title.nl
        )
        PageLayout(
            header = { LuxHeader() },
            footer = {},
            title = "RegioFoodValley - $pageTitle",
        ) {
            content()
        }
    }
)