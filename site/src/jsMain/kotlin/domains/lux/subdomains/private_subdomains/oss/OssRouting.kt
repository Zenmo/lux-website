package domains.lux.subdomains.private_subdomains.oss

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
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.asRoutes
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.ossTwinModels
import kotlinx.browser.window

@Composable
fun OssRouting() {

    val router = remember {
        createLuxRouter {
            ossRouting(ossNavMenu.asRoutes())
            ossRouting(ossTwinModels.asRoutes())
        }
    }

    router.tryRoutingTo(
        BasePath.remove(window.location.href.removePrefix(window.origin)),
        UpdateHistoryMode.REPLACE
    )
    router.renderActivePage { DeferringHost { it() } }
}


private fun Router.ossRouting(
    routes: List<RoutedMenuItem>
) = this.registerRoutesOfMenu(
    routes = routes,
    layoutWrapper = { title, content ->
        OssLayout(
            title = LocalLanguage.current.translate(
                title.en,
                title.nl
            )
        ) { content() }
    }
)