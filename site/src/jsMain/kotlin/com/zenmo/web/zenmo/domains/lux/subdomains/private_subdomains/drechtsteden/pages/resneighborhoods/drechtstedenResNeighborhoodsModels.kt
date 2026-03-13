package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages.resneighborhoods

import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.DrechtstedenTwinModel
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.PublicDrechtstedenTwinModel
import kotlin.uuid.Uuid

val overTSpoor =
    DrechtstedenTwinModel(
        projectPath = "/overtspoor",
        label = LocalizedText(nl = "Energy Twin Over 't Spoor"),
        applicationArea = LuxApplicationArea.LUX_NEIGHBOURHOOD,
        entryPoint = "drechtsteden/resneighborhoods/overtspoor",
        imageUrl = "/lux/images/drechtsteden/resneighborhoods/over_t_spoor.png",
        pageComponent = { OverTSpoor() }
    )
val oostdonk =
    DrechtstedenTwinModel(
        projectPath = "/oostdonk",
        label = LocalizedText(nl = "Energy Twin Oostdonk"),
        applicationArea = LuxApplicationArea.LUX_NEIGHBOURHOOD,
        entryPoint = "drechtsteden/resneighborhoods/oostdonk",
        imageUrl = "/lux/images/drechtsteden/resneighborhoods/oostdonk.png",
        pageComponent = { Oostdonk() }
    )
val kerkbuurt =
    DrechtstedenTwinModel(
        projectPath = "/kerkbuurt",
        label = LocalizedText(nl = "Energy Twin Kerkbuurt"),
        applicationArea = LuxApplicationArea.LUX_NEIGHBOURHOOD,
        entryPoint = "drechtsteden/resneighborhoods/kerkbuurt",
        imageUrl = "/lux/images/drechtsteden/resneighborhoods/kerkbuurt.png",
        pageComponent = { Kerkbuurt() }
    )
val landVanValk =
    PublicDrechtstedenTwinModel(
        projectPath = "/landVanValk",
        label = LocalizedText(nl = "Energy Twin Land Van Valk"),
        applicationArea = LuxApplicationArea.LUX_NEIGHBOURHOOD,
        modelId = Uuid.parse("5fbcc4b5-f1b1-4b9c-9b4f-9f10629ebec9"),
        imageUrl = "/lux/images/drechtsteden/resneighborhoods/landVanValk.png",
        pageComponent = { LandVanValk() }
    )


val drechtstedenNeighbourhoodsModels = listOf(
    overTSpoor,
    oostdonk,
    kerkbuurt,
    landVanValk,
)
