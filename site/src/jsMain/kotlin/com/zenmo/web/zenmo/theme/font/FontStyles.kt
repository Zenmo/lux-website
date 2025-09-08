package com.zenmo.web.zenmo.theme.font

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.font
import com.varabyte.kobweb.silk.style.ComponentKind
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.utils.PublicRes
import org.jetbrains.compose.web.css.cssRem

sealed interface TextComponentKind : ComponentKind

val TextStyle = CssStyle<TextComponentKind> {
    val defaultFonts = Fonts[Breakpoint.LG]
    base {
        Modifier.font { defaultFonts.body }
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


val HeaderTextStyle = TextStyle.addVariant {
    Breakpoint.ZERO {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.header) }
    }
    Breakpoint.SM {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.header) }
    }
    Breakpoint.MD {
        val fontsMD = Fonts[Breakpoint.MD]
        Modifier.font { siteFont(fontsMD.header) }
    }
    Breakpoint.LG {
        val fontsLG = Fonts[Breakpoint.LG]
        Modifier.font { siteFont(fontsLG.header) }
    }
    Breakpoint.XL {
        val fontsXL = Fonts[Breakpoint.XL]
        Modifier.font { siteFont(fontsXL.header) }
    }
}


val BodyTextStyle = TextStyle.addVariant {
    Breakpoint.ZERO {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.body) }
    }
    Breakpoint.SM {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.body) }
    }
    Breakpoint.MD {
        val fontsMD = Fonts[Breakpoint.MD]
        Modifier.font { siteFont(fontsMD.body) }
    }
    Breakpoint.LG {
        val fontsLG = Fonts[Breakpoint.LG]
        Modifier.font { siteFont(fontsLG.body) }
    }
    Breakpoint.XL {
        val fontsXL = Fonts[Breakpoint.XL]
        Modifier.font { siteFont(fontsXL.body) }
    }
}


val LabelTextStyle = TextStyle.addVariant {
    Breakpoint.ZERO {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.label) }
    }
    Breakpoint.SM {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.label) }
    }
    Breakpoint.MD {
        val fontsMD = Fonts[Breakpoint.MD]
        Modifier.font { siteFont(fontsMD.label) }
    }
    Breakpoint.LG {
        val fontsLG = Fonts[Breakpoint.LG]
        Modifier.font { siteFont(fontsLG.label) }
    }
    Breakpoint.XL {
        val fontsXL = Fonts[Breakpoint.XL]
        Modifier.font { siteFont(fontsXL.label) }
    }
}


val HolonLineTextStyle = TextStyle.addVariant {
    fun applyHolonLineFont(breakpoint: Breakpoint): Modifier {
        val fonts = Fonts[breakpoint]
        return Modifier.font {
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


val TitleTextStyle = TextStyle.addVariant {
    Breakpoint.ZERO {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.title) }
    }
    Breakpoint.SM {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.title) }
    }
    Breakpoint.MD {
        val fontsMD = Fonts[Breakpoint.MD]
        Modifier.font { siteFont(fontsMD.title) }
    }
    Breakpoint.LG {
        val fontsLG = Fonts[Breakpoint.LG]
        Modifier.font { siteFont(fontsLG.title) }
    }
    Breakpoint.XL {
        val fontsXL = Fonts[Breakpoint.XL]
        Modifier.font { siteFont(fontsXL.title) }
    }
}
