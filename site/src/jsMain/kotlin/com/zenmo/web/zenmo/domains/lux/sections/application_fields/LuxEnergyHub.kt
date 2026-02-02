package com.zenmo.web.zenmo.domains.lux.sections.application_fields

import androidx.compose.runtime.Composable
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
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.zenmo.web.zenmo.components.widgets.*
import com.zenmo.web.zenmo.domains.lux.components.CallToActionAnchorButton
import com.zenmo.web.zenmo.domains.lux.sections.DeEmphasizedTextStyle
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.styles.HeaderBottomDividerLineStyle
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*


@OptIn(DelicateApi::class)
@Composable
fun LuxEnergyHub() {
    val breakpoint = rememberBreakpoint()
    SectionContainer(
        variant = LuxSectionContainerStyleVariant,
        horizontalAlignment = Alignment.Start,
    ) {
        HeaderText(
            enText = "LUX Energy HUB",
            nlText = "LUX Energy HUB",
            modifier = Modifier.fillMaxWidth()
        )

        P(Modifier.margin(0.cssRem).toAttrs()) {
            LangBlock(
                en = {
                    Text(
                        """
                        Business parks are the engine of the Dutch economy and are increasingly switching to
                        sustainable electricity instead of fossil fuels. Unfortunately, more and more business
                        parks are facing grid congestion that slows down sustainability and makes extremely
                        expensive diesel generators necessary. It can even lead to companies having to close or
                        relocate. Fortunately, 
                    """.trimIndent()
                    )
                    B {
                        Text(" Lux shows energy hub")
                    }
                    Text(" solutions.")
                },
                nl = {
                    Text(
                        """
                        Bedrijventerreinen zijn de motor van de Nederlandse economie en schakelen steeds vaker
                        over op duurzame elektriciteit in plaats van fossiele brandstoffen. Helaas krijgen steeds
                        meer bedrijventerreinen te maken met netcongestie die verduurzaming vertraagt en
                        extreem dure dieselgeneratoren noodzakelijk maakt. Het kan zelfs leiden tot
                        bedrijven die moeten sluiten of verhuizen. Gelukkig laat, 
                    """.trimIndent()
                    )
                    B {
                        Text(" Lux laat energiehubs zien")
                    }
                    Text(" oplossingen.")
                }
            )
        }
        //todo use 3min video demonstrating how LUX energy hub works
        LuxVideo()
        TextContent()
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
                P(
                    Modifier
                        .margin(0.cssRem)
                        .maxWidth(if (breakpoint < Breakpoint.MD) 100.percent else 80.percent)
                        .toAttrs()
                ) {
                    LangText(
                        en = """
                            On the basis of the new Energiewet, the grid operators must provide transparency so that
                            companies that run into problems can think along about how to get more out of an
                            existing grid connection. It often turns out that a lot is possible. 
                        """.trimIndent(),
                        nl = """
                            Op basis van de nieuwe Energiewet moet de netbeheerder transparantie bieden zodat
                            bedrijven die tegen problemen aanlopen mee kunnen denken over hoe meer uit een
                            bestaande netaansluiting te halen. Het blijkt vaak dat er veel mogelijk is. 
                        """.trimIndent()
                    )
                }
            }

            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomStart) {
                CallToActionAnchorButton {
                    LangText(
                        en = "Calculate  ",
                        nl = "Bereken  "
                    )
                    Br {}
                    LangText(
                        en = "Your Energy Hub?",
                        nl = "Uw Energie Hub?"
                    )
                }
            }
        }

    }
}

