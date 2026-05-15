package energy.lux.frontend.domains.zenmo.sections.nav_header

import energy.lux.frontend.core.models.MenuItem
import energy.lux.frontend.core.models.RoutedMenuItem
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.pages.ComponentDemoPage
import energy.lux.frontend.domains.zenmo.pages.ComingSoon
import energy.lux.frontend.domains.zenmo.pages.ContactPage
import energy.lux.frontend.domains.zenmo.pages.HomePage
import energy.lux.frontend.domains.zenmo.pages.aboutUs.OurTeamPage
import energy.lux.frontend.pages.isLocalOrPreviewEnvironment


val zenmoHomeMenuItem = MenuItem.Simple(
    route = RoutedMenuItem(
        path = "/",
        label = LocalizedText(en = "Home", nl = "Thuis"),
        pageComponent = { HomePage() }
    )
)

val zenmoProjectsMenuItem = MenuItem.Simple(
    RoutedMenuItem(
        label = LocalizedText(
            en = "Projects",
            nl = "Projecten"
        ),
        pageComponent = { ComingSoon() }
    )
)
val zenmoClientsMenuItem = MenuItem.Simple(
    route = RoutedMenuItem(
        label = LocalizedText(en = "Our Clients", nl = "Onz Klanten"),
        pageComponent = { ComingSoon() }
    )
)

val zenmoAboutUsMenuItem = MenuItem.WithSubs(
    title = LocalizedText(en = "About us", nl = "Over ons"),
    subItems = listOf(
        MenuItem.Simple(
            route = RoutedMenuItem(
                label = LocalizedText(en = "Our Story", nl = "Ons Verhaal"),
                pageComponent = { ComingSoon() }
            )
        ),
        MenuItem.Simple(
            route = RoutedMenuItem(
                label = LocalizedText(en = "Our Team", nl = "Ons Team"),
                pageComponent = { OurTeamPage() }
            )
        ),
        MenuItem.Simple(
            route = RoutedMenuItem(
                label = LocalizedText(en = "Working at", nl = "Banen"),
                pageComponent = { ComingSoon() }
            )
        ),
    )
)

val contactZenmoMenuItem = MenuItem.Simple(
    route = RoutedMenuItem(
        label = LocalizedText(en = "Contact", nl = "Contact"),
        pageComponent = { ContactPage() }
    )
)

val componentDemoMenuItem = MenuItem.Simple(
    route = RoutedMenuItem(
        label = LocalizedText(en = "Component Demo", nl = "Component Demo"),
        pageComponent = { ComponentDemoPage() }
    )
)


val zenmoNavMenu = buildList {
    add(zenmoProjectsMenuItem)
    add(zenmoClientsMenuItem)
    add(zenmoAboutUsMenuItem)
    add(contactZenmoMenuItem)

    if (isLocalOrPreviewEnvironment()) {
        add(componentDemoMenuItem)
    }
}