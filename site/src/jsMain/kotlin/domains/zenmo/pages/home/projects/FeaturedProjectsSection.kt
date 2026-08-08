package energy.lux.frontend.domains.zenmo.pages.home.projects

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.icons.mdi.MdiArrowRightAlt
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.extendedBy
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.sections.nav_header.zenmoProjectsMenuItem
import energy.lux.frontend.domains.zenmo.widgets.button.PrimaryButton
import energy.lux.frontend.theme.SitePalette
import energy.lux.frontend.theme.styles.OutlinePrimaryButtonStyle
import org.jetbrains.compose.web.css.AlignSelf
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

private val featuredProjects = listOf(
    ProjectItem(
        imageUrl = "/zenmo/images/projects/project1.jpg",
        categoryText = LocalizedText(en = "Battery Storage", nl = "Batterijopslag"),
    ),
    ProjectItem(
        imageUrl = "/zenmo/images/projects/project2.jpg",
        categoryText = LocalizedText(en = "Innovation", nl = "Innovatie"),
    ),
    ProjectItem(
        imageUrl = "/zenmo/images/projects/project3.jpg",
        categoryText = LocalizedText(en = "Battery Storage", nl = "Batterijopslag"),
    ),
)

@Composable
fun FeaturedProjectsSection() {
    SectionContainer(
        horizontalAlignment = Alignment.Start,
    ) {
        val ctx = rememberPageContext()
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
        PrimaryButton(
            enText = "All our projects",
            nlText = "Alle projecten",
            icon = { MdiArrowRightAlt() },
            onClick = {
                ctx.router.navigateTo(zenmoProjectsMenuItem.route.path)
            },
            modifier = TextButtonStyle.toModifier()
                .alignSelf(AlignSelf.FlexEnd)

        )
    }
}

val TextButtonStyle = OutlinePrimaryButtonStyle.extendedBy {
    base { Modifier.border(0.px) }
    hover {
        Modifier
            .backgroundColor(SitePalette.light.overlay)
            .color(SitePalette.light.primary)
    }
}