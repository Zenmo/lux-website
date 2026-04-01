package energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.navigation.remove
import com.varabyte.kobweb.silk.defer.DeferringHost
import energy.lux.frontend.core.models.MenuItem
import energy.lux.frontend.core.models.RoutedMenuItem
import energy.lux.frontend.core.models.asRoutes
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.core.createLuxRouter
import energy.lux.frontend.domains.lux.pages.registerRoutesOfMenu
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.pages.Bronckhorst
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.pages.NijmegenHengstdal
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.pages.empowered.EmpoweredIndex
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

val empoweredMenuItems = listOf(
    MenuItem.Simple(
        RoutedMenuItem(
            path = "/", label = LocalizedText("EmPowerED", "EmPowerED"),
            pageComponent = { EmpoweredIndex() })
    ),
    MenuItem.Simple(
        RoutedMenuItem(
            label = LocalizedText("Bronckhorst", "Bronckhorst"),
            pageComponent = { Bronckhorst() })
    ),
    MenuItem.Simple(
        RoutedMenuItem(
            label = LocalizedText("Nijmegen Hengstdal", "Nijmegen Hengstdal"),
            pageComponent = { NijmegenHengstdal() })
    ),
)
