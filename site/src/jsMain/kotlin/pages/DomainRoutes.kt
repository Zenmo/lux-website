package energy.lux.frontend.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.AppGlobals
import com.varabyte.kobweb.core.Page
import energy.lux.frontend.components.widgets.UnknownDomain
import energy.lux.frontend.protected.LazyModule
import energy.lux.frontend.utils.setDomainFavicon
import js.import.importAsync
import kotlinx.browser.window

object SiteGlobals {
    val LUX_DOMAIN: String = AppGlobals.getValue("LUX_DOMAIN")
    val ZENMO_DOMAIN: String = AppGlobals.getValue("ZENMO_DOMAIN")

    /**
     * In the production and test environments the LUX project-specific
     * subdomains are separated using a dot (.).
     * The projects go under [project].lux.energy.
     *
     * For pull requests, however, we use a dash (-).
     * The projects go under [project]-[build-number].pr.lux.energy.
     * This is so that we can use the *.pr.lux.energy. wildcard certificate
     * for all pull requests.
     *
     * Example settings to deploy a pull request:
     *
     * LUX_DOMAIN=123.pr.lux.energy
     * SUBDOMAIN_SEPARATOR=-
     */
    val SUBDOMAIN_SEPARATOR: String = AppGlobals.getValue("SUBDOMAIN_SEPARATOR")
    val luxSubdomainSuffix = SUBDOMAIN_SEPARATOR + LUX_DOMAIN
}

@Page("{...catch-all}")
@Composable
fun DomainRoutes() {
    val domain = window.location.host
    val luxSubdomainSuffix = SiteGlobals.luxSubdomainSuffix

    when {
        domain == SiteGlobals.LUX_DOMAIN -> LuxDomainLoader()
        domain == SiteGlobals.ZENMO_DOMAIN -> ZenmoDomainLoader()
        domain.endsWith(luxSubdomainSuffix) -> {
            val sub = domain.substringBefore(luxSubdomainSuffix)
            LuxSubdomainLoader(sub)
        }

        else -> UnknownDomain(domain)
    }
    setDomainFavicon()
}

fun isLocalOrPreviewEnvironment() =
    listOf("preview", "local").any { it in window.location.host }

private external interface LuxDomainModule {
    @Composable
    fun LuxDomain()
}

private external interface ZenmoDomainModule {
    @Composable
    fun ZenmoDomain()
}

private external interface LuxSubdomainModule {
    @Composable
    fun LuxSubdomain(subdomain: String)
}

@Composable
private fun LuxDomainLoader() = LazyModule(
    load = { importAsync<LuxDomainModule>("./domains/lux/LuxDomainEntry.export.mjs") },
    content = { LuxDomain() },
)

@Composable
private fun ZenmoDomainLoader() = LazyModule(
    load = { importAsync<ZenmoDomainModule>("./domains/zenmo/ZenmoDomainEntry.export.mjs") },
    content = { ZenmoDomain() },
)

@Composable
private fun LuxSubdomainLoader(subdomain: String) = LazyModule(
    load = { importAsync<LuxSubdomainModule>("./domains/subdomains/LuxSubdomainEntry.export.mjs") },
    content = { LuxSubdomain(subdomain) },
)
