package com.zenmo.web.zenmo.theme.font

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.font
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.zenmo.web.zenmo.utils.PublicRes
import org.jetbrains.compose.web.css.cssRem

val HolonLineTextStyle = TextStyle.addVariant {
    fun applyHolonLineFont(breakpoint: Breakpoint): Modifier {
        val fonts = Fonts[breakpoint]
        return Modifier.Companion.font {
            siteFont(
                fonts.title.copy(
                    fontFamily = PublicRes.FontFamilies.HOLON_LINE,
                    fontSize = 1.25.cssRem
                )
            )
        }
    }

    Breakpoint.ZERO { applyHolonLineFont(Breakpoint.ZERO) }
    Breakpoint.SM { applyHolonLineFont(Breakpoint.SM) }
    Breakpoint.MD { applyHolonLineFont(Breakpoint.MD) }
    Breakpoint.LG { applyHolonLineFont(Breakpoint.LG) }
    Breakpoint.XL { applyHolonLineFont(Breakpoint.XL) }
}