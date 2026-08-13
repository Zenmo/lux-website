package energy.lux.frontend.domains.lux.subdomains.private_subdomains.regiofoodvalley

import energy.lux.frontend.core.models.MenuItem
import energy.lux.frontend.core.models.RoutedMenuItem
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.regiofoodvalley.pages.RegioFoodValleyBusinessParksPage
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.regiofoodvalley.pages.RegioFoodValleyHomePage
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.regiofoodvalley.pages.RegioFoodValleyNeighbourhoodsPage
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.regiofoodvalley.pages.regio.RegioFoodValleyRegioPage

val regiofoodvalleyHomeMenuItem = MenuItem.Simple(
    RoutedMenuItem(
        path = "/",
        label = LocalizedText(en = "Home", nl = "Thuis"),
        pageComponent = { RegioFoodValleyHomePage() }
    )
)
val regiofoodvalleyRegioMenuItem = MenuItem.Simple(
    RoutedMenuItem(
        label = LocalizedText(nl = "Regio"),
        pageComponent = { RegioFoodValleyRegioPage() }
    )
)

val regiofoodvalleyBusinessParksMenuItem = MenuItem.Simple(
    RoutedMenuItem(
        label = LocalizedText(nl = "Bedrijventerreinen"),
        pageComponent = { RegioFoodValleyBusinessParksPage() }
    )
)

val regiofoodvalleyNeighbourhoodsMenuItem = MenuItem.Simple(
    RoutedMenuItem(
        label = LocalizedText(nl = "Woonwijken"),
        pageComponent = { RegioFoodValleyNeighbourhoodsPage() }
    )
)


val regiofoodvalleyMenu = listOf(
    regiofoodvalleyHomeMenuItem,
    regiofoodvalleyRegioMenuItem,
    regiofoodvalleyBusinessParksMenuItem,
    regiofoodvalleyNeighbourhoodsMenuItem
)