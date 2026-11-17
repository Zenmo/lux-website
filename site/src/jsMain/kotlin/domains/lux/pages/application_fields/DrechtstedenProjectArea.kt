package energy.lux.frontend.domains.lux.pages.application_fields

import energy.lux.frontend.core.models.SimpleMenuItem
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.core.services.localization.localizedUrl

/**
 * The page of each area is chosen in drechtstedenNavMenu, not stored here,
 * so code that only needs an area's label or url does not pull in the Drechtsteden pages.
 */
enum class DrechtstedenProjectArea(
    override val label: LocalizedText,
    override val areaTitle: LocalizedText = label,
    val path: String,
    override val url: String = localizedUrl(path),
) : SimpleMenuItem, ApplicationArea {
    RES_REGION(
        path = "/region",
        label = LocalizedText(en = "Region", nl = "Regio"),
    ),
    RESIDENTIAL_AREAS(
        path = "/residential-areas",
        label = LocalizedText(en = "Residential Areas", nl = "Woonwijken"),
    ),
    BUSINESS_PARKS(
        path = "/business-parks",
        label = LocalizedText(en = "Business Parks", nl = "Bedrijventerreinen"),
    ),
}
