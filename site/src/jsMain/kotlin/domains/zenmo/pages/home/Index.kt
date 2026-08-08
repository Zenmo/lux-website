package energy.lux.frontend.domains.zenmo.pages.home

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.components.layouts.ZenmoPageLayout
import energy.lux.frontend.domains.zenmo.pages.home.clients.ClientsSection
import energy.lux.frontend.domains.zenmo.pages.home.contact.ContactSection
import energy.lux.frontend.domains.zenmo.pages.home.hero.ZenmoHero
import energy.lux.frontend.domains.zenmo.pages.home.projects.FeaturedProjectsSection
import energy.lux.frontend.domains.zenmo.pages.home.what_we_do.WhatWeDoSection
import energy.lux.frontend.domains.zenmo.sections.nav_header.zenmoHomeMenuItem

@Composable
fun HomePage() {
    ZenmoPageLayout(zenmoHomeMenuItem.route.label) {
        ZenmoHero()
        WhatWeDoSection()
        FeaturedProjectsSection()
        ClientsSection()
        ContactSection()
    }
}