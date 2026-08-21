package energy.lux.frontend.domains.lux.styles

import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.functions.clamp
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.vw

val ResponsiveFlexStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .display(DisplayStyle.Flex)
            .alignItems(AlignItems.Center)
            .flexDirection(FlexDirection.Column)
            .responsiveGap()
    }

    Breakpoint.LG {
        Modifier
            .flexDirection(FlexDirection.Row)
    }
}

fun Modifier.responsiveGap() = this.gap(clamp(2.5.cssRem, 5.vw, 5.5.cssRem))