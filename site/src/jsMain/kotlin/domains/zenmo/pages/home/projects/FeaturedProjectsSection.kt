package energy.lux.frontend.domains.zenmo.pages.home.projects

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiArrowRightAlt
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.theme.font.LabelTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.pages.projects.holonProject
import energy.lux.frontend.domains.zenmo.pages.projects.isieProject
import energy.lux.frontend.domains.zenmo.pages.projects.neonProject
import energy.lux.frontend.domains.zenmo.sections.nav_header.zenmoProjectsMenuItem
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.AlignSelf
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.A

private val featuredProjects = listOf(
    isieProject,
    holonProject,
    neonProject,
)

@Composable
fun FeaturedProjectsSection() {
    SectionContainer(
        horizontalAlignment = Alignment.Start,
    ) {
        HeaderText(
            enText = "Featured Current Projects",
            nlText = "Actuele Uitgelichte Projecten"
        )
        SimpleGrid(
            numColumns(base = 1, md = 2, lg = 3),
            modifier = Modifier.gap(1.5.cssRem).fillMaxWidth(),
        ) {
            featuredProjects.forEach { ProjectCard(it) }
        }
        A(
            href = zenmoProjectsMenuItem.route.path,
            attrs = TextStyle.toModifier(LabelTextStyle)
                .display(DisplayStyle.Flex)
                .alignItems(AlignItems.Center)
                .alignSelf(AlignSelf.FlexEnd)
                .color(SitePalette.light.primary)
                .gap(0.25.cssRem)
                .textDecorationLine(TextDecorationLine.None)
                .toAttrs(),
        ) {
            LangText(
                en = "All our projects",
                nl = "Alle projecten",
            )
            MdiArrowRightAlt()
        }
    }
}