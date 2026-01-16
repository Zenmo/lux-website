package com.zenmo.web.zenmo.domains.lux.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.init.InitKobwebContext
import com.zenmo.web.zenmo.core.models.RoutedMenuItem
import com.zenmo.web.zenmo.core.services.localization.LocalizedText


/**
 * Registers a list of routed menu items as routes and wraps each page
 * in a layout that has access to the route metadata (e.g. label, path).
 *
 * The [layoutWrapper] receives the menu title as [LocalizedText]
 * together with the page content, allowing layouts to use route information
 * for titles, breadcrumbs, or navigation context.
 */
fun InitKobwebContext.registerRoutesOfMenu(
    routes: List<RoutedMenuItem>,
    layoutWrapper: @Composable (title: LocalizedText, content: @Composable () -> Unit) -> Unit =
        { _, content -> content() }
) {
    with(this.router) {
        routes
            .forEach { item ->
                register(item.path) {
                    layoutWrapper(item.label) {
                        item.pageComponent()
                    }
                }
            }
    }
}