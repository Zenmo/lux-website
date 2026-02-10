package com.zenmo.web.zenmo.domains.lux.sections.about_us

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.zenmo.web.zenmo.components.widgets.InlineLink
import com.zenmo.web.zenmo.components.widgets.LangBlock
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.sections.about_us.components.JourneyBlock
import com.zenmo.web.zenmo.domains.lux.sections.about_us.sections.LuxStoryHeaderText
import com.zenmo.web.zenmo.domains.lux.sections.about_us.sections.WhyLux
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.LuxSpecificColorHues
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.dom.B
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@OptIn(DelicateApi::class)
@Composable
fun AboutUs() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        LuxStoryHeaderText(breakpoint)
        SectionContainer(
            variant = LuxSectionContainerStyleVariant,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            JourneyBlock(
                breakpoint = breakpoint,
                title = LocalizedText(
                    en = "The Beginning",
                    nl = "Het Begin"
                ),
                journeyDescription = LocalizedText(
                    en = "The journey begins at TU Eindhoven",
                    nl = "De reis begint aan de TU Eindhoven"
                ),
                textContent = {
                    LangBlock(
                        en = {
                            P {
                                Text(
                                    """
                                        LUX came to be more than ten years ago at Eindhoven University of Technology. 
                                        It was clear that a wave of sustainable innovation was coming—one that would be 
                                        transformative: solar panels, wind energy, electric vehicles, batteries, 
                                        heat pumps, hydrogen, and more. But how could we gain a firm grasp on these 
                                        developments so we could guide the transition and, above all, accelerate it?
                                    """.trimIndent()
                                )
                                Br { }
                                Br { }
                                Text(
                                    """
                                        From the field of innovation science, influential Dutch schools of thought had 
                                        emerged, such as transition management and the multi-level perspective, with 
                                        Prof. Jan Rotmans and Prof. Geert Verbong as key figures. But these 
                                        transformative ideas had not yet been quantified. Quantitatively calculating 
                                        how to best control systems is the domain of control systems engineering, and 
                                        Prof. Maarten Steinbuch is a leading authority in this field. However, control 
                                        systems typically apply only to technical systems. Meanwhile, within grid 
                                        operator Alliander, CEO Peter Molengraaf was painfully aware of the problem 
                                        and open to innovative approaches.
                                    """.trimIndent()
                                )
                                Br { }
                                Br { }

                                Text(
                                    """
                                        After his 2008 sabbatical, Auke Hoekstra successfully predicted developments 
                                        using learning curves and began working as an energy transition strategist for 
                                        Alliander. He proposed using agent-based modelling to gain control over the 
                                        system. This ultimately led to LUX. The considerations behind this were later 
                                        """.trimIndent()
                                )

                                InlineLink(
                                    enLinkText = "published",
                                    nlLinkText = "uitgewerkt",
                                    destinationUrl = "https://research.tue.nl/nl/publications/creating-agent-based-energy-transition-management-models-that-can/"
                                )

                                Text(" in more detail by Auke, Geert, and Maarten.")
                            }
                        },
                        nl = {
                            P {
                                Text(
                                    """
                                        LUX ontstond ruim tien jaar geleden aan de TU Eindhoven. Het was duidelijk dat 
                                        er een golf aan duurzame innovatie aan kwam die transformatief zou zijn: 
                                        zonnepanelen, windenergie, elektrische voertuigen, batterijen, warmtepompen, 
                                        waterstof, et cetera. Maar hoe konden we daar grip op krijgen zodat we die 
                                        transitie kunnen begeleiden en - vooral - versnellen?
                                    """.trimIndent()
                                )
                                Br { }
                                Br { }
                                Text(
                                    """
                                        Vanuit innovation science waren er invloedrijke Nederlandse stromingen als 
                                        transition management en het multi-level perspective, met prof Jan Rotmans en 
                                        prof Geert Verbong als belangrijke exponenten. Maar deze transformatieve ideeën 
                                        werden nog niet gekwantificeerd. Het kwantitatief berekenen hoe je systemen het 
                                        best aanstuurt is het gebied van control systems en prof Maarten Steinbuch is 
                                        op het gebied van control systems toonaangevend. Maar control systems beperkt 
                                        zich normaal gesproken tot technische systemen. Vanuit Alliander was CEO Peter 
                                        Molengraaf zich pijnlijk bewust van het probleem en geïnteresseerd in 
                                        innovatieve benaderingen. 
                                    """.trimIndent()
                                )
                                Br { }
                                Br { }

                                Text(
                                    """
                                        Auke Hoekstra voorspelde na zijn sabbatical in 2008 succesvol de ontwikkelingen 
                                        met leercurves en ging werken als energietransitiestrateeg voor Alliander. Hij 
                                        stelde hen voor grip op het systeem te krijgen met agent-based modelling. Dit 
                                        leidde uiteindelijk tot LUX. De overwegingen hierachter werden later in meer 
                                        detail door Auke, Geert en Maarten   
                                    """.trimIndent()
                                )

                                InlineLink(
                                    enLinkText = "published.",
                                    nlLinkText = "gepubliceerd.",
                                    destinationUrl = "https://research.tue.nl/nl/publications/creating-agent-based-energy-transition-management-models-that-can/"
                                )
                            }
                        }
                    )
                },
                yearText = {
                    HeaderText(
                        enText = "2008",
                        nlText = "2008",
                        textColor = SitePalette.light.primary
                    )
                },
                yearBoxModifier = Modifier.background(SitePalette.light.secondary),
            )

            JourneyBlock(
                breakpoint = breakpoint,
                title = LocalizedText(
                    en = "Zenmo Simulations",
                    nl = "Zenmo Simulaties"
                ),
                journeyDescription = LocalizedText(
                    en = "Zenmo Simulations founded",
                    nl = "Oprichting Zenmo Simulaties"
                ),
                textContent = {
                    LangBlock(
                        en = {
                            P {
                                Text(
                                    """
                                      Initially, the focus was on electric mobility, using models such as SparkCity for 
                                      the ElaadNL foundation. But in 2016, Peter Hogeveen entered the picture. He was 
                                      able to further expand and deepen the models. This collaboration worked so well 
                                      that in 2018, Auke, Peter Hogeveen, Geert, Maarten, and Peter Molengraaf decided 
                                      to found Zenmo Simulations.   
                                    """.trimIndent()
                                )

                                B { Text("Zenmo stands for Zero-emission energy and mobility.") }

                                Br { }
                                Br { }
                                Text(
                                    """
                                        Acceleration came in 2019, when Auke, Maarten, and Zenmo's first employee, 
                                        Naud Loomans, succeeded in securing the NEON research project, which put 35 
                                        researchers to work. While NEON brings researchers from different disciplines 
                                        together (and was a finalist for the Huibregtsen Award in 2024), moving from 
                                        science to practice is always challenging.
                                    """.trimIndent()
                                )
                            }
                        },
                        nl = {
                            P {
                                Text(
                                    """
                                        In eerste instantie lag de nadruk met modellen als SparkCity voor stichting 
                                        ElaadNL op elektrisch vervoer maar in 2016 diende Peter Hogeveen zich aan. Hij 
                                        was in staat om de modellen verder en breder te ontwikkelen. Dat beviel zo goed 
                                        dat Auke, Peter Hogeveen, Geert, Maarten en Peter Molengraaf in 2018 besloten 
                                        Zenmo simulations op te richten. 
                                    """.trimIndent()
                                )

                                B { Text("Zenmo staat voor Zero-emissie energie en mobiliteit.") }

                                Br { }
                                Br { }
                                Text(
                                    """
                                        Een versnelling kwam in 2019 toen Auke, Maarten en eerste Zenmo medewerker Naud 
                                        Loomans er in slaagden het NEON research project in de wacht te slepen dat 35 
                                        onderzoekers aan het werk zette. Hoewel NEON research onderzoekers 
                                        interdisciplinair bij elkaar brengt (en in 2024 tot de finalisten van de 
                                        huibregtsenprijs behoorde) is het een uitdaging om van wetenschap naar praktijk 
                                        te komen.
                                    """.trimIndent()
                                )
                            }
                        }
                    )
                },
                yearText = {
                    HeaderText(
                        enText = "2018",
                        nlText = "2018",
                        textColor = SitePalette.light.primary
                    )
                },
                yearBoxModifier = Modifier.background(SitePalette.light.primary.toRgb().copyf(alpha = 0.10f)),
                modifier = Modifier.color(SitePalette.light.primary).flexDirection(FlexDirection.RowReverse)
            )

            JourneyBlock(
                breakpoint = breakpoint,
                title = LocalizedText(
                    en = "The Holon Project",
                    nl = "Het Holon Project"
                ),
                journeyDescription = LocalizedText(
                    en = "Growth & Development",
                    nl = "Groeien & Ontwikkelen"
                ),
                textContent = {
                    LangBlock(
                        en = {
                            P {
                                Text(
                                    """
                                      A more practice-oriented project was the HOLON project by the Dutch Top Sector 
                                      Energy System Integration, for which Zenmo became the main contractor in 2022. 
                                      This enabled Zenmo to expand and continue developing its agent-based models. The 
                                      concept of semi-autonomous energy systems was also tested and validated within a 
                                      broad consortium of experts, including Quintel (known for the energy transition 
                                      model), TNO, Witteveen & Bos, and many knowledge institutions.
                                    """.trimIndent()
                                )
                                Br { }
                                Br { }
                                Text(
                                    """
                                        In 2023, visionaries from the Drechtsteden region and the provinces of Brabant 
                                        and Utrecht recognized the potential of LUX, and by now LUX has been applied to 
                                        dozens of energy hubs. This also taught us that while a solid theoretical 
                                        foundation is important, nothing can replace real-world experience. 
                                        Additionally, "necessity is the mother of invention" and with increasing grid 
                                        congestion, the need to develop a new approach became ever more pressing.
                                    """.trimIndent()
                                )
                            }
                        },
                        nl = {
                            P {
                                Text(
                                    """
                                       Een praktischer project was het HOLON project van de topsector energie systeem 
                                       integratie waarvan Zenmo in 2022 hoofdaannemer werd. Dit gaf Zenmo de 
                                       mogelijkheid om uit te breiden en verder te werken aan haar agent-based 
                                       modellen. Ook werd het concept van semi-autonome energiesystemen getoetst en 
                                       gevalideerd in een breed consortium van experts van o.a. Quintel (van het 
                                       bekende energietransitiemodel), TNO, Witteveen & Bos en vele kennisinstellingen.  
                                    """.trimIndent()
                                )
                                Br { }
                                Br { }
                                Text(
                                    """
                                        In 2023 zagen visionairs bij Drechtsteden en de provincie Brabant en Utrecht de 
                                        potentie van LUX en intussen is LUX toegepast bij tientallen energy hubs. 
                                        Daaruit leerden we ook dat een solide theoretische basis belangrijk is maar dat 
                                        niets echte praktijkervaring kan vervangen. Bovendien: ‘noodzaak is de vader 
                                        van de uitvinding’ en met de toenemende netcongestie werd de noodzaak om een 
                                        nieuwe aanpak uit te vinden steeds duidelijker.  
                                    """.trimIndent()
                                )
                            }
                        }
                    )
                },
                yearText = {
                    HeaderText(
                        enText = "2022",
                        nlText = "2022",
                        textColor = Colors.White
                    )
                },
                yearBoxModifier = Modifier.background(LuxSpecificColorHues().luxBlackRussian).color(Colors.White),
            )

            WhyLux(breakpoint)
        }
    }
}

