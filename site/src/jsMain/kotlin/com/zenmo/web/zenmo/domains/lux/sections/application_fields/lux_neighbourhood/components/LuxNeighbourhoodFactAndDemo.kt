package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_neighbourhood.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.components.ApplicationAreaVideo
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette

@Composable
fun LuxNeighbourhoodFactAndDemo() {
    LuxSectionContainer(
        modifier = Modifier.background(SitePalette.light.overlay),
    ) {
        LuxNeighbourhoodFacts()
        HeaderText(
            enText = "LUX Neighborhood in action",
            nlText = "LUX Woonwijk in actie",
        )
        //todo use resdential area video
        ApplicationAreaVideo(
            videoTitle = LocalizedText(
                en = "LUX Neighbourhood Walkthrough",
                nl = "LUX Woonwijk Rondleiding"
            ),
        )
    }
}