@Composable
private fun TextContent() {
    Column(
        modifier = Modifier.fillMaxWidth().gap(3.cssRem),
        horizontalAlignment = Alignment.Start,
    ) {
        Div {
            P(
                Modifier
                    .margin(0.cssRem).toAttrs()
            ) {

                LangBlock(
                    en = {
                        B {
                            Text("LUX energy hub ")
                        }
                        Text("is for situations where ")
                        InlineLink(
                            destinationUrl = "lux-company",
                            enLinkText = "LUX company",
                            nlLinkText = "LUX bedrijf"
                        )
                        Text(
                            """
                                 does not go far enough. It originated at Eindhoven University of Technology and was designed for 
                                a new energy system that does more with the existing electricity grid through local autonomy and
                                smart use of storage. In jargon, it is based on modern concepts such as 
                            """.trimIndent()
                        )
                        InlineLink(
                            destinationUrl = "", //todo link to holons page?
                            enLinkText = "holons",
                            nlLinkText = "holons",
                        )
                        Text(", ")
                        Span(
                            BorderBottomModifier
                                .toAttrs()
                        ) {
                            Text("integrated area development")
                        }

                        Text(" and ")

                        InlineLink(
                            destinationUrl = "", //todo link to autonomous agents?
                            enLinkText = "autonomous agents.",
                            nlLinkText = "autonome agenten.",
                        )

                        Text(" For you, the result is an ")
                        Span(
                            BorderBottomModifier
                                .toAttrs()
                        ) {
                            Text("interactive simulation tool")
                        }

                        Text(
                            """
                                 with which you, together with other companies and possibly the grid operator and municipality, 
                                can calculate ideas within seconds.
                            """.trimIndent()
                        )
                    },
                    nl = {
                        B {
                            Text("LUX-energiehub ")
                        }
                        Text("is voor situaties waarin ")
                        InlineLink(
                            destinationUrl = "lux-company",
                            enLinkText = "LUX company",
                            nlLinkText = "LUX bedrijf"
                        )
                        Text(
                            """
                                 niet ver genoeg gaat. Het is ontstaan aan de Technische Universiteit Eindhoven en is ontworpen voor
                                een nieuw energiesysteem dat meer doet met het bestaande elektriciteitsnet door lokale autonomie en
                                slim gebruik van opslag. In jargon is het gebaseerd op moderne concepten zoals 
                            """.trimIndent()
                        )
                        InlineLink(
                            destinationUrl = "", //todo link to holons page?
                            enLinkText = "holons",
                            nlLinkText = "holons",
                        )
                        Text(", ")
                        Span(
                            BorderBottomModifier
                                .toAttrs()
                        ) {
                            Text("geïntegreerde gebiedsontwikkeling")
                        }

                        Text(" en ")

                        InlineLink(
                            destinationUrl = "", //todo link to autonomous agents?
                            enLinkText = "autonomous agents.",
                            nlLinkText = "autonome agenten.",
                        )

                        Text(" Voor u is het resultaat een ")
                        Span(
                            BorderBottomModifier
                                .toAttrs()
                        ) {
                            Text("interactieve simulatie tool")
                        }

                        Text(
                            """
                                  waarmee u, samen met andere bedrijven en mogelijk de netbeheerder en gemeente, ideeën binnen 
                                 enkele seconden kunt berekenen.
                            """.trimIndent()
                        )
                    }
                )
            }
        }

        Div {
            listOfQuestions.forEachIndexed { index, (enExample, nlExample) ->
                QuestionExampleItem(
                    exampleNumber = index + 1,
                    enExample = enExample,
                    nlExample = nlExample,
                )
                if (index < listOfQuestions.size - 1) {
                    Div(
                        Modifier
                            .position(Position.Relative)
                            .then(HeaderBottomDividerLineStyle.toModifier())
                            .toAttrs()
                    )
                }
            }

        }
    }
}


private val listOfQuestions = listOf(
    "What if we form an energy hub, coordinate energy flows and conclude a group contract?"
            to "Wat als we een energiehub vormen, energiestromen coördineren en een groepscontract afsluiten?",
    "What if we started to control electric cars, trucks and heat pumps smartly so that they buy cheaper electricity and do not cause peaks on the electricity grid?"
            to "Wat als we elektrische auto’s, vrachtwagens en warmtepompen slim gaan aansturen zodat ze goedkoper stroom inkopen en geen pieken op het elektriciteitsnet veroorzaken?",
    "What if we use a battery to solve grid congestion problems?"
            to "Wat als we een batterij gebruiken om netcongestieproblemen op te lossen?",
    "What if two companies start pooling their grid connection by laying a direct electricity line between the companies?"
            to "Wat als twee bedrijven hun netaansluiting gaan bundelen door een directe elektriciteitslijn tussen de bedrijven aan te leggen?",
    "What if the site takes over the management of the electricity grid itself? (a closed distribution network)"
            to "Wat als het terrein zelf het beheer van het elektriciteitsnet overneemt? (een gesloten distributienetwerk)",
    "What if we build a heat network and share residual heat?"
            to "Wat als we een warmtenet bouwen en restwarmte delen?",
    "What if we start making or using hydrogen or another electro-fuel locally?"
            to "Wat als we lokaal waterstof of een andere elektro-brandstof gaan maken of gebruiken?"
)


@Composable
private fun QuestionExampleItem(
    exampleNumber: Int,
    enExample: String,
    nlExample: String,
) {
    Div(
        Modifier
            .display(DisplayStyle.Block)
            .padding(topBottom = 1.cssRem)
            .toAttrs()
    ) {
        Span(
            DeEmphasizedTextStyle
                .toModifier()
                .fontSize(0.9.cssRem)
                .toAttrs()
        ) {
            LangText(
                en = "EXAMPLE",
                nl = "VOORBEELD",
            )
        }

        H4(
            Modifier
                .margin(0.px)
                .toAttrs()
        ) {
            Sup(
                DeEmphasizedTextStyle
                    .toModifier()
                    .toAttrs()
            ) {
                Text("0$exampleNumber.")
            }

            LangText(
                en = enExample,
                nl = nlExample,
            )
        }
    }
}