package com.zenmo.web.zenmo.domains.lux.sections.home

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.SimpleGridStyle
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.addVariantBase
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.ImageContent
import com.zenmo.web.zenmo.components.widgets.InlineLink
import com.zenmo.web.zenmo.components.widgets.LangBlock
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.LuxSection
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.pages.SiteGlobals
import com.zenmo.web.zenmo.theme.SitePalette
import kotlinx.browser.window
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*

@Composable
fun HomePage() {
    SectionContainer(
        modifier = Modifier
            .id(LuxSection.HOME.id)
            .gap(7.cssRem),
        variant = LuxSectionContainerStyleVariant,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Hero()
        LuxSolutionContent()
    }
}


val SolutionContentImageStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .objectFit(ObjectFit.Cover)
            .height(600.px)
    }
    Breakpoint.SM {
        Modifier
            .height(300.px)
    }
    Breakpoint.MD {
        Modifier
            .height(500.px)
    }
    Breakpoint.XL {
        Modifier
            .height(600.px)
    }
}

val ImageGridVariant = SimpleGridStyle.addVariantBase {
    Modifier.rowGap(0.px).columnGap(0.px)
}

@Composable
fun LuxSolutionContent() {
    Row(
        Modifier.fillMaxWidth().gap(5.cssRem).padding(top = 5.cssRem),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Div(
            Modifier.fillMaxWidth().toAttrs()
        ) {
            Column(
                modifier = Modifier
                    .gap(1.cssRem)
            ) {
                SubHeaderText(
                    enText = "Accelerating Smart, Sustainable Planning.",
                    nlText = "Versnellen van Slim, Duurzaam Plannen.",
                    modifier = Modifier
                        .margin(0.cssRem)
                        .color(SitePalette.light.primary),
                )
                P {
                    val protocol = window.location.protocol
                    LangBlock(
                        en = {
                            Text("To fit sustainable solutions in a smarter way, ")
                            InlineLink(
                                destinationUrl = "${protocol}//${SiteGlobals.ZENMO_DOMAIN}",
                                enLinkText = "Zenmo Simulations",
                                nlLinkText = "Zenmo Simulations",
                            )
                            Text(" and ")
                            InlineLink(
                                destinationUrl = "",
                                enLinkText = "Eindhoven University of Technology",
                                nlLinkText = "Technische Universiteit Eindhoven",
                            )
                            Text(" developed ")
                            B {
                                Text("LUX Energy Twin. ")
                            }
                            Br { }
                            Br { }
                            Text(
                                """
                                LUX enables you to quickly create integrated energy plans for a company or area. Alone 
                                or in interactive workshops with all stakeholders, you will work with LUX to create 
                                cost-effective scenarios that will make everyone happy.
                            """.trimIndent()
                            )

                        },
                        nl = {
                            Text("Om duurzame oplossingen slimmer in te passen, hebben ")
                            InlineLink(
                                destinationUrl = "${protocol}//${SiteGlobals.ZENMO_DOMAIN}",
                                enLinkText = "Zenmo Simulations",
                                nlLinkText = "Zenmo Simulations",
                            )
                            Text(" en ")
                            InlineLink(
                                destinationUrl = "",
                                enLinkText = "Eindhoven University of Technology",
                                nlLinkText = "Technische Universiteit Eindhoven",
                            )
                            Text(" LUX Energy Twin ontwikkeld. ")
                            Br { }
                            Br { }
                            Text(
                                """
                                LUX stelt je in staat om snel geïntegreerde energieplannen te maken voor een bedrijf 
                                of gebied. Alleen of in interactieve workshops met alle belanghebbenden werk je met 
                                LUX aan kosteneffectieve scenario's die iedereen gelukkig maken.
                            """.trimIndent()
                            )
                        }
                    )
                }
            }
        }

        Div(
            Modifier.fillMaxWidth().toAttrs()
        ) {
            SimpleGrid(
                numColumns = numColumns(base = 3, md = 3, lg = 3, xl = 3),
                variant = ImageGridVariant,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                ImageContent(
                    imageUrl = "/lux/images/turbine.jpg",
                    keepImageAsIs = true,
                    alt = "turbine image",
                    modifier = SolutionContentImageStyle.toModifier()
                )
                ImageContent(
                    imageUrl = "/lux/images/nature_img.jpg",
                    keepImageAsIs = true,
                    alt = "nature image",
                    modifier = SolutionContentImageStyle.toModifier()
                )
                ImageContent(
                    imageUrl = "/lux/images/horizon_img.jpg",
                    keepImageAsIs = true,
                    alt = "horizon image",
                    modifier = SolutionContentImageStyle.toModifier()
                )
            }
        }
    }
}