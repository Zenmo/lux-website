package energy.lux.frontend.domains.lux.sections.home.hero

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.domains.lux.components.LuxSectionContainer
import energy.lux.frontend.domains.lux.sections.responsiveGap
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.Div

val HeroFlexStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .display(DisplayStyle.Flex)
    }

    Breakpoint.ZERO {
        Modifier
            .flexDirection(FlexDirection.Column)
            .alignItems(AlignItems.FlexStart)
            .gap(1.cssRem)
    }

    Breakpoint.SM {
        Modifier
            .flexDirection(FlexDirection.Column)
            .alignItems(AlignItems.FlexStart)
            .gap(1.cssRem)
    }
    Breakpoint.MD {
        Modifier
            .flexDirection(FlexDirection.Column)
            .alignItems(AlignItems.FlexStart)
            .gap(1.cssRem)
            .width(60.percent)
    }

    Breakpoint.LG {
        Modifier
            .flexDirection(FlexDirection.Row)
            .fillMaxWidth()
            .alignItems(AlignItems.Center)
            .responsiveGap()
    }

    Breakpoint.XL {
        Modifier
            .flexDirection(FlexDirection.Row)
            .fillMaxWidth()
            .alignItems(AlignItems.Center)
            .responsiveGap()
    }
}

@Composable
fun HeroParagraphAndVideoContent() {
    LuxSectionContainer(
        Modifier
            .position(Position.Relative)
            .alignItems(AlignItems.FlexStart)
    ) {
        Div(
            HeroFlexStyle
                .toModifier()
                .toAttrs(),
        ) {
            WhatIsLuxText()
            WhatIsLuxVideo()
        }
    }
}