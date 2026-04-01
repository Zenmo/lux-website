package energy.lux.frontend.domains.lux.sections.application_fields

import androidx.compose.runtime.Composable
import energy.lux.frontend.core.models.Route
import energy.lux.frontend.core.models.SimpleMenuItem
import energy.lux.frontend.core.models.asNavLinkPath
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.core.services.localization.localizedUrl
import energy.lux.frontend.domains.lux.sections.application_fields.lux_business.LuxBusiness
import energy.lux.frontend.domains.lux.sections.application_fields.lux_enegy_hub.LuxEnergyHub
import energy.lux.frontend.domains.lux.sections.application_fields.lux_neighbourhood.LuxNeighbourhood
import energy.lux.frontend.domains.lux.sections.application_fields.lux_region.LuxRegion

enum class LuxApplicationArea(
    val shortDescription: LocalizedText,
    override val label: LocalizedText,
    override val areaTitle: LocalizedText = label,
    override val path: String = label.en.asNavLinkPath("application-areas"),
    override val url: String = localizedUrl(path),
    override val pageComponent: @Composable () -> Unit,
) : Route, SimpleMenuItem, ApplicationArea {
    LUX_ENERGY_HUB(
        label = LocalizedText("LUX Energie Hub", "LUX Energy Hub"),
        shortDescription = LocalizedText(
            "Lokale energie- en netcongestie-analyse",
            "Local energy and grid congestion analysis",
        ),
        pageComponent = { LuxEnergyHub() }
    ),
    LUX_REGION(
        label = LocalizedText("LUX Regio", "LUX Region"),
        shortDescription = LocalizedText(
            "Regionale energie- en congestiescenario’s",
            "Regional energy and congestion scenarios",
        ),
        pageComponent = { LuxRegion() }
    ),
    LUX_NEIGHBOURHOOD(
        label = LocalizedText("LUX Woonwijk", "LUX Neighbourhood"),
        shortDescription = LocalizedText(
            "Energie- en netanalyse voor woonwijken",
            "Energy and grid analysis for residential neighbourhoods",
        ),
        pageComponent = { LuxNeighbourhood() }
    ),
    LUX_BUSINESS(
        label = LocalizedText("LUX Bedrijf", "LUX Business"),
        shortDescription = LocalizedText(
            "Inzicht in batterijwaarde en energieflexibiliteit",
            "Insight into battery value and energy flexibility",
        ),
        pageComponent = { LuxBusiness() }
    ),
}


