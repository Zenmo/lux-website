package energy.lux.frontend.domains.zenmo.pages.aboutUs.our_story.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.mdi.IconStyle
import com.varabyte.kobweb.silk.components.icons.mdi.MdiBolt
import com.varabyte.kobweb.silk.components.icons.mdi.MdiNavigation
import com.varabyte.kobweb.silk.components.icons.mdi.MdiPlace
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.theme.shapes.Circle
import com.varabyte.kobweb.silk.theme.shapes.clip
import energy.lux.frontend.components.widgets.InlineLink
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.domains.lux.styles.responsiveGap
import energy.lux.frontend.domains.lux.widgets.headings.SubHeaderText
import energy.lux.frontend.domains.zenmo.pages.models.constrainedWidth
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ContentSection() {
    SectionContainer {
        SimpleGrid(
            numColumns(base = 1, lg = 2),
            modifier = Modifier
                .responsiveGap()
                .constrainedWidth(),
        ) {
            HowItStartedColumn()
            OurModelsColumn()
        }
    }
}

@Composable
private fun OurModelsColumn() {
    Column {
        SubHeaderText(enText = "Our models", nlText = "Onze modellen")
        P {
            LangText(
                en = """
                    The switch from fossil to sustainable energy is perhaps the greatest adventure in the history of
                    human kind. And we are in a hurry, because fossil fuels are causing climate change, disrupting
                    the ecosystem on which life on this unique planet depends. 
                """.trimIndent(),
                nl = """
                    De overstap van fossiele energie naar duurzame energie is misschien wel het grootste avontuur uit
                    de geschiedenis van de mensheid. En we hebben haast, want fossiele brandstoffen zorgen voor
                    klimaatverandering, waardoor het ecosysteem waar het leven op deze unieke planeet van afhankelijk
                    is, wordt verstoord. 
                """.trimIndent(),
            )
            Br { }
            Br { }
            LangText(
                en = """
                    Awareness of the severity of this problem is growing, but many entrepreneurs and policymakers find 
                    it difficult to assess what's the best thing to do. That is why Zenmo translates the latest 
                    scientific insights directly into practice. 
                """.trimIndent(),
                nl = """
                     Het bewustzijn van de ernst van dit probleem neemt toe maar veel ondernemers en beleidsmakers 
                     vinden het moeilijk in te schatten wat zij het beste kunnen doen. Daarom brengt Zenmo de laatste 
                     wetenschappelijke inzichten direct over naar de praktijk. 
                """.trimIndent()
            )
            Br { }
            LangText(
                en = """
                    In doing so, we use the newest modelling techniques. We feed our models with geographic
                    information (GIS) and other relevant data to create realistic simulations of existing areas.
                """.trimIndent(),
                nl = """
                    Daarbij maken we gebruik van de nieuwste modelleertechnieken. Onze modellen vullen we met 
                    geografische informatie (GIS) en andere relevante data om realistische simulaties te maken van 
                    bestaande gebieden.
                """.trimIndent()
            )
        }
        WhatWeDoFeatureCards()
    }
}

@Composable
private fun HowItStartedColumn() {
    Column {
        SubHeaderText(enText = "How it started", nlText = "Hoe het begon")
        P {
            LangText(
                en = """
                    Zenmo was founded by Auke Hoekstra, Peter Hogeveen, professor Maarten Steinbuch, professor Geert
                    Verbong and Peter Molengraaf. From the vantage point of their own expertise, they each saw that
                    the transition can happen much faster """.trimIndent(),
                nl = """
                    Zenmo is opgericht door Auke Hoekstra, Peter Hogeveen, professor Maarten Steinbuch, professor
                    Geert Verbong en Peter Molengraaf. Zij zagen elk binnen hun eigen expertisegebied dat we veel
                    sneller kunnen verduurzamen """.trimIndent(),
            )
            InlineLink(
                destinationUrl = "https://twitter.com/aukehoekstra/status/931869221386104832?lang=en",
                enLinkText = "than traditional organisations would have us believe",
                nlLinkText = "dan traditionele instanties ons willen doen geloven",
            )
            LangText(
                en = ". And so they researched ",
                nl = ". Dus zochten ze uit ",
            )
            InlineLink(
                destinationUrl = "https://www.hindawi.com/journals/complexity/2017/1967645/abs/",
                enLinkText = "the better way to make predictions about the transition",
                nlLinkText = "hoe je de transitie wel goed kan voorspellen",
            )
            Text(". ")
            Br { }
            Br { }
            LangText(
                en = """
                    But talk is cheap, and the logical next step was to go ahead and do it. That is how Zenmo
                    simulations came to be. The team has grown now. But we aim to grow much more in years to come.
                    Until everybody uses the models that show you that we can do it.
                """.trimIndent(),
                nl = """
                    Maar de beste stuurlui staan aan wal. Dus een logische volgende stap was om het dan ook
                    maar te gaan doen. Zo ontstond Zenmo simulations. Intussen is het team gegroeid. Maar ons doel
                    is om de komende jaren nog flink door te groeien. Net zo lang tot iedereen modellen gebruikt
                    die laten zien hoe het wél kan.
                """.trimIndent(),
            )
        }
    }
}

private data class FeatureCard(
    val icon: @Composable () -> Unit,
    val enText: String,
    val nlText: String
)

private val featureCards = listOf(
    FeatureCard(
        icon = { MdiNavigation(style = IconStyle.OUTLINED) },
        enText = "Navigate complex decisions",
        nlText = "Complexe keuzes navigeren",
    ),
    FeatureCard(
        icon = { MdiBolt(style = IconStyle.OUTLINED) },
        enText = "Scientific insights into practice",
        nlText = "Wetenschappelijke inzichten in de praktijk",
    ),
    FeatureCard(
        icon = { MdiPlace(style = IconStyle.OUTLINED) },
        enText = "Realistic simulations of real places",
        nlText = "Realistische simulaties van echte plaatsen",
    ),
)

@Composable
private fun WhatWeDoFeatureCards() {
    Row(
        modifier = Modifier.gap(1.cssRem)
            .margin(topBottom = 1.cssRem),
    ) {
        featureCards.forEach { card ->
            Column(
                modifier = Modifier
                    .padding(16.px)
                    .borderRadius(16.px)
                    .gap(0.5.cssRem)
                    .flex(1)
                    .fillMaxHeight(),
            ) {
                Box(
                    modifier = Modifier
                        .size(42.px)
                        .backgroundColor(SitePalette.light.primary.toRgb().copyf(alpha = 0.12f))
                        .color(SitePalette.light.primary)
                        .clip(Circle()),
                    contentAlignment = Alignment.Center,
                ) { card.icon() }
                LangText(en = card.enText, nl = card.nlText)
            }
        }
    }
}