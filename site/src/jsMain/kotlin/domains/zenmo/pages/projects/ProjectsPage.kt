package energy.lux.frontend.domains.zenmo.pages.projects

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.components.layouts.ZenmoPageLayout
import energy.lux.frontend.domains.zenmo.pages.models.constrainedWidth
import energy.lux.frontend.domains.zenmo.sections.nav_header.zenmoProjectsMenuItem


@Composable
fun ProjectsPage() {
    ZenmoPageLayout(zenmoProjectsMenuItem.route.label) {
        SectionContainer(
            modifier = Modifier.constrainedWidth()
        ) {
            HeaderText(
                enText = "Our Projects", nlText = "Onze Projecten",
                modifier = Modifier.textAlign(TextAlign.Center)
            )
            ProjectsListSection()
        }
    }
}

@Composable
private fun ProjectsListSection() {
    Column {
        allProjects.forEachIndexed { index, project ->
            val reversed = index % 2 != 0
            ProjectRowCard(item = project, reversed = reversed)
        }
    }
}