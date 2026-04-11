package energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss

import energy.lux.frontend.core.models.PageComponent
import energy.lux.frontend.core.models.Route
import energy.lux.frontend.core.models.RoutedMenuItem
import energy.lux.frontend.core.models.asNavLinkPath
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.core.services.localization.localizedUrl
import energy.lux.frontend.domains.lux.core.PrivateTwinModel
import energy.lux.frontend.domains.lux.core.TwinModelCard
import energy.lux.frontend.domains.lux.core.model.subdomain.PrivateSubdomainModel
import energy.lux.frontend.domains.lux.sections.application_fields.ApplicationArea
import energy.lux.frontend.domains.lux.sections.application_fields.LuxApplicationArea
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.pages.ElzenburgDeGeer
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.pages.Moleneind
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.pages.VorstenGrafDonk
import energy.lux.frontend.pages.SiteGlobals
import kotlin.uuid.Uuid

private val ossDomain = "${PrivateSubdomainModel.OSS.subdomain}.${SiteGlobals.LUX_DOMAIN}"

data class OssTwinModel(
    override val label: LocalizedText,
    override val path: String = label.en.asNavLinkPath(),
    override val url: String = localizedUrl(ossDomain, path),
    override val imageUrl: String,
    override val modelId: Uuid = Uuid.NIL,
    override val applicationArea: ApplicationArea = LuxApplicationArea.LUX_ENERGY_HUB,
    override val entryPoint: String,
    override val pageComponent: PageComponent,
) : Route, TwinModelCard, PrivateTwinModel

val elzenburgDeGeer =
    OssTwinModel(
        label = LocalizedText("Elzenburg-De Geer"),
        imageUrl = "/lux/images/oss/elzenburgDeGeer.jpeg",
        entryPoint = "oss/elzenburgDeGeer",
        pageComponent = { ElzenburgDeGeer() },
    )
val vorstenGrafDonk =
    OssTwinModel(
        label = LocalizedText("Vorstengrafdonk"),
        imageUrl = "/lux/images/oss/vorstengrafdonk.jpeg",
        entryPoint = "oss/vorstengrafdonk",
        pageComponent = { VorstenGrafDonk() },
    )
val moleneind =
    OssTwinModel(
        label = LocalizedText("Moleneind"),
        imageUrl = "/lux/images/oss/moleneind.jpeg",
        entryPoint = "oss/moleneind",
        pageComponent = { Moleneind() },
    )


fun OssTwinModel.asRoute() =
    RoutedMenuItem(
        label = label,
        path = path,
        url = url,
        pageComponent = pageComponent,
    )


fun List<OssTwinModel>.asRoutes(): List<RoutedMenuItem> =
    this.map { it.asRoute() }

val ossTwinModels = listOf(
    elzenburgDeGeer,
    vorstenGrafDonk,
    moleneind,
)

