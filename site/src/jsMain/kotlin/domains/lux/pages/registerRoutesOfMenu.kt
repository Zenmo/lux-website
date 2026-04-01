package energy.lux.frontend.domains.lux.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.navigation.Router
import energy.lux.frontend.core.models.RoutedMenuItem
import energy.lux.frontend.core.registerLocalizedRoute
import energy.lux.frontend.core.services.localization.LocalizedText


/**
 * Registers a list of routed menu items as routes and wraps each page
 * in a layout that has access to the route metadata (e.g. label, path).
 *
 * The [layoutWrapper] receives the menu title as [LocalizedText]
 * together with the page content, allowing layouts to use route information
 * for titles, breadcrumbs, or navigation context.
 */
fun Router.registerRoutesOfMenu(
    routes: List<RoutedMenuItem>,
    layoutWrapper: @Composable (title: LocalizedText, content: @Composable () -> Unit) -> Unit =
        { _, content -> content() }
) {
    routes.forEach { item ->
        registerLocalizedRoute(item.path) {
            layoutWrapper(item.label) {
                item.pageComponent()
            }
        }
    }
}
