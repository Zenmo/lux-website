package energy.lux.frontend.domains.zenmo.pages.aboutUs

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.layouts.PageLayout
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.components.widgets.SectionContainerStyle
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.lux.widgets.headings.SubHeaderText
import energy.lux.frontend.domains.zenmo.sections.home.LuxProductsTextHeaderStyle
import energy.lux.frontend.domains.zenmo.sections.team.TeamCard
import energy.lux.frontend.domains.zenmo.sections.team.ZenmoTeam
import energy.lux.frontend.theme.toSitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent


val OurTeamContainerVariant = SectionContainerStyle.addVariant {
    base {
        Modifier
            .backgroundColor(colorMode.toSitePalette().overlay)
    }
}

@Composable
fun OurTeamPage() {
    PageLayout("Our Team") {
        SectionContainer {
            Column(
                modifier = LuxProductsTextHeaderStyle.toModifier().fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SubHeaderText(
                    enText = "Our Team",
                    nlText = "Onze Team",
                )
                HeaderText(
                    enText = "Meet the lovely people behind Zenmo",
                    nlText = "Ontmoet de geweldige mensen achter Zenmo",
                    modifier = Modifier
                        .width(50.percent)
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
        numColumns(base = 1, sm = 2, md = 3, lg = 3, xl = 3),
        modifier = Modifier.gap(1.cssRem).fillMaxWidth().margin(bottom = 5.cssRem),
    ) {
        ZenmoTeam.entries.forEach { TeamCard(it) }
    }
}