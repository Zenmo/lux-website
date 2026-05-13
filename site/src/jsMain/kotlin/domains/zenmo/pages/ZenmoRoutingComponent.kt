package energy.lux.frontend.domains.zenmo.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.navigation.remove
import com.varabyte.kobweb.silk.defer.DeferringHost
import energy.lux.frontend.core.models.asRoutes
import energy.lux.frontend.core.registerLocalizedRoute
import energy.lux.frontend.domains.lux.core.createLuxRouter
import energy.lux.frontend.domains.lux.pages.registerRoutesOfMenu
import energy.lux.frontend.domains.zenmo.sections.nav_header.zenmoHomeMenuItem
import energy.lux.frontend.domains.zenmo.sections.nav_header.zenmoNavMenu
import kotlinx.browser.window

@Composable
fun ZenmoRoutingComponent() {
    val router = remember {
        createLuxRouter {
            registerLocalizedRoute(zenmoHomeMenuItem.route.path) {
                zenmoHomeMenuItem.route.pageComponent()
            }
            registerRoutesOfMenu(
                routes = zenmoNavMenu.asRoutes()
            )
        }
    }

    router.tryRoutingTo(
        BasePath.remove(window.location.href.removePrefix(window.origin)),
        UpdateHistoryMode.REPLACE
    )

    router.renderActivePage { DeferringHost { it() } }
}