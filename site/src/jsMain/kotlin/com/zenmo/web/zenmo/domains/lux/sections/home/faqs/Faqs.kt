package com.zenmo.web.zenmo.domains.lux.sections.home.faqs

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.InlineLink
import com.zenmo.web.zenmo.components.widgets.LangBlock
import com.zenmo.web.zenmo.core.services.localization.localizedUrl
import com.zenmo.web.zenmo.domains.lux.sections.home.CardGridStyle
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.AlignSelf
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun Faqs(breakpoint: Breakpoint) {
    var expandedIndex by remember { mutableStateOf<Int?>(null) }
    Div(
        CardGridStyle.toModifier()
            .fillMaxHeight()
            .alignSelf(AlignSelf.Stretch)
            .thenIf(
                breakpoint < Breakpoint.MD,
                Modifier.display(DisplayStyle.Flex)
                    .flexDirection(FlexDirection.Column)
            )
            .toAttrs()
    ) {
        FaqItem.faqs.forEachIndexed { index, faq ->
            FaqsCardItem(
                faq = faq,
                isExpanded = expandedIndex == index,
                onClick = {
                    expandedIndex = if (expandedIndex == index) null else index
                }
            )
        }
    }
}

val FaqFallbackStyle = CssStyle {
    base {
        Modifier
            .background(SitePalette.light.primary)
            .color(Colors.White)
            .luxBorderRadius(LuxCornerRadius.lg)
            .padding(32.px)
            .alignSelf(AlignSelf.Stretch)
    }
    cssRule(" .silk-link") {
        Modifier.color(Colors.White)
    }
}

@Composable
fun FaqFallBack() {
    Box(
        FaqFallbackStyle.toModifier(),
        contentAlignment = Alignment.Center,
    ) {
        P(
            Modifier.margin(0.px)
                .display(DisplayStyle.InlineBlock)
                .toAttrs()
        ) {
            LangBlock(
                en = {
                    Text(
                        "Can't find what you're looking for? ",
                    )
                    InlineLink(
                        destinationUrl = localizedUrl("/book-demo"),
                        enLinkText = "Contact us",
                        nlLinkText = "",
                    )
                    Text(
                        " for support!"
                    )
                },
                nl = {
                    Text(
                        "Kun je niet vinden wat je zoekt? ",
                    )
                    InlineLink(
                        destinationUrl = localizedUrl("/book-demo"),
                        enLinkText = "",
                        nlLinkText = "Neem contact met ons op",
                        textColor = Colors.White
                    )
                    Text(
                        " voor ondersteuning!"
                    )
                }
            )
        }
    }
}
