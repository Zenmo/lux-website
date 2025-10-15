package com.zenmo.web.zenmo.domains.zenmo.navigation

import com.zenmo.web.zenmo.domains.lux.components.model.SubdomainModel
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.ApplicationField
import com.zenmo.web.zenmo.pages.SiteGlobals
import com.zenmo.web.zenmo.pages.isLocalOrPreviewEnvironment
import kotlinx.browser.window

//todo rename this to LocalizedText or something more generic
data class MenuLanguage(
    val en: String,
    val nl: String,
)

/**
 * Represents a menu item in the navigation bar.
 * The [MenuItem] can be either a simple item with a path and language
 * or a complex item with sub-items.
 * */
sealed class MenuItem {
    data class Simple(
        val path: String = "",
        val title: MenuLanguage
    ) : MenuItem() {
        val getPath: String
            get() = path.ifEmpty { title.en.asNavLinkPath() }
    }

    /**
     * Represents a menu item with sub-items.
     * The [title] is the main title of the menu item,
     * and [subItems] is a list of menu items.
     * */
    data class WithSubs(val path: String = "", val title: MenuLanguage, val subItems: List<MenuLanguage>) : MenuItem()

    companion object {
        private val zenmoMenuItems = buildList {
            add(Simple(path = "/", title = MenuLanguage(en = "Home", nl = "Thuis")))
            add(
                Simple(
                    title = MenuLanguage(
                        en = "What we do",
                        nl = "Wat we doen"
                    )
                )
            )
            add(
                Simple(
                    title = MenuLanguage(
                        en = "Customers",
                        nl = "Klanten"
                    )
                )
            )
            add(
                WithSubs(
                    title = MenuLanguage(en = "About us", nl = "Over ons"),
                    subItems = listOf(
                        MenuLanguage(en = "Our Team", nl = "Ons Team"),
                        MenuLanguage(en = "Jobs", nl = "Banen"),
                        MenuLanguage(en = "History", nl = "Geschiedenis"),
                    )
                )
            )
            add(
                Simple(
                    title = MenuLanguage(en = "Contact", nl = "Contact")
                )
            )

            if (isLocalOrPreviewEnvironment()) {
                add(
                    Simple(
                        title = MenuLanguage(en = "Component Demo", nl = "Component Demo")
                    )
                )
            }
        }

        private val luxMenuItems = listOf(
            Simple(
                path = "/",
                title = MenuLanguage(en = "Home", nl = "Thuis")
            ),
            WithSubs(
                title = MenuLanguage(en = "Application fields", nl = "Toepassingen"),
                subItems = ApplicationField.entries.map {
                    MenuLanguage(
                        en = it.enFieldName,
                        nl = it.nlFieldName
                    )
                }
            ),
            Simple(
                title = MenuLanguage(en = "Models", nl = "Modellen")
            ),
        )

        private val drechtstedenMenuItems = listOf(
            Simple(
                path = "/",
                title = MenuLanguage(
                    en = "Home",
                    nl = "Thuis",
                )
            ),
            Simple(
                path = "/res-region",
                title = MenuLanguage(
                    en = "Res Region",
                    nl = "Res Regio",
                )
            ),
            Simple(
                path = "/res-neighborhoods",
                title = MenuLanguage(
                    en = "Res Neighborhoods",
                    nl = "Woonwijken",
                )
            ),
            Simple(
                path = "/business-parks",
                title = MenuLanguage(
                    en = "Business Parks",
                    nl = "Bedrijventerreinen",
                )
            ),
        )

        fun menuItems(): List<MenuItem> {
            val domain = window.location.host
            val luxSubdomainSuffix = ".${SiteGlobals.LUX_DOMAIN}"

            return when {
                domain == SiteGlobals.LUX_DOMAIN -> luxMenuItems
                domain == SiteGlobals.ZENMO_DOMAIN -> zenmoMenuItems
                domain.endsWith(luxSubdomainSuffix) -> {
                    val sub = domain.substringBefore(luxSubdomainSuffix)
                    val model = SubdomainModel.allModels.find { it.title.equals(sub, ignoreCase = true) }
                    when (model) {
                        SubdomainModel.Drechtsteden -> drechtstedenMenuItems
                        else -> emptyList()
                    }
                }

                else -> emptyList()
            }
        }
    }
}


fun String.asNavLinkPath(
    base: String = ""
): String {
    val basePath = if (base.isNotBlank()) "/${base.trim()}" else ""
    return "$basePath/${this.trim()}".replace(" ", "-").lowercase()
}
