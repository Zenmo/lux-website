package energy.lux.frontend.domains.lux.sections.application_fields.lux_neighbourhood

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.framework.annotations.DelicateApi
import energy.lux.frontend.domains.lux.core.model.subdomain.bunderbuurten
import energy.lux.frontend.domains.lux.core.model.subdomain.kronenberg
import energy.lux.frontend.domains.lux.core.model.subdomain.loenen
import energy.lux.frontend.domains.lux.core.toTwinModelCardItem
import energy.lux.frontend.domains.lux.sections.application_fields.FieldModels
import energy.lux.frontend.domains.lux.sections.application_fields.LuxApplicationArea
import energy.lux.frontend.domains.lux.sections.application_fields.components.LuxPageDemoSection
import energy.lux.frontend.domains.lux.sections.application_fields.components.PeterContactCard
import energy.lux.frontend.domains.lux.sections.application_fields.lux_neighbourhood.components.LuxNeighbourhoodFacts
import energy.lux.frontend.domains.lux.sections.application_fields.lux_neighbourhood.components.NeighbourhoodHero
import energy.lux.frontend.domains.lux.sections.application_fields.lux_neighbourhood.components.RealDataSimulation
import energy.lux.frontend.domains.lux.sections.application_fields.lux_neighbourhood.components.WhatLuxNeighbourhoodSolves
import energy.lux.frontend.domains.lux.sections.application_fields.lux_neighbourhood.components.get_lux_neighbourhood.GetLuxNeighbourhoodSection
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import kotlin.uuid.Uuid


@OptIn(DelicateApi::class)
@Composable
fun LuxNeighbourhood() {
    val applicationArea = LuxApplicationArea.LUX_NEIGHBOURHOOD
    Column {
        NeighbourhoodHero()
        RealDataSimulation()
        WhatLuxNeighbourhoodSolves()
        LuxNeighbourhoodFacts()
        LuxPageDemoSection(
            applicationArea = applicationArea,
            modelContent = {
                AnyLogicEmbed(
                    modelId = Uuid.parse("ccbd35d7-98a8-4fb9-8161-dda239d7f049")
                )
            }
        )
        GetLuxNeighbourhoodSection()
        FieldModels(
            applicationArea = applicationArea,
            featuredModels = listOf(
                bunderbuurten.toTwinModelCardItem(),
                loenen.toTwinModelCardItem(),
                kronenberg.toTwinModelCardItem(),
            ),
            showMoreModelsLink = true,
        )
        PeterContactCard()
    }
}
