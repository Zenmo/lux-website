package com.zenmo.web.zenmo.domains.lux.components.model

sealed class DrechtstedenMunicipality(
    name: String,
    title: String,
    entryPoint: String,
    image: String,
) : DrechtstedenTwinModel(name, title, entryPoint, image) {

    data object Alblasserdam : DrechtstedenMunicipality(
        "alblasserdam",
        "Digital twin Gemeente Alblasserdam",
        "drechtsteden/municipalities/alblasserdam",
        "/lux/images/drechtsteden/municipalities/Gemeente_Alblasserdam_foto.png"
    )

    data object Hardinxveld : DrechtstedenMunicipality(
        "hardinxveld",
        "Digital twin Gemeente Hardinxveld-Giessendam",
        "drechtsteden/municipalities/hardinxveld",
        "/lux/images/drechtsteden/municipalities/Gemeente_Hardinxveld-Giessendam_foto.png"
    )

    data object SliedrechtMunicipality : DrechtstedenMunicipality(
        "sliedrechtmunicipality",
        "Digital twin Gemeente Sliedrecht",
        "drechtsteden/municipalities/sliedrecht",
        "/lux/images/drechtsteden/municipalities/Gemeente_Sliedrecht_foto.png"
    )

    data object Dordrecht : DrechtstedenMunicipality(
        "dordrecht",
        "Digital twin Dordrecht",
        "drechtsteden/municipalities/dordrecht",
        "/lux/images/drechtsteden/municipalities/dordrecht.png"
    )

    data object Papendrecht : DrechtstedenMunicipality(
        "papendrecht",
        "Digital twin Papendrecht",
        "drechtsteden/municipalities/papendrecht",
        "/lux/images/drechtsteden/municipalities/papendrecht.png"
    )

    data object Zwijndrecht : DrechtstedenMunicipality(
        "zwijndrecht",
        "Digital twin Zwijndrecht",
        "drechtsteden/municipalities/zwijndrecht",
        "/lux/images/drechtsteden/municipalities/zwijndrecht.png"
    )

    data object HendrikIdoAmbacht : DrechtstedenMunicipality(
        "hendrikidoambacht",
        "Digital twin Hendrik-Ido-Ambacht",
        "drechtsteden/municipalities/hendrikidoambacht",
        "/lux/images/drechtsteden/municipalities/hendrik_ido_ambacht.png"
    )

    companion object {
        val models = listOf(
            Alblasserdam,
            Hardinxveld,
            SliedrechtMunicipality,
            Dordrecht,
            Papendrecht,
            Zwijndrecht,
            HendrikIdoAmbacht
        )
    }
}