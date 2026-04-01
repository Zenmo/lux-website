package energy.lux.frontend.core

import com.varabyte.kobweb.navigation.Router
import energy.lux.frontend.core.models.PageComponent
import energy.lux.frontend.core.services.localization.LanguageManager

fun Router.registerLocalizedRoute(path: String, pageComponent: PageComponent) {
    val path = path.removePrefix("/")

    register(route = "/en/$path") { pageComponent() }
    register(route = "/nl/$path") { pageComponent() }

    val languageCode = LanguageManager.language.value.shortCode
    registerRedirect("/$path", "/$languageCode/$path")
}
