package energy.lux.site.frontend.domains.lux.subdomains.drechtsteden.pages.resneighborhoods

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.model.DrechtstedenResNeighborhood
import com.zenmo.web.zenmo.domains.lux.components.model.TwinModelsGrid
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.layout.DrechtstedenTwinLayout

@Composable
fun ResNeighborhoodsPage() {
    DrechtstedenTwinLayout(
        title = "Residential Neighborhoods",
    ) {
        SectionContainer(
            variant = LuxSectionContainerStyleVariant
        ) {
            ResNeighborhoodModels()
        }
    }
}

@Composable
fun ResNeighborhoodModels() =
    TwinModelsGrid(
        models = DrechtstedenResNeighborhood.models,
        path = "res-neighborhoods",
    )
