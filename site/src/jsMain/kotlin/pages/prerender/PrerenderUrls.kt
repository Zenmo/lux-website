package energy.lux.frontend.pages.prerender

import energy.lux.frontend.core.localizedPaths
import energy.lux.frontend.core.models.RoutedMenuItem
import energy.lux.frontend.core.models.asRoutes
import energy.lux.frontend.domains.lux.core.model.subdomain.*
import energy.lux.frontend.domains.lux.sections.nav_header.luxNavMenu
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.drechtstedenRoutes
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.ossRoutes
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.regiofoodvalley.regioFoodValleyRoutes
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.brabant.brabantRoutes
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.empoweredMenuItems
import energy.lux.frontend.domains.zenmo.sections.nav_header.zenmoHomeMenuItem
import energy.lux.frontend.domains.zenmo.sections.nav_header.zenmoNavMenu
import energy.lux.frontend.pages.SiteGlobals
import energy.lux.site.shared.AccessPolicy
import kotlinx.browser.window

/*
 * The list of pages for the prerender task (see prerender/).
 *
 * This is its own entrypoint that nothing in the site imports,
 * so collecting every domain's routes here does not pull them into main.
 * rollup.config.mjs gives it a fixed file name, and never puts shared code in this chunk.
 *
 * It must run inside a rendered page: the menus read the language from the URL,
 * and SiteGlobals needs Kobweb's AppGlobals.
 */

@JsExport
val accessPolicy = AccessPolicy.Public()

/**
 * Full URLs of the public pages of all domains, in all languages.
 * Pages that need a login (like the user profile) are left out.
 */
@JsExport
fun prerenderUrls(): Array<String> {
    val lux = urls(SiteGlobals.LUX_DOMAIN, luxPaths())
    val zenmo = urls(SiteGlobals.ZENMO_DOMAIN, zenmoPaths())
    val subdomains = subdomainModels.flatMap { model ->
        urls(model.subdomain + SiteGlobals.luxSubdomainSuffix, subdomainPaths(model))
    }
    return buildList {
        addAll(lux)
        addAll(zenmo)
        addAll(subdomains)
    }.distinct().toTypedArray()
}

private fun urls(host: String, paths: List<String>): List<String> =
    paths.map { "${window.location.protocol}//$host$it" }

/** Keep in sync with LuxRoutingComponent. */
private fun luxPaths(): List<String> =
    localized(
        listOf("/", "/book-demo") + luxNavMenu.asRoutes().paths()
    )

/** Keep in sync with ZenmoRoutingComponent. */
private fun zenmoPaths(): List<String> =
    localized(
        listOf(zenmoHomeMenuItem.route.path) + zenmoNavMenu.asRoutes().paths()
    )

/** Keep in sync with LuxSubdomainRoutingComponent. */
private fun subdomainPaths(model: SubdomainTwinModel): List<String> = when (model) {
    PrivateSubdomainModel.DRECHTSTEDEN -> localized(drechtstedenRoutes().paths())
    PrivateSubdomainModel.OSS -> localized(ossRoutes().paths())
    PrivateSubdomainModel.REGIOFOODVALLEY -> localized(regioFoodValleyRoutes().paths())
    empowered -> localized(empoweredMenuItems.asRoutes().paths())
    brabant -> localized(brabantRoutes().paths())
    // Subdomains without a router show the same page on every path.
    // Links point to /nl/ and /en/, so render those too, not only "/".
    else -> listOf("/") + localizedPaths("/")
}

private fun List<RoutedMenuItem>.paths() = map { it.path }

private fun localized(paths: List<String>) = paths.flatMap { localizedPaths(it) }