package com.zenmo.web.zenmo.domains.lux.styles

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.silk.style.CssStyle
import org.jetbrains.compose.web.css.deg

val LuxSubMenuItemParentHoverStyle = CssStyle {
    cssRule(":hover  div span ") {
        Modifier.Companion
            .transform {
                rotate(180.deg)
            }
    }
}