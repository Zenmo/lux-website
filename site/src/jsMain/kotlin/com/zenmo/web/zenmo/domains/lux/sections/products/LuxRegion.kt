package com.zenmo.web.zenmo.domains.lux.sections.products

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.zenmo.web.zenmo.components.widgets.*
import com.zenmo.web.zenmo.domains.lux.components.CallToActionAnchorButton
import com.zenmo.web.zenmo.domains.lux.sections.DeEmphasizedTextStyle
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.sections.ResponsiveRowStyle
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*


val LuxRegionStyle = CssStyle {
    base {
        Modifier.fillMaxWidth()
    }

    Breakpoint.ZERO {
        Modifier.gap(3.cssRem)
    }
    Breakpoint.SM {
        Modifier.gap(3.cssRem)
    }
    Breakpoint.MD {
        Modifier.gap(4.cssRem)
    }
    Breakpoint.LG {
        Modifier.gap(5.cssRem)
    }
    Breakpoint.XL {
        Modifier.gap(5.cssRem)
    }
}

@OptIn(DelicateApi::class)
@Composable
fun LuxMunicipality() {
    val breakpoint = rememberBreakpoint()
    SectionContainer(
        variant = LuxSectionContainerStyleVariant,
    ) {
        Div(
            ResponsiveRowStyle.toModifier()
                .alignItems(AlignItems.Stretch).toAttrs(),
        ) {
            StartContent(breakpoint)

            Column(
                modifier = LuxRegionStyle.toModifier(),
                horizontalAlignment = Alignment.Start,
            ) {
                //todo use video recorded by Naud about model for the whole of NL.
                LuxVideo()
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
                        src = "/lux/images/nature_img.jpg",
                        alt = "turbine",
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
                            nl = "Lux wordt al gebruikt door de "
                        )
                        InlineLink(
                            destinationUrl = "",// todo link to Drechtsteden
                            enLinkText = "RES region Drechtsteden",
                            nlLinkText = "RES region Drechtsteden"
                        )

                        LangText(
                            en = " and the ",
                            nl = " een de "
                        )

                        InlineLink(
                            destinationUrl = "",// todo link to brabant
                            enLinkText = "Province of Brabant.",
                            nlLinkText = "Province of Brabant."
                        )
                        Br { }
                        LangText(
                            en = "It was also used at the ",
                            nl = "Het werd ook gebruikt bij de "
                        )
                        InlineLink(
                            destinationUrl = "",// todo link to PMIEK
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
}


@Composable
private fun StartContent(breakpoint: Breakpoint) {
    Div(
        attrs = Modifier.position(Position.Relative)
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
            .alignItems(AlignItems.FlexStart)
            .maxWidth(if (breakpoint >= Breakpoint.MD) 40.percent else 100.percent)
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
                enText = "LUX Region",
                nlText = "LUX Regio",
                modifier = Modifier.margin(0.px)
            )

            P {
                LangBlock(
                    en = {
                        Text(
                            """
                                LUX aims to create the new bottom-up energy system (based on the holon approach) for
                                the whole of the Netherlands.  
                            """.trimIndent(),
                        )
                        B {
                            Text(" Municipalities, RES regions ")
                        }
                        Text("and ")
                        B { Text("Provinces ") }
                        Text(
                            """
                                can make their own selection of their neighbourhoods and enrich the model with 
                                non-public data and future plans.
                            """.trimIndent()
                        )
                    },
                    nl = {
                        Text(
                            """
                                Lux wil het nieuwe bottom-up energiesysteem (gebaseerd op de Holon-aanpak) maken voor 
                                heel Nederland.
                            """.trimIndent(),
                        )
                        B {
                            Text(" Gemeenten, RES -regio's ")
                        }
                        Text("en een ")
                        B { Text("Provincies ") }
                        Text(
                            """
                                kan hun eigen selectie van hun buurten maken en het model verrijken met niet-openbare 
                                gegevens en toekomstplannen.
                            """.trimIndent()
                        )
                    }
                )
            }
        }
    }
}
