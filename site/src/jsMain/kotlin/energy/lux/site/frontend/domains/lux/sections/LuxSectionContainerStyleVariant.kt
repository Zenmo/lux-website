package energy.lux.site.frontend.domains.lux.sections

import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.zenmo.web.zenmo.components.widgets.SectionContainerStyle
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

val LuxSectionContainerStyleVariant = SectionContainerStyle.addVariant {
    base {
        Modifier
            .fillMaxWidth()
            .display(DisplayStyle.Flex)
            .alignItems(AlignItems.Center)
    }

    Breakpoint.ZERO {
        Modifier.Companion.padding(leftRight = 15.px, topBottom = 50.px)
            .gap(3.cssRem)
    }
    Breakpoint.SM {
        Modifier.Companion.padding(leftRight = 15.px, topBottom = 50.px)
            .gap(3.cssRem)
    }
    Breakpoint.MD {
        Modifier.Companion.padding(leftRight = 134.px, topBottom = 100.px)
            .gap(4.cssRem)
    }
    Breakpoint.LG {
        Modifier.Companion.padding(leftRight = 250.px, topBottom = 120.px)
            .gap(5.cssRem)
    }
    Breakpoint.XL {
        Modifier.Companion.padding(leftRight = 250.px, topBottom = 120.px)
            .gap(5.cssRem)
    }
}

