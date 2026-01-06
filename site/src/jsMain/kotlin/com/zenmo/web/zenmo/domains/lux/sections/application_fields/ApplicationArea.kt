package com.zenmo.web.zenmo.domains.lux.sections.application_fields

import com.varabyte.kobweb.compose.ui.graphics.Color
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.zenmo.navigation.asNavLinkPath
import com.zenmo.web.zenmo.theme.LuxSpecificColorHues
import web.window.window


enum class ApplicationArea(
    val areaTitle: LocalizedText,
    val shortDescription: LocalizedText,
) {
    LUX_COMPANY(
        LocalizedText("LUX Company", "LUX Bedrijf"),
        LocalizedText(
            "Short description about LUX Company",
            "Korte beschrijving over LUX Bedrijf"
        )
    ),
    LUX_ENERGY_HUB(
        LocalizedText("LUX Energy Hub", "LUX Energie Hub"),
        LocalizedText(
            "Short description for LUX Energy Hub",
            "Korte beschrijving over LUX Energie Hub"
        )
    ),
    LUX_RESIDENTIAL_AREA(
        LocalizedText("LUX Residential Area", "LUX Woongebied"),
        LocalizedText(
            "Short description for LUX Residential Area",
            "Korte beschrijving over LUX Woongebied"
        )
    ),
    LUX_REGION(
        LocalizedText("LUX Region", "LUX Regio"),
        LocalizedText(
            "Short description for LUX Region",
            "Korte beschrijving over LUX Regio"
        )
    );


    fun fieldRoute() = this.areaTitle.en.asNavLinkPath("application-areas")

    companion object {
        fun current(): ApplicationArea? {
            val path = window.location.pathname
            return entries.firstOrNull { it.fieldRoute() == path }
        }
    }
}

fun ApplicationArea.tagColor(): Color = when (this) {
    ApplicationArea.LUX_COMPANY -> LuxSpecificColorHues().luxYellow
    ApplicationArea.LUX_ENERGY_HUB -> LuxSpecificColorHues().luxGreen
    ApplicationArea.LUX_RESIDENTIAL_AREA -> LuxSpecificColorHues().luxRed
    ApplicationArea.LUX_REGION -> LuxSpecificColorHues().luxBlue
}