package energy.lux.site.frontend.domains.lux.sections.home

import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.AlignSelf
import org.jetbrains.compose.web.css.JustifyContent


private val sharedModifier = Modifier
    .position(Position.Absolute)
    .styleModifier { property("-webkit-backface-visibility", "hidden") }
    .justifyContent(JustifyContent.Center)
    .alignItems(AlignItems.Center)
    .gap(24.px)
    .padding(16.px)
    .alignSelf(AlignSelf.Stretch)
    .justifySelf(JustifySelf.Stretch)
    .backfaceVisibility(BackfaceVisibility.Hidden)
    .luxBorderRadius(LuxCornerRadius.lg)
    .fillMaxSize()

val FlipCardStyle = CssStyle {
    base {
        Modifier
            .fillMaxSize()
            .cursor(Cursor.Pointer)
            .styleModifier {
                property("perspective", "1000px")
            }
            .transform { rotateY(0.deg) }
    }
    cssRule(":hover .flip-card-inner") {
        Modifier
            .transform { rotateY(180.deg) }
    }
}

val FlipCardInnerStyle = CssStyle.base {
    Modifier
        .position(Position.Relative)
        .textAlign(TextAlign.Center)
        .transition(Transition.of("transform", 0.8.s))
        .transformStyle(TransformStyle.Preserve3d)
        .fillMaxSize()
}

val FlipCardFrontStyle = CssStyle.base {
    sharedModifier
        .backgroundColor(Colors.White.copyf(alpha = 0.1f))
        .color(Colors.White)
}

val FlipCardBackStyle = CssStyle.base {
    sharedModifier
        .backgroundColor(SitePalette.light.secondary)
        .color(Colors.Black)
        .transform { rotateY(180.deg) }
}