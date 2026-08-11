package energy.lux.frontend.domains.zenmo.pages.models

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.domains.lux.core.model.subdomain.amersfoort
import energy.lux.frontend.domains.lux.core.model.subdomain.demoEnergyHubModel
import energy.lux.frontend.domains.lux.core.model.subdomain.demoNeighbourhoodModel
import energy.lux.frontend.domains.lux.core.model.subdomain.empowered
import energy.lux.frontend.domains.lux.pages.application_fields.LuxApplicationArea
import energy.lux.frontend.domains.lux.pages.application_fields.components.LUX_DEMO_SECTION_ID
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.components.PlaceholderText
import energy.lux.frontend.domains.zenmo.components.layouts.ZenmoPageLayout
import energy.lux.frontend.domains.zenmo.sections.nav_header.zenmoModelsMenuItem
import energy.lux.frontend.pages.SiteGlobals
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.P
import web.window.window

val DEMO_MODEL_URL_PREFIX = "${window.location.protocol}//${SiteGlobals.LUX_DOMAIN}/"
val zenmoShowcasedModels: List<ShowcasedModel> = listOf(
    ShowcasedModel(
        demoNeighbourhoodModel.copy(
            url = "$DEMO_MODEL_URL_PREFIX${LuxApplicationArea.LUX_ENERGY_HUB.url}#${LUX_DEMO_SECTION_ID}",
        )
    ),
    ShowcasedModel(
        demoEnergyHubModel.copy(
            url = "$DEMO_MODEL_URL_PREFIX${LuxApplicationArea.LUX_ENERGY_HUB.url}#${LUX_DEMO_SECTION_ID}",
        )
    ),
    ShowcasedModel(empowered),
    ShowcasedModel(amersfoort),
)

@Composable
fun ModelsPage() {
    ZenmoPageLayout(zenmoModelsMenuItem.route.label) {
        SectionContainer {
            HeaderText(enText = "Interactive Energy Models", nlText = "Interactieve Energiemodellen")
            P(
                Modifier
                    .textAlign(TextAlign.Center)
                    .constrainedWidth().toAttrs()
            ) {
                PlaceholderText(repeat = 2)
            }
            SimpleGrid(
                numColumns(base = 1, md = 2),
                modifier = Modifier.gap(2.5.cssRem)
                    .constrainedWidth(),
            ) {
                zenmoShowcasedModels.forEach { ModelCard(it) }
            }
        }
    }
}