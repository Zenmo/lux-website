package com.zenmo.web.zenmo.domains.lux.sections.application_fields

import com.varabyte.kobweb.compose.ui.graphics.Color
import com.zenmo.web.zenmo.theme.LuxSpecificColorHues
import com.zenmo.web.zenmo.theme.SitePalette

fun getApplicationAreaColor(area: ApplicationArea): Color = when (area) {
    LuxApplicationArea.LUX_COMPANY -> LuxSpecificColorHues().luxYellow
    LuxApplicationArea.LUX_ENERGY_HUB -> LuxSpecificColorHues().luxGreen
    LuxApplicationArea.LUX_RESIDENTIAL_AREA -> LuxSpecificColorHues().luxRed
    LuxApplicationArea.LUX_REGION -> LuxSpecificColorHues().luxBlue
    DrechtstedenProjectArea.BUSINESS_PARKS -> SitePalette.Companion.light.primary
    DrechtstedenProjectArea.RES_NEIGHBORHOODS -> LuxSpecificColorHues().luxBlackRussian
    DrechtstedenProjectArea.RES_REGION -> SitePalette.Companion.light.secondary.darkened(0.4f)
}