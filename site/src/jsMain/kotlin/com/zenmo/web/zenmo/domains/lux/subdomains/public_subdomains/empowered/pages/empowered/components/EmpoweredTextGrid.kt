package com.zenmo.web.zenmo.domains.lux.subdomains.public_subdomains.empowered.pages.empowered.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.columnGap
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.rowGap
import com.varabyte.kobweb.compose.ui.modifiers.textTransform
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.InlineLink
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.HorizontalLine
import com.zenmo.web.zenmo.domains.lux.sections.DeEmphasizedTextStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span

@Composable
fun EmpoweredTextGrid() {
    SimpleGrid(
        numColumns = numColumns(base = 1, md = 1, lg = 2, xl = 2),
        modifier = Modifier.columnGap(3.cssRem)
            .rowGap(2.cssRem)
            .fillMaxWidth()
    ) {
        EmpoweredTextBlock(
            blockLabel = LocalizedText(
                en = "01 — Zenmo's Role",
                nl = "01 — De rol van Zenmo",
            ),
            textContent = {
                P {
                    InlineLink(
                        destinationUrl = "https://zenmo.com.",
                        enLinkText = "Zenmo",
                        nlLinkText = "Zenmo"
                    )
                    LangText(
                        en =
                            """
                                 is a project partner developing local energy models that help policymakers, energy 
                                communities, residents, and other stakeholders visualize the energy impacts of different choices 
                                and "what-if" scenarios on the path toward Positive Energy Districts. These models make the 
                                consequences of technical and policy decisions tangible and support informed decision-making. 
                                Within the project, Zenmo creates such models for all included use cases.
                            """.trimIndent(),
                        nl =
                            """
                                 is partner in het project en ontwikkelt lokale energiemodellen die beleidsmakers, 
                                energiegemeenschappen, bewoners en andere stakeholders helpen om de energetische impact van 
                                verschillende keuzes en ‘what-if’-scenario’s richting Positive Energy Districts te visualiseren. 
                                Deze modellen maken de gevolgen van technische en beleidsmatige beslissingen inzichtelijk en 
                                ondersteunen weloverwogen besluitvorming. Binnen het project ontwikkelt Zenmo dergelijke modellen 
                                voor alle betrokken use cases.
                            """.trimIndent()
                    )
                }
            }
        )

        EmpoweredTextBlock(
            blockLabel = LocalizedText(
                en = "02 — Project Context",
                nl = "02 — Projectcontext",
            ),
            textContent = {
                P {
                    LangText(
                        en = """
                            The project responds to mounting pressure on the Dutch energy transition, where many heat 
                            transition projects stall due to misalignment with local needs, lack of public support, and 
                            increasing grid congestion.
                        """.trimIndent(),
                        nl = """
                            Het project speelt in op de toenemende druk op de Nederlandse energietransitie, waarin veel 
                            warmtetransitieprojecten vastlopen door onvoldoende aansluiting op lokale behoeften, gebrek aan 
                            maatschappelijk draagvlak en toenemende netcongestie.
                        """.trimIndent()
                    )
                }
            }
        )

        EmpoweredTextBlock(
            blockLabel = LocalizedText(
                en = "03 — Focus on Positive Energy Districts",
                nl = "03 — Focus op Positive Energy Districts",
            ),
            textContent = {
                P {
                    LangText(
                        en = """
                            EmPowerED focuses on Positive Energy Districts—areas that generate more renewable energy than 
                            they consume—recognizing that success depends not only on technology but also on collaboration 
                            between residents, municipalities, housing associations, grid operators, and technology providers.
                        """.trimIndent(),
                        nl = """
                            EmPowerED richt zich op Positive Energy Districts—gebieden die meer hernieuwbare energie 
                            opwekken dan zij verbruiken—en erkent dat succes niet alleen afhangt van technologie, maar ook 
                            van samenwerking tussen bewoners, gemeenten, woningcorporaties, netbeheerders en technologieaanbieders.
                        """.trimIndent()
                    )
                }
            }
        )

        EmpoweredTextBlock(
            blockLabel = LocalizedText(
                en = "04 — Methodology",
                nl = "04 — Methodologie",
            ),
            textContent = {
                P {
                    LangText(
                        en = """
                            By developing a systems design toolbox, running real-world experiments, and building a Community 
                            of Practice, the project helps local actors navigate the social, legal, financial, and technical 
                            complexity of energy systems.
                        """.trimIndent(),
                        nl = """
                            Door het ontwikkelen van een ‘systems design toolbox’, het uitvoeren van praktijkexperimenten 
                            en het opbouwen van een Community of Practice ondersteunt het project lokale actoren bij het 
                            omgaan met de sociale, juridische, financiële en technische complexiteit vande energietransitie.
                        """.trimIndent()
                    )
                }
            }
        )
    }
}


@OptIn(DelicateApi::class)
@Composable
private fun EmpoweredTextBlock(
    blockLabel: LocalizedText,
    textContent: @Composable () -> Unit
) {
    Column(Modifier.fillMaxWidth()) {
        HorizontalLine(
            Modifier
                .displayUntil(Breakpoint.LG)
        )
        Span(
            DeEmphasizedTextStyle.toModifier()
                .textTransform(TextTransform.Uppercase)
                .toAttrs()
        ) {
            LangText(
                en = blockLabel.en,
                nl = blockLabel.nl,
            )
        }
        textContent()
    }
}