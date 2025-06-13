package com.zenmo.web.zenmo.domains.lux.subdomains

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.mdi.MdiMail
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.shapes.Circle
import com.varabyte.kobweb.silk.theme.shapes.clip
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.MediaContentLayout
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.components.widgets.ZenmoInlineLink
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import kotlin.uuid.Uuid

@Composable
fun LoenenIndex() {
    LuxSubdomainPageLayout(
        title = "Zero - Digital twin Loenen",
    ) {
        Column(
            modifier = Modifier
                .gap(5.cssRem).margin(topBottom = 5.cssRem),
        ) {
            SectionContainer {
                MediaContentLayout(
                    imageUrl = "/lux/images/Digital-twin-Loenen.png",
                    imageModifier = Modifier.borderRadius(30.px).border(
                        width = 2.px,
                        color = SitePalette.light.primary,
                        style = LineStyle.Solid
                    ),
                    keepImageAsIs = true,
                    reversed = true,
                    description = {
                        P {
                            LangText(
                                en = """
                                Below is a mock-up of the digital twin for the sustainability project in the village 
                                of Loenen. In Loenen, the energy cooperative is working on a smart energy system with a 
                                Community Virtual Power Plant. The digital twin will assist in designing these sustainable 
                                energy systems and making the right decisions.
                            """.trimIndent(), nl = """
                                Bekijk hieronder de mock-up van de digital twin voor de verduurzaming van het dorp 
                                Loenen. In Loenen werkt de energie coöperatie aan een slim energiesysteem met een 
                                Community Virtual Power Plant. De digital twin zal helpen bij het ontwerpen van deze 
                                duurzame energiesystemen en het maken van de juiste beslissingen.
                            """.trimIndent()
                            )
                        }
                    })
            }
            SectionContainer(
                Modifier
                    .background(Color.white)
                    .width(100.percent)
                    .maxWidth(130.cssRem),
                variant = null
            ) {
                AnyLogicEmbed(
                    modelId = Uuid.parse("ba998ba3-05dc-45f6-ac6d-78279765375d"),
                    apiKey = Uuid.parse("17e0722f-25c4-4549-85c3-d36509f5c710"),
                    modifier = Modifier.maxWidth(90.cssRem).margin(topBottom = 5.cssRem)
                )
            }

            SectionContainer {
                Column(
                    modifier = Modifier.fillMaxWidth().gap(1.cssRem),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    HeaderText(
                        enText = "Contact and info",
                        nlText = "Contact en info",
                        modifier = Modifier.margin(0.cssRem)
                    )
                    SubHeaderText(
                        enText = "Website and model development",
                        nlText = "Website en model ontwikkeling",
                        modifier = Modifier.margin(0.cssRem)
                    )

                    SimpleGrid(
                        numColumns = numColumns(base = 1, md = 2, lg = 2, xl = 2),
                        modifier = Modifier.gap(2.cssRem).margin(top = 4.cssRem)
                    ) {
                        ContactCard(
                            name = ZenmoTeam.NAUD_LOOMANS.memberName,
                            image = ZenmoTeam.NAUD_LOOMANS.image,
                            email = ZenmoTeam.NAUD_LOOMANS.email,
                            organization = { ZenmoInlineLink() },
                        )

                        ContactCard(
                            name = "Ariadne Renteria Castaneda",
                            image = "avatars/blank.png",
                            email = "a.renteria.castaneda@student.tue.nl",
                            organization = {
                                Span(
                                    Modifier.fontWeight(FontWeight.Bold).toAttrs()
                                ) {
                                    Text("TU Eindhoven")
                                }
                            },
                        )
                    }
                }
            }
        }
    }
}

val ContactCardDivStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .alignItems(AlignItems.Center)
            .gap(1.cssRem)
    }

    Breakpoint.SM {
        Modifier
            .fillMaxWidth()
            .flexDirection(FlexDirection.Row)
    }

    Breakpoint.MD {
        Modifier
            .flexDirection(FlexDirection.Column)
    }

    Breakpoint.LG {
        Modifier
            .flexDirection(FlexDirection.Column)
    }
    Breakpoint.XL {
        Modifier
            .flexDirection(FlexDirection.Column)
    }
}


@Composable
fun ContactCard(
    modifier: Modifier = Modifier.fillMaxWidth(),
    name: String,
    image: String,
    email: String,
    organization: @Composable () -> Unit,
) {
    val breakpoint = rememberBreakpoint()
    Div(
        ContactCardDivStyle.toModifier().then(modifier).toAttrs(),
    ) {
        Box(ContactCardImageContainerStyle.toModifier()) {
            Image(
                modifier = Modifier.fillMaxSize().objectFit(ObjectFit.Cover).clip(Circle()),
                src = image,
                alt = "$name photo",
            )
        }
        Column(
            Modifier
                .gap(0.5.cssRem),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = if (breakpoint < Breakpoint.MD) Alignment.Start
            else Alignment.CenterHorizontally,
        ) {
            SubHeaderText(
                enText = name,
                nlText = name,
                modifier = Modifier.color(SitePalette.light.primary).margin(0.cssRem)
            )
            Row {
                MdiMail(Modifier.padding(right = 0.25.cssRem))
                Text(email)
            }
            organization()
        }
    }
}

val ContactCardImageContainerStyle = CssStyle {
    base {
        Modifier
            .size(12.cssRem)
            .borderRadius(
                50.percent
            )
            .border(
                width = 6.px,
                color = Color.white,
                style = LineStyle.Solid
            )
    }

    Breakpoint.XL {
        Modifier
            .size(15.cssRem)
    }

    Breakpoint.LG {
        Modifier
            .size(15.cssRem)
    }
}
