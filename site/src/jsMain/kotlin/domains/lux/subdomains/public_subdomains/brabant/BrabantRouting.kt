package energy.lux.frontend.domains.lux.subdomains.public_subdomains.brabant

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.navigation.remove
import com.varabyte.kobweb.silk.defer.DeferringHost
import energy.lux.frontend.core.registerLocalizedRoute
import energy.lux.frontend.domains.lux.core.createLuxRouter
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.brabant.pages.BrabantIndex
import kotlinx.browser.window

@Composable
fun BrabantRouting() {
    val router = remember {
        createLuxRouter {
            registerLocalizedRoute("/") { BrabantIndex() }
        }
    }

    router.tryRoutingTo(
        BasePath.remove(window.location.href.removePrefix(window.origin)),
        UpdateHistoryMode.REPLACE
    )
    router.renderActivePage { DeferringHost { it() } }
}

