package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_neighbourhood.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiInfo
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.ImageContent
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.ResponsiveFlexStyle
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*


@Composable
fun NeighbourhoodHero() {
    LuxSectionContainer {
        Div(
            ResponsiveFlexStyle.toModifier()
                .alignItems(AlignItems.FlexStart)
                .toAttrs()
        ) {
            TextContent()
            Box(Modifier.fillMaxWidth()) {
                ImageContent(
                    imageUrl = "/lux/images/lux_neighbourhood.png",
                    alt = "lux neighbourhood",
                )
            }
        }
    }
}

@Composable
private fun TextContent() {
    Column(
        modifier = Modifier.fillMaxWidth()
            .gap(1.5.cssRem)
    ) {
        Span(
            Modifier
                .padding(5.px, 8.px)
                .backgroundColor(SitePalette.light.primary.lightened(0.85f))
                .luxBorderRadius()
                .color(SitePalette.light.primary)
                .toAttrs()
        ) {
            LangText(
                en = "For Communities",
                nl = "Voor Gemeenschappen"
            )
        }
        HeaderText(
            enText = LuxApplicationArea.LUX_NEIGHBOURHOOD.areaTitle.en,
            nlText = LuxApplicationArea.LUX_NEIGHBOURHOOD.areaTitle.nl,
        )
        Div {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(18.px)
                    .gap(16.px)
                    .background(SitePalette.light.secondary.lightened(0.85f))
                    .luxBorderRadius(LuxCornerRadius.lg)
                    .borderLeft(4.px, LineStyle.Solid, SitePalette.light.secondary)
            ) {
                MdiInfo(Modifier.color(SitePalette.light.secondary))
                P(
                    Modifier.margin(0.cssRem)
                        .toAttrs()
                ) {
                    LangText(
                        en = """
                    Grid congestion and electrification of vehicles and heating are key challenges for municipalities, 
                    energy cooperatives, and residents in residential neighborhoods.
                """.trimIndent(),
                        nl = """
                    Overbelasting van het elektriciteitsnet en de elektrificatie van voertuigen en verwarming vormen 
                    belangrijke uitdagingen voor gemeenten, energiecoöperaties en bewoners van woonwijken.
                """.trimIndent()
                    )
                }
            }

            P {
                LangText(
                    en = """
                        LUX Neighbourhood allows stakeholders to identify bottlenecks and problems, and compare many 
                        potential solutions with smarter energy systems. This can range from
                    """.trimIndent(),
                    nl = """
                        LUX Woonwijk stelt belanghebbenden in staat knelpunten en problemen te identificeren en 
                        vele potentiële oplossingen met slimmere energiesystemen te vergelijken. Dit kan variëren van 
                    """.trimIndent()
                )
            }
            Ul(
                Modifier
                    .display(DisplayStyle.Flex)
                    .flexDirection(FlexDirection.Column)
                    .gap(8.px)
                    .toAttrs()
            ) {
                Li {
                    LangText(
                        en = "grid reinforcement,",
                        nl = "netverzwaring,"
                    )
                }
                Li {
                    LangText(
                        en = "shared energy storage,",
                        nl = "gedeelde energieopslag,"
                    )
                }
                Li {
                    LangText(
                        en = "implementing the ‘holon spirit’ through increasing self-consumption with solar pv,",
                        nl = "het ‘holon-gedachtegoed’ toepassen door zelfconsumptie te verhogen met zonne-pv,"
                    )
                }
                Li {
                    LangText(
                        en = "electric vehicles and smart consumption.",
                        nl = "elektrische voertuigen en slim verbruik."
                    )
                }
            }
        }
    }
}
