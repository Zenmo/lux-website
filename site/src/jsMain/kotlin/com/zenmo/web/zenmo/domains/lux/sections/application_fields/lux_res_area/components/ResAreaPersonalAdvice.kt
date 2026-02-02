package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_res_area.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiBalance
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.shapes.Circle
import com.varabyte.kobweb.silk.theme.shapes.clip
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.sections.ResponsiveRowStyle
import com.zenmo.web.zenmo.domains.lux.sections.responsiveGap
import com.zenmo.web.zenmo.domains.lux.styles.verticalLinearBackground
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P


@Composable
fun ResAreaPersonalAdvice() {
    Div(
        ResponsiveRowStyle.toModifier()
            .alignItems(AlignItems.Center)
            .responsiveGap()
            .toAttrs()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .gap(1.cssRem)
        ) {
            HeaderText(
                enText = "Need Personal Advice?",
                nlText = "Persoonlijk Advies Nodig?",
            )
            P {
                LangText(
                    en = """
                        If your situation is unique or if you want personal advice, that is also possible. Possibly as 
                        a next step.
                    """.trimIndent(),
                    nl = """
                        Als jouw situatie uniek is of als je persoonlijk advies wilt kan dat ook. Eventueel als
                        vervolgstap.
                    """.trimIndent()
                )
            }
        }
        ImpartialAdviceCard()
    }
}


@Composable
private fun ImpartialAdviceCard() {
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(48.px)
            .gap(1.cssRem)
            .luxBorderRadius(LuxCornerRadius.lg)
            .verticalLinearBackground(
                topColor = SitePalette.light.primary.lightened(0.85f),
                bottomColor = Colors.White
            )
            .border(
                1.px,
                LineStyle.Solid,
                SitePalette.light.primary.lightened(0.5f)
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                Modifier
                    .size(48.px)
                    .background(SitePalette.light.primary.lightened(0.1f))
                    .color(Colors.White)
                    .clip(shape = Circle())
                    .flexShrink(0),
                contentAlignment = Alignment.Center
            ) {
                MdiBalance(Modifier.fontSize(24.px))
            }

            Column(
                Modifier.margin(left = 16.px)
                    .gap(0.5.cssRem)
            ) {
                LangText(
                    en = "Independent",
                    nl = "Onafhankelijk"
                )
                H3(
                    Modifier
                        .color(SitePalette.light.primary)
                        .toAttrs()
                ) {
                    LangText(
                        en = "Impartial Advice",
                        nl = "Onpartijdig Advies"
                    )
                }
            }
        }

        P {
            LangText(
                en = """
                    Because Zenmo is independent of selling parties, you can expect reliable and impartial advice from 
                    us.
                """.trimIndent(),
                nl = """
                    En omdat Zenmo onafhankelijk is van verkopende partijen kan je van ons betrouwbaar en onpartijdig 
                    advies verwachten.
                """.trimIndent()
            )
        }
    }
}