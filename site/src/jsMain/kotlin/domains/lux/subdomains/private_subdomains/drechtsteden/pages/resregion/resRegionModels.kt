package energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.pages.resregion

import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.sections.application_fields.DrechtstedenProjectArea
import energy.lux.frontend.domains.lux.sections.application_fields.LuxApplicationArea
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.DrechtstedenTwinModel


val drechtstedenResRegion =
    DrechtstedenTwinModel(
        projectPath = DrechtstedenProjectArea.RES_REGION.path,
        label = LocalizedText(nl = "Energy Twin Drechtsteden"),
        applicationArea = LuxApplicationArea.LUX_REGION,
        entryPoint = "drechtsteden/resregion/drechtsteden",
        imageUrl = "/lux/images/drechtsteden/res-region/drechtsteden.png",
        pageComponent = { DrechtstedenRegioIndex() }
    )


val resRegionModels = listOf(
    drechtstedenResRegion
)
