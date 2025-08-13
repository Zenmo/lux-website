package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.municipalities

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.components.model.DrechtstedenTwinModel
import com.zenmo.web.zenmo.domains.lux.components.model.TwinModelsGrid
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.layout.DrechtstedenTwinLayout
import org.jetbrains.compose.web.css.cssRem

@Composable
fun MunicipalitiesPage() {
    DrechtstedenTwinLayout(
        title = "Municipalities",
    ) {
        SectionContainer(
            modifier = Modifier.gap(2.cssRem),
            variant = LuxSectionContainerStyleVariant
        ) {
            MunicipalitiesModels()
        }
    }
}

@Composable
fun MunicipalitiesModels() =
    TwinModelsGrid(
        models = DrechtstedenTwinModel.municipalModels,
        path = "municipalities",
    )
