package energy.lux.frontend.domains.lux.subdomains.public_subdomains.brabant.components

import energy.lux.frontend.core.models.MenuItem
import energy.lux.frontend.core.models.RoutedMenuItem
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.brabant.pages.Brabant

val brabantHome = MenuItem.Simple(
    RoutedMenuItem(
        path = "/",
        label = LocalizedText("Brabant"),
        pageComponent = { Brabant() }
    )
)

val brabantNavMenu = listOf(
    brabantHome
)