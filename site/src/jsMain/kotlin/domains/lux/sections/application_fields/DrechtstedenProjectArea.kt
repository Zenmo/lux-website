package energy.lux.frontend.domains.lux.sections.application_fields

import androidx.compose.runtime.Composable
import energy.lux.frontend.core.models.Route
import energy.lux.frontend.core.models.SimpleMenuItem
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.core.services.localization.localizedUrl
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.pages.businessparks.BusinessParksPage
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.pages.residential_neighborhoods.NeighbourhoodsPage
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.pages.residential_region.DrechtstedenRegioIndex

enum class DrechtstedenProjectArea(
    override val label: LocalizedText,
    override val areaTitle: LocalizedText = label,
    override val path: String,
    override val url: String = localizedUrl(path),
    override val pageComponent: @Composable () -> Unit,
) : Route, SimpleMenuItem, ApplicationArea {
    RES_REGION(
        path = "/region",
        label = LocalizedText(en = "Region", nl = "Regio"),
        pageComponent = { DrechtstedenRegioIndex() }
    ),
    RESIDENTIAL_AREAS(
        path = "/residential-areas",
        label = LocalizedText(en = "Residential Areas", nl = "Woonwijken"),
        pageComponent = { NeighbourhoodsPage() }
    ),
    BUSINESS_PARKS(
        path = "/business-parks",
        label = LocalizedText(en = "Business Parks", nl = "Bedrijventerreinen"),
        pageComponent = { BusinessParksPage() }
    ),
}
