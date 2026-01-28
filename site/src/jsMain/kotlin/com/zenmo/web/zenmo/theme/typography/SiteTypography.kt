package com.zenmo.web.zenmo.theme.typography

import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.textTransform
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.zenmo.web.zenmo.pages.SiteGlobals
import com.zenmo.web.zenmo.theme.typography.core.TextRole
import com.zenmo.web.zenmo.utils.PublicRes
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
        )