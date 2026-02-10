package com.zenmo.web.zenmo.domains.lux.sections.home

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiTaskAlt
import com.varabyte.kobweb.silk.components.icons.mdi.MdiTrendingDown
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.sections.ResponsiveFlexStyle
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.LuxSpecificColorHues
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.font.BodyTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P

@Composable
fun ProblemAndSolutionSection() {
    SectionContainer(
        variant = LuxSectionContainerStyleVariant,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Div(
            ResponsiveFlexStyle
                .toModifier()
                .alignItems(AlignItems.FlexStart)
                .toAttrs()
        ) {
            FeatureColumn(
                features = FeatureItemData.challenges,
                title = LocalizedText(
                    en = "The old system is at its limits",
                    nl = "Het oude systeem zit aan zijn grenzen"
                ),
                badgeText = LocalizedText(
                    en = "The Challenge",
                    nl = "De Uitdaging"
                ),
                badgeColor = LuxSpecificColorHues().luxRed
            )
            FeatureColumn(
                features = FeatureItemData.solutions,
                title = LocalizedText(
                    en = "A new approach",
                    nl = "Een nieuwe aanpak"
                ),
                badgeText = LocalizedText(
                    en = "The Solution",
                    nl = "De Oplossing"
                ),
                badgeColor = LuxSpecificColorHues().luxGreen
            )
        }
    }
}


@Composable
private fun FeatureColumn(
    features: List<FeatureItemData>,
    title: LocalizedText,
    badgeText: LocalizedText,
    badgeColor: Color = Colors.Red
) {
    Column(
        modifier = Modifier
            .gap(32.px)
            .flex(1, 0, 0.percent),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        FeatureBadge(
            text = badgeText,
            badgeColor = badgeColor
        )
        HeaderText(
            enText = title.en,
            nlText = title.nl,
            modifier = Modifier.width(90.percent)
        )
        Column(
            modifier = Modifier.gap(16.px).width(90.percent)
        ) {
            features.forEach { FeatureItem(it) }
        }
    }
}

@Composable
fun FeatureBadge(
    text: LocalizedText,
    badgeColor: Color
) {
    Div(
        Modifier
            .display(DisplayStyle.InlineBlock)
            .padding(8.px, 16.px)
            .justifyContent(JustifyContent.Center)
            .backgroundColor(badgeColor.lightened(0.85f))
            .luxBorderRadius()
            .color(badgeColor)
            .toAttrs()
    ) {
        LangText(
            en = text.en,
            nl = text.nl
        )
    }
}

@Composable
private fun FeatureItem(
    feature: FeatureItemData
) {
    Row(
        modifier = Modifier.alignSelf(AlignSelf.Stretch).gap(16.px),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top
    ) {
        feature.icon()
        P(
            TextStyle.toModifier(BodyTextStyle).margin(0.cssRem).toAttrs()
        ) {
            LangText(
                en = feature.text.en,
                nl = feature.text.nl
            )
        }
    }
}


private data class FeatureItemData(
    val icon: @Composable () -> Unit,
    val text: LocalizedText,
) {
    companion object {
        val challenges = listOf(
            FeatureItemData(
                icon = {
                    MdiTrendingDown(Modifier.featureIcon(LuxSpecificColorHues().luxRed))
                },
                text = LocalizedText(
                    en = "Fossil Fuel is dirty, expensive, and running out.",
                    nl = "Fossiele brandstof is vervuilend, duur en raakt op."
                )
            ),
            FeatureItemData(
                icon = {
                    MdiTrendingDown(Modifier.featureIcon(LuxSpecificColorHues().luxRed))
                },
                text = LocalizedText(
                    en = """
                        Old top-down electricity grids are increasingly inadequate, expensive, and the grid is not set 
                        up to facilitate demand-response.
                    """.trimIndent(),
                    nl = """
                        Oude top-down elektriciteitsnetten zijn steeds minder adequaat en duur, en het net is niet 
                        ingericht op vraagsturing.
                    """.trimIndent()
                )
            )
        )

        val solutions = listOf(
            FeatureItemData(
                icon = {
                    MdiTaskAlt(Modifier.featureIcon(LuxSpecificColorHues().luxGreen))
                },
                text = LocalizedText(
                    en = "Solar, wind, battery storage and grid forming converters are heralding a revolution.",
                    nl = "Zonne-energie, windenergie, batterijopslag en netvormende omvormers luiden een revolutie in."
                )
            ),
            FeatureItemData(
                icon = {
                    MdiTaskAlt(Modifier.featureIcon(LuxSpecificColorHues().luxGreen))
                },
                text = LocalizedText(
                    en = """
                        The new smart-grid will be resilient, cost-effective, and controlled from the bottom-up. LUX 
                        shows how.
                    """.trimIndent(),
                    nl = """
                        Het nieuwe slimme netwerk zal veerkrachtig, kosteneffectief en van onderaf aangestuurd zijn. 
                        LUX laat zien hoe.
                    """.trimIndent()
                )
            )
        )
    }
}

fun Modifier.featureIcon(
    color: Color = SitePalette.light.primary,
    size: CSSLengthValue = 24.px
) = this.fontSize(size)
    .color(color)




