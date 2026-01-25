package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages.resregion

import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.DrechtstedenProjectArea
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.DrechtstedenTwinModel


val drechtstedenRes =
    DrechtstedenTwinModel(
        projectPath = "",
        label = LocalizedText(nl = "Digital twin Drechtsteden"),
        applicationArea = DrechtstedenProjectArea.RES_REGION,
        entryPoint = "drechtsteden/resregion/drechtsteden",
        imageUrl = "/lux/images/drechtsteden/res-region/drechtsteden.png",
        pageComponent = { DrechtstedenRegioIndex() }
    )


val resRegionModels = listOf(
    drechtstedenRes
)