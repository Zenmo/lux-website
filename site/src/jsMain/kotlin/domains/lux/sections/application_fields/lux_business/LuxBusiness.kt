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
import energy.lux.frontend.domains.lux.sections.application_fields.components.PeterContactCard
import energy.lux.frontend.domains.lux.sections.application_fields.lux_business.components.*


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
        PeterContactCard()
    }
}
