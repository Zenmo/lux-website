package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.resregion

import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.DrechtstedenProjectArea
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.DrechtstedenTwinModel


val drechtstedenRes = DrechtstedenTwinModel(
    projectPath = "drechtstedenres",
    label = LocalizedText(nl = "Digital twin Drechtsteden"),
    applicationArea = DrechtstedenProjectArea.RES_REGION,
    entryPoint = "drechtsteden/resregion/drechtsteden",
    imageUrl = "/lux/images/drechtsteden/res-region/drechtsteden.png",
    pageComponent = { DrechtstedenPage() }
)


val resRegionModels = listOf(
    drechtstedenRes
)