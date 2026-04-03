package energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden

import androidx.compose.runtime.Composable
import energy.lux.frontend.core.models.Route
import energy.lux.frontend.core.models.RoutedMenuItem
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.core.services.localization.localizedUrl
import energy.lux.frontend.domains.lux.core.PrivateTwinModel
import energy.lux.frontend.domains.lux.core.TwinModelCard
import energy.lux.frontend.domains.lux.core.model.subdomain.PrivateSubdomainModel
import energy.lux.frontend.domains.lux.core.toTwinModelCardItem
import energy.lux.frontend.domains.lux.sections.application_fields.DrechtstedenProjectArea
import energy.lux.frontend.domains.lux.sections.application_fields.LuxApplicationArea
import energy.lux.frontend.pages.SiteGlobals
import kotlin.uuid.Uuid

private val drechtstedenFullDomain = "${PrivateSubdomainModel.DRECHTSTEDEN.subdomain}.${SiteGlobals.LUX_DOMAIN}"

sealed interface DrechtstedenTwinModelBase : Route, TwinModelCard {
    val projectPath: String

    override val url: String
        get() = localizedUrl(drechtstedenFullDomain, path)

    override val path: String
        get() = when (applicationArea) {
            LuxApplicationArea.LUX_ENERGY_HUB -> DrechtstedenProjectArea.BUSINESS_PARKS.path
            LuxApplicationArea.LUX_REGION -> DrechtstedenProjectArea.RES_REGION.path
            LuxApplicationArea.LUX_NEIGHBOURHOOD -> DrechtstedenProjectArea.RESIDENTIAL_AREAS.path
            LuxApplicationArea.LUX_BUSINESS -> LuxApplicationArea.LUX_BUSINESS.path
            else -> error("Unknown application area: $applicationArea")
        } + projectPath
}

data class PublicDrechtstedenTwinModel(
    override val projectPath: String,
    override val modelId: Uuid,
    override val applicationArea: LuxApplicationArea = LuxApplicationArea.LUX_ENERGY_HUB,
    override val label: LocalizedText,
    override val imageUrl: String,
    override val pageComponent: @Composable () -> Unit,
) : DrechtstedenTwinModelBase


data class DrechtstedenTwinModel(
    override val projectPath: String,
    override val applicationArea: LuxApplicationArea = LuxApplicationArea.LUX_ENERGY_HUB,
    override val label: LocalizedText,
    override val imageUrl: String,
    override val entryPoint: String,
    override val modelId: Uuid = Uuid.NIL,
    override val pageComponent: @Composable () -> Unit,
) : DrechtstedenTwinModelBase, PrivateTwinModel

fun DrechtstedenTwinModelBase.asRoutedMenuItem() =
    RoutedMenuItem(
        label = label,
        path = path,
        url = url,
        pageComponent = pageComponent,
    )

fun List<DrechtstedenTwinModelBase>.toTwinModelCardItems() =
    this.map { it.toTwinModelCardItem() }
