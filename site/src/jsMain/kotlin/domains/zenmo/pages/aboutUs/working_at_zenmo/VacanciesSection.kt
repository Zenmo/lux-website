package energy.lux.frontend.domains.zenmo.pages.aboutUs.working_at_zenmo

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiArrowRightAlt
import com.varabyte.kobweb.silk.components.icons.mdi.MdiGroupOff
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLightbulb
import com.varabyte.kobweb.silk.components.icons.mdi.MdiNorthEast
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import com.varabyte.kobweb.silk.theme.shapes.Circle
import com.varabyte.kobweb.silk.theme.shapes.clip
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.domains.lux.styles.verticalLinearBackground
import energy.lux.frontend.domains.lux.widgets.headings.SubHeaderText
import energy.lux.frontend.domains.zenmo.pages.models.constrainedWidth
import energy.lux.frontend.domains.zenmo.sections.nav_header.contactZenmoMenuItem
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span

@Composable
fun VacanciesSection() {
    SectionContainer {
        SimpleGrid(
            numColumns(base = 1, md = 2),
            modifier = Modifier.gap(2.cssRem)
                .constrainedWidth(70.percent),
        ) {
            NoVacanciesCard()
            InternshipCard()
        }
    }
}

@Composable
private fun NoVacanciesCard() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .border(1.px, LineStyle.Solid, Colors.Black.copyf(alpha = 0.08f))
            .borderRadius(24.px)
            .padding(2.5.cssRem)
            .gap(1.5.cssRem),
    ) {
        Box(
            modifier = Modifier
                .size(48.px)
                .clip(Circle())
                .backgroundColor(SitePalette.light.primary.lightened(0.9f))
                .color(SitePalette.light.primary),
            contentAlignment = Alignment.Center,
        ) { MdiGroupOff() }
        SubHeaderText(
            enText = "No vacancies right now",
            nlText = "Geen vacatures op dit moment",
        )
        P(
            Modifier.flexGrow(1).toAttrs()
        ) {
            LangText(
                en = """
                    At the moment, we don’t have any vacancies, but we are always keen to meet people who share our 
                    interest in renewable energy.  
                """.trimIndent(),
                nl = """
                    Op dit moment staan er geen vacatures open maar wij zijn altijd geïnteresseerd in een kennismaking 
                    met mensen die onze belangstelling voor duurzame energie delen.  
                """.trimIndent(),
            )
        }
        Link(
            path = contactZenmoMenuItem.route.path,
            variant = UndecoratedLinkVariant.then(UncoloredLinkVariant),
        ) {
            Row(
                modifier = Modifier
                    .color(SitePalette.light.primary)
                    .fontWeight(FontWeight.Bold)
                    .gap(0.25.cssRem),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                LangText(en = "Get in touch", nl = "Neem contact op")
                MdiNorthEast()
            }
        }
    }
}

@Composable
private fun InternshipCard() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .verticalLinearBackground()
            .borderRadius(24.px)
            .padding(2.5.cssRem)
            .gap(1.5.cssRem),
    ) {
        Box(
            modifier = Modifier
                .size(48.px)
                .clip(Circle())
                .backgroundColor(Colors.White.copyf(alpha = 0.2f))
                .color(Colors.White),
            contentAlignment = Alignment.Center,
        ) {
            MdiLightbulb()
        }
        SubHeaderText(
            enText = "Master's internship",
            nlText = "Afstudeerstage",
            textColor = Colors.White,
        )
        P(
            Modifier
                .flexGrow(1)
                .color(Colors.White.copyf(alpha = 0.85f))
                .toAttrs()
        ) {
            LangText(
                en = """
                    We can usually make room for a master’s internship. Would you like to experience what it’s like to 
                    work in a small dynamic team? We are always on the lookout for motivated students who want to make 
                    the world a little better through their talent. 
                """.trimIndent(),
                nl = """
                    Voor een afstudeerstage hebben wij meestal wel ruimte. Wil je ervaren hoe het is om te werken in 
                    een klein dynamisch team? Wij zijn altijd op zoek naar enthousiaste studenten die de wereld een 
                    stukje beter willen maken met hun talent. 
                """.trimIndent(),
            )
        }
        Link(
            path = contactZenmoMenuItem.route.path,
            variant = UndecoratedLinkVariant.then(UncoloredLinkVariant),
        ) {
            Span(
                Modifier
                    .display(DisplayStyle.InlineBlock)
                    .backgroundColor(Colors.White)
                    .color(SitePalette.light.primary)
                    .padding(leftRight = 1.5.cssRem, topBottom = 0.625.cssRem)
                    .borderRadius(50.px)
                    .fontWeight(FontWeight.Bold)
                    .display(DisplayStyle.Flex)
                    .gap(0.25.cssRem)
                    .toAttrs()
            ) {
                LangText(en = "Talk to us", nl = "Neem contact op")
                MdiArrowRightAlt()
            }
        }
    }
}