package com.zenmo.web.zenmo.domains.lux.sections.application_fields

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.core.models.Route
import com.zenmo.web.zenmo.core.models.SimpleMenuItem
import com.zenmo.web.zenmo.core.models.asNavLinkPath
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_company.LuxCompany
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub.LuxEnergyHub

enum class LuxApplicationArea(
    val shortDescription: LocalizedText,
    override val label: LocalizedText,
    override val areaTitle: LocalizedText = label,
    override val path: String = label.en.asNavLinkPath("application-areas"),
    override val url: String = path,
    override val pageComponent: @Composable () -> Unit,
) : Route, SimpleMenuItem, ApplicationArea {
    LUX_COMPANY(
        label = LocalizedText("LUX Bedrijf", "LUX Company"),
        shortDescription = LocalizedText(
            "Korte beschrijving over LUX Bedrijf",
            "Short description about LUX Company",
        ),
        pageComponent = { LuxCompany() }
    ),
    LUX_ENERGY_HUB(
        label = LocalizedText("LUX Energie Hub", "LUX Energy Hub"),
        shortDescription = LocalizedText(
            "Korte beschrijving over LUX Energie Hub",
            "Short description for LUX Energy Hub",
        ),
        pageComponent = { LuxEnergyHub() }
    ),
    LUX_RESIDENTIAL_AREA(
        label = LocalizedText("LUX Woongebied", "LUX Residential Area"),
        shortDescription = LocalizedText(
            "Korte beschrijving over LUX Woongebied",
            "Short description for LUX Residential Area",
        ),
        pageComponent = { LuxResidentialArea() }
    ),
    LUX_REGION(
        label = LocalizedText("LUX Regio", "LUX Region"),
        shortDescription = LocalizedText(
            "Korte beschrijving over LUX Regio",
            "Short description for LUX Region",
        ),
        pageComponent = { LuxMunicipality() }
    );
}


