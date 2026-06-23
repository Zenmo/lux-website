package energy.lux.frontend.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.ComponentKind
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.CssStyleVariant
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.theme.SiteFluidSpacing
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.keywords.auto

sealed interface SectionComponentKind : ComponentKind


val SectionContainerStyle = CssStyle<SectionComponentKind> {
    base {
        Modifier
            .fillMaxWidth()
            .height(auto)
            .display(DisplayStyle.Flex)
            .padding(
                leftRight = SiteFluidSpacing.current.horizontalPadding,
                topBottom = SiteFluidSpacing.current.verticalPadding
            )
            .gap(SiteFluidSpacing.current.gap)
    }
}


/**
 * [SectionContainer] should be used when you need:
 * - a container that automatically adapts to different breakpoints
 * - a standardized container for responsive page sections with consistent padding
 *
 * Typical usage includes:
 * - Main page sections in the website
 * - Content blocks that need a responsive behavior
 */

@Composable
fun SectionContainer(
    modifier: Modifier = Modifier,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    variant: CssStyleVariant<SectionComponentKind>? = null,
    content: @Composable ColumnScope.() -> Unit = {},
) {
    Column(
        modifier = SectionContainerStyle.toModifier(variant)
            .then(modifier),
        horizontalAlignment = horizontalAlignment,
        verticalArrangement = verticalArrangement,
        content = content
    )
}