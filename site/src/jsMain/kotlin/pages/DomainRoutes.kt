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
}

@Page("{...catch-all}")
@Composable
fun DomainRoutes() {
    val domain = window.location.host
    val luxSubdomainSuffix = ".${SiteGlobals.LUX_DOMAIN}"

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