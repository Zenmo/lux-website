package energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden

import androidx.compose.runtime.Composable
import energy.lux.frontend.core.models.MenuItem
import energy.lux.frontend.core.models.RoutedMenuItem
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.pages.application_fields.DrechtstedenProjectArea
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.pages.DrechtstedenHomePage
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.pages.businessparks.BusinessParksPage
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.pages.residential_neighborhoods.NeighbourhoodsPage
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.pages.residential_region.DrechtstedenRegioIndex

val drechtstedenNavMenu = buildList {
    add(
        MenuItem.Simple(
            RoutedMenuItem(
                path = "/",
                label = LocalizedText(en = "Home", nl = "Thuis"),
                pageComponent = { DrechtstedenHomePage() }
            )
        )
    )

    addAll(
        DrechtstedenProjectArea.entries.map { field ->
            MenuItem.Simple(
                RoutedMenuItem(
                    path = field.path,
                    label = field.label,
                    pageComponent = { DrechtstedenProjectAreaPage(field) },
                )
            )
        }
    )
}

@Composable
private fun DrechtstedenProjectAreaPage(area: DrechtstedenProjectArea) = when (area) {
    DrechtstedenProjectArea.RES_REGION -> DrechtstedenRegioIndex()
    DrechtstedenProjectArea.RESIDENTIAL_AREAS -> NeighbourhoodsPage()
    DrechtstedenProjectArea.BUSINESS_PARKS -> BusinessParksPage()
}
