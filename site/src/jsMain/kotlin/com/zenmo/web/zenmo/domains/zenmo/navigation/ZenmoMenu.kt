package com.zenmo.web.zenmo.domains.zenmo.navigation

import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.pages.isLocalOrPreviewEnvironment

object ZenmoMenu {
    val items = buildList {
        add(MenuItem.Simple(path = "/", title = LocalizedText(en = "Home", nl = "Thuis")))
        add(
            MenuItem.Simple(
                title = LocalizedText(
                    en = "What we do",
                    nl = "Wat we doen"
                )
            )
        )
        add(
            MenuItem.Simple(
                title = LocalizedText(
                    en = "Customers",
                    nl = "Klanten"
                )
            )
        )
        add(
            MenuItem.WithSubs(
                title = LocalizedText(en = "About us", nl = "Over ons"),
                subItems = listOf(
                    MenuItem.Simple(title = LocalizedText(en = "Our Team", nl = "Ons Team")),
                    MenuItem.Simple(title = LocalizedText(en = "Jobs", nl = "Banen")),
                    MenuItem.Simple(title = LocalizedText(en = "History", nl = "Geschiedenis")),
                )
            ).withGeneratedPaths()
        )
        add(
            MenuItem.Simple(
                title = LocalizedText(en = "Contact", nl = "Contact")
            )
        )

        if (isLocalOrPreviewEnvironment()) {
            add(
                MenuItem.Simple(
                    title = LocalizedText(en = "Component Demo", nl = "Component Demo")
                )
            )
        }
    }
}