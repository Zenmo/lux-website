package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.PrivateSubdomainModel
import com.zenmo.web.zenmo.domains.lux.core.toTwinModelCardItem
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.FieldModels
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.components.ApplicationAreaContactPerson
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub.components.DidYouKNowSection
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub.components.LuxEnergyHubHero
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub.components.energy_hub_process.EnergyHubProcessSection
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam


@OptIn(DelicateApi::class)
@Composable
fun LuxEnergyHub() {
    Column {
        LuxEnergyHubHero()
        DidYouKNowSection()
        EnergyHubProcessSection()
        FieldModels(
            applicationArea = LuxApplicationArea.LUX_ENERGY_HUB,
            featuredModels = listOf(
                PrivateSubdomainModel.HESSENPOORT.toTwinModelCardItem(),
                PrivateSubdomainModel.GENUIS.toTwinModelCardItem(),
                PrivateSubdomainModel.KAS_ALS_ENERGIEBRON.toTwinModelCardItem(),
            ),
            showMoreModelsLink = true,
        )
        ApplicationAreaContactPerson(ZenmoTeam.AUKE)
    }
}