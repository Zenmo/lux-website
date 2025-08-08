package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden

enum class DrechstedenTwin(
    val title: String,
    val entryPoint: String,
    val image: String,
) {
    // RES REGION MODELS
    PMIEK(
        "Digital twin Drechtsteden - PMIEK",
        "drechtsteden/resregion/pmiek",
        "/lux/images/drechtsteden/res-region/pmiek.png",
    ),
    WARMTETRANSITIE(
        "Digital twin Drechtsteden - Warmtetransitie",
        "drechtsteden/resregion/warmtetransitie",
        "/lux/images/drechtsteden/res-region/warmtetransitie.png",
    ),
    DRECHTSTEDEN_RES(
        "Digital twin Drechtsteden",
        "drechtsteden/resregion/drechtsteden",
        "/lux/images/drechtsteden/res-region/drechtsteden.png",
    ),

    // MUNICIPAL REGION MODELS
    ALBLASSERDAM(
        "Digital twin Gemeente Alblasserdam",
        "drechtsteden/municipalities/alblasserdam",
        "/lux/images/drechtsteden/municipalities/Gemeente_Alblasserdam_foto.png",
    ),
    HARDINXVELD(
        "Digital twin Gemeente Hardinxveld-Giessendam",
        "drechtsteden/municipalities/hardinxveld",
        "/lux/images/drechtsteden/municipalities/Gemeente_Hardinxveld-Giessendam_foto.png",
    ),
    SLIEDRECHT_MUNICIPALITY(
        "Digital twin Gemeente Sliedrecht",
        "drechtsteden/municipalities/sliedrecht",
        "/lux/images/drechtsteden/municipalities/Gemeente_Sliedrecht_foto.png",
    ),

    // BUSINESS PARK MODELS
    AMBACHTSE_ZOOM(
        "Digital twin Ambachtse Zoom",
        "drechtsteden/businessparks/ambachtse",
        "/lux/images/drechtsteden/business-parks/ambachtsezoom.png",
    ),
    AMSTELWIJCK_BUSINESSPARK(
        "Digital twin Amstelwijck Businesspark",
        "drechtsteden/businessparks/amstelwijck",
        "/lux/images/drechtsteden/business-parks/Amstelwijck_businesspark_foto.png",
    ),
    ANTONIAPOLDER(
        "Digital twin Antoniapolder",
        "drechtsteden/businessparks/antoniapolder",
        "/lux/images/drechtsteden/business-parks/antoniapolder.png",
    ),
    BAKESTEIN(
        "Digital twin Bakestein",
        "drechtsteden/businessparks/bakestein",
        "/lux/images/drechtsteden/business-parks/bakestein.png",
    ),
    DE_GEER(
        "Digital twin De Geer",
        "drechtsteden/businessparks/degeer",
        "/lux/images/drechtsteden/business-parks/de_geer.png",
    ),
    DE_STAART(
        "Digital twin De Staart",
        "drechtsteden/businessparks/destaart",
        "/lux/images/drechtsteden/business-parks/de-staart.jpg",
    ),
    DORDTSE_KIL_12_AMSTELWIJCK_WEST(
        "Digital twin Dordtse Kil I & II en Amstelwijck West",
        "drechtsteden/businessparks/dordtseamstelwijck",
        "/lux/images/drechtsteden/business-parks/dordtsekil12enAmstelwijckWest_foto.png",
    ),
    DORDTSE_KIL_34(
        "Digital twin Dordtse Kil III & IV",
        "drechtsteden/businessparks/dordtse",
        "/lux/images/drechtsteden/business-parks/dordtsekil34.png",
    ),
    GROOTE_LINDT_V2(
        "Digital twin Groote Lindt v2",
        "drechtsteden/businessparks/groote",
        "/lux/images/drechtsteden/business-parks/Groote-Lindt.png",
    ),
    LEERPARK(
        "Digital twin Leerpark",
        "drechtsteden/businessparks/leerpark",
        "/lux/images/drechtsteden/business-parks/Leerpark_foto.png",
    ),
    NIEUWE_WEG(
        "Digital twin Nieuwe Weg",
        "drechtsteden/businessparks/nieuweweg",
        "/lux/images/drechtsteden/business-parks/FeaturedImageNieuweWegPagina.png",
    ),
    PAPENDRECHT_OOSTEIND(
        "Digital twin Papendrecht Oosteind",
        "drechtsteden/businessparks/papendrecht",
        "/lux/images/drechtsteden/business-parks/papendrecht_oosteind.png",
    ),
    SLIEDRECHT_BUSINESSPARK(
        "Digital twin Sliedrecht",
        "drechtsteden/businessparks/sliedrecht",
        "/lux/images/drechtsteden/business-parks/FeaturedImageSliedrechtPagina.png",
    );

    companion object {
        val resRegionModels = listOf(
            PMIEK,
            WARMTETRANSITIE,
            DRECHTSTEDEN_RES
        )

        val municipalRegionModels = listOf(
            ALBLASSERDAM,
            HARDINXVELD,
            SLIEDRECHT_MUNICIPALITY
        )

        val businessParkModels = entries.filter {
            it !in (resRegionModels + municipalRegionModels)
        }
    }
}
