package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.resneighborhoods

import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.DrechtstedenProjectArea
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.DrechtstedenTwinModel

val overTSpoor = DrechtstedenTwinModel(
    projectPath = "overtspoor",
    label = LocalizedText(nl = "Digital twin Over 't Spoor"),
    applicationArea = DrechtstedenProjectArea.RES_NEIGHBORHOODS,
    entryPoint = "drechtsteden/resneighborhoods/overtspoor",
    imageUrl = "/lux/images/drechtsteden/resneighborhoods/over_t_spoor.png",
    pageComponent = { OverTSpoor() }
)
val oostdonk = DrechtstedenTwinModel(
    projectPath = "oostdonk",
    label = LocalizedText(nl = "Digital twin Oostdonk"),
    applicationArea = DrechtstedenProjectArea.RES_NEIGHBORHOODS,
    entryPoint = "drechtsteden/resneighborhoods/oostdonk",
    imageUrl = "/lux/images/drechtsteden/resneighborhoods/oostdonk.png",
    pageComponent = { Oostdonk() }
)
val kerkbuurt = DrechtstedenTwinModel(
    projectPath = "kerkbuurt",
    label = LocalizedText(nl = "Digital twin Kerkbuurt"),
    applicationArea = DrechtstedenProjectArea.RES_NEIGHBORHOODS,
    entryPoint = "drechtsteden/resneighborhoods/kerkbuurt",
    imageUrl = "/lux/images/drechtsteden/resneighborhoods/kerkbuurt.png",
    pageComponent = { Kerkbuurt() }
)

val drechtstedenResNeighborhoodsModels = listOf(
    overTSpoor,
    oostdonk,
    kerkbuurt
)