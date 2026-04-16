package energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.pages.resneighborhoods

import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.sections.application_fields.LuxApplicationArea
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.DrechtstedenTwinModel
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.PublicDrechtstedenTwinModel
import kotlin.uuid.Uuid

val overTSpoor =
    DrechtstedenTwinModel(
        projectPath = "/overtspoor",
        label = LocalizedText(nl = "Energy Twin Over 't Spoor"),
        applicationArea = LuxApplicationArea.LUX_NEIGHBOURHOOD,
        entryPoint = "drechtsteden/resneighborhoods/overtspoor",
        modelId = Uuid.parse("612143ff-eedc-4f36-8606-13d4c4d710a7"),
        imageUrl = "/lux/images/drechtsteden/resneighborhoods/over_t_spoor.png",
        pageComponent = { OverTSpoor() }
    )
val oostdonk =
    DrechtstedenTwinModel(
        projectPath = "/oostdonk",
        label = LocalizedText(nl = "Energy Twin Oostdonk"),
        applicationArea = LuxApplicationArea.LUX_NEIGHBOURHOOD,
        entryPoint = "drechtsteden/resneighborhoods/oostdonk",
        modelId = Uuid.parse("3b4289ea-d2b8-4887-95bf-bf293fc34263"),
        imageUrl = "/lux/images/drechtsteden/resneighborhoods/oostdonk.png",
        pageComponent = { Oostdonk() }
    )
val kerkbuurt =
    DrechtstedenTwinModel(
        projectPath = "/kerkbuurt",
        label = LocalizedText(nl = "Energy Twin Kerkbuurt"),
        applicationArea = LuxApplicationArea.LUX_NEIGHBOURHOOD,
        entryPoint = "drechtsteden/resneighborhoods/kerkbuurt",
        modelId = Uuid.parse("a8d6e6ae-8a4c-4685-9195-33b9cd986c48"),
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
