package energy.lux.frontend.domains.zenmo.pages.aboutUs.our_team

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.core.models.ZenmoTeamMember
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.lux.widgets.headings.SubHeaderText
import energy.lux.frontend.domains.zenmo.components.layouts.ZenmoPageLayout
import energy.lux.frontend.domains.zenmo.pages.models.constrainedWidth
import energy.lux.frontend.domains.zenmo.sections.nav_header.zenmoTeamMenuItem
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent


@Composable
fun OurTeamPage() {
    ZenmoPageLayout(zenmoTeamMenuItem.route.label) {
        SectionContainer(
            Modifier.backgroundColor(SitePalette.light.overlay)
        ) {
            SubHeaderText(
                enText = "Our Team",
                nlText = "Ons Team",
            )
            HeaderText(
                enText = "Meet the lovely people behind Zenmo",
                nlText = "Ontmoet de geweldige mensen achter Zenmo",
                modifier = Modifier
                    .constrainedWidth(70.percent)
                    .textAlign(TextAlign.Center),
            )
            TeamMembers()
        }
    }
}


@Composable
private fun TeamMembers() {
    SimpleGrid(
        numColumns(base = 1, sm = 2, md = 2, lg = 3, xl = 4),
        modifier = Modifier.gap(2.cssRem)
            .constrainedWidth(90.percent),
    ) {
        ZenmoTeamMember.entries.forEach { TeamMemberCard(it) }
    }
}