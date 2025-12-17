package energy.lux.site.frontend.domains.lux.sections.application_fields

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.functions.RadialGradient
import com.varabyte.kobweb.compose.css.functions.radialGradient
import com.varabyte.kobweb.compose.css.functions.toImage
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.rgb
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.zenmo.web.zenmo.components.widgets.InlineLink
import com.zenmo.web.zenmo.components.widgets.LangBlock
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.CallToActionAnchorButton
import com.zenmo.web.zenmo.domains.lux.sections.DeEmphasizedTextStyle
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.sections.ResponsiveRowStyle
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.font.HolonLineTextStyle
import com.zenmo.web.zenmo.theme.font.LabelTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.dom.*


@OptIn(DelicateApi::class)
@Composable
fun LuxCompany(
) {
    val breakpoint = rememberBreakpoint()
    SectionContainer(
        variant = LuxSectionContainerStyleVariant,
    ) {
        HeaderTextContent(breakpoint)
        //todo use video of LUX company in action
        LuxVideo()
        MoreAboutLuxCompany()

        Div(
            ResponsiveRowStyle
                .toModifier()
                .alignItems(com.varabyte.kobweb.compose.css.AlignItems.Companion.End)
                .padding(0.cssRem)
                .toAttrs(),
        ) {
            Div(
                Modifier.fillMaxWidth().toAttrs()
            ) {
                P {
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

                    InlineLink(
                        destinationUrl = "lux-energy-hub",
                        enLinkText = "LUX Energy Hub.",
                        nlLinkText = "LUX Energy Hub."
                    )
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
        TryConfiguratorCard()
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
                .margin(right = if (breakpoint > Breakpoint.MD) 20.percent else 0.percent)
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
                .margin(left = if (breakpoint > Breakpoint.MD) 25.percent else 0.percent)
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


@Composable
private fun TryConfiguratorCard() {
    Div(
        Modifier.fillMaxWidth()
            .boxSizing(BoxSizing.BorderBox)
            .borderRadius(30.px)
            .background(
                Background.of(
                    image = com.varabyte.kobweb.compose.css.functions.linearGradient(
                        angle = 180.deg
                    ) {
                        add(rgb(0x0f1222))
                        add(rgb(0x1a1f36))
                    }.toImage()
                ),
                Background.of(
                    image = radialGradient(
                        RadialGradient.Shape.Ellipse(800.px, 300.px),
                        CSSPosition(90.percent, 0.percent)
                    ) {
                        add(rgba(255, 212, 0, 0.18f))
                        add(Colors.Transparent, 60.percent)
                    }.toImage()
                ),
                Background.of(
                    image = radialGradient(
                        RadialGradient.Shape.Ellipse(1200.px, 400.px),
                        CSSPosition(10.percent, 0.percent)
                    ) {
                        add(rgba(21, 168, 107, 0.18f))
                        add(Colors.Transparent, 60.percent)
                    }.toImage()
                )
            )
            .color(Colors.White)
            .padding(2.5.cssRem)
            .display(DisplayStyle.Block)
            .textAlign(TextAlign.Center)
            .toAttrs()
    ) {
        SubHeaderText(
            enText = "Be part of our energy journey!",
            nlText = "Doe mee met onze energie reis!",
        )
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
        Div(
            Modifier.padding(top = 1.cssRem).toAttrs()
        ) {
            A(
                href = "/book-demo",
                attrs = TextStyle.toModifier(HolonLineTextStyle)
                    .borderRadius(16.px)
                    .background(SitePalette.light.secondary)
                    .color(SitePalette.light.onBackground)
                    .padding(leftRight = 1.5.cssRem, topBottom = 0.65.cssRem)
                    .textDecorationLine(TextDecorationLine.None)
                    .display(DisplayStyle.InlineBlock)
                    .toAttrs()
            ) {
                LangText(
                    en = "Try the Configurator",
                    nl = "Probeer de Configurator",
                )
            }
        }
    }
}

val MoreAboutLuxGridGapStyle = CssStyle {
    Breakpoint.ZERO {
        Modifier.rowGap(1.cssRem)
    }
    Breakpoint.SM {
        Modifier.rowGap(1.cssRem)
    }

    Breakpoint.MD {
        Modifier.columnGap(2.5.cssRem)
    }

    Breakpoint.LG {
        Modifier.columnGap(5.cssRem)
    }

    Breakpoint.XL {
        Modifier.columnGap(5.cssRem)
    }
}

@Composable
private fun MoreAboutLuxCompany() {
    SimpleGrid(
        numColumns = numColumns(base = 1, md = 2, lg = 2, xl = 2),
        modifier = MoreAboutLuxGridGapStyle.toModifier()
    ) {
        InfoWithCaption(
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
        )
        InfoWithCaption(
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
        )
    }
}

@Composable
private fun InfoWithCaption(
    title: @Composable () -> Unit,
    body: @Composable () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        H4(
            TextStyle.toModifier(LabelTextStyle)
                .fontWeight(FontWeight.Bold)
                .fillMaxWidth()
                .toAttrs()
        ) {
            title()
        }
        Box(
            modifier = Modifier
                .fontSize(0.9.cssRem),
            contentAlignment = Alignment.TopStart
        ) {
            body()
        }
    }
}
