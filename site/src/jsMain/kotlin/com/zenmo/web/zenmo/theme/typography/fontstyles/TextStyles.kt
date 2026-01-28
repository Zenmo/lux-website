package com.zenmo.web.zenmo.theme.font

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.silk.style.ComponentKind
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.typography.core.TextRole
import com.zenmo.web.zenmo.theme.typography.typography

sealed interface TextComponentKind : ComponentKind

val TextStyle = CssStyle<TextComponentKind> {
    base {
        Modifier.typography(TextRole.BODY, Breakpoint.LG)
    }
}

val TextStylePrimaryColor = TextStyle.addVariant {
    base {
        Modifier.color(SitePalette.light.onBackground)
    }
}

val TextStyleSecondaryColor = TextStyle.addVariant {
    base {
        Modifier.color(SitePalette.light.secondary)
    }
}

val TextStyleBrandColor = TextStyle.addVariant {
    base {
        Modifier.color(SitePalette.light.primary)
    }
}
