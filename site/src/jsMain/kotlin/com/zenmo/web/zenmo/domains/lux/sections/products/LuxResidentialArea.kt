package com.zenmo.web.zenmo.domains.lux.sections.products

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.zenmo.web.zenmo.components.widgets.CaptionImageStyle
import com.zenmo.web.zenmo.components.widgets.ImageContentStyleVariant
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.CallToActionAnchorButton
import com.zenmo.web.zenmo.domains.lux.sections.DeEmphasizedTextStyle
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.font.LabelTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

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
    SectionContainer(
        variant = LuxSectionContainerStyleVariant,
    ) {
        val pMaxWidth = if (breakpoint < Breakpoint.MD) 100.percent else 80.percent
        Column {
            Row(
                modifier = LuxResRowStyle.toModifier(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Div(Modifier.fillMaxWidth().toAttrs()) {
                    HeaderText(
                        enText = "LUX Residential Area",
                        nlText = "LUX Residential Area",
                        modifier = LuxResHeaderTextStyle.toModifier()
                    )
                }

                Div(
                    Modifier.fillMaxWidth()
                        .toAttrs()
                ) {
                    P(
                        Modifier.textAlign(
                            if (breakpoint < Breakpoint.MD) TextAlign.Start else TextAlign.Right
                        ).margin(0.px).toAttrs()
                    ) {
                        LangText(
                            en = "LUX residential area allows you to immediately load all public data about a neighborhood and make it part of an interactive simulation.",
                            nl = "Met Lux Residential Area kunt u onmiddellijk alle openbare gegevens over een buurt laden en onderdeel maken van een interactieve simulatie."
                        )
                    }
                }
            }
        }
        //todo replace this with visual for this product
        Image(
            src = "/lux/images/horizon_img.jpg",
            alt = "horizon",
            variant = ImageContentStyleVariant,
            modifier = CaptionImageStyle.toModifier()
                .height(280.px)
        )
        Row(
            modifier = LuxResRowStyle.toModifier(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Div(
                Modifier.fillMaxWidth()
                    .toAttrs()
            ) {
                P(Modifier.margin(0.px).maxWidth(pMaxWidth).toAttrs()) {
                    LangText(
                        en = "This allows you to quickly gain insight into the situation in the neighborhood and what this means for different future scenarios. For example:",
                        nl = "Hierdoor kunt u snel inzicht krijgen in de situatie in de buurt en wat dit betekent voor verschillende toekomstscenario's. Bijvoorbeeld:"
                    )
                }
            }

            Div(Modifier.fillMaxWidth().toAttrs()) {
                SimpleGrid(
                    numColumns = numColumns(base = 2, md = 2, lg = 2, xl = 2),
                    modifier = Modifier.columnGap(1.cssRem).rowGap(1.5.cssRem)
                ) {
                    ScenarioExample.EXAMPLES.forEachIndexed { index, item ->
                        ScenarioExampleItem(
                            exampleNo = "0${index + 1}",
                            title = {
                                Span(
                                    TextStyle.toModifier(LabelTextStyle)
                                        .fontWeight(FontWeight.Bold)
                                        .margin(0.px)
                                        .toAttrs()
                                ) {
                                    LangText(
                                        en = item.enTitle,
                                        nl = item.nlTitle
                                    )
                                }
                            },
                            body = {
                                LangText(
                                    en = item.enExample,
                                    nl = item.enExample,
                                )
                            }
                        )
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .thenIf(
                    (breakpoint < Breakpoint.MD), Modifier
                        .display(DisplayStyle.Flex)
                        .flexDirection(FlexDirection.Column)
                        .gap(1.cssRem)
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Div(
                Modifier.fillMaxWidth()
                    .toAttrs()
            ) {
                H4(
                    Modifier
                        .margin(0.px)
                        .toAttrs()
                ) {
                    LangText(
                        en = "Data Synergy",
                        nl = "Gegevenssynergie"
                    )
                }
                P(Modifier.maxWidth(pMaxWidth).toAttrs()) {
                    LangText(
                        en = """
                            LUX residential area becomes more valuable as the grid operator is willing to share more 
                            data and as it is combined with other LUX products.
                        """.trimIndent(),
                        nl = """
                            De woonwijk van Lux wordt waardevoller naarmate de rasterbeheerder bereid is om meer 
                            gegevens te delen en omdat deze wordt gecombineerd met andere LUX -producten. 
                        """.trimIndent()
                    )
                }

                P(
                    Modifier.maxWidth(pMaxWidth)
                        .then(DeEmphasizedTextStyle.toModifier())
                        .fontSize(0.9.cssRem)
                        .toAttrs()
                ) {
                    LangText(
                        en = """
                            For example, there can often be a very productive interaction between energy hubs and 
                            residential areas because they need energy at different times. It is also easy to see in 
                            LUX municipality which neighborhoods together are suitable for a heat network.
                        """.trimIndent(),
                        nl = """
                            Er kan bijvoorbeeld vaak een zeer productieve interactie zijn tussen energiehubs en 
                            woonwijken omdat ze op verschillende tijdstippen energie nodig hebben. Het is ook 
                            gemakkelijk te zien in Lux -gemeente welke buurten samen geschikt zijn voor een warmtetwerk.
                        """.trimIndent()
                    )
                }
            }

            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomStart) {
                CallToActionAnchorButton {
                    LangText(
                        en = "Experience  ",
                        nl = "Ervaring "
                    )
                    Br {}
                    LangText(
                        en = "LUX today",
                        nl = "LUX vandaag "
                    )
                }
            }
        }
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