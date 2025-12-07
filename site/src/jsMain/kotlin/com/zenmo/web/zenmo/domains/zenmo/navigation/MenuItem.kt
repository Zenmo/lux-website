package com.zenmo.web.zenmo.domains.zenmo.navigation

import com.zenmo.web.zenmo.core.services.localization.LocalizedText


/**
 * Represents a menu item in the navigation bar.
 * The [MenuItem] can be either a simple item with a path and language
 * or a complex item with sub-items.
 * */
sealed class MenuItem {
    data class Simple(
        val title: LocalizedText,
        val path: String = title.en.asNavLinkPath(),
        val descriptionParagraph: LocalizedText? = null
    ) : MenuItem()

    /**
     * Represents a menu item with sub-items.
     * [title] is the main title of the menu item,
     * [subItems] is a list of menu items.
     * */
    data class WithSubs(val title: LocalizedText, val subItems: List<Simple>) : MenuItem()

}


fun MenuItem.WithSubs.withGeneratedPaths(): MenuItem.WithSubs {

    val children = subItems.map { child ->
        if (child.path == child.title.en.asNavLinkPath()) {
            // child path is default, generate sub-menu path with parent title as base
            child.copy(path = child.title.en.asNavLinkPath(title.en))
        } else {
            // explicit path, keep as is
            child
        }
    }

    return copy(subItems = children)
}


fun String.asNavLinkPath(
    base: String = ""
): String {
    val basePath = if (base.isNotBlank()) "/${base.trim()}" else ""
    return "$basePath/${this.trim()}".replace(" ", "-").lowercase()
}
