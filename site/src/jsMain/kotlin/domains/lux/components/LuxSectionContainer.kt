package energy.lux.frontend.domains.lux.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Modifier
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.domains.lux.sections.LuxSectionContainerStyleVariant


@Composable
fun LuxSectionContainer(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) = SectionContainer(
    variant = LuxSectionContainerStyleVariant,
    modifier = modifier,
    content = content
)