package energy.lux.frontend.theme.typography

import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.OverflowWrap
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import energy.lux.frontend.pages.SiteGlobals
import energy.lux.frontend.theme.typography.core.TextRole
import energy.lux.frontend.utils.PublicRes
import kotlinx.browser.window


fun Modifier.typography(role: TextRole, breakpoint: Breakpoint) =
    when (window.location.host) {
        SiteGlobals.ZENMO_DOMAIN -> zenmoTypography(role, breakpoint)
        else -> luxTypography(role, breakpoint)
    }


private fun Modifier.zenmoTypography(role: TextRole, breakpoint: Breakpoint) =
    this.fontFamily(
        when (role) {
            TextRole.HEADER, TextRole.TITLE -> PublicRes.FontFamilies.MONTSERRAT_MEDIUM
            else -> PublicRes.FontFamilies.POPPINS_REGULAR
        }
    )
        .fontSize(DefaultScales.forRole(role).at(breakpoint))
        .fontWeight(FontWeight.Normal)


private fun Modifier.luxTypography(role: TextRole, breakpoint: Breakpoint) =
    this.fontFamily(
        when (role) {
            TextRole.HEADER -> PublicRes.FontFamilies.HOLON_BLOCK
            else -> PublicRes.FontFamilies.HOLON_LINE
        }
    )
        .fontSize(DefaultScales.forRole(role).at(breakpoint))
        .fontWeight(FontWeight.Normal)
        .thenIf(
            role == TextRole.HEADER,
            this.textTransform(TextTransform.Uppercase)
                .overflowWrap(OverflowWrap.Anywhere),
        )