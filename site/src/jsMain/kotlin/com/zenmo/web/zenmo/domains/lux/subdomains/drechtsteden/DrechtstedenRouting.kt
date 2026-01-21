package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.init.InitKobwebContext
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.navigation.Router
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.navigation.remove
import com.varabyte.kobweb.silk.defer.DeferringHost
import com.zenmo.web.zenmo.core.models.RoutedMenuItem
import com.zenmo.web.zenmo.core.models.asRoutes
import com.zenmo.web.zenmo.core.services.localization.LocalLanguage
import com.zenmo.web.zenmo.domains.lux.pages.registerRoutesOfMenu
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.layout.DrechtstedenTwinLayout
import kotlinx.browser.window

@Composable
fun DrechtstedenRouting() {
    val router = Router()
    com.varabyte.kobweb.core.init.initKobweb(router) { ctx ->
        ctx.drechtstdenRouting(drechtstedenNavMenu.asRoutes())
        ctx.drechtstdenRouting(
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

    router.tryRoutingTo(
        BasePath.remove(window.location.href.removePrefix(window.origin)),
        UpdateHistoryMode.REPLACE
    )
    router.renderActivePage { DeferringHost { it() } }
}

fun InitKobwebContext.drechtstdenRouting(
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