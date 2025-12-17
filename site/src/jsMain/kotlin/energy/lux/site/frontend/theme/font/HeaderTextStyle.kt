package energy.lux.site.frontend.theme.font

import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.font
import com.varabyte.kobweb.compose.ui.modifiers.textTransform
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import energy.lux.site.frontend.utils.PublicRes


val HeaderTextStyle = TextStyle.addVariant {
    Breakpoint.ZERO {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.Companion.siteFont(fontsSM.header)
    }
    Breakpoint.SM {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.Companion.siteFont(fontsSM.header)
    }
    Breakpoint.MD {
        val fontsMD = Fonts[Breakpoint.MD]
        Modifier.Companion.siteFont(fontsMD.header)
    }
    Breakpoint.LG {
        val fontsLG = Fonts[Breakpoint.LG]
        Modifier.Companion.siteFont(fontsLG.header)
    }
    Breakpoint.XL {
        val fontsXL = Fonts[Breakpoint.XL]
        Modifier.Companion.siteFont(fontsXL.header)
    }
}

fun Modifier.siteFont(font: SiteFont): Modifier =
    this.font { siteFont(font) }
        .thenIf(
            font.fontFamily == PublicRes.FontFamilies.HOLON_BLOCK,
            this.textTransform(TextTransform.Uppercase)
        )
