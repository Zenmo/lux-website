package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_res_area.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.icons.mdi.MdiHelp
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.sections.home.CardGridStyle
import com.zenmo.web.zenmo.domains.lux.styles.HoverBoxShadowStyle
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P

private val questions = listOf(
    LocalizedText(
        en = "How do we get residential areas off the gas and at the same time reduce energy costs?",
        nl = "Hoe krijgen we woonwijken van het gas af en verlagen we tegelijkertijd de energiekosten?"
    ),
    LocalizedText(
        en = "How do we deal with grid congestion?",
        nl = "Hoe gaan we om met netcongestie?"
    ),
    LocalizedText(
        en = "Where are district heating the solutions and where are (hybrid) heat pumps a better option?",
        nl = "Waar zijn warmtenetten de oplossingen en waar zijn (hybride) warmtepompen een betere optie?"
    ),
    LocalizedText(
        en = "How do we facilitate energy cooperatives?",
        nl = "Hoe faciliteren we energiecoöperaties?"
    ),
    LocalizedText(
        en = "Which sustainable options are attractive in your residential area?",
        nl = "Welke duurzame opties zijn in jouw woonwijk aantrekkelijk?"
    ),
)


@OptIn(DelicateApi::class)
@Composable
fun QuestionsGrid() {
    val breakpoint = rememberBreakpoint()
    Div(
        CardGridStyle.toModifier()
            .height(auto)
            .alignSelf(AlignSelf.Stretch)
            .thenIf(
                breakpoint < Breakpoint.MD,
                Modifier.display(DisplayStyle.Flex)
                    .flexDirection(FlexDirection.Column)
            )
            .toAttrs()
    ) {
        questions.forEach { question ->
            QuestionItem(question)
        }
    }
}

@Composable
private fun QuestionItem(
    question: LocalizedText
) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(32.px)
            .gap(12.px)
            .background(SitePalette.light.overlay)
            .luxBorderRadius(LuxCornerRadius.lg)
            .borderLeft(4.px, LineStyle.Solid, SitePalette.light.primary)
            .then(HoverBoxShadowStyle.toModifier())
    ) {
        MdiHelp(Modifier.color(SitePalette.light.primary))
        P(
            Modifier.margin(0.px)
                .toAttrs()
        ) {
            LangText(
                en = question.en,
                nl = question.nl
            )
        }
    }
}