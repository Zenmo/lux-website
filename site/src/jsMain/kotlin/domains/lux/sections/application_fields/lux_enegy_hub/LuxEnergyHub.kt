package energy.lux.frontend.domains.lux.sections.application_fields.lux_enegy_hub

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.framework.annotations.DelicateApi
import energy.lux.frontend.domains.lux.core.model.subdomain.PrivateSubdomainModel
import energy.lux.frontend.domains.lux.core.toTwinModelCardItem
import energy.lux.frontend.domains.lux.sections.application_fields.FieldModels
import energy.lux.frontend.domains.lux.sections.application_fields.LuxApplicationArea
import energy.lux.frontend.domains.lux.sections.application_fields.components.ApplicationAreaContactPerson
import energy.lux.frontend.domains.lux.sections.application_fields.lux_enegy_hub.components.AboutLuxEnergyHub
import energy.lux.frontend.domains.lux.sections.application_fields.lux_enegy_hub.components.LuxEnergyHubHero
import energy.lux.frontend.domains.lux.sections.application_fields.lux_enegy_hub.components.energy_hub_process.EnergyHubProcessSection
import energy.lux.frontend.domains.zenmo.sections.team.ZenmoTeam


@OptIn(DelicateApi::class)
@Composable
fun LuxEnergyHub() {
    Column {
        LuxEnergyHubHero()
        AboutLuxEnergyHub()
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