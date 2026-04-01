package energy.lux.frontend.domains.lux.sections.application_fields.lux_region

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import energy.lux.frontend.domains.lux.core.model.subdomain.PrivateSubdomainModel
import energy.lux.frontend.domains.lux.core.model.subdomain.empowered
import energy.lux.frontend.domains.lux.core.model.subdomain.hilversum
import energy.lux.frontend.domains.lux.core.toTwinModelCardItem
import energy.lux.frontend.domains.lux.sections.application_fields.FieldModels
import energy.lux.frontend.domains.lux.sections.application_fields.LuxApplicationArea
import energy.lux.frontend.domains.lux.sections.application_fields.components.ApplicationAreaContactPerson
import energy.lux.frontend.domains.zenmo.sections.team.ZenmoTeam
import energy.lux.frontend.domains.lux.sections.application_fields.lux_region.components.ConsistentInterface
import energy.lux.frontend.domains.lux.sections.application_fields.lux_region.components.LuxRegionDemoVideo
import energy.lux.frontend.domains.lux.sections.application_fields.lux_region.components.LuxRegionHero
import energy.lux.frontend.domains.lux.sections.application_fields.lux_region.components.MoreThanAMap
import energy.lux.frontend.domains.lux.sections.application_fields.lux_region.components.MultiScaleAnalysis
import energy.lux.frontend.domains.lux.sections.application_fields.lux_region.components.WhatIfScenarios


@Composable
fun LuxRegion() {
    Column {
        LuxRegionHero()
        MoreThanAMap()
        LuxRegionDemoVideo()
        WhatIfScenarios()
        MultiScaleAnalysis()
        ConsistentInterface()
        FieldModels(
            applicationArea = LuxApplicationArea.LUX_REGION,
            featuredModels = listOf(
                PrivateSubdomainModel.DRECHTSTEDEN.toTwinModelCardItem(),
                empowered.toTwinModelCardItem(),
                hilversum.toTwinModelCardItem(),
            ),
            showMoreModelsLink = true,
        )
        ApplicationAreaContactPerson(ZenmoTeam.NAUD_LOOMANS)
    }
}