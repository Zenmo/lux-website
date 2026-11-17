package energy.lux.frontend.domains.lux.pages.application_fields

import energy.lux.frontend.core.models.SimpleMenuItem
import energy.lux.frontend.core.models.asNavLinkPath
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.core.services.localization.localizedUrl

/**
 * The page of each area is chosen in luxNavMenu, not stored here,
 * so code that only needs an area's label or url does not pull in all area pages.
 */
enum class LuxApplicationArea(
    val shortDescription: LocalizedText,
    override val label: LocalizedText,
    override val areaTitle: LocalizedText = label,
    val path: String = label.en.asNavLinkPath("application-areas"),
    override val url: String = localizedUrl(path),
) : SimpleMenuItem, ApplicationArea {
    LUX_ENERGY_HUB(
        label = LocalizedText("LUX Energie Hub", "LUX Energy Hub"),
        shortDescription = LocalizedText(
            "Lokale energie- en netcongestie-analyse",
            "Local energy and grid congestion analysis",
        ),
    ),
    LUX_REGION(
        label = LocalizedText("LUX Regio", "LUX Region"),
        shortDescription = LocalizedText(
            "Regionale energie- en congestiescenario’s",
            "Regional energy and congestion scenarios",
        ),
    ),
    LUX_NEIGHBOURHOOD(
        label = LocalizedText("LUX Woonwijk", "LUX Neighbourhood"),
        shortDescription = LocalizedText(
            "Energie- en netanalyse voor woonwijken",
            "Energy and grid analysis for residential neighbourhoods",
        ),
    ),
    LUX_BUSINESS(
        label = LocalizedText("LUX Bedrijf", "LUX Business"),
        shortDescription = LocalizedText(
            "Inzicht in batterijwaarde en energieflexibiliteit",
            "Insight into battery value and energy flexibility",
        ),
    ),
}


