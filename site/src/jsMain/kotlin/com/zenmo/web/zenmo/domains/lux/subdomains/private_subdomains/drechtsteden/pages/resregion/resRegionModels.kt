package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages.resregion

import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.DrechtstedenProjectArea
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.DrechtstedenTwinModel


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
