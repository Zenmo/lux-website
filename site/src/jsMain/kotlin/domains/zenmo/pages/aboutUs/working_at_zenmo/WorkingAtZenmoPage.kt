package energy.lux.frontend.domains.zenmo.pages.aboutUs.working_at_zenmo

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.components.layouts.ZenmoPageLayout
import energy.lux.frontend.domains.zenmo.sections.nav_header.workingAtZenmoMenuItem

@Composable
fun WorkingAtZenmoPage() {
    ZenmoPageLayout(workingAtZenmoMenuItem.route.label) {
        WorkingHero()
        VacanciesSection()
    }
}