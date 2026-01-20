package com.zenmo.web.zenmo.core.models

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.core.services.localization.LocalizedText

/**
 * A menu item that represents a route within the site
 *
 * @property label The localized label for the menu item
 * @property path The navigation path for the menu item
 * @property url The URL for the menu item, defaults to the path
 * @property pageComponent The composable function that renders the page for this route
 * */
data class RoutedMenuItem(
    override val label: LocalizedText,
    override val path: String = label.en.asNavLinkPath(),
    override val url: String = path,
    override val pageComponent: @Composable () -> Unit
) : NavigableMenuItem