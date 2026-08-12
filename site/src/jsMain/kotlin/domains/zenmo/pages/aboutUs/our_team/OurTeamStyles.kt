package energy.lux.frontend.domains.zenmo.pages.aboutUs.our_team

import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.invert
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.css.functions.toImage
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.theme.shapes.Circle
import com.varabyte.kobweb.silk.theme.shapes.clip
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.JustifyContent

// Kept for use by ProfileContactCard in lux subdomain components.
val TeamCardImageContainerStyle = CssStyle {
    base { Modifier.size(15.cssRem) }
    Breakpoint.LG { Modifier.size(20.cssRem) }
    Breakpoint.XL { Modifier.size(20.cssRem) }
}

val ProfileImageStyle = CssStyle.base {
    Modifier.fillMaxSize()
        .borderRadius(50.percent)
        .padding(10.px)
        .objectFit(ObjectFit.Cover)
        .clip(Circle())
}

val TeamCardStyle = CssStyle {
    base {
        Modifier
            .background(Colors.White)
            .borderRadius(20.px)
            .overflow(Overflow.Hidden)
            .boxShadow(
                0.px,
                2.px,
                8.px,
                0.px,
                rgba(0, 0, 0, 0.08f)
            )
            .transition(
                Transition.of(
                    TransitionProperty.All,
                    300.ms,
                    AnimationTimingFunction.Ease
                )
            )
    }
    hover {
        Modifier
            .boxShadow(
                0.px,
                20.px,
                40.px,
                0.px,
                rgba(0, 0, 0, 0.16f)
            )
            .transform { translateY((-8).px) }
    }
    cssRule(" .team-card-image") {
        Modifier.transition(
            Transition.of(
                "transform",
                500.ms,
                AnimationTimingFunction.Ease
            )
        )
    }
    cssRule(":hover .team-card-image") {
        Modifier.transform { scale(1.1f) }
    }
    // overlay position/gradient/opacity live here (not inline) so :hover can override them.
    cssRule(" .team-card-overlay") {
        Modifier
            .position(Position.Absolute)
            .top(0.px).left(0.px).right(0.px).bottom(0.px)
            .background(
                Background.of(
                    image = linearGradient(LinearGradient.Direction.ToTop) {
                        add(SitePalette.light.primary.toRgb().copyf(alpha = 0.92f), 0.percent)
                        add(SitePalette.light.primary.toRgb().copyf(alpha = 0.6f), 25.percent)
                        add(SitePalette.light.primary.toRgb().copyf(alpha = 0.1f), 50.percent)
                        add(Colors.Transparent, 70.percent)
                    }.toImage()
                )
            )
            .opacity(0)
            .transition(
                Transition.of(
                    "opacity",
                    300.ms,
                    AnimationTimingFunction.Ease
                )
            )
    }
    cssRule(":hover .team-card-overlay") {
        Modifier.opacity(1)
    }
}

val SocialLinkStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .alignItems(AlignItems.Center)
            .justifyContent(JustifyContent.Center)
            .padding(0.5.cssRem)
            .borderRadius(50.percent)
            .background(Colors.Black.lightened(0.95f))
            .transition(
                Transition.of(
                    TransitionProperty.All,
                    200.ms,
                    AnimationTimingFunction.Ease
                )
            )
    }
    hover {
        Modifier
            .background(SitePalette.light.primary)
            .color(SitePalette.light.onPrimary)
    }
    cssRule(" img") {
        Modifier
            .size(16.px)
            .filter(Filter.of(invert(1)))
            .transition(
                Transition.of(
                    "filter",
                    200.ms,
                    AnimationTimingFunction.Ease
                )
            )
    }
    cssRule(":hover img") {
        Modifier
            .filter(Filter.of(invert(0)))
    }
}