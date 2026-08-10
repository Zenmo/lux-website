package energy.lux.frontend.domains.zenmo.pages.home.hero

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.mdi.MdiArrowRightAlt
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.domains.lux.styles.ResponsiveFlexStyle
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.widgets.button.PrimaryButton
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P

@Composable
fun ZenmoHero() {
    SectionContainer {
        Div(
            ResponsiveFlexStyle.toModifier().toAttrs()
        ) {
            HeroText()
            Image(
                src = "/zenmo/images/duurzaam-Nederland-met-schaduw.png",
                alt = "Zenmo illustration",
                modifier = HeroIllustrationStyle.toModifier()
            )
        }
    }
}

@Composable
private fun HeroText() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(1.cssRem),
    ) {
        HeaderText(
            enText = "Accelerating the Energy Transition",
            nlText = "De Energietransitie Versnellen",
        )
        P{
            LangText(
                en = """
                    Zenmo connects companies, grid operators, governments, and knowledge institutions to 
                    cost-effectively accelerate the transition from fossil to sustainable energy through smart 
                    decentralized solutions.
                """.trimIndent(),
                nl = """
                    Zenmo verbindt bedrijven, netbeheerders, overheden en kennisinstellingen om de overgang van 
                    fossiele naar duurzame energie op een kosteneffectieve manier te versnellen door middel van slimme, 
                    gedecentraliseerde oplossingen.
                """.trimIndent()
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(1.cssRem),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            PrimaryButton(
                enText = "Explore Our Work",
                nlText = "Bekijk Ons Werk",
                icon = { MdiArrowRightAlt() },
            )
            PrimaryButton(
                modifier = GetInTouchButtonStyle.toModifier(),
                enText = "Get in Touch",
                nlText = "Neem Contact Op",
            )
        }
    }
}