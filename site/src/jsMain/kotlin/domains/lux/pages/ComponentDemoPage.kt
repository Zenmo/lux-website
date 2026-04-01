package energy.lux.frontend.domains.lux.pages

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.lux.components.layout.LuxSubdomainPageLayout
import energy.lux.frontend.domains.lux.widgets.ColorPaletteDemo
import energy.lux.frontend.domains.lux.widgets.DataVizualitationColorDemo

@Composable
fun ComponentDemoPage() {
    LuxSubdomainPageLayout(
        title = "Componenten"
    ) {
        DataVizualitationColorDemo()

        ColorPaletteDemo()
    }
}
