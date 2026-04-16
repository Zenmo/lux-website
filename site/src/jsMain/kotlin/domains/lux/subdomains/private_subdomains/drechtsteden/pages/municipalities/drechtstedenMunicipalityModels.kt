package energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.pages.municipalities

import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.DrechtstedenTwinModel
import kotlin.uuid.Uuid


val alblasserdam =
    DrechtstedenTwinModel(
        projectPath = "/alblasserdam",
        label = LocalizedText(nl = "Energy Twin Gemeente Alblasserdam"),
        entryPoint = "drechtsteden/municipalities/alblasserdam",
        modelId = Uuid.parse("92e0993d-e96d-4f05-9c0b-eb9bbf1d1eb1"),
        imageUrl = "/lux/images/drechtsteden/municipalities/Gemeente_Alblasserdam_foto.png",
        pageComponent = { GemeenteAlblasserdamPage() }
    )

val hardinxveld =
    DrechtstedenTwinModel(
        projectPath = "/hardinxveld",
        label = LocalizedText(nl = "Energy Twin Gemeente Hardinxveld-Giessendam"),
        entryPoint = "drechtsteden/municipalities/hardinxveld",
        modelId = Uuid.parse("87d8b189-bcc4-4e37-ba44-3ee1e242985a"),
        imageUrl = "/lux/images/drechtsteden/municipalities/Gemeente_Hardinxveld-Giessendam_foto.png",
        pageComponent = { HardinxveldPage() }
    )
val sliedrechtMunicipality =
    DrechtstedenTwinModel(
        projectPath = "/sliedrechtmunicipality",
        label = LocalizedText(nl = "Energy Twin Gemeente Sliedrecht"),
        entryPoint = "drechtsteden/municipalities/sliedrecht",
        modelId = Uuid.parse("e62f7668-a52c-47d2-aae6-e89717ddb5a7"),
        imageUrl = "/lux/images/drechtsteden/municipalities/Gemeente_Sliedrecht_foto.png",
        pageComponent = { GemeenteSliedrechtPage() }
    )
val dordrecht =
    DrechtstedenTwinModel(
        projectPath = "/dordrecht",
        label = LocalizedText(nl = "Energy Twin Dordrecht"),
        entryPoint = "drechtsteden/municipalities/dordrecht",
        modelId = Uuid.parse("ccc42e85-3ae9-4025-bb98-a34a29adb18a"),
        imageUrl = "/lux/images/drechtsteden/municipalities/dordrecht.png",
        pageComponent = { Dordrecht() }
    )
val papendrecht =
    DrechtstedenTwinModel(
        projectPath = "/papendrecht",
        label = LocalizedText(nl = "Energy Twin Papendrecht"),
        entryPoint = "drechtsteden/municipalities/papendrecht",
        modelId = Uuid.parse("af3272d6-b1a4-49a2-af86-e3f55cc731d9"),
        imageUrl = "/lux/images/drechtsteden/municipalities/papendrecht.png",
        pageComponent = { Papendrecht() }
    )
val zwijndrecht =
    DrechtstedenTwinModel(
        projectPath = "/zwijndrecht",
        label = LocalizedText(nl = "Energy Twin Zwijndrecht"),
        entryPoint = "drechtsteden/municipalities/zwijndrecht",
        modelId = Uuid.parse("a4c15d4b-025a-4169-b948-3ddd75c67091"),
        imageUrl = "/lux/images/drechtsteden/municipalities/zwijndrecht.png",
        pageComponent = { Zwijndrecht() }
    )
val hendrikIdoAmbacht =
    DrechtstedenTwinModel(
        projectPath = "/hendrikidoambacht",
        label = LocalizedText(nl = "Energy Twin Hendrik-Ido-Ambacht"),
        entryPoint = "drechtsteden/municipalities/hendrikidoambacht",
        modelId = Uuid.parse("95110865-7aca-4a5f-9934-ef5f1891ebd9"),
        imageUrl = "/lux/images/drechtsteden/municipalities/hendrik_ido_ambacht.png",
        pageComponent = { HendrikIdoAmbacht() }
    )

val drechtstedenMunicipalityModels = listOf(
    alblasserdam,
    hardinxveld,
    sliedrechtMunicipality,
    dordrecht,
    papendrecht,
    zwijndrecht,
    hendrikIdoAmbacht
)