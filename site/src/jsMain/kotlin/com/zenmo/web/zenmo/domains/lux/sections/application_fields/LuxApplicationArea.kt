package com.zenmo.web.zenmo.domains.lux.sections.application_fields

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.core.models.Route
import com.zenmo.web.zenmo.core.models.SimpleMenuItem
import com.zenmo.web.zenmo.core.models.asNavLinkPath
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_company.LuxCompany
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub.LuxEnergyHub
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_region.LuxRegion
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_res_area.LuxNeighbourhood

enum class LuxApplicationArea(
    val shortDescription: LocalizedText,
    override val label: LocalizedText,
    override val areaTitle: LocalizedText = label,
    override val path: String = label.en.asNavLinkPath("application-areas"),
    override val url: String = path,
    override val pageComponent: @Composable () -> Unit,
) : Route, SimpleMenuItem, ApplicationArea {
    LUX_BUSINESS(
        label = LocalizedText("LUX Bedrijf", "LUX Business"),
        shortDescription = LocalizedText(
            "Inzicht in batterijwaarde en energieflexibiliteit",
            "Insight into battery value and energy flexibility",
        ),
        pageComponent = { LuxCompany() }
    ),
    LUX_ENERGY_HUB(
        label = LocalizedText("LUX Energie Hub", "LUX Energy Hub"),
        shortDescription = LocalizedText(
            "Lokale energie- en netcongestie-analyse",
            "Local energy and grid congestion analysis",
        ),
        pageComponent = { LuxEnergyHub() }
    ),
    LUX_NEIGHBOURHOOD(
        label = LocalizedText("LUX Woonwijk", "LUX Neighbourhood"),
        shortDescription = LocalizedText(
            "Energie- en netanalyse voor woonwijken",
            "Energy and grid analysis for residential neighbourhoods",
        ),
        pageComponent = { LuxNeighbourhood() }
    ),
    LUX_REGION(
        label = LocalizedText("LUX Regio", "LUX Region"),
        shortDescription = LocalizedText(
            "Regionale energie- en congestiescenario’s",
            "Regional energy and congestion scenarios",
        ),
        pageComponent = { LuxRegion() }
    );
}


