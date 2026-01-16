package com.zenmo.web.zenmo.domains.lux.sections.application_fields

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.core.models.Route
import com.zenmo.web.zenmo.core.models.SimpleMenuItem
import com.zenmo.web.zenmo.core.models.asNavLinkPath
import com.zenmo.web.zenmo.core.services.localization.LocalizedText

enum class LuxApplicationArea(
    val shortDescription: LocalizedText,
    override val label: LocalizedText,
    override val areaTitle: LocalizedText = label,
    override val path: String = label.en.asNavLinkPath("application-areas"),
    override val url: String = path,
    override val pageComponent: @Composable () -> Unit,
) : Route, SimpleMenuItem, ApplicationArea {
    LUX_COMPANY(
        label = LocalizedText("LUX Company", "LUX Bedrijf"),
        shortDescription = LocalizedText(
            "Short description about LUX Company",
            "Korte beschrijving over LUX Bedrijf"
        ),
        pageComponent = { LuxCompany() }
    ),
    LUX_ENERGY_HUB(
        label = LocalizedText("LUX Energy Hub", "LUX Energie Hub"),
        shortDescription = LocalizedText(
            "Short description for LUX Energy Hub",
            "Korte beschrijving over LUX Energie Hub"
        ),
        pageComponent = { LuxEnergyHub() }
    ),
    LUX_RESIDENTIAL_AREA(
        label = LocalizedText("LUX Residential Area", "LUX Woongebied"),
        shortDescription = LocalizedText(
            "Short description for LUX Residential Area",
            "Korte beschrijving over LUX Woongebied"
        ),
        pageComponent = { LuxResidentialArea() }
    ),
    LUX_REGION(
        label = LocalizedText("LUX Region", "LUX Regio"),
        shortDescription = LocalizedText(
            "Short description for LUX Region",
            "Korte beschrijving over LUX Regio"
        ),
        pageComponent = { LuxMunicipality() }
    );
}


