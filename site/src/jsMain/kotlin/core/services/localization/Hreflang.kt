package energy.lux.frontend.core.services.localization

import com.varabyte.kobweb.navigation.RouteInterceptorScope
import com.varabyte.kobweb.navigation.Router
import web.dom.document
import web.html.HTMLLinkElement
import web.location.location
import kotlin.text.get

fun Router.addHreflangInterceptor() {
    this.addRouteInterceptor(RouteInterceptorScope::hreflangInterceptor)
}

/**
 * Add two <link> elements to point search engines to the English and Dutch versions of the page.
 * See https://developers.google.com/search/docs/specialty/international/localized-versions
 */
private fun RouteInterceptorScope.hreflangInterceptor() {
    removeHreflangs()
    val commonPath = getNonLocalizedPath(path) ?: return
    addHreflangs(commonPath)
}

/**
 * Remove the language prefix from the path.
 * If there is no language prefix, return null.
 */
private fun getNonLocalizedPath(fullPath: String): String? {
    val regex = Regex("^/(?:${Language.Dutch.shortCode}|${Language.English.shortCode})/(?<rest>.*)")

    val matchResult = regex.find(fullPath) ?: return fullPath

    return matchResult.groups["rest"]?.value
}

/**
 * Add two <link> elements to the <head>
 */
private fun addHreflangs(commonPath: String) {
    val nlElement = (document.createElement("link") as HTMLLinkElement).apply {
        rel = "alternate"
        hreflang = "nl"
        href = "${location.origin}/nl/$commonPath"
    }

    val enElement = (document.createElement("link") as HTMLLinkElement).apply {
        rel = "alternate"
        hreflang = "en"
        href = "${location.origin}/en/$commonPath"
    }

    document.head.append(nlElement, enElement)
}

/**
 * Remove all <link> elements with rel="alternate" and hreflang
 */
fun removeHreflangs() {
    document.head.querySelectorAll("link[rel=alternate][hreflang]").forEach { it.remove() }
}
