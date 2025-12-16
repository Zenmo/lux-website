package com.zenmo.web.zenmo.domains.lux.sections.home.sections.application_areas.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.domains.lux.sections.home.CardGridStyle
import com.zenmo.web.zenmo.domains.lux.sections.home.sections.application_areas.model.ApplicationAreaItem
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div


@Composable
fun ApplicationAreasGrid(breakpoint: Breakpoint) {
    Div(
        CardGridStyle.toModifier()
            .height(auto)
            .rowGap(32.px)
            .columnGap(32.px)
            .thenIf(
                breakpoint < Breakpoint.MD,
                Modifier.display(DisplayStyle.Flex)
                    .flexDirection(FlexDirection.Column)
            )
            .toAttrs()
    ) {
        ApplicationAreaItem.luxApplicationAreas.forEach { ApplicationAreaCard(it) }
    }
}