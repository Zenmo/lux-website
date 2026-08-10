package energy.lux.frontend.domains.zenmo.pages.home.hero

import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.extendedBy
import com.varabyte.kobweb.silk.style.selectors.hover
import energy.lux.frontend.theme.styles.OutlinePrimaryButtonStyle
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val GetInTouchButtonStyle = OutlinePrimaryButtonStyle.extendedBy {
    base {
        Modifier.color(Colors.Black)
            .border(1.5.px, color = Colors.Black, style = LineStyle.Solid)
            .transition(
                Transition.of(
                    property = TransitionProperty.All,
                    duration = 300.ms,
                    timingFunction = AnimationTimingFunction.Ease
                )
            )
    }
    hover {
        Modifier.color(Colors.White)
            .background(Colors.Black)
    }
}