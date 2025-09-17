package com.zenmo.web.zenmo.domains.lux.components.model


sealed class TwinModel(
    val title: String,
    val entryPoint: String?,
    val image: String
) {
    open fun url(path: String, protocol: String, luxDomain: String): String {
        return "${protocol}//$luxDomain/$path/${title.lowercase()}"
    }
}


// RES REGION MODELS
sealed class DrechtstedenTwinModel(val name: String, title: String, entryPoint: String, image: String) :
    TwinModel(title, entryPoint, image) {

    override fun url(path: String, protocol: String, luxDomain: String): String {
        val drechtstedenBase = "${protocol}//${SubdomainModel.Drechtsteden.title}.$luxDomain/$path"
        return "$drechtstedenBase/${name}"
    }

    // RES REGION MODELS

    data object DrechtstedenRes : DrechtstedenTwinModel(
        "drechtstedenres",
        "Digital twin Drechtsteden",
        "drechtsteden/resregion/drechtsteden",
        "/lux/images/drechtsteden/res-region/drechtsteden.png"
    )


    // MUNICIPAL REGION MODELS
    data object Alblasserdam : DrechtstedenTwinModel(
        "alblasserdam",
        "Digital twin Gemeente Alblasserdam",
        "drechtsteden/municipalities/alblasserdam",
        "/lux/images/drechtsteden/municipalities/Gemeente_Alblasserdam_foto.png"
    )

    data object Hardinxveld : DrechtstedenTwinModel(
        "hardinxveld",
        "Digital twin Gemeente Hardinxveld-Giessendam",
        "drechtsteden/municipalities/hardinxveld",
        "/lux/images/drechtsteden/municipalities/Gemeente_Hardinxveld-Giessendam_foto.png"
    )

    data object SliedrechtMunicipality : DrechtstedenTwinModel(
        "sliedrechtmunicipality",
        "Digital twin Gemeente Sliedrecht",
        "drechtsteden/municipalities/sliedrecht",
        "/lux/images/drechtsteden/municipalities/Gemeente_Sliedrecht_foto.png"
    )

    //  BUSINESS PARK MODELS
    data object AmbachtseZoom : DrechtstedenTwinModel(
        "ambachtsezoom",
        "Digital twin Ambachtse Zoom",
        "drechtsteden/businessparks/ambachtse",
        "/lux/images/drechtsteden/business-parks/ambachtsezoom.png"
    )

    data object AmstelwijckBusinesspark : DrechtstedenTwinModel(
        "amstelwijckbusinesspark",
        "Digital twin Amstelwijck Businesspark",
        "drechtsteden/businessparks/amstelwijck",
        "/lux/images/drechtsteden/business-parks/Amstelwijck_businesspark_foto.png"
    )

    data object Antoniapolder : DrechtstedenTwinModel(
        "antoniapolder",
        "Digital twin Antoniapolder",
        "drechtsteden/businessparks/antoniapolder",
        "/lux/images/drechtsteden/business-parks/antoniapolder.png"
    )

    data object Bakestein : DrechtstedenTwinModel(
        "bakestein",
        "Digital twin Bakestein",
        "drechtsteden/businessparks/bakestein",
        "/lux/images/drechtsteden/business-parks/bakestein.png"
    )

    data object DeGeer : DrechtstedenTwinModel(
        "degeer",
        "Digital twin De Geer",
        "drechtsteden/businessparks/degeer",
        "/lux/images/drechtsteden/business-parks/de_geer.png"
    )

    data object DeStaart : DrechtstedenTwinModel(
        "destaart",
        "Digital twin De Staart",
        "drechtsteden/businessparks/destaart",
        "/lux/images/drechtsteden/business-parks/de-staart.jpg"
    )

    data object DordtseKil12AmstelwijckWest : DrechtstedenTwinModel(
        "dordtsekil12amstelwijckwest",
        "Digital twin Dordtse Kil I & II en Amstelwijck West",
        "drechtsteden/businessparks/dordtseamstelwijck",
        "/lux/images/drechtsteden/business-parks/dordtsekil12enAmstelwijckWest_foto.png"
    )

    data object DordtseKil34 : DrechtstedenTwinModel(
        "dordtsekil34",
        "Digital twin Dordtse Kil III & IV",
        "drechtsteden/businessparks/dordtse",
        "/lux/images/drechtsteden/business-parks/dordtsekil34.png"
    )

    data object GrooteLindtV2 : DrechtstedenTwinModel(
        "grootelindtv2",
        "Digital twin Groote Lindt v2",
        "drechtsteden/businessparks/groote",
        "/lux/images/drechtsteden/business-parks/Groote-Lindt.png"
    )

    data object Leerpark : DrechtstedenTwinModel(
        "leerpark",
        "Digital twin Leerpark",
        "drechtsteden/businessparks/leerpark",
        "/lux/images/drechtsteden/business-parks/Leerpark_foto.png"
    )

    data object NieuweWeg : DrechtstedenTwinModel(
        "nieuweweg",
        "Digital twin Nieuwe Weg",
        "drechtsteden/businessparks/nieuweweg",
        "/lux/images/drechtsteden/business-parks/FeaturedImageNieuweWegPagina.png"
    )

    data object PapendrechtOosteind : DrechtstedenTwinModel(
        "papendrechtoosteind",
        "Digital twin Papendrecht Oosteind",
        "drechtsteden/businessparks/papendrecht",
        "/lux/images/drechtsteden/business-parks/papendrecht_oosteind.png"
    )

    data object SliedrechtBusinesspark : DrechtstedenTwinModel(
        "sliedrechtbusinesspark",
        "Digital twin Sliedrecht",
        "drechtsteden/businessparks/sliedrecht",
        "/lux/images/drechtsteden/business-parks/FeaturedImageSliedrechtPagina.png"
    )


    companion object {

        val resRegionModels = listOf(
            DrechtstedenRes
        )
        val municipalModels = listOf(
            Alblasserdam,
            Hardinxveld,
            SliedrechtMunicipality
        )

        val businessParkModels = listOf(
            AmbachtseZoom,
            AmstelwijckBusinesspark,
            Antoniapolder,
            Bakestein,
            DeGeer,
            DeStaart,
            DordtseKil12AmstelwijckWest,
            DordtseKil34,
            GrooteLindtV2,
            Leerpark,
            NieuweWeg,
            PapendrechtOosteind,
            SliedrechtBusinesspark
        )
    }
}


