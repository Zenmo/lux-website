package energy.lux.site.frontend.theme.font

import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.ui.modifiers.FontScope
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import energy.lux.site.frontend.pages.SiteGlobals
import energy.lux.site.frontend.utils.PublicRes
import kotlinx.browser.window
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.cssRem

data class SiteFontFamily(
    val header: String,
    val subHeader: String,
    val body: String, // the default font used in the site
)

/**
 * Represents a font used in the site.
 * */
data class SiteFont(
    val fontFamily: String,
    val fontSize: CSSSizeValue<CSSUnit.rem>,
    val fontWeight: FontWeight = FontWeight.Normal,
    val fontStyle: FontStyle = FontStyle.Normal
)

/**
 * ... a collection of fonts used in the site.
 * doing this for UI consistency and to avoid hardcoding font values in the components.
 * */
data class SiteFonts(
    val header: SiteFont,
    val title: SiteFont,
    val body: SiteFont,
    val label: SiteFont,
)


fun FontScope.siteFont(siteFont: SiteFont) {
    this.style(siteFont.fontStyle)
    this.size(siteFont.fontSize)
    this.weight(siteFont.fontWeight)
    this.family(siteFont.fontFamily)
}

object Fonts {

    operator fun get(breakpoint: Breakpoint) = when (breakpoint) {
        Breakpoint.ZERO -> {
            smallFonts
        }

        Breakpoint.SM -> {
            smallFonts
        }

        Breakpoint.MD -> {
            mediumFonts
        }

        Breakpoint.LG -> {
            largeFonts
        }

        Breakpoint.XL -> {
            superLargeFonts
        }
    }

    private val zenmoFontFamily = SiteFontFamily(
        header = PublicRes.FontFamilies.MONTSERRAT_MEDIUM,
        subHeader = PublicRes.FontFamilies.MONTSERRAT_MEDIUM,
        body = PublicRes.FontFamilies.POPPINS_REGULAR,
    )

    private val luxFontFamily = SiteFontFamily(
        header = PublicRes.FontFamilies.HOLON_BLOCK,
        subHeader = PublicRes.FontFamilies.HOLON_LINE,
        body = PublicRes.FontFamilies.HOLON_LINE,
    )

    val domain = window.location.host
    val siteFontFamily = when (domain) {
        SiteGlobals.ZENMO_DOMAIN -> zenmoFontFamily
        else -> luxFontFamily
    }

    private val superLargeFonts = SiteFonts(
        header = SiteFont(
            fontFamily = siteFontFamily.header,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 3.7.cssRem,
        ),
        title = SiteFont(
            fontFamily = siteFontFamily.subHeader,
            fontWeight = FontWeight.Medium,
            fontSize = 2.cssRem,
        ),
        body = SiteFont(
            fontFamily = siteFontFamily.body,
            fontWeight = FontWeight.Normal,
            fontSize = 1.25.cssRem,
        ),
        label = SiteFont(
            fontFamily = siteFontFamily.body,
            fontWeight = FontWeight.Medium,
            fontSize = 0.9.cssRem,
        ),
    )

    private val largeFonts = SiteFonts(
        header = superLargeFonts.header.copy(fontSize = 3.cssRem),
        title = superLargeFonts.title.copy(fontSize = 1.35.cssRem),
        body = superLargeFonts.body.copy(fontSize = 1.15.cssRem),
        label = superLargeFonts.label,
    )

    private val mediumFonts = SiteFonts(
        header = superLargeFonts.header.copy(fontSize = 2.cssRem),
        title = superLargeFonts.title.copy(fontSize = 1.35.cssRem),
        body = superLargeFonts.body.copy(fontSize = 1.cssRem),
        label = superLargeFonts.label,
    )

    private val smallFonts = SiteFonts(
        header = superLargeFonts.header.copy(fontSize = 1.8.cssRem),
        title = superLargeFonts.title.copy(fontSize = 1.35.cssRem),
        body = superLargeFonts.body.copy(fontSize = 1.cssRem),
        label = superLargeFonts.label,
    )
}