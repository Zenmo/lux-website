package energy.lux.frontend.domains.lux.sections.application_fields.lux_neighbourhood.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.domains.lux.sections.application_fields.components.ApplicationAreaVideo
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.theme.SitePalette

@Composable
fun LuxNeighbourhoodFactAndDemo() {
    SectionContainer(
        modifier = Modifier.background(SitePalette.light.overlay),
    ) {
        LuxNeighbourhoodFacts()
        HeaderText(
            enText = "LUX Neighbourhood in action",
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