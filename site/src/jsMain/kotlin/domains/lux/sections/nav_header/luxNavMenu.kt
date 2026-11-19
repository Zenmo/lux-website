package energy.lux.frontend.domains.lux.sections.nav_header

import androidx.compose.runtime.Composable
import energy.lux.frontend.core.models.MenuItem
import energy.lux.frontend.core.models.RoutedMenuItem
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.pages.about_us.AboutUs
import energy.lux.frontend.domains.lux.pages.application_fields.LuxApplicationArea
import energy.lux.frontend.domains.lux.pages.application_fields.lux_business.LuxBusiness
import energy.lux.frontend.domains.lux.pages.application_fields.lux_enegy_hub.LuxEnergyHub
import energy.lux.frontend.domains.lux.pages.application_fields.lux_neighbourhood.LuxNeighbourhood
import energy.lux.frontend.domains.lux.pages.application_fields.lux_region.LuxRegion
import energy.lux.frontend.domains.lux.pages.luxmodels.LuxModels

private val applicationAreasMenuItem = MenuItem.WithSubs(
    title = LocalizedText(en = "Application Areas", nl = "Toepassingsgebieden"),
    subItems = LuxApplicationArea.entries.map { field ->
        MenuItem.Simple(
            route = RoutedMenuItem(
                path = field.path,
                url = field.url,
                label = field.label,
                pageComponent = { ApplicationAreaPage(field) },
            ),
            descriptionParagraph = field.shortDescription
        )
    }
)

@Composable
private fun ApplicationAreaPage(area: LuxApplicationArea) = when (area) {
    LuxApplicationArea.LUX_ENERGY_HUB -> LuxEnergyHub()
    LuxApplicationArea.LUX_REGION -> LuxRegion()
    LuxApplicationArea.LUX_NEIGHBOURHOOD -> LuxNeighbourhood()
    LuxApplicationArea.LUX_BUSINESS -> LuxBusiness()
}

private val aboutUsMenuItem = MenuItem.Simple(
    route = RoutedMenuItem(
        label = LocalizedText(en = "About Us", nl = "Over Ons"),
        pageComponent = { AboutUs() }
    )
)

val luxModelsMenuItem = MenuItem.Simple(
    route = RoutedMenuItem(
        label = LocalizedText(en = "Models", nl = "Modellen"),
        pageComponent = { LuxModels() }
    )
)

val luxNavMenu = listOf(
    applicationAreasMenuItem,
    luxModelsMenuItem,
    aboutUsMenuItem
)
