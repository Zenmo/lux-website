package energy.lux.site.frontend.domains.lux.components.model

sealed class DrechtstedenBusinessPark(
    name: String,
    title: String,
    entryPoint: String,
    image: String,
) : DrechtstedenTwinModel(name, title, entryPoint, image) {

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
        "drechtsteden/businessparks/papendrechtoosteind",
        "/lux/images/drechtsteden/business-parks/papendrecht_oosteind.png"
    )

    data object SliedrechtBusinesspark : DrechtstedenTwinModel(
        "sliedrechtbusinesspark",
        "Digital twin Sliedrecht",
        "drechtsteden/businessparks/sliedrecht",
        "/lux/images/drechtsteden/business-parks/FeaturedImageSliedrechtPagina.png"
    )

    companion object {
        val models = listOf(
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