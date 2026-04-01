package energy.lux.frontend.core.models

import androidx.compose.runtime.Composable
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.core.services.localization.localizedUrl

/**
 * A menu item that represents a route within the site
 *
 * @property label The localized label for the menu item
 * @property path The navigation path for the menu item
 * @property url The URL for the menu item, defaults to the path with locale prefix
 * @property pageComponent The composable function that renders the page for this route
 * */
data class RoutedMenuItem(
    override val label: LocalizedText,
    override val path: String = label.en.asNavLinkPath(),
    override val url: String = localizedUrl(path),
    override val pageComponent: @Composable () -> Unit
) : NavigableMenuItem
