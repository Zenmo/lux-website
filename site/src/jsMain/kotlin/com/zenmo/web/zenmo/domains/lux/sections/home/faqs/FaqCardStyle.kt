package com.zenmo.web.zenmo.domains.lux.sections.home.faqs

import com.varabyte.kobweb.compose.css.BoxShadow
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.JustifySelf
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.rotate
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.hover
import com.zenmo.web.zenmo.domains.lux.styles.verticalLinearBackground
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.AlignSelf
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

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
            .cursor(Cursor.Pointer)
            .transition(
                Transition.of(
                    property = TransitionProperty.All,
                    duration = 300.ms,
                    timingFunction = AnimationTimingFunction.Ease
                )
            )
            .verticalLinearBackground(
                SitePalette.light.overlay,
                SitePalette.light.overlay.lightened(0.7f)
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

val FaqsIconHoverStyle = CssStyle {
    cssRule(":hover  .material-icons ") {
        Modifier.Companion
            .transform {
                rotate(90.deg)
            }
    }
}

val FaqsAnswerBlockStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .padding(16.px)
            .background(SitePalette.light.overlay)
            .color(Colors.Black)
            .boxShadow(
                BoxShadow.of(
                    0.px, 20.px, 25.px, (-5).px, Colors.Black.copyf(alpha = 0.1f)
                ),
                BoxShadow.of(
                    0.px, 10.px, 10.px, (-5).px, Colors.Black.copyf(alpha = 0.04f)
                ),
            )
            .overflow(
                overflowY = Overflow.Scroll,
                overflowX = Overflow.Auto
            )
    }
    Breakpoint.ZERO {
        Modifier.maxHeight(200.px)
    }
    Breakpoint.SM {
        Modifier.maxHeight(200.px)
    }
    Breakpoint.MD {
        Modifier.maxHeight(250.px)
    }
    Breakpoint.LG {
        Modifier.maxHeight(300.px)
    }
    Breakpoint.XL {
        Modifier.maxHeight(300.px)
    }
    Breakpoint.XXL {
        Modifier.maxHeight(300.px)
    }
}


val FaqsAnswerBlockSlideOutAnimKeyFrames = Keyframes {
    from {
        Modifier
            .height(0.px)
            .opacity(0)
            .translateY((-8).px)
    }
    to {
        Modifier
            .maxHeight(300.px)
            .opacity(1)
            .translateY(0.px)
    }
}

