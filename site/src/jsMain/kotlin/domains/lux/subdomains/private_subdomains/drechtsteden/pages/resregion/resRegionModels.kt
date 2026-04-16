package energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.pages.resregion

import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.sections.application_fields.DrechtstedenProjectArea
import energy.lux.frontend.domains.lux.sections.application_fields.LuxApplicationArea
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.DrechtstedenTwinModel
import kotlin.uuid.Uuid


val drechtstedenResRegion =
    DrechtstedenTwinModel(
        projectPath = DrechtstedenProjectArea.RES_REGION.path,
        label = LocalizedText(nl = "Energy Twin Drechtsteden"),
        applicationArea = LuxApplicationArea.LUX_REGION,
        entryPoint = "drechtsteden/resregion/drechtsteden",
        modelId = Uuid.parse("fc879bf3-c6ae-41f5-90f6-af2726e03da7"),
        imageUrl = "/lux/images/drechtsteden/res-region/drechtsteden.png",
        pageComponent = { DrechtstedenRegioIndex() }
    )


val resRegionModels = listOf(
    drechtstedenResRegion
)
