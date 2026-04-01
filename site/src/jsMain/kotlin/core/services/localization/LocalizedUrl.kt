package energy.lux.frontend.core.services.localization

import kotlinx.browser.window

/**
 * Prepend /en or /nl to the given path.
 */
fun localizedUrl(path: String): String =
    "/${LanguageManager.language.value.shortCode}/${path.removePrefix("/")}"

/**
 * Prepend /en or /nl to the given path.
 */
fun localizedUrl(domain: String, path: String): String {
    val localizedPath = localizedUrl(path)

    return if (window.location.host == domain) {
        localizedPath
    } else {
        "//$domain$localizedPath"
    }
}
