package energy.lux.frontend.domains.lux.subdomains.public_subdomains.brabant.components

import energy.lux.frontend.core.models.PageComponent
import energy.lux.frontend.core.models.Route
import energy.lux.frontend.core.models.RoutedMenuItem
import energy.lux.frontend.core.models.asNavLinkPath
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.core.services.localization.localizedUrl
import energy.lux.frontend.domains.lux.core.TwinModelCard
import energy.lux.frontend.domains.lux.core.model.subdomain.brabant
import energy.lux.frontend.domains.lux.sections.application_fields.ApplicationArea
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.brabant.pages.BrabantNeighbourhood
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.brabant.pages.BrabantProvince
import energy.lux.frontend.pages.SiteGlobals
import kotlin.uuid.Uuid


private val brabantDomain = "${brabant.subdomain}.${SiteGlobals.LUX_DOMAIN}"

data class BrabantTwinModel(
    override val applicationArea: ApplicationArea = brabant.applicationArea,
    override val imageUrl: String,
    override val label: LocalizedText,
    override val modelId: Uuid,
    override val path: String = label.en.asNavLinkPath(),
    override val url: String = localizedUrl(brabantDomain, path),
    override val pageComponent: PageComponent,
) : TwinModelCard, Route


val brabantNeighbourhoodModel = BrabantTwinModel(
    imageUrl = "/lux/images/brabant/buurtmodel.png",
    label = LocalizedText(
        en = "Neighbourhood Model",
        nl = "Buurt Model"
    ),
    modelId = Uuid.parse("973255f2-d5fb-4daa-b835-852388716ca7"),
    pageComponent = { BrabantNeighbourhood() }
)

val brabantProvinceModel = BrabantTwinModel(
    imageUrl = "/lux/images/brabant/provinciemodel.png",
    label = LocalizedText(
        en = "Province Model",
        nl = "Provincie Model"
    ),
    modelId = Uuid.parse("d6d94e58-74a5-40b4-aef1-7ee30fa7aef0"),
    pageComponent = { BrabantProvince() }
)


fun BrabantTwinModel.asRoute() =
    RoutedMenuItem(
        label = label,
        path = path,
        url = url,
        pageComponent = pageComponent,
    )


fun List<BrabantTwinModel>.asRoutes(): List<RoutedMenuItem> =
    this.map { it.asRoute() }

val brabantModels = listOf(
    brabantNeighbourhoodModel,
    brabantProvinceModel,
)