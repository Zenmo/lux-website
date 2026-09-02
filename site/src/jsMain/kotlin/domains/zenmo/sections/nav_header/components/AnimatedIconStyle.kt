package energy.lux.frontend.domains.zenmo.sections.nav_header.components

import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.ms

/**
 * Shared by any expand/collapse-style icon (chevrons, arrows) that rotates on state change.
 * Also used outside this package by domains/lux/pages/home/faqs/FaqsCardItem.kt,
 * domains/lux/sections/nav_header/components/MenuSectionItem.kt, and domains/zenmo/widgets/MenuItemWithSubs.kt.
 */
val AnimatedIconStyle = CssStyle {
    base {
        Modifier
            .transition(
                Transition.of(
                    property = "transform",
                    duration = 300.ms,
                    timingFunction = AnimationTimingFunction.Ease
                )
            )
    }
}
