package com.zenmo.web.zenmo.theme

import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.button
import com.varabyte.kobweb.silk.theme.colors.palette.color
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.zenmo.web.zenmo.domains.lux.components.model.SubdomainModel
import com.zenmo.web.zenmo.pages.SiteGlobals
import kotlinx.browser.window


data class LuxSpecificColorHues(
    val luxBlue: Color = Color.rgb(0x3C83EF),
    val luxRed: Color = Color.rgb(0xF8285A),
    val luxYellow: Color = Color.rgb(0xFFC300),
    val luxGreen: Color = Color.rgb(0x28A745),
)

data class SitePalette(
    val primary: Color = Color.rgb(0xb6084e),
    val onPrimary: Color = Color.rgb(0xFFFFFF),
    val secondary: Color = Color.rgb(0x3d2c2f),
    val overlay: Color = Color.rgb(0xFFF0F1),
    val background: Color = Color.rgb(0xFFF8F7),
    val onBackground: Color = Color.rgb(0x26181A),

    // Lux data visualization Colors for map legends and charts.
    val luxDataVizColors: List<Color> = emptyList(),
    val luxSpecificColorHues: LuxSpecificColorHues = LuxSpecificColorHues()

    /** TODO: Standardized Colors for Specific Concepts/Purposes
     *    like electricity, gasoline, etc.
     *
     *   val electricity: Color,
     *   val gasoline: Color,
     */
) {
    companion object {
        private val zenmoColorPalette = SitePalette()

        // picked base color palette from the Brabant logo /lux/logos/Logo-balk
        private val brabantColorPalette = SitePalette(
            primary = Color.rgb(0xd01c1c),
            onPrimary = Color.rgb(0xFFFFFF),
            secondary = Color.rgb(0xa7382f),
            overlay = Color.rgb(0xfff0ee),
            background = Color.rgb(0xfff8f7),
            onBackground = Color.rgb(0x3f2c29),
        )

        private val luxColorPalette = SitePalette(
            primary = Color.rgb(0x007E84),
            onPrimary = Color.rgb(0xFFFFFF),
            secondary = Color.rgb(0xFCC200),
            overlay = Color.rgb(0xf2f4f4),
            background = Colors.White,
            onBackground = Colors.Black,

            /** generated these with https://material-foundation.github.io/material-theme-builder/
             * using the Lux color palette as a base
             */
            luxDataVizColors = listOf(
                Color.rgb(0xFCC200), // orange-ish yellow like secondary
                Color.rgb(0x007E84),  // teal
                Color.rgb(0x8bd2d7), // light teal, an inverse of the teal
                Color.rgb(0xffe5b2), // medium contrast of the orange-yellow
                Color.rgb(0x3C83EF), // blue
                Color.rgb(0xF8285A), // red
            ),

            luxSpecificColorHues = LuxSpecificColorHues()
        )

        private val domain = window.location.host
        val light = when (domain) {
            SiteGlobals.ZENMO_DOMAIN -> zenmoColorPalette
            "${SubdomainModel.Brabant.title}.${SiteGlobals.LUX_DOMAIN}" -> brabantColorPalette
            else -> luxColorPalette
        }
    }
}


fun ColorMode.toSitePalette(): SitePalette = SitePalette.light

@InitSilk
fun initTheme(ctx: InitSilkContext) {
    ctx.theme.palettes.light.apply {
        this.background = SitePalette.light.background
        color = SitePalette.light.onBackground
        this.overlay = SitePalette.light.overlay
        button.set(
            default = SitePalette.light.primary,
            hover = SitePalette.light.primary.darkened(byPercent = 0.1f),
            focus = SitePalette.light.primary,
            pressed = SitePalette.light.primary.darkened(byPercent = 0.2f),
        )
    }
}
