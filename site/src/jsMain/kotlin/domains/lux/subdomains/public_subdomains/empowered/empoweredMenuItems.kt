package energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered

import energy.lux.frontend.core.models.MenuItem
import energy.lux.frontend.core.models.RoutedMenuItem
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.core.model.subdomain.empowered
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.pages.Bronckhorst
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.pages.NijmegenHengstdal
import energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.pages.empowered.EmpoweredIndex
import energy.lux.frontend.pages.SiteGlobals

val empoweredDomain = "${empowered.subdomain}.${SiteGlobals.LUX_DOMAIN}"
val empoweredHomeMenuItem = MenuItem.Simple(
    RoutedMenuItem(
        path = "/", label = LocalizedText("EmPowerED", "EmPowerED"),
        pageComponent = { EmpoweredIndex() })
)

val bronckhorstMenuItem = MenuItem.Simple(
    RoutedMenuItem(
        label = LocalizedText("Bronckhorst", "Bronckhorst"),
        pageComponent = { Bronckhorst() })
)

val nijmegenHengstdalMenuItem = MenuItem.Simple(
    RoutedMenuItem(
        label = LocalizedText("Nijmegen Hengstdal", "Nijmegen Hengstdal"),
        pageComponent = { NijmegenHengstdal() })
)

val empoweredMenuItems = listOf(
    empoweredHomeMenuItem,
    bronckhorstMenuItem,
    nijmegenHengstdalMenuItem
)