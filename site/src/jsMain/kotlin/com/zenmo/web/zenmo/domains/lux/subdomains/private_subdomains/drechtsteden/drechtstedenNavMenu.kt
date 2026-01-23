package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden

import com.zenmo.web.zenmo.core.models.MenuItem
import com.zenmo.web.zenmo.core.models.RoutedMenuItem
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.DrechtstedenProjectArea
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages.DrechtstedenHomePage

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