//  SUBDOMAIN MODELS
sealed class SubdomainModel(
    title: String,
    image: String,
    entryPoint: String = "",
    val isPrivate: Boolean,
) : TwinModel(title, entryPoint, image) {
    override fun url(path: String, protocol: String, luxDomain: String): String {
        return "${protocol}//${title.lowercase()}.$luxDomain"
    }

    data object Drechtsteden : SubdomainModel(
        "drechtsteden",
        "/img/drechtsteden-rivier.jpg",
        "drechtsteden",
        isPrivate = true
    )

    data object Genius : SubdomainModel(
        "genius",
        "/lux/images/models/genius.png",
        "genius",
        isPrivate = true
    )

    data object Hessenpoort : SubdomainModel(
        "hessenpoort",
        "/lux/images/models/hessenpoort.png",
        "hessenpoort",
        isPrivate = true
    )

    data object KasAlsEnergiebron : SubdomainModel(
        "kasalsenergiebron",
        "/lux/images/models/kasals.png",
        "kasalsenergiebron",
        isPrivate = true
    )

    data object Brabant : SubdomainModel(
        "brabant",
        "/lux/images/models/brabant.png",
        isPrivate = false
    )

    data object Nederland : SubdomainModel(
        "nederland",
        "/lux/images/models/nederland.png",
        isPrivate = false
    )


    data object Hilversum : SubdomainModel(
        "hilversum",
        "/lux/images/models/hilversum.png",
        isPrivate = false
    )

    data object Bunderbuurten : SubdomainModel(
        "bunderbuurten",
        "/lux/images/models/bunderbuurten.png",
        isPrivate = false
    )

    data object Loenen : SubdomainModel(
        "loenen",
        "/lux/images/models/loenen.png",
        isPrivate = false
    )

    data object RotterdamDenHaag : SubdomainModel(
        "rotterdamdenhaag",
        "/lux/images/models/rotterdam.png",
        isPrivate = false
    )

    data object Vruchtenbuurt : SubdomainModel(
        "vruchtenbuurt",
        "/lux/images/models/vruchtenbuurt.png",
        isPrivate = false
    )

    data object Cognizant : SubdomainModel(
        "cognizant",
        "/lux/images/models/cognizant.png",
        isPrivate = false
    )

    companion object {
        val allModels = listOf(
            Drechtsteden,
            Genius,
            Brabant,
            Nederland,
            Hessenpoort,
            KasAlsEnergiebron,
            Hilversum,
            Bunderbuurten,
            Loenen,
            RotterdamDenHaag,
            Vruchtenbuurt,
            Cognizant
        )
        val publicSubdomains = allModels.filter { !it.isPrivate }
        val privateSubdomains = allModels.filter { it.isPrivate }
    }
}
