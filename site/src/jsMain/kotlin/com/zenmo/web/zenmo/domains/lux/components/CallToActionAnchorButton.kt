package com.zenmo.web.zenmo.domains.lux.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.ArrowUpIcon
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.before
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.sections.DeEmphasizedTextStyle
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.font.HolonLineTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Span


val CallToActionAnchorButtonStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.LegacyInlineFlex)
            .position(Position.Relative)
            .alignItems(AlignItems.Center)
            .textDecorationLine(TextDecorationLine.None)
            .transition(Transition.of("color", 0.3.s))
            .gap(16.px)
    }
    cssRule(" .anchor-icon-wrapper") {
        Modifier
            .position(Position.Relative)
            .display(DisplayStyle.Flex)
            .justifyContent(JustifyContent.Center)
            .alignItems(AlignItems.Center)
            .transition(Transition.of("background-color", 0.3.s))
            .backgroundColor(SitePalette.light.primary)
            .backgroundImage(
                linearGradient(
                    SitePalette.light.primary, SitePalette.light.secondary,
                    LinearGradient.Direction.ToBottomRight
                )
            )
            .color(SitePalette.light.onPrimary)
            .borderRadius(16.px)
            .size(80.px)
    }

    cssRule(" .anchor-icon") {
        Modifier
            .fontSize(com.varabyte.kobweb.compose.css.FontSize.XXLarge)
            .transform { rotate(45.deg) }
    }

    cssRule(" .anchor-text-content h3") {
        Modifier
            .transition(Transition.of("transform", 0.3.s))
            .textAlign(TextAlign.Left)
            .color(SitePalette.light.onBackground)
            .margin(0.px)
    }


    cssRule(":hover .anchor-icon-wrapper") {
        Modifier
//            .backgroundColor(SitePalette.light.secondary)
//            .color(SitePalette.light.primary)
    }

    cssRule(":hover .anchor-text-content:last-child") {
        Modifier
            .transform { translateX(12.px) }
            .transition(Transition.of("transform", 0.3.s))
    }

    cssRule(":hover .anchor-icon") {
        Modifier
            .transform {
                rotate(45.deg)
                scale(2)
            }
            .transition(Transition.of("transform", 0.3.s))

    }
}

val LuxIconWrapperStyle = CssStyle {
    before {
        Modifier
            .content("")
            .left(0.px)
            .top(0.px)
            .right(0.px)
            .bottom(0.px)
            .borderRadius(16.px)
            .position(Position.Absolute)
            .display(DisplayStyle.Block)
            .transition(Transition.of("opacity", 0.3.s))
    }
}


@Composable
fun CallToActionAnchorButton(
    href: String = "/book-demo",
    subActionTextContent: @Composable () -> Unit = {
        Span(
            DeEmphasizedTextStyle.toModifier()
                .fontSize(0.9.cssRem)
                .toAttrs()
        ) {
            LangText(
                en = "BOOK A DEMO NOW!",
                nl = "BOEK NU EEN DEMO!"
            )
        }
    },
    actionTextContent: @Composable () -> Unit = {},
) {
    A(href = href, attrs = CallToActionAnchorButtonStyle.toAttrs()) {
        Div(
            Modifier.classNames("anchor-icon-wrapper")
                .then(LuxIconWrapperStyle.toModifier())
                .toAttrs()
        ) {
            ArrowUpIcon(
                modifier = Modifier.classNames("anchor-icon")
            )
        }
        Div(
            Modifier.classNames("anchor-text-content")
                .toAttrs()
        ) {
            H3(
                TextStyle.toModifier(HolonLineTextStyle)
                    .fontWeight(FontWeight.Bold)
                    .toAttrs()
            ) {
                actionTextContent()
            }
            subActionTextContent()
        }
    }
}