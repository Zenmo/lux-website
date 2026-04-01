package energy.lux.frontend.domains.lux.sections.application_fields

import com.varabyte.kobweb.compose.ui.graphics.Color
import energy.lux.frontend.theme.LuxSpecificColorHues
import energy.lux.frontend.theme.SitePalette

fun getApplicationAreaColor(area: ApplicationArea): Color = when (area) {
    LuxApplicationArea.LUX_BUSINESS -> LuxSpecificColorHues().luxYellow
    LuxApplicationArea.LUX_ENERGY_HUB -> LuxSpecificColorHues().luxGreen
    LuxApplicationArea.LUX_NEIGHBOURHOOD -> LuxSpecificColorHues().luxRed
    LuxApplicationArea.LUX_REGION -> LuxSpecificColorHues().luxBlue
    DrechtstedenProjectArea.BUSINESS_PARKS -> SitePalette.light.primary
    DrechtstedenProjectArea.RESIDENTIAL_AREAS -> LuxSpecificColorHues().luxBlackRussian
    DrechtstedenProjectArea.RES_REGION -> SitePalette.light.secondary.darkened(0.4f)
}
