package energy.lux.frontend.domains.lux.sections.nav_header

import energy.lux.frontend.core.models.MenuItem
import energy.lux.frontend.core.models.RoutedMenuItem
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.pages.about_us.AboutUs
import energy.lux.frontend.domains.lux.pages.application_fields.LuxApplicationArea
import energy.lux.frontend.domains.lux.pages.luxmodels.LuxModels

private val applicationAreasMenuItem = MenuItem.WithSubs(
    title = LocalizedText(en = "Application Areas", nl = "Toepassingsgebieden"),
    subItems = LuxApplicationArea.entries.map { field ->
        MenuItem.Simple(
            route = RoutedMenuItem(
                path = field.path,
                url = field.url,
                label = field.label,
                pageComponent = field.pageComponent,
            ),
            descriptionParagraph = field.shortDescription
        )
    }
)

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
