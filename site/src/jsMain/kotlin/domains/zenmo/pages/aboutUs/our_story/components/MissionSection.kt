package energy.lux.frontend.domains.zenmo.pages.aboutUs.our_story.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.pages.models.constrainedWidth
import energy.lux.frontend.theme.SiteFluidSpacing
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.P

@Composable
fun MissionSection() {
    SectionContainer(
        modifier = Modifier.textAlign(TextAlign.Center)
            .constrainedWidth(60.percent)
            .padding(
                leftRight = SiteFluidSpacing.current.horizontalPadding,
                top = 1.cssRem,
                bottom = SiteFluidSpacing.current.verticalPadding
            ),
    ) {
        HeaderText(
            enText = "We speed up the energy transition",
            nlText = "Wij versnellen de energietransitie",
            modifier = Modifier.textAlign(TextAlign.Center),
        )
        P {
            LangText(
                en = """
                    The renewable energy transition is coming no matter what. But how soon it comes makes all the
                    difference for humanity and nature in the Netherlands and elsewhere. The transition to renewable
                    energy is a complex puzzle. We think that our interactive models provide the insight that is needed
                    to face this challenge. 
                """.trimIndent(),
                nl = """
                    De duurzaamheidstransitie komt er hoe dan ook aan. Maar hoe snel ze komt maakt een groot verschil
                    voor mens en natuur in Nederland en daarbuiten. De transitie naar duurzame energie en mobiliteit is
                    een complexe puzzel. Wij denken dat onze interactieve modellen het inzicht geven dat nodig is om
                    deze uitdaging aan te gaan.
                """.trimIndent(),
            )
            Br { }
            LangText(
                en = """
                    In this way, Zenmo wants to accelerate the renewable energy transition as much as possible.
                """.trimIndent(),
                nl = """
                    Zo wil Zenmo de duurzaamheidstransitie maximaal versnellen.
                """.trimIndent(),
            )
        }
    }
}