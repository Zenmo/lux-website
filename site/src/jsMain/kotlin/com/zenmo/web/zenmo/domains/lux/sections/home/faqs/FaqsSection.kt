package com.zenmo.web.zenmo.domains.lux.sections.home.faqs

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant


@Composable
fun FaqsSection(
    breakpoint: Breakpoint,
) {
    SectionContainer(
        variant = LuxSectionContainerStyleVariant,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        FaqsHeaderText()
        Faqs(breakpoint)
        FaqFallBack()
    }
}

