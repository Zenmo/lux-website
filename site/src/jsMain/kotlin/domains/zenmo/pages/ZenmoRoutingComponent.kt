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
import energy.lux.frontend.domains.zenmo.sections.nav_header.zenmoNavMenu
import energy.lux.frontend.domains.zenmo.widgets.ComponentDemoPage
import kotlinx.browser.window

@Composable
fun ZenmoRoutingComponent() {
    val router = remember {
        createLuxRouter {
            registerRoutesOfMenu(
                routes = zenmoNavMenu.asRoutes()
                    // remove component demo to avoid registering its route twice
                    .dropLast(1),
            )

            if (window.location.host != "zenmo.com") {
                registerLocalizedRoute("/component-demo") { ComponentDemoPage() }
            }
        }
    }

    router.tryRoutingTo(
        BasePath.remove(window.location.href.removePrefix(window.origin)),
        UpdateHistoryMode.REPLACE
    )

    router.renderActivePage { DeferringHost { it() } }
}
