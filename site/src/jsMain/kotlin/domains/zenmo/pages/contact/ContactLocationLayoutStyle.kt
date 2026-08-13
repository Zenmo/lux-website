package energy.lux.frontend.domains.zenmo.pages.contact

import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import energy.lux.frontend.domains.lux.styles.responsiveGap
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection

val ContactLocationLayoutStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
            .alignItems(AlignItems.FlexStart)
            .responsiveGap()
    }

    Breakpoint.MD {
        Modifier
            .flexDirection(FlexDirection.Row)
    }
}