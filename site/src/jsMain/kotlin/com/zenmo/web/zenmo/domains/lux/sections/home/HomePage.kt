package com.zenmo.web.zenmo.domains.lux.sections.home

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.LuxSection
import org.jetbrains.compose.web.css.cssRem

@Composable
fun HomePage() {
    SectionContainer(
        modifier = Modifier
            .id(LuxSection.HOME.id)
            .gap(7.cssRem),
        variant = LuxSectionContainerStyleVariant,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Hero()
    }
}