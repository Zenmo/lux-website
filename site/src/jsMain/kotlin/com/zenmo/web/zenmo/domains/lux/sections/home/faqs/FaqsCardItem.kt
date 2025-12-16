package com.zenmo.web.zenmo.domains.lux.sections.home.faqs

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.JustifySelf
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.mdi.MdiChevronRight
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.styles.verticalLinearBackground
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.font.BodyTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.*

val FaqCardStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .padding(24.px)
            .alignItems(AlignItems.Center)
            .alignSelf(AlignSelf.Stretch)
            .justifySelf(JustifySelf.Stretch)
            .luxBorderRadius(LuxCornerRadius.lg)
            .border(1.px, LineStyle.Solid, SitePalette.light.overlay)
            .color(Colors.Black)
            .cursor(Cursor.Companion.Pointer)
            .transition(
                Transition.of(
                    property = TransitionProperty.All,
                    duration = 300.ms,
                    timingFunction = AnimationTimingFunction.Ease
                )
            )
            .verticalLinearBackground(
                SitePalette.Companion.light.overlay,
                SitePalette.Companion.light.overlay.lightened(0.7f)
            )
    }

    hover {
        Modifier
            .color(Colors.White)
            .border(1.px, LineStyle.Solid, SitePalette.light.overlay)
            .verticalLinearBackground()
    }
    cssRule(" .faq-icon ") {
        Modifier
            .background(SitePalette.light.secondary)
            .transition(
                Transition.of(
                    property = TransitionProperty.All,
                    duration = 300.ms,
                    timingFunction = AnimationTimingFunction.Ease
                )
            )
    }

    cssRule(":hover .faq-icon ") {
        Modifier.background(Colors.White)
    }

}

@Composable
fun FaqsCardItem(
    question: LocalizedText,
) {
    Box(
        modifier = FaqCardStyle.toModifier(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = TextStyle.toModifier(BodyTextStyle).gap(16.px)
        ) {
            Box(
                Modifier
                    .padding(6.px)
                    .color(Colors.Black)
                    .luxBorderRadius()
                    .classNames("faq-icon"),
                contentAlignment = Alignment.Center
            ) {
                MdiChevronRight(Modifier.fontSize(24.px))
            }

            LangText(
                en = question.en,
                nl = question.nl
            )
        }
    }
}