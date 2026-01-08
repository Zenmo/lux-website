package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.resneighborhoods

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.model.DrechtstedenResNeighborhood
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.layout.DrechtstedenTwinLayout
import com.zenmo.web.zenmo.domains.lux.widgets.TwinModelsGrid

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

const val resNeighbourhoodsPath = "/res-neighborhoods"

@Composable
fun ResNeighborhoodModels() =
    TwinModelsGrid(
        models = DrechtstedenResNeighborhood.models,
    )
