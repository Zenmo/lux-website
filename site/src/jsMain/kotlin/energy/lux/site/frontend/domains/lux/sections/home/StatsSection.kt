package energy.lux.site.frontend.domains.lux.sections.home

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.components.widgets.SectionContainerStyle
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.styles.verticalLinearBackground
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.font.BodyTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P


val StatsSectionContainerStyleVariant = SectionContainerStyle.addVariant {

    Breakpoint.ZERO {
        Modifier.Companion.padding(leftRight = 15.px, topBottom = 30.px)
    }
    Breakpoint.SM {
        Modifier.Companion.padding(leftRight = 15.px, topBottom = 30.px)
    }
    Breakpoint.MD {
        Modifier.Companion.padding(leftRight = 120.px, topBottom = 30.px)
    }
    Breakpoint.LG {
        Modifier.Companion.padding(leftRight = 250.px, topBottom = 50.px)
    }
    Breakpoint.XL {
        Modifier.Companion.padding(leftRight = 250.px, topBottom = 50.px)
    }
}

@OptIn(DelicateApi::class)
@Composable
fun StatsSection(
    breakpoint: Breakpoint
) {
    SectionContainer(
        variant = StatsSectionContainerStyleVariant,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalLinearBackground()
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .flexWrap(FlexWrap.Wrap)
                .thenIf(breakpoint >= Breakpoint.MD, Modifier.gap(2.cssRem)),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            for (stat in StatItem.entries) {
                StatsCard(stat)
            }
        }
    }
}

enum class StatItem(
    val value: String,
    val description: LocalizedText,
) {
    WAITING_COMPANIES(
        value = "20k+",
        description = LocalizedText(
            en = "Dutch companies waiting for grid capacity",
            nl = "Nederlandse bedrijven die wachten op netcapaciteit",
        )
    ),

    UNUSED_CAPACITY(
        value = "80%",
        description = LocalizedText(
            en = "Unused grid capacity on average that LUX can help to unlock",
            nl = "Gemiddelde ongebruikte netcapaciteit die met LUX benut kan worden",
        )
    ),

    SOCIETAL_SAVINGS(
        value = "220",
        description = LocalizedText(
            en = "Billion potential societal savings in the Netherlands alone",
            nl = "Miljard aan potentiële besparingen voor de samenleving, alleen al in Nederland",
        )
    );
}


@Composable
fun StatsCard(statItem: StatItem) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .flex(1, 0, 0.percent)
            .color(Colors.White)
    ) {
        HeaderText(
            enText = statItem.value,
            nlText = statItem.value,
            modifier = Modifier.margin(0.cssRem)
        )

        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier.width(90.percent)
        ) {
            P(
                TextStyle.toModifier(BodyTextStyle)
                    .opacity(0.8)
                    .textAlign(TextAlign.Center)
                    .toAttrs()
            ) {
                LangText(
                    en = statItem.description.en,
                    nl = statItem.description.nl
                )
            }
        }
    }
}