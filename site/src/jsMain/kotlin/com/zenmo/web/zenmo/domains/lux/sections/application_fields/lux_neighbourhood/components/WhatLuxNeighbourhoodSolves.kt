package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_neighbourhood.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.functions.max
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.aspectRatio
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import com.zenmo.web.zenmo.components.widgets.ImageContent
import com.zenmo.web.zenmo.core.services.localization.Language
import com.zenmo.web.zenmo.core.services.localization.LocalLanguage
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh


@Composable
fun WhatLuxNeighbourhoodSolves() {
    LuxSectionContainer {
        HeaderText(
            enText = "What LUX Neighbourhood solves",
            nlText = "Wat LUX Woonwijk oplost",
        )

        val imageSrc = when (LocalLanguage.current) {
            Language.English -> "lux_neighborhood_solution_en.png"
            Language.Dutch -> "lux_neighborhood_solution.png"
        }

        ImageContent(
            imageUrl = "/lux/images/$imageSrc",
            alt = "what lux neighbourhood solves",
            modifier = Modifier.fillMaxWidth()
                .objectFit(ObjectFit.Contain)
                .height(max(50.vh, 500.px))
                .aspectRatio(4f / 3f)
                .displayIfAtLeast(Breakpoint.MD)
        )

        ImageContent(
            imageUrl = "/lux/images/$imageSrc",
            alt = "what lux neighbourhood solves",
            modifier = Modifier.fillMaxWidth()
                .objectFit(ObjectFit.Contain)
                .height(auto)
                .displayUntil(Breakpoint.MD)
        )
    }
}