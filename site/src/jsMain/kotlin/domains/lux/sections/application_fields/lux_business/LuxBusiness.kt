package energy.lux.frontend.domains.lux.sections.application_fields.lux_business

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import energy.lux.frontend.domains.lux.core.model.subdomain.PrivateSubdomainModel
import energy.lux.frontend.domains.lux.core.model.subdomain.cognizant
import energy.lux.frontend.domains.lux.core.toTwinModelCardItem
import energy.lux.frontend.domains.lux.sections.application_fields.FieldModels
import energy.lux.frontend.domains.lux.sections.application_fields.LuxApplicationArea
import energy.lux.frontend.domains.lux.sections.application_fields.components.ApplicationAreaContactPerson
import energy.lux.frontend.domains.zenmo.sections.team.ZenmoTeam
import energy.lux.frontend.domains.lux.sections.application_fields.lux_business.components.CalculateYourEnergyFuture
import energy.lux.frontend.domains.lux.sections.application_fields.lux_business.components.GridCongestionExplanation
import energy.lux.frontend.domains.lux.sections.application_fields.lux_business.components.InteractiveDashboardSection
import energy.lux.frontend.domains.lux.sections.application_fields.lux_business.components.LuxBusinessDemoVideo
import energy.lux.frontend.domains.lux.sections.application_fields.lux_business.components.LuxBusinessHero
import energy.lux.frontend.domains.lux.sections.application_fields.lux_business.components.PersonalAdvice
import energy.lux.frontend.domains.lux.sections.application_fields.lux_business.components.SmarterEnergyUse
import energy.lux.frontend.domains.lux.sections.application_fields.lux_business.components.UniqueFeature


@Composable
fun LuxBusiness(
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        LuxBusinessHero()
        GridCongestionExplanation()
        CalculateYourEnergyFuture()
        SmarterEnergyUse()
        LuxBusinessDemoVideo()
        InteractiveDashboardSection()
        PersonalAdvice()
        UniqueFeature()
        FieldModels(
            applicationArea = LuxApplicationArea.LUX_BUSINESS,
            featuredModels = listOf(
                cognizant.toTwinModelCardItem(),
                PrivateSubdomainModel.PREZERO.toTwinModelCardItem(),
            ),
            showMoreModelsLink = false,
        )
        ApplicationAreaContactPerson(ZenmoTeam.PETER_HOGEVEEN)
    }
}
