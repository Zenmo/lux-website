package energy.lux.frontend.core

import com.varabyte.kobweb.navigation.Router
import energy.lux.frontend.core.models.PageComponent
import energy.lux.frontend.core.services.localization.LanguageManager

/** Every page exists once per language, e.g. "/about" -> "/en/about" and "/nl/about". */
fun localizedPaths(path: String): List<String> {
    val path = path.removePrefix("/")
    return listOf("/en/$path", "/nl/$path")
}

fun Router.registerLocalizedRoute(path: String, pageComponent: PageComponent) {
    localizedPaths(path).forEach { register(route = it) { pageComponent() } }

    val path = path.removePrefix("/")
    val languageCode = LanguageManager.language.value.shortCode
    registerRedirect("/$path", "/$languageCode/$path")
}
