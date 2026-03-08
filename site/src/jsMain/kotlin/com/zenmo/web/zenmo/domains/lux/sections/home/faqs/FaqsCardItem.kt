package com.zenmo.web.zenmo.domains.lux.sections.home.faqs

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.Cursor
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
import com.varabyte.kobweb.silk.components.icons.mdi.MdiChevronRight
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.styles.SubMenuContentStyle
import com.zenmo.web.zenmo.domains.lux.styles.SubmenuContainerStyle
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.components.AnimatedIconStyle
import com.zenmo.web.zenmo.theme.font.BodyTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import com.zenmo.web.zenmo.theme.styles.DropdownTriggerStyle
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div


@Composable
fun FaqsCardItem(
    faq: FaqItem,
    isExpanded: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = FaqCardStyle.toModifier()
            .thenIf(
                isExpanded,
                DropdownTriggerStyle.toModifier()
                    .then(FaqsIconHoverStyle.toModifier())
            )
            .cursor(Cursor.Pointer)
            .onClick { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = TextStyle.toModifier(BodyTextStyle)
                    .gap(16.px)
            ) {
                Box(
                    Modifier
                        .padding(6.px)
                        .color(Colors.Black)
                        .luxBorderRadius()
                        .classNames("faq-icon"),
                    contentAlignment = Alignment.Center
                ) {
                    MdiChevronRight(
                        Modifier.fontSize(24.px)
                            .then(AnimatedIconStyle.toModifier())
                    )
                }

                LangText(
                    en = faq.question.en,
                    nl = faq.question.nl
                )
            }
            FaqAnswerBlock { faq.answerBlock() }
        }
    }
}


@Composable
private fun FaqAnswerBlock(
    content: @Composable () -> Unit,
) {
    Div(
        SubmenuContainerStyle.toModifier()
            .animation(
                FaqsAnswerBlockSlideOutAnimKeyFrames.toAnimation(
                    duration = 200.ms,
                    timingFunction = AnimationTimingFunction.EaseIn,
                )
            )
            .fillMaxWidth()
            .toAttrs()
    ) {
        Column(
            modifier = SubMenuContentStyle.toModifier()
                .then(FaqsAnswerBlockStyle.toModifier())
        ) {
            content()
        }
    }
}