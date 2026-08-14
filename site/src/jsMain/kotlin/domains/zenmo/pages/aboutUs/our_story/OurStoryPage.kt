package energy.lux.frontend.domains.zenmo.pages.aboutUs.our_story

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.lux.components.HorizontalLine
import energy.lux.frontend.domains.zenmo.components.layouts.ZenmoPageLayout
import energy.lux.frontend.domains.zenmo.pages.aboutUs.our_story.components.ContentSection
import energy.lux.frontend.domains.zenmo.pages.aboutUs.our_story.components.MilestoneSection
import energy.lux.frontend.domains.zenmo.pages.aboutUs.our_story.components.MissionSection
import energy.lux.frontend.domains.zenmo.pages.aboutUs.our_story.components.OurStoryHero
import energy.lux.frontend.domains.zenmo.sections.nav_header.zenmoStoryMenuItem

@Composable
fun OurStoryPage() {
    ZenmoPageLayout(zenmoStoryMenuItem.route.label) {
        OurStoryHero()
        MissionSection()
        HorizontalLine()
        ContentSection()
        MilestoneSection()
    }
}