package energy.lux.frontend.domains.lux.subdomains.private_subdomains.regiofoodvalley

import energy.lux.frontend.core.models.PageComponent
import energy.lux.frontend.core.models.Route
import energy.lux.frontend.core.models.RoutedMenuItem
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.core.services.localization.localizedUrl
import energy.lux.frontend.domains.lux.core.PrivateTwinModel
import energy.lux.frontend.domains.lux.core.TwinModelCard
import energy.lux.frontend.domains.lux.core.model.subdomain.PrivateSubdomainModel
import energy.lux.frontend.domains.lux.pages.application_fields.ApplicationArea
import kotlin.uuid.Uuid

private val regioFoodValleyDomain = PrivateSubdomainModel.REGIOFOODVALLEY.fullDomain

data class RegioFoodValleyTwinModel(
    override val label: LocalizedText,
    val projectPath: String,
    val areaPath: String,
    override val path: String = "$areaPath$projectPath",
    override val url: String = localizedUrl(regioFoodValleyDomain, path),
    override val imageUrl: String,
    override val modelId: Uuid,
    override val applicationArea: ApplicationArea = PrivateSubdomainModel.REGIOFOODVALLEY.applicationArea,
    override val entryPoint: String,
    override val pageComponent: PageComponent,
) : Route, TwinModelCard, PrivateTwinModel


fun RegioFoodValleyTwinModel.asRoutedMenuItem() =
    RoutedMenuItem(
        label = label,
        path = path,
        url = url,
        pageComponent = pageComponent,
    )