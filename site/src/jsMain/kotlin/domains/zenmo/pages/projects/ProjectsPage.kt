package energy.lux.frontend.domains.zenmo.pages.projects

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.components.layouts.ZenmoPageLayout
import energy.lux.frontend.domains.zenmo.pages.models.constrainedWidth
import energy.lux.frontend.domains.zenmo.sections.nav_header.zenmoProjectsMenuItem
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent


@Composable
fun ProjectsPage() {
    ZenmoPageLayout(zenmoProjectsMenuItem.route.label) {
        ProjectsHeaderText()
        ProjectsListSection()
    }
}

@Composable
private fun ProjectsHeaderText() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.textAlign(TextAlign.Center)
    ) {
        HeaderText(enText = "Our Projects", nlText = "Onze Projecten")
    }
}

@Composable
private fun ProjectsListSection() {
    SectionContainer(
        modifier = Modifier
            .constrainedWidth()
            .gap(0.cssRem)
    ) {
        allProjects.forEachIndexed { index, project ->
            val reversed = index % 2 != 0
            ProjectRowCard(item = project, reversed = reversed)
        }
    }
}