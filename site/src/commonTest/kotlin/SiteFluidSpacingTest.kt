package energy.lux.frontend

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import energy.lux.frontend.theme.SiteFluidSpacing
import energy.lux.frontend.theme.computeFluidClamp
import kotlinx.browser.window
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.testutils.ComposeWebExperimentalTestsApi
import org.jetbrains.compose.web.testutils.runTest
import org.w3c.dom.Element
import kotlin.math.max
import kotlin.math.min
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ComposeWebExperimentalTestsApi::class)
class SiteFluidSpacingTest {

    private val spacing = SiteFluidSpacing(
        minHorizontalPadding = 15.px,
        maxHorizontalPadding = 250.px,
        minVerticalPadding = 50.px,
        maxVerticalPadding = 120.px,
        minGap = 8.px,
        maxGap = 32.px,
    )

    // window.resizeTo() is a no-op in the karma headless environment — the viewport stays
    // fixed (~765px) so this test always runs at the wrong size. Needs Playwright to fix.
    @Ignore
    @Test
    fun `horizontal padding at narrow viewport`() = runTest {
        window.resizeTo(400, 768)
        composition {
            Div(attrs = Modifier.padding(leftRight = spacing.horizontalPadding).toAttrs()) {}
        }
        assertEquals(
            expected = 15.0,
            actual = computedPxProperty("padding-left", root.firstElementChild!!),
            absoluteTolerance = 1.0,
        )
    }

    @Test
    fun `horizontal padding at mid viewport`() = runTest {
        window.resizeTo(890, 768)
        composition {
            Div(attrs = Modifier.padding(leftRight = spacing.horizontalPadding).toAttrs()) {}
        }
        assertEquals(
            expected = expectedClamp(minPx = 15.0, maxPx = 250.0),
            actual = computedPxProperty("padding-left", root.firstElementChild!!),
            absoluteTolerance = 1.0,
        )
    }

    @Ignore
    @Test
    fun `horizontal padding at wide viewport`() = runTest {
        window.resizeTo(1400, 768)
        composition {
            Div(attrs = Modifier.padding(leftRight = spacing.horizontalPadding).toAttrs()) {}
        }
        assertEquals(
            expected = 250.0,
            actual = computedPxProperty("padding-left", root.firstElementChild!!),
            absoluteTolerance = 1.0,
        )
    }

    @Test
    fun `vertical padding at mid viewport`() = runTest {
        window.resizeTo(890, 768)
        composition {
            Div(attrs = Modifier.padding(topBottom = spacing.verticalPadding).toAttrs()) {}
        }
        assertEquals(
            expected = expectedClamp(minPx = 50.0, maxPx = 120.0),
            actual = computedPxProperty("padding-top", root.firstElementChild!!),
            absoluteTolerance = 1.0,
        )
    }

    @Test
    fun `gap at mid viewport`() = runTest {
        window.resizeTo(890, 768)
        composition {
            Div(attrs = Modifier.gap(spacing.gap).toAttrs {
                style { property("display", "flex") }
            }) {}
        }
        assertEquals(
            expected = expectedClamp(minPx = 8.0, maxPx = 32.0),
            actual = computedPxProperty("column-gap", root.firstElementChild!!),
            absoluteTolerance = 1.0,
        )
    }

    private fun computedPxProperty(property: String, element: Element): Double =
        window.getComputedStyle(element)
            .getPropertyValue(property)
            .removeSuffix("px")
            .toDouble()

    // Evaluates the CSS clamp formula in Kotlin so we have a number to assert against.
    // Both sides use the same math — the test verifies the browser applies the expression,
    // not that the formula is correct.
    private fun expectedClamp(minPx: Double, maxPx: Double): Double {
        val params = computeFluidClamp(minPx, maxPx)
        val viewportPx = window.innerWidth.toDouble()
        return max(minPx, min(maxPx, params.intersectionPx + params.slopeVwPercent / 100.0 * viewportPx))
    }
}