package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_res_area

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.DeEmphasizedTextStyle
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.components.ApplicationAreaVideo
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_res_area.components.GetStartedWithResBanner
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_res_area.components.ResAreaPersonalAdvice
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_res_area.components.ResHero
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_res_area.components.UniqueIntegration
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Span

val LuxResHeaderTextStyle = CssStyle {
    base { Modifier.margin(0.px) }

    Breakpoint.MD {
        Modifier.maxWidth(60.percent)
    }
    Breakpoint.LG {
        Modifier.maxWidth(80.percent)
    }

    Breakpoint.XL {
        Modifier.maxWidth(80.percent)
    }
}

val LuxResRowStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .display(DisplayStyle.Flex)
    }

    Breakpoint.ZERO {
        Modifier.flexDirection(FlexDirection.Column)
            .gap(1.cssRem)
    }
    Breakpoint.SM {
        Modifier.flexDirection(FlexDirection.Column)
            .gap(1.cssRem)
    }
    Breakpoint.MD {
        Modifier.flexDirection(FlexDirection.Row)
    }
    Breakpoint.LG {
        Modifier.flexDirection(FlexDirection.Row)
    }
    Breakpoint.XL {
        Modifier.flexDirection(FlexDirection.Row)
    }

    cssRule(":last-child") {
        Modifier.fillMaxSize()
            .alignItems(AlignItems.FlexEnd)
    }
}


@OptIn(DelicateApi::class)
@Composable
fun LuxResidentialArea() {
    val breakpoint = rememberBreakpoint()
    Column {
        ResHero()
        LuxSectionContainer(
            modifier = Modifier.background(SitePalette.light.overlay),
        ) {
            HeaderText(
                enText = "See it in action",
                nlText = "Bekijk het in actie"
            )

            //todo use resdential area video
            ApplicationAreaVideo(
                videoTitle = LocalizedText(
                    en = "LUX Residential Area Walkthrough",
                    nl = "LUX Woonwijk Rondleiding"
                ),
            )
            ResAreaPersonalAdvice()
        }
        UniqueIntegration()
        GetStartedWithResBanner()
    }
}

data class ScenarioExample(
    val enTitle: String,
    val nlTitle: String,
    val enExample: String,
    val nlExample: String,
) {
    companion object {
        val EXAMPLES = listOf(
            ScenarioExample(
                enTitle = "Neighborhood Infrastructure Overview",
                nlTitle = "Overzicht van de buurtinfrastructuur",
                enExample = "An overview of the neighborhood's infrastructure, including grid topology, heat pumps, solar panels, parking situations, space for batteries, and charging plazas.",
                nlExample = "Een overzicht van de infrastructuur van de buurt, inclusief netwerktopologie, warmtepompen, zonnepanelen, parkeersituaties, ruimte voor batterijen en oplaadpleinen."
            ),
            ScenarioExample(
                enTitle = "Heat Strategy Comparison",
                nlTitle = "Vergelijking van warmtestrategieën",
                enExample = "A comparison of individual heat pumps versus a heat network and which neighborhoods are suitable for what.",
                nlExample = "Een vergelijking van individuele warmtepompen versus een warmtenetwerk en welke buurten geschikt zijn voor wat."
            ),
            ScenarioExample(
                enTitle = "Energy Scenario Exploration",
                nlTitle = "Verkenning van energiescenario's",
                enExample = "Exploring in detail all possible energy transition scenarios in the district, including (neighborhood) batteries.",
                nlExample = "In detail alle mogelijke energiestransitiescenario's in het district verkennen, inclusief (buurt)batterijen."
            ),
            ScenarioExample(
                enTitle = "Interactive Planning & Engagement",
                nlTitle = "Interactieve planning & betrokkenheid",
                enExample = "Using the tool to support interactive workshops with local residents and grid operators.",
                nlExample = "Het gebruik van de tool ter ondersteuning van interactieve workshops met lokale bewoners en netbeheerders."
            )
        )
    }
}

@Composable
private fun ScenarioExampleItem(
    exampleNo: String,
    title: @Composable () -> Unit,
    body: @Composable () -> Unit,
) {
    Column(horizontalAlignment = Alignment.Start) {
        Span(
            DeEmphasizedTextStyle
                .toModifier()
                .fontSize(0.9.cssRem)
                .toAttrs()
        ) {
            LangText(
                en = "Example $exampleNo",
                nl = "Voorbeeld $exampleNo",
            )
        }
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier
                .height(60.px)
        ) {
            title()
        }
        Box(
            contentAlignment = Alignment.TopStart,
            modifier =
                DeEmphasizedTextStyle
                    .toModifier()
                    .fontSize(0.9.cssRem)
        ) {
            body()
        }
    }
}