package energy.lux.site.frontend.utils

import energy.lux.site.frontend.pages.SiteGlobals
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLLinkElement

fun setDomainFavicon() {
    val domain = window.location.host
    val faviconPath = when (domain) {
        SiteGlobals.ZENMO_DOMAIN -> "/favicon.ico"
        else -> "/lux/logos/lux-sun-logo.svg"
    }
    val currentFaviconLink = document.querySelector("link[rel*='icon']") as? HTMLLinkElement
    currentFaviconLink?.href = faviconPath
}