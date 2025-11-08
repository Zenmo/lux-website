package com.zenmo.web.zenmo.theme.font

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.font
import com.varabyte.kobweb.silk.style.ComponentKind
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.zenmo.web.zenmo.theme.SitePalette

sealed interface TextComponentKind : ComponentKind

val TextStyle = CssStyle<TextComponentKind> {
    val defaultFonts = Fonts[Breakpoint.LG]
    base {
        Modifier.font { siteFont(defaultFonts.body) }
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
