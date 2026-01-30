package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_company.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.ImageContent
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.ResponsiveFlexStyle
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.components.ApplicationAreaCTAButton
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P

@Composable
fun LuxCompanyHero() {
    LuxSectionContainer(
        modifier = Modifier.alignItems(AlignItems.FlexStart)
    ) {
        HeaderText(
            enText = LuxApplicationArea.LUX_BUSINESS.label.en,
            nlText = LuxApplicationArea.LUX_BUSINESS.label.nl,
        )
        Div(
            ResponsiveFlexStyle.toModifier()
                .alignItems(AlignItems.FlexStart)
                .toAttrs()
        ) {
            HeroTextContent()
            Box(Modifier.fillMaxWidth()) {
                ImageContent(
                    imageUrl = "/lux/images/horizon_img.jpg",
                    alt = "horizon",
                )
            }
        }
    }
}

@Composable
private fun HeroTextContent() {
    Column(
        modifier = Modifier.fillMaxWidth()
            .gap(1.cssRem)
    ) {
        P(
            Modifier.margin(0.px)
                .toAttrs()
        ) {
            LangText(
                en = """
                    More and more companies are discovering that they can grow their business with batteries, even if 
                    the grid operator does not make extra capacity available.
                """.trimIndent(),
                nl = """
                    Steeds meer bedrijven ontdekken dat ze met batterijen hun bedrijf kunnen laten groeien, zelfs als 
                    de netbeheerder geen extra capaciteit beschikbaar stelt.
                """.trimIndent()
            )
        }
        InsightTextContent()
        ApplicationAreaCTAButton(
            text = LocalizedText(
                en = "Start Your Analysis",
                nl = "Start Uw Analyse"
            )
        )
    }
}

@Composable
private fun InsightTextContent() {
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(32.px)
            .background(SitePalette.light.secondary)
            .luxBorderRadius(LuxCornerRadius.lg)
    ) {
        P(
            Modifier.margin(0.px)
                .toAttrs()
        ) {
            LangText(
                en = """
                    Did you know that an average company only uses [X]% of its peak power and that a battery of [X]% 
                    extra energy consumption allows for [X]% extra energy consumption?
                """.trimIndent(),
                nl = """
                   Wist je dat een gemiddeld bedrijf maar [X]% van zijn piekvermogen gebruikt en dat een batterij van 
                   [X] uur wel [X]% extra energieverbruik mogelijk maakt? 
                """.trimIndent()
            )
        }
        P(
            Modifier
                .opacity(70.percent)
                .toAttrs()
        ) {
            LangText(
                en = """
                    [These figures are based on a recent analysis that we did with our software on all standard SBI 
                    usage profiles as made available by TNO and Alliander at the end of 2024. See [here] for our 
                    analysis.]
                """.trimIndent(),
                nl = """
                    [Deze cijfers zijn gebaseerd op een recente analyse die wij met onze software gedaan hebben op alle
                     standaard SBI gebruiksprofielen zoals die eind 2024 door TNO en Alliander beschikbaar zijn 
                     gesteld. Zie [hier] voor onze analyse.]
                """.trimIndent()
            )
        }
    }
}