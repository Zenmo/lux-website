package com.zenmo.web.zenmo.domains.lux.sections.products

import androidx.compose.runtime.*
import androidx.compose.web.events.SyntheticMouseEvent
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.*
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.icons.mdi.MdiKeyboardArrowUp
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.zenmo.web.zenmo.components.widgets.ImageContent
import com.zenmo.web.zenmo.components.widgets.LangBlock
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.CallToActionAnchorButton
import com.zenmo.web.zenmo.domains.lux.sections.DeEmphasizedTextStyle
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.styles.HeaderBottomDividerLineStyle
import com.zenmo.web.zenmo.domains.lux.styles.TopDividerLineStyle
import com.zenmo.web.zenmo.domains.lux.subdomains.LuxSubdomains
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.font.LabelTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.dom.*

const val LUX_COMPANY_SECTION_ID = "lux-company"

@OptIn(DelicateApi::class)
@Composable
fun LuxCompany(
) {
    val breakpoint = rememberBreakpoint()
    Column {
        SectionContainer(
            modifier = Modifier.gap(5.cssRem).id(LUX_COMPANY_SECTION_ID).fillMaxWidth(),
            variant = LuxSectionContainerStyleVariant,
        ) {
            HeaderTextContent(breakpoint)
            LuxCompanyImages()
            Div(
                Modifier.fillMaxWidth()
                    .background(SitePalette.light.overlay)
                    .borderRadius(30.px)
                    .padding(
                        leftRight = if (breakpoint >= Breakpoint.MD) 10.cssRem else 2.cssRem,
                        topBottom = 2.cssRem
                    )
                    .display(DisplayStyle.Block)
                    .textAlign(TextAlign.Center)
                    .toAttrs()
            ) {
                P {
                    LangText(
                        en = """
                            We are currently also working on a battery configurator that will allow you to compare
                            and combine different installers and suppliers of hardware and software. We are looking
                            for customers who provide feedback in exchange for the free use of this that helps
                            improve the configurator.
                        """.trimIndent(),
                        nl = """
                            We zijn momenteel ook bezig met een batterijconfigurator waarmee je verschillende
                            installateurs en leveranciers van hardware en software kunt vergelijken en combineren.
                            We zoeken klanten die feedback geven in ruil voor het gratis gebruik van deze configurator
                            die helpt de configurator te verbeteren.
                        """.trimIndent()
                    )
                }
            }
            Row(
                // borrow this lux municipality row style because why not :)
                modifier = LuxRegionRowStyle.toModifier()
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                VideoAndActionContent(
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Div(
                    Modifier.fillMaxWidth().toAttrs()
                ) {
                    MoreAboutLuxCompany()
                }
            }

            Div(
                Modifier.fillMaxWidth().toAttrs()
            ) {
                CallToActionAnchorButton {
                    LangText(
                        en = "Interested",
                        nl = "Geïnteresseerd"
                    )
                    Br {}
                    LangText(
                        en = "in Demo/Costs?",
                        nl = "in Demo/Kosten?"
                    )
                }
            }
        }

        SectionContainer(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier =
                Modifier.position(Position.Relative)
                    .then(TopDividerLineStyle.toModifier())
                    .then(HeaderBottomDividerLineStyle.toModifier())
                    .background(SitePalette.light.overlay)
                    .padding(topBottom = 3.cssRem)
                    .textAlign(TextAlign.Center),
        ) {
            P(
                Modifier
                    .width(if (breakpoint >= Breakpoint.MD) 60.percent else 100.percent)
                    .toAttrs()
            ) {
                LangText(
                    en = """
                        Often even more space is created on the electricity grid when you start working together 
                        with other companies. That is why we also developed 
                    """.trimIndent(),
                    nl = """
                        Vaak wordt er zelfs nog meer ruimte op het elektriciteitsnet gecreëerd wanneer je gaat
                        samenwerken met andere bedrijven. Daarom hebben we ook 
                    """.trimIndent()
                )
                A(
                    href = "#$LUX_ENERGY_HUB_SECTION_ID",
                ) {
                    B { Text("LUX Energy Hub.") }
                }
            }
        }
    }
}

@Composable
private fun HeaderTextContent(breakpoint: Breakpoint) {
    Column(
        Modifier
            .alignItems(AlignItems.FlexStart)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        HeaderText(
            enText = "LUX Company",
            nlText = "LUX Company",
        )
        Div(
            Modifier
                .margin(right = if (breakpoint >= Breakpoint.MD) 20.percent else 0.percent)
                .toAttrs()
        ) {
            P {
                LangBlock(
                    en = {
                        Text(

                            """
                                Companies are increasingly switching to electrical appliances, but at the same time
                                more and more companies are being told by the grid operator that they cannot get the
                                power they need. Of course, a company can then move or generate its own very
                                expensive electricity with diesel generators, but 
                            """.trimIndent()
                        )
                        B { Text("LUX company") }
                        Text(" shows that much more is possible.")
                    },
                    nl = {
                        Text(
                            """
                                Bedrijven schakelen steeds vaker over op elektrische apparaten, maar tegelijkertijd
                                krijgen steeds meer bedrijven te horen van de netbeheerder dat ze de benodigde
                                stroom niet kunnen krijgen. Natuurlijk kan een bedrijf dan verhuizen of zelf heel
                                dure elektriciteit opwekken met dieselgeneratoren, maar 
                            """.trimIndent()
                        )
                        B { Text("LUX company") }
                        Text(" laat zien dat er veel meer mogelijk is.")
                    }
                )
            }
        }
        Div(
            DeEmphasizedTextStyle
                .toModifier()
                .fontSize(0.9.cssRem)
                .margin(left = if (breakpoint >= Breakpoint.MD) 25.percent else 0.percent)
                .toAttrs()
        ) {
            P {
                LangBlock(
                    en = {
                        Text(
                            """
                                For example, a company can grow without having to increase its grid connection by
                                installing a battery. A battery can also ensure that energy from your own solar panels is
                                used more and can earn money by trading on the energy market. Finally, the grid
                                operator will reward battery owners for preventing grid congestion in the future. With 
                            """.trimIndent()
                        )
                        B { Text("LUX company") }
                        Text(
                            """
                             , you can calculate in no time whether a battery is a good idea for your company based on
                              your own historical energy consumption and the future plans you set yourself.
                            """.trimIndent()
                        )
                    },
                    nl = {
                        Text(
                            """
                                Zo kan een bedrijf groeien zonder dat het zijn netaansluiting hoeft te vergroten door
                                een batterij te installeren. Een batterij kan er ook voor zorgen dat energie van je
                                eigen zonnepanelen beter wordt benut en kan geld verdienen door te handelen op de
                                energiemarkt. Tot slot zal de netbeheerder in de toekomst batterijbezitters belonen
                                voor het voorkomen van netcongestie. Met 
                            """.trimIndent()
                        )
                        B { Text("LUX company") }
                        Text(
                            """
                             , kun je in een mum van tijd berekenen of een batterij een goed idee is voor jouw bedrijf op 
                             basis van je eigen historische energieverbruik en de toekomstplannen die je zelf stelt.
                            """.trimIndent()
                        )
                    }
                )
            }
        }
    }
}

// todo replce with lux company images
private val listOfLuxCompanyImages = listOf(
    "/img/drechtsteden-rivier.jpg" to LuxSubdomains.DRECHTSTEDEN.domainName,
    "/img/tue-luchtfoto.png" to LuxSubdomains.GENIUS.domainName,
    "/img/tue-luchtfoto.png" to LuxSubdomains.LOENEN.domainName,
)

@Composable
private fun LuxCompanyImages() {
    Column {
        SimpleGrid(
            numColumns = numColumns(base = 3, md = 3, lg = 3, xl = 3),
            modifier = Modifier
                .fillMaxWidth()
                .gap(2.cssRem)
        ) {
            listOfLuxCompanyImages.forEach { item ->
                ImageContent(
                    imageUrl = item.first,
                    alt = "${item.second} image",
                    modifier = Modifier
                        .height(auto)
                        .fillMaxHeight()
                )
            }
        }
    }
}

@Composable
private fun MoreAboutLuxCompany() {
    var expandedItemIndex by remember { mutableStateOf(1) }

    Column(
        Modifier.fillMaxWidth()
            .gap(1.cssRem),
        horizontalAlignment = Alignment.Start
    ) {
        ExpandableInfoContent(
            title = {
                LangText(
                    en = "Smarter Energy Use Is Closer Than You Think",
                    nl = "Slimmer Energiegebruik Is Dichterbij Dan Je Denkt"
                )
            },
            body = {
                P {
                    LangText(
                        en = """
                            Many companies also have more flexibility than they think. For example, electric cars
                            and trucks can charge smartly, heating and cooling can often be turned off for an hour,
                            heat can be stored, some energy-intensive processes can shift to the night, et cetera.
                            With LUX company you can quickly see what that yields.
                        """.trimIndent(),
                        nl = """
                            Veel bedrijven hebben ook meer flexibiliteit dan ze denken. Zo kunnen elektrische
                            auto's en vrachtwagens slim opladen, kan verwarming en koeling vaak een uur uit,
                            kan warmte worden opgeslagen, kunnen sommige energie-intensieve processen naar de
                            nacht worden verschoven, enzovoort. Met LUX company zie je snel wat dat oplevert.
                        """.trimIndent()
                    )
                }
            },
            onClick = { expandedItemIndex = if (expandedItemIndex == 1) 0 else 1 },
            expanded = expandedItemIndex == 1
        )
        ExpandableInfoContent(
            title = {
                LangText(
                    en = "Easily Share What Works with Others",
                    nl = "Deel Wat Werkt Eenvoudig Met Anderen"
                )
            },
            body = {
                P {
                    LangText(
                        en = """
                            If you have developed a scenario yourself, you can export it as a PowerPoint or PDF to
                            convince others, for example your manager or the bank. This export option also makes
                            LUX company ideal for energy experts who advise a company. They can develop
                            scenarios with LUX company and export the best scenarios and present them to their
                            business customer.
                        """.trimIndent(),
                        nl = """
                            Heb je zelf een scenario ontwikkeld? Dan kun je het exporteren als PowerPoint of PDF om
                            anderen te overtuigen, bijvoorbeeld je manager of de bank. Deze exportoptie maakt LUX
                            company ook ideaal voor energie-experts die een bedrijf adviseren. Zij kunnen met LUX
                            company scenario's ontwikkelen en de beste scenario's exporteren en presenteren aan hun
                            zakelijke klant.
                        """.trimIndent()
                    )
                }
            },
            onClick = { expandedItemIndex = if (expandedItemIndex == 2) 0 else 2 },
            expanded = expandedItemIndex == 2
        )
    }
}

@Composable
private fun ExpandableInfoContent(
    title: @Composable () -> Unit,
    body: @Composable () -> Unit,
    onClick: (SyntheticMouseEvent) -> Unit = {},
    expanded: Boolean = false,
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .gap(1.cssRem)
                .padding(topBottom = 0.35.cssRem, leftRight = 1.cssRem)
                .thenIf(expanded, Modifier.background(SitePalette.light.overlay))
                .cursor(Cursor.Pointer)
                .onClick(onClick),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            H4(
                TextStyle.toModifier(LabelTextStyle)
                    .fontWeight(FontWeight.Bold)
                    .fillMaxWidth()
                    .toAttrs()
            ) {
                title()
            }
            MdiKeyboardArrowUp(
                modifier = Modifier
                    .thenIf(expanded, Modifier.transform { rotate(180.deg) })
                    .transition(
                        Transition.of("transform", 0.3.s)
                    )
            )
        }
        if (expanded) {
            Box(
                modifier = Modifier
                    .padding(leftRight = 1.cssRem)
                    .fontSize(0.9.cssRem),
                contentAlignment = Alignment.TopStart
            ) {
                body()
            }
        }
    }
}

@Composable
private fun VideoAndActionContent(
    modifier: Modifier = Modifier
) {
    Box(
        Modifier
            .height(300.px)
            .then(modifier)
    ) {
        Video(
            attrs = Modifier
                .borderRadius(30.px)
                .objectFit(ObjectFit.Cover)
                .attrsModifier {
                    //todo use video of LUX company in action
                    attr("src", "/lux/videos/energyTransitionOnVL.mp4")
                    attr("alt", "Video of LUX company in action.")
                    attr("controls", "true")
                    attr("width", "100%")
                    attr("height", "100%")
                }.toAttrs()
        )
    }
}