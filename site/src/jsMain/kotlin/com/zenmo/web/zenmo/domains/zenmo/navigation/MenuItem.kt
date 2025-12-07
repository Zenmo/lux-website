package com.zenmo.web.zenmo.domains.zenmo.navigation

import com.zenmo.web.zenmo.core.services.localization.LocalizedText


/**
 * Represents a menu item in the navigation bar.
 * The [MenuItem] can be either a simple item with a path and language
 * or a complex item with sub-items.
 * */
sealed class MenuItem {
    data class Simple(
        val path: String = "",
        val title: LocalizedText,
        val descriptionParagraph: LocalizedText? = null
    ) : MenuItem() {
        val getPath: String
            get() = path.ifEmpty { title.en.asNavLinkPath() }
    }

    /**
     * Represents a menu item with sub-items.
     * The [title] is the main title of the menu item,
     * and [subItems] is a list of menu items.
     * */
    data class WithSubs(val title: LocalizedText, val subItems: List<Simple>) : MenuItem()

}


fun String.asNavLinkPath(
    base: String = ""
): String {
    val basePath = if (base.isNotBlank()) "/${base.trim()}" else ""
    return "$basePath/${this.trim()}".replace(" ", "-").lowercase()
}
