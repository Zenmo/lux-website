package com.zenmo.web.zenmo.domains.lux.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Modifier
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant


@Composable
fun LuxSectionContainer(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) = SectionContainer(
    variant = LuxSectionContainerStyleVariant,
    modifier = modifier,
    content = content
)