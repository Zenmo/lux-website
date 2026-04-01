package energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.pages.municipalities

import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.DrechtstedenTwinModel


val alblasserdam =
    DrechtstedenTwinModel(
        projectPath = "/alblasserdam",
        label = LocalizedText(nl = "Energy Twin Gemeente Alblasserdam"),
        entryPoint = "drechtsteden/municipalities/alblasserdam",
        imageUrl = "/lux/images/drechtsteden/municipalities/Gemeente_Alblasserdam_foto.png",
        pageComponent = { GemeenteAlblasserdamPage() }
    )

val hardinxveld =
    DrechtstedenTwinModel(
        projectPath = "/hardinxveld",
        label = LocalizedText(nl = "Energy Twin Gemeente Hardinxveld-Giessendam"),
        entryPoint = "drechtsteden/municipalities/hardinxveld",
        imageUrl = "/lux/images/drechtsteden/municipalities/Gemeente_Hardinxveld-Giessendam_foto.png",
        pageComponent = { HardinxveldPage() }
    )
val sliedrechtMunicipality =
    DrechtstedenTwinModel(
        projectPath = "/sliedrechtmunicipality",
        label = LocalizedText(nl = "Energy Twin Gemeente Sliedrecht"),
        entryPoint = "drechtsteden/municipalities/sliedrecht",
        imageUrl = "/lux/images/drechtsteden/municipalities/Gemeente_Sliedrecht_foto.png",
        pageComponent = { GemeenteSliedrechtPage() }
    )
val dordrecht =
    DrechtstedenTwinModel(
        projectPath = "/dordrecht",
        label = LocalizedText(nl = "Energy Twin Dordrecht"),
        entryPoint = "drechtsteden/municipalities/dordrecht",
        imageUrl = "/lux/images/drechtsteden/municipalities/dordrecht.png",
        pageComponent = { Dordrecht() }
    )
val papendrecht =
    DrechtstedenTwinModel(
        projectPath = "/papendrecht",
        label = LocalizedText(nl = "Energy Twin Papendrecht"),
        entryPoint = "drechtsteden/municipalities/papendrecht",
        imageUrl = "/lux/images/drechtsteden/municipalities/papendrecht.png",
        pageComponent = { Papendrecht() }
    )
val zwijndrecht =
    DrechtstedenTwinModel(
        projectPath = "/zwijndrecht",
        label = LocalizedText(nl = "Energy Twin Zwijndrecht"),
        entryPoint = "drechtsteden/municipalities/zwijndrecht",
        imageUrl = "/lux/images/drechtsteden/municipalities/zwijndrecht.png",
        pageComponent = { Zwijndrecht() }
    )
val hendrikIdoAmbacht =
    DrechtstedenTwinModel(
        projectPath = "/hendrikidoambacht",
        label = LocalizedText(nl = "Energy Twin Hendrik-Ido-Ambacht"),
        entryPoint = "drechtsteden/municipalities/hendrikidoambacht",
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