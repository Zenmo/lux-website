package energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.pages.businessparks

import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.DrechtstedenTwinModel
import kotlin.uuid.Uuid

val ambachtseZoom =
    DrechtstedenTwinModel(
        projectPath = "/ambachtsezoom",
        label = LocalizedText(nl = "Energy Twin Ambachtse Zoom"),
        entryPoint = "drechtsteden/businessparks/ambachtse",
        modelId = Uuid.parse("fc8e83f5-2c0d-4961-b4f9-35069486eca6"),
        imageUrl = "/lux/images/drechtsteden/business-parks/ambachtsezoom.png",
        pageComponent = { AmbachtsePage() }
    )
val amstelwijckBusinesspark =
    DrechtstedenTwinModel(
        projectPath = "/amstelwijckbusinesspark",
        label = LocalizedText(nl = "Energy Twin Amstelwijck Businesspark"),
        entryPoint = "drechtsteden/businessparks/amstelwijck",
        modelId = Uuid.parse("266253e0-16b4-44de-baac-51641f99e34b"),
        imageUrl = "/lux/images/drechtsteden/business-parks/Amstelwijck_businesspark_foto.png",
        pageComponent = { AmstelwijckPage() }
    )
val antoniapolder =
    DrechtstedenTwinModel(
        projectPath = "/antoniapolder",
        label = LocalizedText(nl = "Energy Twin Antoniapolder"),
        entryPoint = "drechtsteden/businessparks/antoniapolder",
        modelId = Uuid.parse("4f86e085-34f3-4b45-891b-8c9789711a91"),
        imageUrl = "/lux/images/drechtsteden/business-parks/antoniapolder.png",
        pageComponent = { AntoniapolderPage() }
    )
val bakestein =
    DrechtstedenTwinModel(
        projectPath = "/bakestein",
        label = LocalizedText(nl = "Energy Twin Bakestein"),
        entryPoint = "drechtsteden/businessparks/bakestein",
        modelId = Uuid.parse("19fcb3e6-bfaa-4f22-81b3-701b36456acc"),
        imageUrl = "/lux/images/drechtsteden/business-parks/bakestein.png",
        pageComponent = { BakesteinPage() }
    )
val deGeer =
    DrechtstedenTwinModel(
        projectPath = "/degeer",
        label = LocalizedText(nl = "Energy Twin De Geer"),
        entryPoint = "drechtsteden/businessparks/degeer",
        modelId = Uuid.parse("f8ceaf4d-5d2e-48e6-8b7e-e95874c0d1a3"),
        imageUrl = "/lux/images/drechtsteden/business-parks/de_geer.png",
        pageComponent = { DeGeerPage() }
    )
val deStaart =
    DrechtstedenTwinModel(
        projectPath = "/destaart",
        label = LocalizedText(nl = "Energy Twin De Staart"),
        entryPoint = "drechtsteden/businessparks/destaart",
        modelId = Uuid.parse("b2275ee1-18bb-46d8-9e40-5b45b0295b33"),
        imageUrl = "/lux/images/drechtsteden/business-parks/de-staart.jpg",
        pageComponent = { DeStaartPage() }
    )
val dordtseKil12AmstelwijckWest =
    DrechtstedenTwinModel(
        projectPath = "/dordtsekil12amstelwijckwest",
        label = LocalizedText(nl = "Energy Twin Dordtse Kil I & II en Amstelwijck West"),
        entryPoint = "drechtsteden/businessparks/dordtseamstelwijck",
        modelId = Uuid.parse("1e473aa2-0581-4584-82cd-1b2d0507d274"),
        imageUrl = "/lux/images/drechtsteden/business-parks/dordtsekil12enAmstelwijckWest_foto.png",
        pageComponent = { DordtseKilIPage() }
    )
val dordtseKil34 =
    DrechtstedenTwinModel(
        projectPath = "/dordtsekil34",
        label = LocalizedText(nl = "Energy Twin Dordtse Kil III & IV"),
        entryPoint = "drechtsteden/businessparks/dordtse",
        modelId = Uuid.parse("2f9547eb-e123-4f92-9351-85f739a27ae8"),
        imageUrl = "/lux/images/drechtsteden/business-parks/dordtsekil34.png",
        pageComponent = { DordtseKilIIIPage() }
    )
val grooteLindtV2 =
    DrechtstedenTwinModel(
        projectPath = "/grootelindtv2",
        label = LocalizedText(nl = "Energy Twin Groote Lindt v2"),
        entryPoint = "drechtsteden/businessparks/groote",
        modelId = Uuid.parse("96a551f4-8e56-4fc5-8b5c-babfddf92ac4"),
        imageUrl = "/lux/images/drechtsteden/business-parks/Groote-Lindt.png",
        pageComponent = { LindtPage() }
    )
val leerpark =
    DrechtstedenTwinModel(
        projectPath = "/leerpark",
        label = LocalizedText(nl = "Energy Twin Leerpark"),
        entryPoint = "drechtsteden/businessparks/leerpark",
        modelId = Uuid.parse("54711b02-60db-4336-b20a-b7ac9940b3dc"),
        imageUrl = "/lux/images/drechtsteden/business-parks/Leerpark_foto.png",
        pageComponent = { LeerparkPage() }
    )
val nieuweWeg =
    DrechtstedenTwinModel(
        projectPath = "/nieuweweg",
        label = LocalizedText(nl = "Energy Twin Nieuwe Weg"),
        entryPoint = "drechtsteden/businessparks/nieuweweg",
        modelId = Uuid.parse("57f0e77f-b609-4487-badc-9167e53f6a24"),
        imageUrl = "/lux/images/drechtsteden/business-parks/FeaturedImageNieuweWegPagina.png",
        pageComponent = { NieuweWegPage() }
    )
val papendrechtOosteind =
    DrechtstedenTwinModel(
        projectPath = "/papendrechtoosteind",
        label = LocalizedText(nl = "Energy Twin Papendrecht Oosteind"),
        entryPoint = "drechtsteden/businessparks/papendrechtoosteind",
        modelId = Uuid.parse("0ef34b9d-4887-451c-bb51-2d991b8f07ff"),
        imageUrl = "/lux/images/drechtsteden/business-parks/papendrecht_oosteind.png",
        pageComponent = { PapendrechtPage() }
    )
val sliedrechtBusinesspark =
    DrechtstedenTwinModel(
        projectPath = "/sliedrechtbusinesspark",
        label = LocalizedText(nl = "Energy Twin Sliedrecht"),
        entryPoint = "drechtsteden/businessparks/sliedrecht",
        modelId = Uuid.parse("51df1e41-81ed-48a3-af5c-631a74f5cabf"),
        imageUrl = "/lux/images/drechtsteden/business-parks/FeaturedImageSliedrechtPagina.png",
        pageComponent = { SliedrechtPage() }
    )


val drechtstedenBusinessParkModels = listOf(
    ambachtseZoom,
    amstelwijckBusinesspark,
    antoniapolder,
    bakestein,
    deGeer,
    deStaart,
    dordtseKil12AmstelwijckWest,
    dordtseKil34,
    grooteLindtV2,
    leerpark,
    nieuweWeg,
    papendrechtOosteind,
    sliedrechtBusinesspark
)