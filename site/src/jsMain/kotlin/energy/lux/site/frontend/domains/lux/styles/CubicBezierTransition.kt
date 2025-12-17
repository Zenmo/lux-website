package energy.lux.site.frontend.domains.lux.styles

import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.css.TransitionTimingFunction
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.transition
import org.jetbrains.compose.web.css.ms


fun Modifier.cubicBezierTransition(): Modifier = this.transition(
    Transition.of(
        property = TransitionProperty.All,
        duration = 300.ms,
        timingFunction = TransitionTimingFunction.cubicBezier(0.4, 0.0, 0.2, 1.0)
    )
)