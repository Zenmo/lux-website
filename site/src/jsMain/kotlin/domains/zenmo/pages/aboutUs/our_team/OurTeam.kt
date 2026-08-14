package energy.lux.frontend.domains.zenmo.pages.aboutUs.our_team

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.core.models.ZenmoTeamMember
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.components.layouts.ZenmoPageLayout
import energy.lux.frontend.domains.zenmo.pages.models.constrainedWidth
import energy.lux.frontend.domains.zenmo.sections.nav_header.zenmoTeamMenuItem
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.P


@Composable
fun OurTeamPage() {
    ZenmoPageLayout(zenmoTeamMenuItem.route.label) {
        SectionContainer(
            Modifier.backgroundColor(SitePalette.light.overlay)
        ) {
            Column(
                Modifier.gap(0.5.cssRem)
                    .constrainedWidth(60.percent)
                    .textAlign(TextAlign.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                P(Modifier.color(SitePalette.light.primary).toAttrs()) {
                    LangText(
                        en = "Our Team",
                        nl = "Ons Team",
                    )
                }
                HeaderText(
                    enText = "Meet the people behind Zenmo",
                    nlText = "Ontmoet de mensen achter Zenmo",
                    modifier = Modifier
                        .textAlign(TextAlign.Center),
                )
            }
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