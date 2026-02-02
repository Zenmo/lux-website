package com.zenmo.web.zenmo.domains.lux.sections.about_us.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangBlock
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.sections.about_us.components.AboutUsHorizontalPaddingStyle
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.LuxSpecificColorHues
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun WhyLux(breakpoint: Breakpoint) {
    Div(
        AboutUsHorizontalPaddingStyle.toModifier()
            .margin(top = 1.5.cssRem)
            .toAttrs()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .background(LuxSpecificColorHues().luxBlackRussian)
                .flexWrap(FlexWrap.Wrap)
                .luxBorderRadius(LuxCornerRadius.xl)
                .overflow(Overflow.Hidden)
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(3.cssRem)
                    .thenIf(breakpoint < Breakpoint.MD, Modifier.padding(2.cssRem))
                    .gap(1.cssRem)
                    .width(60.percent)
                    .thenIf(breakpoint < Breakpoint.MD, Modifier.width(100.percent))
            ) {
                HeaderText(
                    enText = "Why LUX?",
                    nlText = "Waarom LUX?",
                    textColor = Colors.White
                )

                Div(
                    Modifier.color(Colors.White.copyf(alpha = 0.8f))
                        .textAlign(TextAlign.Justify)
                        .toAttrs()
                ) {
                    LangBlock(
                        en = {
                            P {
                                Text(
                                    """
                            The name LUX was introduced by Zenmo in 2024. We noticed there was confusion between the 
                            company Zenmo, the HOLON project, and the open-source software now known as the "LUX energy 
                            twin." Energy twin refers to the use of digital twins with a focus on energy.
                        """.trimIndent()
                                )
                                Br {}
                                Br {}
                                Text(
                                    """
                            Lux is the scientific unit that indicates how well something can be seen by the human eye. 
                            A lux is also directly related to sunlight, which powers solar panels and wind turbines.
                        """.trimIndent()
                                )
                            }
                        },
                        nl = {
                            P {
                                Text(
                                    """
                                    De naam LUX werd door Zenmo geïntroduceerd in 2024. We merkten dat er verwarring 
                                    was tussen het bedrijf Zenmo, het project HOLON en de open source software die nu
                                     ‘LUX energy twin’ heet. Energy twin verwijst naar het gebruik van digital twins 
                                     met een focus op energie.
                                """.trimIndent()
                                )
                                Br {}
                                Br {}
                                Text(
                                    """
                                    Lux is de wetenschappelijke eenheid die uitdrukt hoe goed iets voor het menselijk 
                                    oog te zien is. Een lux is ook direct gerelateerd aan het zonlicht waar 
                                    zonnepanelen en windmolens hun elektriciteit mee maken.
                                """.trimIndent()
                                )
                            }
                        }
                    )
                }

                Div(
                    Modifier.padding(16.px, 24.px)
                        .background(Colors.White.copyf(alpha = 0.10f))
                        .color(SitePalette.light.secondary)
                        .alignSelf(AlignSelf.Stretch)
                        .luxBorderRadius(LuxCornerRadius.lg)
                        .toAttrs()
                ) {
                    P {
                        LangText(
                            en = """
                            That Lux also happens to be the name of the first Zenmo baby is, of course, pure 
                            coincidence.
                        """.trimIndent(),
                            nl = """
                            Dat Lux ook de naam is van de eerste Zenmo baby is natuurlijk puur toeval.
                        """.trimIndent()
                        )
                    }
                }
            }

            Box(
                modifier = Modifier.width(40.percent)
                    .alignSelf(AlignSelf.Stretch)
                    .thenIf(breakpoint < Breakpoint.MD, Modifier.height(350.px).fillMaxWidth())
            ) {
                Img(
                    src = "/lux/images/zenmo_baby.png",
                    alt = "Zenmo Baby",
                    attrs = Modifier.fillMaxSize()
                        .objectFit(ObjectFit.Cover)
                        .toAttrs()
                )
            }
        }
    }
}