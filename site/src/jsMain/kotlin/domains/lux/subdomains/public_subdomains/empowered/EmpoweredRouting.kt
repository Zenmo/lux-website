package energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.navigation.remove
import com.varabyte.kobweb.silk.defer.DeferringHost
import energy.lux.frontend.core.models.asRoutes
import energy.lux.frontend.domains.lux.core.createLuxRouter
import energy.lux.frontend.domains.lux.pages.registerRoutesOfMenu
import kotlinx.browser.window

@Composable
fun EmpoweredRouting() {
    val router = remember {
        createLuxRouter {
            registerRoutesOfMenu(
                routes = empoweredMenuItems.asRoutes(),
                layoutWrapper = { _, content -> EmpoweredLayout { content() } }
            )
        }
    }

    router.tryRoutingTo(
        BasePath.remove(window.location.href.removePrefix(window.origin)),
        UpdateHistoryMode.REPLACE
    )
    router.renderActivePage { DeferringHost { it() } }
}