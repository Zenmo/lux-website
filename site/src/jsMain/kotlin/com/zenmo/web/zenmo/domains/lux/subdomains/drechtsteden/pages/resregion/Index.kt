package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.resregion

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.model.DrechtstedenResRegion
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.layout.DrechtstedenTwinLayout
import com.zenmo.web.zenmo.domains.lux.widgets.TwinModelsGrid
import org.jetbrains.compose.web.css.cssRem


@Composable
fun ResRegionPage() {
    DrechtstedenTwinLayout(
        title = "Res Region",
    ) {
        SectionContainer(
            modifier = Modifier.gap(2.cssRem),
            variant = LuxSectionContainerStyleVariant
        ) {
            ResRegionModels()
        }
    }
}

@Composable
fun ResRegionModels() =
    TwinModelsGrid(
        models = DrechtstedenResRegion.models,
        path = "res-region",
    )


