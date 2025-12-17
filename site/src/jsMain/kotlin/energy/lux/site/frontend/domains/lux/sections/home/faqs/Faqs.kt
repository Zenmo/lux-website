package energy.lux.site.frontend.domains.lux.sections.home.faqs

import androidx.compose.runtime.Composable
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
import com.zenmo.web.zenmo.domains.lux.sections.home.CardGridStyle
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.AlignSelf
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun Faqs(breakpoint: Breakpoint) {
    Div(
        CardGridStyle.toModifier()
            .height(auto)
            .alignSelf(AlignSelf.Companion.Stretch)
            .thenIf(
                breakpoint < Breakpoint.MD,
                Modifier.Companion.display(DisplayStyle.Companion.Flex)
                    .flexDirection(FlexDirection.Companion.Column)
            )
            .toAttrs()
    ) {
        FaqItem.Companion.faqs.forEach { faq ->
            FaqsCardItem(faq.question)
        }
    }
}

val FaqFallbackStyle = CssStyle {
    base {
        Modifier.Companion
            .background(SitePalette.Companion.light.primary)
            .color(Colors.White)
            .luxBorderRadius(LuxCornerRadius.lg)
            .padding(32.px)
            .alignSelf(AlignSelf.Companion.Stretch)
    }
    cssRule(" .silk-link") {
        Modifier.Companion.color(Colors.White)
    }
}

@Composable
fun FaqFallBack() {
    Box(
        FaqFallbackStyle.toModifier(),
        contentAlignment = Alignment.Center,
    ) {
        P(
            Modifier.Companion.margin(0.px)
                .display(DisplayStyle.Companion.InlineBlock)
                .toAttrs()
        ) {
            LangBlock(
                en = {
                    Text(
                        "Can't find what you're looking for? ",
                    )
                    InlineLink(
                        enLinkText = "Contact us",
                        nlLinkText = "",
                        destinationUrl = "/book-demo",
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
                        enLinkText = "",
                        nlLinkText = "Neem contact met ons op",
                        destinationUrl = "/book-demo",
                    )
                    Text(
                        " voor ondersteuning!"
                    )
                }
            )
        }
    }
}