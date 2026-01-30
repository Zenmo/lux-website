package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiWarning
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.ImageContent
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.ResponsiveRowStyle
import com.zenmo.web.zenmo.domains.lux.sections.responsiveGap
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.LuxSpecificColorHues
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P

@Composable
fun LuxEnergyHubHero(
    breakpoint: Breakpoint
) {
    LuxSectionContainer(
        modifier = Modifier.alignItems(AlignItems.FlexStart)
    ) {
        Div(
            ResponsiveRowStyle.toModifier()
                .thenIf(
                    breakpoint < Breakpoint.MD,
                    Modifier.flexDirection(FlexDirection.Column)
                )
                .alignItems(AlignItems.FlexStart)
                .responsiveGap()
                .toAttrs()
        ) {
            HeroTextContent()
            Box(Modifier.fillMaxWidth()) {
                ImageContent(
                    imageUrl = "/lux/images/nature_img.jpg",
                    alt = "nature",
                )
            }
        }
    }
}

@Composable
private fun HeroTextContent() {
    Column(
        modifier = Modifier.fillMaxWidth()
            .gap(1.5.cssRem)
    ) {
        HeaderText(
            enText = "LUX Energy Hub",
            nlText = "LUX-Energiehub",
        )
        P(
            Modifier.margin(0.px)
                .toAttrs()
        ) {
            LangText(
                en = """
                    More and more business parks are faced with a grid operator that does not make sufficient capacity 
                    available: grid congestion.
                """.trimIndent(),
                nl = """
                    Steeds meer bedrijventerreinen krijgen te maken met een netbeheerder die onvoldoende capaciteit ter 
                    beschikking stelt: netcongestie.
                """.trimIndent()
            )
        }
        NederlandCodeRed()
    }
}

@Composable
private fun NederlandCodeRed() {
    val luxRed = LuxSpecificColorHues().luxRed
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(24.px)
            .gap(16.px)
            .background(luxRed.lightened(0.85f))
            .luxBorderRadius(LuxCornerRadius.lg)
            .borderLeft(4.px, LineStyle.Solid, luxRed)
    ) {
        MdiWarning(Modifier.color(luxRed))
        P(
            Modifier
                .margin(0.px)
                .toAttrs()
        ) {
            LangText(
                en = """
                    In almost all of the Netherlands it is now "code red" and there are already more than 20 thousand 
                    companies on the queue. This while companies want to expand and become more sustainable with solar 
                    panels, electric vehicles, heat pumps, etc.
                """.trimIndent(),
                nl = """
                    In bijna heel Nederland is het intussen “code rood” en er staan al meer dan 20 duizend bedrijven op 
                    de wachtrij. Dat terwijl bedrijven juist willen uitbreiden en verduurzamen met zonnepanelen, 
                    elektrische voertuigen, warmtepompen, et cetera.
                """.trimIndent()
            )
        }
    }
}