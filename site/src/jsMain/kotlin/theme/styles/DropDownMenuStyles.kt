package energy.lux.frontend.theme.styles

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val DropdownTriggerStyle = CssStyle {
    base {
        Modifier
            .position(Position.Relative)
    }

    hover {
        Modifier
            .styleModifier {
                property("--dropdown-visibility", "block")
            }
    }
}

val DropdownContentStyle = CssStyle {
    base {
        Modifier
            .position(Position.Absolute)
            .top(100.percent)
            .margin(top = 1.percent)
            .right(0.percent)
            .backgroundColor(SitePalette.light.overlay)
            .borderRadius(r = 30.px)
            .display(DisplayStyle.None)
            .zIndex(10)
            /*todo ease-in ease-out transition animation for this*/
            .styleModifier {
                property("display", "var(--dropdown-visibility, none)")
            }
    }
}