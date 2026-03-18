package energy.lux.frontend.domains.lux.sections.application_fields.lux_region

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import domains.lux.sections.application_fields.lux_region.components.LuxRegionDemoModel
import domains.lux.sections.application_fields.lux_region.components.LuxRegionHero
import domains.lux.sections.application_fields.lux_region.components.MoreThanAMap
import energy.lux.frontend.domains.lux.core.model.subdomain.PrivateSubdomainModel
import energy.lux.frontend.domains.lux.core.model.subdomain.rotterdamDenHaag
import energy.lux.frontend.domains.lux.core.toTwinModelCardItem
import energy.lux.frontend.domains.lux.sections.application_fields.FieldModels
import energy.lux.frontend.domains.lux.sections.application_fields.LuxApplicationArea
import energy.lux.frontend.domains.lux.sections.application_fields.components.ApplicationAreaContactPerson
import energy.lux.frontend.domains.zenmo.sections.team.ZenmoTeam
import domains.lux.sections.application_fields.lux_region.components.ConsistentInterface
import domains.lux.sections.application_fields.lux_region.components.WhatIfScenarios


@Composable
fun LuxRegion() {
    Column {
        LuxRegionHero()
        MoreThanAMap()
        LuxRegionDemoModel()
        WhatIfScenarios()
//        MultiScaleAnalysis() Naud envisions this part to be added in the coming year
        ConsistentInterface()
        FieldModels(
            applicationArea = LuxApplicationArea.LUX_REGION,
            featuredModels = listOf(
                PrivateSubdomainModel.DRECHTSTEDEN.toTwinModelCardItem(),
                rotterdamDenHaag.toTwinModelCardItem(),
            ),
            showMoreModelsLink = true,
        )
        ApplicationAreaContactPerson(ZenmoTeam.NAUD_LOOMANS)
    }
}