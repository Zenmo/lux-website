package energy.lux.frontend.domains.lux.core.model.subdomain

import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.core.TwinModelCardItem
import energy.lux.frontend.domains.lux.sections.application_fields.LuxApplicationArea
import energy.lux.frontend.domains.lux.sections.application_fields.components.LUX_DEMO_SECTION_ID
import kotlin.uuid.Uuid

val demoEnergyHubModel = TwinModelCardItem(
    label = LocalizedText(en = "Demo Energy Hub", nl = "Demo Energy Hub"),
    imageUrl = PrivateSubdomainModel.VAANPARK.imageUrl,
    url = "${LuxApplicationArea.LUX_ENERGY_HUB.url}#${LUX_DEMO_SECTION_ID}",
    applicationArea = LuxApplicationArea.LUX_ENERGY_HUB,
    modelId = Uuid.parse("834a212f-7e61-4f55-9b21-a4de5327aee1"),
    isPrivate = false
)

val demoNeighbourhoodModel = TwinModelCardItem(
    label = LocalizedText(en = "Demo Neighbourhood", nl = "Demo Woonwijk"),
    imageUrl = "/lux/images/lux_neighbourhood.png",
    url = "${LuxApplicationArea.LUX_NEIGHBOURHOOD.url}#${LUX_DEMO_SECTION_ID}",
    applicationArea = LuxApplicationArea.LUX_NEIGHBOURHOOD,
    modelId = Uuid.parse("ccbd35d7-98a8-4fb9-8161-dda239d7f049"),
    isPrivate = false
)
val demoModels = listOf(
    demoEnergyHubModel,
    demoNeighbourhoodModel
)