package com.zenmo.web.zenmo.core

import com.varabyte.kobweb.navigation.Router
import com.zenmo.web.zenmo.core.models.PageComponent
import com.zenmo.web.zenmo.core.services.localization.LanguageManager

fun Router.registerLocalizedRoute(path: String, pageComponent: PageComponent) {
    val path = path.removePrefix("/")

    register(route = "/en/$path") { pageComponent() }
    register(route = "/nl/$path") { pageComponent() }

    val languageCode = LanguageManager.language.value.shortCode
    registerRedirect("/$path", "/$languageCode/$path")
}
