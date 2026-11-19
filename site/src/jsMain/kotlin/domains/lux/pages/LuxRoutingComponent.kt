package energy.lux.frontend.domains.lux.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.navigation.remove
import com.varabyte.kobweb.silk.defer.DeferringHost
import energy.lux.frontend.core.models.asRoutes
import energy.lux.frontend.core.registerLocalizedRoute
import energy.lux.frontend.domains.lux.components.layout.LuxEnergyLayout
import energy.lux.frontend.domains.lux.core.createLuxRouter
import energy.lux.frontend.domains.lux.pages.user_profile.USER_PROFILE_PATH
import energy.lux.frontend.domains.lux.pages.user_profile.UserProfilePage
import energy.lux.frontend.domains.lux.pages.home.HomePage
import energy.lux.frontend.domains.lux.sections.nav_header.luxNavMenu
import kotlinx.browser.window

/** Keep the public pages in sync with luxPaths() in PrerenderUrls.kt, which lists the pages to pre-render. */
@Composable
fun LuxRoutingComponent() {
    val router = remember {
        createLuxRouter {
            registerLocalizedRoute("/") {
                LuxEnergyLayout { HomePage() }
            }
            registerLocalizedRoute("/book-demo") {
                BookADemoPage()
            }

            registerLocalizedRoute(USER_PROFILE_PATH) {
                LuxEnergyLayout { UserProfilePage() }
            }

            registerRoutesOfMenu(
                routes = luxNavMenu.asRoutes(),
                layoutWrapper = { _, content -> LuxEnergyLayout { content() } }
            )

            if (window.location.host != "lux.energy") {
                registerLocalizedRoute("/component-demo") {
                    ComponentDemoPage()
                }
            }
        }
    }

    router.tryRoutingTo(
        BasePath.remove(window.location.href.removePrefix(window.origin)),
        UpdateHistoryMode.REPLACE
    )
    router.renderActivePage { DeferringHost { it() } }
}
