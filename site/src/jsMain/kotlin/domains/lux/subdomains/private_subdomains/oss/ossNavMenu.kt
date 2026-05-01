package domains.lux.subdomains.private_subdomains.oss

import energy.lux.frontend.core.models.MenuItem
import energy.lux.frontend.core.models.RoutedMenuItem
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.pages.OssIndex

val ossNavMenu = listOf(
    MenuItem.Simple(
        RoutedMenuItem(
            path = "/",
            label = LocalizedText(en = "Home", nl = "Thuis"),
            pageComponent = { OssIndex() }
        )
    )
)