package energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden

import energy.lux.frontend.core.models.MenuItem
import energy.lux.frontend.core.models.RoutedMenuItem
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.sections.application_fields.DrechtstedenProjectArea
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.pages.DrechtstedenHomePage

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
                    pageComponent = field.pageComponent,
                )
            )
        }
    )
}
