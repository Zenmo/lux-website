package energy.lux.frontend.domains.zenmo.pages.aboutUs.our_story.components

import com.varabyte.kobweb.compose.css.Background
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.css.functions.toImage
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.*

val OurStoryHeroStyle = CssStyle {
    base { Modifier.height(300.px) }
    Breakpoint.MD { Modifier.height(460.px) }
}

val MilestoneTimelineContainerStyle = CssStyle {
    base {
        Modifier
            .position(Position.Relative)
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
    }
    Breakpoint.MD { Modifier.flexDirection(FlexDirection.Row) }
}


val StoryTimelineLineBackgroundModifier = Modifier
    .background(
        Background.of(
            image = linearGradient(LinearGradient.Direction.ToLeft) {
                add(Colors.Transparent)
                add(Colors.Black.lightened(0.9f))
                add(Colors.Transparent)
            }.toImage()
        )
    )
val MilestoneTimelineVerticalLineStyle = CssStyle {
    base {
        Modifier
            .position(Position.Absolute)
            .left(5.px).top(0.px).bottom(0.px)
            .width(2.px)
            .then(StoryTimelineLineBackgroundModifier)
    }
    Breakpoint.MD { Modifier.display(DisplayStyle.None) }
}

val MilestoneTimelineHorizontalLineStyle = CssStyle {
    base { Modifier.display(DisplayStyle.None) }
    Breakpoint.MD {
        Modifier
            .display(DisplayStyle.Block)
            .position(Position.Absolute)
            .top(5.px).left(0.px).right(0.px)
            .height(2.px)
            .then(StoryTimelineLineBackgroundModifier)
    }
}

val MilestoneItemStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Row)
            .alignItems(AlignItems.Center)
            .gap(1.cssRem)
            .padding(topBottom = 0.75.cssRem)
    }
    Breakpoint.MD {
        Modifier
            .flexDirection(FlexDirection.Column)
            .flex(1)
            .alignItems(AlignItems.Center)
            .textAlign(TextAlign.Center)
            .gap(0.5.cssRem)
            .padding(0.px)
    }
}

val MilestoneContentStyle = CssStyle {
    base {
        Modifier.display(DisplayStyle.Flex)
            .alignItems(AlignItems.Start)
    }
    Breakpoint.MD {
        Modifier.alignItems(AlignItems.Center)
            .gap(1.cssRem)
            .margin(top = 0.5.cssRem)
    }
}