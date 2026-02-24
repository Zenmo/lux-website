package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_region

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.PrivateSubdomainModel
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.empowered
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.hilversum
import com.zenmo.web.zenmo.domains.lux.core.toTwinModelCardItem
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.FieldModels
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.components.ApplicationAreaContactPerson
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_region.components.*
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam


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