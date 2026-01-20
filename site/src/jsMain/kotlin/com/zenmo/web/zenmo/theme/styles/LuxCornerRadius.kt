package com.zenmo.web.zenmo.theme.styles

import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.px


/**
 * A signature corner radius scale for Lux UI components.
 * - sm: subtle rounding for small UI elements (chips, badges)
 * - md: default radius for buttons, inputs and general use
 * - lg: rounding for cards, modals and large containers
 * - xl: very large rounding for hero sections, pill-like components, image & video e
 */
object LuxCornerRadius {
    val sm = 4.px
    val md = 8.px
    val lg = 16.px
    val xl = 24.px
}

fun Modifier.luxBorderRadius(
    size: CSSLengthOrPercentageNumericValue = LuxCornerRadius.md
) = this.borderRadius {
    bottomLeft(size)
    bottomRight(0.px)
    topLeft(0.px)
    topRight(0.px)
}.cornerShapeBevel()

private fun Modifier.cornerShapeBevel() = this.styleModifier {
    property("corner-bottom-left-shape", "bevel")
}