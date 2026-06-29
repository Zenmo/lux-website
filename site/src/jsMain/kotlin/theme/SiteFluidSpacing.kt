package energy.lux.frontend.theme

import com.varabyte.kobweb.compose.css.functions.calc
import com.varabyte.kobweb.compose.css.functions.clamp
import energy.lux.frontend.pages.SiteGlobals
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*


internal data class FluidClampParams(
    val minPx: Double,
    val intersectionPx: Double,
    val slopeVwPercent: Double,
    val maxPx: Double
)

/**
 * Turns min/max px values into `clamp()` params via linear
 * interpolation across the viewport range.
 * */
internal fun computeFluidClamp(
    minPx: Double,
    maxPx: Double,
    minViewportPx: Double = 480.0,
    maxViewportPx: Double = 1300.0
): FluidClampParams {
    val slope = (maxPx - minPx) / (maxViewportPx - minViewportPx)
    return FluidClampParams(minPx, minPx - slope * minViewportPx, slope * 100.0, maxPx)
}

private fun CSSUnitValue.toPx(): Double {
    val n = value.toDouble()
    val s = toString().trim()
    return if (s.endsWith("rem") || s.endsWith("em")) n * rootRemInPx() else n // else: already px
}

/**
 * Spacing that scales fluidly between viewport breakpoints via CSS `clamp()`.
 * One config per subdomain — see [current].
 */
data class SiteFluidSpacing(
    private val minHorizontalPadding: CSSUnitValue,
    private val maxHorizontalPadding: CSSUnitValue,
    private val minVerticalPadding: CSSUnitValue,
    private val maxVerticalPadding: CSSUnitValue,
    private val minGap: CSSUnitValue = 1.cssRem,
    private val maxGap: CSSUnitValue = 3.cssRem,
) {
    val horizontalPadding: CSSNumericValue<out CSSUnitLengthOrPercentage>
        get() = calculateFluidClamp(
            minHorizontalPadding,
            maxHorizontalPadding
        )

    val verticalPadding: CSSNumericValue<out CSSUnitLengthOrPercentage>
        get() = calculateFluidClamp(
            minVerticalPadding,
            maxVerticalPadding
        )

    val gap: CSSNumericValue<out CSSUnitLengthOrPercentage>
        get() = calculateFluidClamp(minGap, maxGap)


    // unsafeCast needed: clamp() returns CSSStyleValue but Kobweb's modifiers want CSSNumericValue
    private fun calculateFluidClamp(
        min: CSSUnitValue,
        max: CSSUnitValue,
    ): CSSNumericValue<out CSSUnitLengthOrPercentage> {
        val params = computeFluidClamp(min.toPx(), max.toPx())
        return clamp(
            min,
            calc { num(params.intersectionPx).px + num(params.slopeVwPercent).vw },
            max,
        ).unsafeCast<CSSNumericValue<out CSSUnitLengthOrPercentage>>()
    }

    companion object {
        private val luxFluidDimensions = SiteFluidSpacing(
            minHorizontalPadding = 15.px,
            maxHorizontalPadding = 250.px,
            minVerticalPadding = 50.px,
            maxVerticalPadding = 120.px,
            minGap = 2.cssRem,
            maxGap = 4.cssRem,
        )
        private val zenmoFluidDimensions = SiteFluidSpacing(
            minHorizontalPadding = 16.px,
            maxHorizontalPadding = 134.px,
            minVerticalPadding = 40.px,
            maxVerticalPadding = 100.px,
        )

        val current: SiteFluidSpacing
            get() = when (window.location.host) {
                SiteGlobals.ZENMO_DOMAIN -> zenmoFluidDimensions
                else -> luxFluidDimensions
            }
    }
}

fun rootRemInPx(): Double =
    window.getComputedStyle(document.documentElement!!)
        .getPropertyValue("font-size")
        .removeSuffix("px")
        .toDouble()