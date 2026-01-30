package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_company.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiBalance
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.shapes.Circle
import com.varabyte.kobweb.silk.theme.shapes.clip
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.ResponsiveRowStyle
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.components.ApplicationAreaCTAButton
import com.zenmo.web.zenmo.domains.lux.sections.responsiveGap
import com.zenmo.web.zenmo.domains.lux.styles.mutedWhite
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.LuxSpecificColorHues
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span


@Composable
fun PersonalAdvice(
    breakpoint: Breakpoint
) {
    LuxSectionContainer(
        modifier = Modifier
            .background(LuxSpecificColorHues().luxBlackRussian)
            .color(Colors.White)
    ) {
        Div(
            ResponsiveRowStyle.toModifier()
                .alignItems(AlignItems.Start)
                .responsiveGap()
                .thenIf(
                    breakpoint < Breakpoint.MD,
                    Modifier.flexDirection(FlexDirection.Column)
                )
                .toAttrs()
        ) {
            PersonalAdviceText()
            IndependentAdviceCard()
        }
    }
}

@Composable
private fun PersonalAdviceText() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        HeaderText(
            enText = "Personal Advice",
            nlText = "Persoonlijk Advies",
        )
        P(
            Modifier.mutedWhite().toAttrs()
        ) {
            LangText(
                en = """
                          If your situation is unique or if you just want personal advice, you can of course do that 
                          too. Possibly as a next step. And because Zenmo is independent of selling parties, you can 
                          expect reliable and impartial advice from us.  
                        """.trimIndent(),
                nl = """
                            Als jouw situatie uniek is of als jij gewoon persoonlijk advies wilt kan dan natuurlijk ook.
                            Eventueel als vervolgstap. En omdat Zenmo onafhankelijk is van verkopende partijen kan jij
                            van ons betrouwbaar en onpartijdig advies verwachten.
                        """.trimIndent()
            )
        }
    }
}


@Composable
private fun IndependentAdviceCard() {
    Column(
        modifier = Modifier.fillMaxWidth()
            .gap(1.cssRem),
        horizontalAlignment = Alignment.End
    ) {
        Column(
            Modifier.fillMaxWidth()
                .luxBorderRadius(LuxCornerRadius.lg)
                .background(Colors.White.copyf(alpha = 0.1f))
                .padding(32.px)
                .gap(1.cssRem)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    Modifier
                        .size(64.px)
                        .background(SitePalette.light.primary)
                        .color(Colors.White)
                        .clip(shape = Circle())
                        .flexShrink(0),
                    contentAlignment = Alignment.Center
                ) {
                    MdiBalance(Modifier.fontSize(32.px))
                }

                Column(
                    Modifier.margin(left = 16.px)
                        .gap(0.5.cssRem)
                ) {
                    Span(
                        Modifier.mutedWhite().toAttrs()
                    ) {
                        LangText(
                            en = "Independent",
                            nl = "Onafhankelijk"
                        )
                    }
                    H3(
                        Modifier
                            .margin(0.cssRem)
                            .toAttrs()
                    ) {
                        LangText(
                            en = "Impartial Advice",
                            nl = "Onpartijdig Advies"
                        )
                    }
                }
            }

            P(
                Modifier.mutedWhite().toAttrs()
            ) {
                LangText(
                    en = """
                        Zenmo is independent of selling parties, ensuring you get objective recommendations.
                    """.trimIndent(),
                    nl = """
                        Zenmo onafhankelijk is van verkopende partijen kan jij van ons betrouwbaar en onpartijdig 
                        advies verwachten.
                    """.trimIndent()
                )
            }
        }

        ApplicationAreaCTAButton(
            text = LocalizedText(
                en = "Contact Zenmo",
                nl = "Contacteer Zenmo"
            )
        )
    }
}

