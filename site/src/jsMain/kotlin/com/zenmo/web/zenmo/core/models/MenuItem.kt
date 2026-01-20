package com.zenmo.web.zenmo.core.models

import com.zenmo.web.zenmo.core.services.localization.LocalizedText


/**
 * Tree structure for the main navigation menu.
 * Can be a single link or a group with sub-items.
 */
sealed class MenuItem {
    data class Simple(
        val route: RoutedMenuItem,
        val descriptionParagraph: LocalizedText? = null
    ) : MenuItem()

    /**
     * Example usage:
     * @see com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.zenmoNavMenu
     * */
    data class WithSubs(val title: LocalizedText, val subItems: List<Simple>) : MenuItem()
}

private fun MenuItem.asRoutes(): List<RoutedMenuItem> = when (this) {
    is MenuItem.Simple -> listOf(this.route)
    is MenuItem.WithSubs -> this.subItems.map { it.route }
}

fun List<MenuItem>.asRoutes(): List<RoutedMenuItem> =
    this.flatMap { it.asRoutes() }

fun String.asNavLinkPath(
    base: String = ""
): String {
    val basePath = if (base.isNotBlank()) "/${base.trim()}" else ""
    return "$basePath/${this.trim()}".replace(" ", "-").lowercase()
}
