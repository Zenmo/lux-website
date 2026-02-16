package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.functions.clamp
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLightbulb
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.shapes.Circle
import com.varabyte.kobweb.silk.theme.shapes.clip
import com.zenmo.web.zenmo.components.widgets.InlineLink
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.ResponsiveFlexStyle
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.components.ApplicationAreaVideo
import com.zenmo.web.zenmo.domains.lux.styles.secondaryGradientBackground
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*


@Composable
fun DidYouKNowSection() {
    LuxSectionContainer(
        modifier = Modifier
            .background(SitePalette.light.overlay),
    ) {
        DidYouKnowBanner()
        Column(
            modifier = Modifier.gap(1.5.cssRem)
                .textAlign(TextAlign.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SubHeaderText(
                enText = "We can do much more with the existing capacity grid.",
                nlText = "We kunnen veel meer met het bestaande elektriciteitsnet.",
            )

            Span(
                Modifier
                    .padding(5.px, 8.px)
                    .justifyContent(JustifyContent.Center)
                    .backgroundColor(SitePalette.light.primary)
                    .color(Colors.White)
                    .luxBorderRadius()
                    .toAttrs()
            ) {
                LangText(
                    en = "LUX Energy Hub shows how!",
                    nl = "LUX Energy Hub laat zien hoe!"
                )
            }
            ApplicationAreaVideo(
                src = "/lux/videos/EnergyHubDashboardMovie.mp4",
                poster = "/lux/images/energyHubMoviePoster.png",
                videoTitle = LocalizedText(
                    en = "Energy Hub Dashboard",
                    nl = "Energy Hub Dashboard"
                ),
            )
        }
        EnergyHubExampleFeatures()
    }
}

@Composable
private fun DidYouKnowBanner() {
    Div(
        ResponsiveFlexStyle.toModifier()
            .alignItems(AlignItems.FlexStart)
            .luxBorderRadius(LuxCornerRadius.xl)
            .padding(clamp(32.px, 5.vw, 64.px))
            .secondaryGradientBackground()
            .toAttrs()
    ) {
        Box(
            Modifier
                .size(96.px)
                .background(Colors.White)
                .color(SitePalette.light.secondary)
                .clip(shape = Circle())
                .flexShrink(0),
            contentAlignment = Alignment.Center
        ) {
            MdiLightbulb(Modifier.fontSize(48.px))
        }

        Column(
            modifier = Modifier.gap(1.cssRem)
        ) {
            HeaderText(
                enText = "Did you know?",
                nlText = "Wist je dat?",
            )

            Div {
                P {
                    LangText(
                        en = "Did you know that the electricity grid has an average of 80% capacity left? ",
                        nl = "Wist je dat het elektriciteitsnet gemiddeld genomen 80% capaciteit over heeft? "
                    )
                    Br { }
                    Br { }
                    LangText(
                        en = """
                            Did you know that most companies only use [X]% of their contracted power on average and 
                            that a [X] hour battery allows them to expand their capacity [X]%? 
                        """.trimIndent(),
                        nl = """
                            Wist je dat de meeste bedrijven gemiddeld maar [X]% van hun gecontracteerd vermogen 
                            gebruiken en dat een batterij van [X] uur hen in staat stelt hun capaciteit [X]% uit te 
                            breiden? 
                        """.trimIndent()
                    )
                }

                P {
                    LangText(
                        en = """
                            These figures are based on a recent analysis that we did with our software on all standard
                            SBI usage profiles as made available by TNO and Alliander at the end of 2024. 
                        """.trimIndent(),
                        nl = """
                            Deze cijfers zijn gebaseerd op een recente analyse die wij met onze software gedaan
                            hebben op alle standaard SBI gebruiksprofielen zoals die eind 2024 door TNO en Alliander
                            beschikbaar zijn gesteld. 
                        """.trimIndent()
                    )
                    Text(" ")
                    InlineLink(
                        destinationUrl = "/",
                        enLinkText = "See here for our analysis",
                        nlLinkText = "Zie hier voor onze analyse."
                    )
                }
            }
        }
    }
}
