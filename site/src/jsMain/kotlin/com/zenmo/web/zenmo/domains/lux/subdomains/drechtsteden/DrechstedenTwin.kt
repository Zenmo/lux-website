package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden

enum class DrechstedenTwin(
    val title: String,
    val entryPoint: String,
    val image: String,
) {
    // RES REGION MODELS
    PMIEK(
        "Digital twin Drechtsteden PMIEK",
        "drechtsteden/res-region/pmeik",
        "/lux/images/drechtsteden/res-region/pmeik.png"
    ),
    WARMTETRANSITIE(
        "Digital twin Drechtsteden Warmtetransitie",
        "drechtsteden/res-region/warmtetransitie",
        "/lux/images/drechtsteden/res-region/warmtetransitie.png"
    ),
    DRECHTSTEDEN_RES(
        "Digital twin Drechtsteden",
        "drechtsteden/res-region/municipalities/drechtsteden",
        "/lux/images/drechtsteden/res-region/Drechtsteden-3.png"
    ),

    // MUNICIPAL REGION MODELS
    ALBLASSERDAM(
        "Digital twin Gemeente Alblasserdam",
        "drechtsteden/municipalities/alblasserdam",
        "/lux/images/drechtsteden/municipalities/Gemeente_Alblasserdam_foto.png"
    ),
    HARDINXVELD(
        "Digital twin Gemeente Hardinxveld-Giessendam",
        "drechtsteden/municipalities/hardinxveld",
        "/lux/images/drechtsteden/municipalities/Gemeente_Hardinxveld-Giessendam_foto.png"
    ),
    SLIEDRECHT_MUNICIPALITY(
        "Digital twin Gemeente Sliedrecht",
        "drechtsteden/municipalities/sliedrecht",
        "/lux/images/drechtsteden/municipalities/Gemeente_Sliedrecht_foto.png"
    ),

    // BUSINESS PARK MODELS
    AMBACHTSE_ZOOM(
        "Digital twin Ambachtse Zoom",
        "drechtsteden/business-parks/ambachtse-zoom",
        "/lux/images/drechtsteden/business-parks/ambachtsezoom.png"
    ),
    AMSTELWIJCK_BUSINESSPARK(
        "Digital twin Amstelwijck Businesspark",
        "drechtsteden/business-parks/amstelwijck-businesspark",
        "/lux/images/drechtsteden/business-parks/Amstelwijck_businesspark_foto.png"
    ),
    ANTONIAPOLDER(
        "Digital twin Antoniapolder",
        "drechtsteden/business-parks/antoniapolder",
        "/lux/images/drechtsteden/business-parks/antoniapolder.png"
    ),
    BAKESTEIN(
        "Digital twin Bakestein",
        "drechtsteden/business-parks/bakestein",
        "/lux/images/drechtsteden/business-parks/bakestein.png"
    ),
    DE_GEER(
        "Digital twin De Geer",
        "drechtsteden/business-parks/de-geer",
        "/lux/images/drechtsteden/business-parks/de-geer.jpg"
    ),
    DE_STAART(
        "Digital twin De Staart",
        "drechtsteden/business-parks/de-staart",
        "/lux/images/drechtsteden/business-parks/de-staart.jpg"
    ),
    DORDTSE_KIL_12_AMSTELWIJCK_WEST(
        "Digital twin Dordtse Kil I & II en Amstelwijck West",
        "drechtsteden/business-parks/dordtse-kil-i-ii-amstelwijck-west",
        "/lux/images/drechtsteden/business-parks/dordtsekil12enAmstelwijckWest_foto.png"
    ),
    DORDTSE_KIL_34(
        "Digital twin Dordtse Kil III & IV",
        "drechtsteden/business-parks/dordtse-kil-iii-iv",
        "/lux/images/drechtsteden/business-parks/dordtsekil34.png"
    ),
    GROOTE_LINDT_V2(
        "Digital twin Groote Lindt v2",
        "drechtsteden/business-parks/groote-lindt-v2",
        "/lux/images/drechtsteden/business-parks/Groote-Lindt.png"
    ),
    LEERPARK(
        "Digital twin Leerpark",
        "drechtsteden/business-parks/leerpark",
        "/lux/images/drechtsteden/business-parks/Leerpark_foto.png"
    ),
    NIEUWE_WEG(
        "Digital twin Nieuwe Weg",
        "drechtsteden/business-parks/nieuwe-weg",
        "/lux/images/drechtsteden/business-parks/FeaturedImageNieuweWegPagina.png"
    ),
    PAPENDRECHT_OOSTEIND(
        "Digital twin Papendrecht Oosteind",
        "drechtsteden/business-parks/papendrecht-oosteind",
        "/lux/images/drechtsteden/business-parks/papendrecht_oosteind.png"
    ),
    SLIEDRECHT_BUSINESSPARK(
        "Digital twin Sliedrecht",
        "drechtsteden/business-parks/sliedrecht-businesspark",
        "/lux/images/drechtsteden/business-parks/FeaturedImageSliedrechtPagina.png"
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
