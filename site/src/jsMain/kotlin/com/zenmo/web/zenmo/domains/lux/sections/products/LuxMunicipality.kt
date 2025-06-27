package com.zenmo.web.zenmo.domains.lux.sections.products

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.zenmo.web.zenmo.components.widgets.*
import com.zenmo.web.zenmo.domains.lux.components.CallToActionAnchorButton
import com.zenmo.web.zenmo.domains.lux.sections.DeEmphasizedTextStyle
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

const val LUX_MUNICIPALITY_SECTION_ID = "lux-municipality"
val LuxMunRowStyle = CssStyle {
    base {
        Modifier
            .maxWidth(100.percent)
            .display(DisplayStyle.Flex)
            .flexWrap(FlexWrap.Nowrap)
            .position(Position.Relative)
            .gap(3.cssRem)
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
}

@Composable
fun LuxMunicipality() {
    val breakpoint = rememberBreakpoint()
    SectionContainer(
        modifier = Modifier.gap(3.cssRem)
            .id(LUX_MUNICIPALITY_SECTION_ID)
            .minHeight(150.vh),
        variant = LuxSectionContainerStyleVariant,
    ) {
        Row(
            modifier = LuxMunRowStyle.toModifier(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            StartContent(breakpoint)

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .gap(if (breakpoint >= Breakpoint.MD) 2.cssRem else 1.cssRem),
                horizontalAlignment = Alignment.Start,
            ) {
                NaudVideo()
                Div {
                    P(Modifier.margin(bottom = 0.px).toAttrs()) {
                        LangText(
                            en = """
                            A key focus of LUX is enabling more in areas with grid congestion. With the insights and
                            opportunities that LUX offers, much more can be done in terms of housing assignments,
                            growth opportunities for companies and sustainability.
                        """.trimIndent(),
                            nl = """
                                Een belangrijke focus van LUX is om meer mogelijk te maken in gebieden met 
                                roostercongestie. Met de inzichten en kansen die Lux biedt, kan veel meer worden gedaan 
                                op het gebied van woningopdrachten, groeimogelijkheden voor bedrijven en duurzaamheid.
                            """.trimIndent()
                        )
                    }
                    P {
                        LangText(
                            en = """
                                It provides insight into the
                                considerations of the grid operator for each transformer and service area (insofar as
                                they do not keep the data secret) and gives the opportunity to test innovative scenarios 
                                yourself.
                            """.trimIndent(),
                            nl = """
                                Het biedt inzicht in de overwegingen van de rasteroperator voor elke transformator en 
                                servicegebied (voor zover ze de gegevens niet geheim houden) en biedt de mogelijkheid 
                                om zelf innovatieve scenario's te testen.
                            """.trimIndent()
                        )
                    }
                    P(
                        DeEmphasizedTextStyle
                            .toModifier()
                            .fontSize(0.9.cssRem)
                            .margin(0.px)
                            .toAttrs()
                    ) {
                        LangText(
                            en = """
                                For example, by introducing more flex into the system and by better aligning
                                local supply and demand and reducing peaks in consumption and use.
                            """.trimIndent(),
                            nl = """
                                Bijvoorbeeld door meer flex in het systeem te introduceren en door de lokale vraag en 
                                aanbod beter af te stemmen en pieken in consumptie en gebruik te verminderen.
                            """.trimIndent()
                        )
                    }
                }
                Box(Modifier.fillMaxWidth()) {
                    Image(
                        src = "/img/drechtsteden-rivier.jpg",
                        variant = ImageContentStyleVariant,
                        modifier = CaptionImageStyle.toModifier()
                            .height(280.px)
                    )
                }
                Div {
                    P {
                        LangText(
                            en = """
                                LUX can also help with the energy system analysis of municipal heat programmes as
                                well as the sketching of a more substantiated final picture of the heat transition vision
                                and a prioritisation and concretisation of district implementation plans. Actually, LUX is
                                intended for all integrated area development. Also think of neighbourhood perspective
                                maps, social prioritisation, energy planning and charging station policy. As more open
                                data becomes available every year, LUX becomes more valuable every year.
                            """.trimIndent(),
                            nl = """
                                Lux kan ook helpen bij de analyse van het energiesysteem van gemeentelijke 
                                warmteprogramma's, evenals het schetsen van een meer onderbouwd definitief beeld van de 
                                warmtetransitie -visie en een prioritering en concretisering van 
                                districtsimplementatieplannen. Lux is eigenlijk bedoeld voor alle geïntegreerde 
                                gebiedsontwikkeling. Denk ook aan buurtperspectiefkaarten, sociale prioriteiten, 
                                energieplanning en laadstationbeleid. Naarmate elk jaar meer open gegevens beschikbaar 
                                komen, wordt Lux elk jaar waardevoller
                            """.trimIndent()
                        )
                    }

                    P {
                        LangText(
                            en = "LUX is already being used by the ",
                            nl = "Lux wordt al gebruikt door de"
                        )
                        InlineLink(
                            destinationUrl = "",// link to Drechtsteden
                            enLinkText = "RES region Drechtsteden",
                            nlLinkText = "RES region Drechtsteden"
                        )

                        LangText(
                            en = " and the ",
                            nl = " een de"
                        )

                        InlineLink(
                            destinationUrl = "",// link to brabant
                            enLinkText = "Province of Brabant.",
                            nlLinkText = "Province of Brabant."
                        )
                        Br { }
                        LangText(
                            en = "It was also used at the ",
                            nl = "Het werd ook gebruikt bij de "
                        )
                        InlineLink(
                            destinationUrl = "",// link to PMIEK
                            enLinkText = "PMIEK Zuid Holland.",
                            nlLinkText = "PMIEK Zuid Holland."
                        )
                    }

                    P {
                        LangText(
                            en = """
                                LUX is therefore used at all levels (from individual companies to the whole of the
                                Netherlands) and by all stakeholders (from governments and knowledge institutions to
                                grid operators). In this way, LUX creates shared insight into the energy system of the
                                future.
                            """.trimIndent(),
                            nl = """
                                LUX wordt daarom op alle niveaus gebruikt (van individuele bedrijven tot heel Nederland) 
                                en door alle belanghebbenden (van overheden en kennisinstellingen tot rasteroperators). 
                                Op deze manier creëert Lux gedeeld inzicht in het energiesysteem van de toekomst.
                            """.trimIndent()
                        )
                    }
                }

                Div {
                    CallToActionAnchorButton {
                        H3 {
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
                        Span(
                            DeEmphasizedTextStyle.toModifier()
                                .fontSize(0.9.cssRem)
                                .toAttrs()
                        ) {
                            LangText(
                                en = "BOOK A DEMO NOW!",
                                nl = "BOEK NU EEN DEMO!"
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
private fun StartContent(breakpoint: Breakpoint) {
    Div(
        attrs = Modifier.position(Position.Relative)
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
            .alignItems(AlignItems.FlexStart)
            .maxWidth(if (breakpoint >= Breakpoint.MD) 40.percent else 100.percent)
            .minHeight(150.vh)
            .toAttrs()
    ) {
        Div(
            attrs = Modifier
                .transform { translateY(0.px) }
                .position(Position.Sticky)
                .top(30.percent)
                .toAttrs()
        ) {
            HeaderText(
                enText = "LUX Municipality, RES Region and Province",
                nlText = "LUX Municipality, RES Region and Province",
                modifier = Modifier.margin(0.px)
            )

            P {
                LangText(
                    en = """
                                LUX aims to create the new bottom-up energy system (based on the holon approach) for
                                the whole of the Netherlands.  
                            """.trimIndent(),
                    nl = """
                                Lux wil het nieuwe bottom-up energiesysteem (gebaseerd op de Holon-aanpak) maken voor 
                                heel Nederland.
                            """.trimIndent()
                )
                B {
                    LangText(
                        en = "Municipalities, RES regions ",
                        nl = "Gemeenten, RES -regio's "
                    )
                }
                LangText(en = "and ", nl = "een ")
                B { LangText(en = "Provinces ", nl = "Provincies ") }
                LangText(
                    en = """
                                can make their own selection of their neighbourhoods and enrich the model with 
                                non-public data and future plans.
                            """.trimIndent(),
                    nl = """
                                Kan hun eigen selectie van hun buurten maken en het model verrijken met niet-openbare 
                                gegevens en toekomstplannen.
                            """.trimIndent()
                )
                Text("👌")
            }
        }
    }
}

@Composable
private fun NaudVideo() {
    Box(
        Modifier
            .fillMaxWidth()
            .background(SitePalette.light.surfaceContainerLow)
            .height(300.px)
    ) {
        Video(
            attrs = Modifier
                .borderRadius(30.px)
                .objectFit(ObjectFit.Cover)
                .attrsModifier {
                    //todo embed video recorded by Naud about model for the whole of NL.
                    attr("src", "/lux/videos/energyTransitionOnVL.mp4")
                    attr("alt", "Video recorded by Naud about model for the whole of NL.")
                    attr("controls", "true")
                    attr("width", "100%")
                    attr("height", "100%")
                }.toAttrs()
        )
    }
}