package com.zenmo.web.zenmo.domains.lux.sections.nav_header

import com.zenmo.web.zenmo.core.models.MenuItem
import com.zenmo.web.zenmo.core.models.RoutedMenuItem
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.sections.about_us.AboutUs
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.lux.sections.luxmodels.LuxModels

val luxNavMenu = listOf(
    MenuItem.WithSubs(
        title = LocalizedText(en = "Application Areas", nl = "Toepassingsgebieden"),
        subItems = LuxApplicationArea.entries.map { field ->
            MenuItem.Simple(
                route = RoutedMenuItem(
                    path = field.path,
                    label = field.label,
                    pageComponent = field.pageComponent,
                ),
                descriptionParagraph = field.shortDescription
            )
        }
    ),
    MenuItem.Simple(
        route = RoutedMenuItem(
            label = LocalizedText(en = "Models", nl = "Modellen"),
            pageComponent = { LuxModels() }
        )
    ),
    MenuItem.Simple(
        route = RoutedMenuItem(
            label = LocalizedText(en = "About Us", nl = "Over Ons"),
            pageComponent = { AboutUs() }
        )
    )
)