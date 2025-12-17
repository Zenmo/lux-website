package energy.lux.site.frontend.domains.lux.pages

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.widgets.ColorPaletteDemo
import com.zenmo.web.zenmo.domains.lux.widgets.DataVizualitationColorDemo

@Composable
fun ComponentDemoPage() {
    LuxSubdomainPageLayout(
        title = "Componenten"
    ) {
        DataVizualitationColorDemo()

        ColorPaletteDemo()
    }
}
