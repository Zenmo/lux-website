package energy.lux.frontend.domains.zenmo.sections.nav_header

import energy.lux.frontend.core.models.MenuItem
import energy.lux.frontend.core.models.RoutedMenuItem
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.pages.ComponentDemoPage
import energy.lux.frontend.domains.zenmo.pages.ContactPage
import energy.lux.frontend.domains.zenmo.pages.CustomersPage
import energy.lux.frontend.domains.zenmo.pages.HomePage
import energy.lux.frontend.domains.zenmo.pages.WhatPage
import energy.lux.frontend.domains.zenmo.pages.aboutUs.OurTeamPage
import energy.lux.frontend.pages.isLocalOrPreviewEnvironment

val zenmoNavMenu = buildList {
    add(
        MenuItem.Simple(
            route = RoutedMenuItem(
                path = "/",
                label = LocalizedText(en = "Home", nl = "Thuis"),
                pageComponent = { HomePage() }
            )
        )
    )
    add(
        MenuItem.Simple(
            RoutedMenuItem(
                label = LocalizedText(
                    en = "What we do",
                    nl = "Wat we doen"
                ),
                pageComponent = { WhatPage() }
            )
        )
    )
    add(
        MenuItem.Simple(
            RoutedMenuItem(
                label = LocalizedText(
                    en = "Customers",
                    nl = "Klanten"
                ),
                pageComponent = { CustomersPage() }
            )
        )
    )
    add(
        MenuItem.WithSubs(
            title = LocalizedText(en = "About us", nl = "Over ons"),
            subItems = listOf(
                MenuItem.Simple(
                    route = RoutedMenuItem(
                        label = LocalizedText(en = "Our Team", nl = "Ons Team"),
                        pageComponent = { OurTeamPage() }
                    )
                ),
                MenuItem.Simple(
                    route = RoutedMenuItem(
                        label = LocalizedText(en = "Jobs", nl = "Banen"),
                        pageComponent = { } // todo add a jobs page
                    )
                ),

                MenuItem.Simple(
                    route = RoutedMenuItem(
                        label = LocalizedText(en = "History", nl = "Geschiedenis"),
                        pageComponent = { } // todo add a page for zenmo history
                    )
                ),
            )
        )
    )
    add(
        MenuItem.Simple(
            route = RoutedMenuItem(
                label = LocalizedText(en = "Contact", nl = "Contact"),
                pageComponent = { ContactPage() }
            )
        )
    )

    if (isLocalOrPreviewEnvironment()) {
        add(
            MenuItem.Simple(
                route = RoutedMenuItem(
                    label = LocalizedText(en = "Component Demo", nl = "Component Demo"),
                    pageComponent = { ComponentDemoPage() }
                )
            )
        )
    }
}