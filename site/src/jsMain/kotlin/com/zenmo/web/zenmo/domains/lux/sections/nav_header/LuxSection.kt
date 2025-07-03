package com.zenmo.web.zenmo.domains.lux.sections.nav_header

import com.zenmo.web.zenmo.domains.zenmo.navigation.MenuLanguage

enum class LuxSection(
    val title: MenuLanguage,
    val href: String = "#${title.en.lowercase()}",
    val id: String = title.en.lowercase(),
) {
    HOME(title = MenuLanguage(en = "Home", nl = "Thuis")),
    PRODUCTS(title = MenuLanguage(en = "Products", nl = "Producten")),
    MODELS(title = MenuLanguage(en = "Models", nl = "Modellen")),
}
