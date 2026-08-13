package energy.lux.frontend.domains.lux.subdomains.private_subdomains.regiofoodvalley.pages.regio

import energy.lux.frontend.domains.lux.subdomains.private_subdomains.regiofoodvalley.RegioFoodValleyTwinModel
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.regiofoodvalley.regiofoodvalleyRegioMenuItem
import kotlin.uuid.Uuid


val regioFoodValleyRegio =
    RegioFoodValleyTwinModel(
        projectPath = "", // same as the area path
        areaPath = regiofoodvalleyRegioMenuItem.route.path,
        label = regiofoodvalleyRegioMenuItem.route.label,
        entryPoint = "regiofoodvalley/regio",
        modelId = Uuid.parse("60fd214e-e939-456b-b563-68d9782c991e"),
        imageUrl = "/lux/images/regiofoodvalley/regio/LUX_Foodvalley_RES.png",
        pageComponent = { RegioFoodValleyRegioPage() }
    )


val regioFoodValleyRegioModels = listOf(
    regioFoodValleyRegio,
)