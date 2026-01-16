package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.businessparks

import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.DrechtstedenProjectArea
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.DrechtstedenTwinModel

val ambachtseZoom = DrechtstedenTwinModel(
    path = "ambachtsezoom",
    label = LocalizedText(nl = "Digital twin Ambachtse Zoom"),
    applicationArea = DrechtstedenProjectArea.BUSINESS_PARKS,
    entryPoint = "drechtsteden/businessparks/ambachtse",
    imageUrl = "/lux/images/drechtsteden/business-parks/ambachtsezoom.png",
    pageComponent = { AmbachtsePage() }
)
val amstelwijckBusinesspark = DrechtstedenTwinModel(
    path = "amstelwijckbusinesspark",
    label = LocalizedText(nl = "Digital twin Amstelwijck Businesspark"),
    applicationArea = DrechtstedenProjectArea.BUSINESS_PARKS,
    entryPoint = "drechtsteden/businessparks/amstelwijck",
    imageUrl = "/lux/images/drechtsteden/business-parks/Amstelwijck_businesspark_foto.png",
    pageComponent = { AmstelwijckPage() }
)
val antoniapolder = DrechtstedenTwinModel(
    path = "antoniapolder",
    label = LocalizedText(nl = "Digital twin Antoniapolder"),
    applicationArea = DrechtstedenProjectArea.BUSINESS_PARKS,
    entryPoint = "drechtsteden/businessparks/antoniapolder",
    imageUrl = "/lux/images/drechtsteden/business-parks/antoniapolder.png",
    pageComponent = { AntoniapolderPage() }
)
val bakestein = DrechtstedenTwinModel(
    path = "bakestein",
    label = LocalizedText(nl = "Digital twin Bakestein"),
    applicationArea = DrechtstedenProjectArea.BUSINESS_PARKS,
    entryPoint = "drechtsteden/businessparks/bakestein",
    imageUrl = "/lux/images/drechtsteden/business-parks/bakestein.png",
    pageComponent = { BakesteinPage() }
)
val deGeer = DrechtstedenTwinModel(
    path = "degeer",
    label = LocalizedText(nl = "Digital twin De Geer"),
    applicationArea = DrechtstedenProjectArea.BUSINESS_PARKS,
    entryPoint = "drechtsteden/businessparks/degeer",
    imageUrl = "/lux/images/drechtsteden/business-parks/de_geer.png",
    pageComponent = { DeGeerPage() }
)
val deStaart = DrechtstedenTwinModel(
    path = "destaart",
    label = LocalizedText(nl = "Digital twin De Staart"),
    applicationArea = DrechtstedenProjectArea.BUSINESS_PARKS,
    entryPoint = "drechtsteden/businessparks/destaart",
    imageUrl = "/lux/images/drechtsteden/business-parks/de-staart.jpg",
    pageComponent = { DeStaartPage() }
)
val dordtseKil12AmstelwijckWest = DrechtstedenTwinModel(
    path = "dordtsekil12amstelwijckwest",
    label = LocalizedText(nl = "Digital twin Dordtse Kil I & II en Amstelwijck West"),
    applicationArea = DrechtstedenProjectArea.BUSINESS_PARKS,
    entryPoint = "drechtsteden/businessparks/dordtseamstelwijck",
    imageUrl = "/lux/images/drechtsteden/business-parks/dordtsekil12enAmstelwijckWest_foto.png",
    pageComponent = { DordtseKilIPage() }
)
val dordtseKil34 = DrechtstedenTwinModel(
    path = "dordtsekil34",
    label = LocalizedText(nl = "Digital twin Dordtse Kil III & IV"),
    applicationArea = DrechtstedenProjectArea.BUSINESS_PARKS,
    entryPoint = "drechtsteden/businessparks/dordtse",
    imageUrl = "/lux/images/drechtsteden/business-parks/dordtsekil34.png",
    pageComponent = { DordtseKilIIIPage() }
)
val grooteLindtV2 = DrechtstedenTwinModel(
    path = "grootelindtv2",
    label = LocalizedText(nl = "Digital twin Groote Lindt v2"),
    applicationArea = DrechtstedenProjectArea.BUSINESS_PARKS,
    entryPoint = "drechtsteden/businessparks/groote",
    imageUrl = "/lux/images/drechtsteden/business-parks/Groote-Lindt.png",
    pageComponent = { LindtPage() }
)
val leerpark = DrechtstedenTwinModel(
    path = "leerpark",
    label = LocalizedText(nl = "Digital twin Leerpark"),
    applicationArea = DrechtstedenProjectArea.BUSINESS_PARKS,
    entryPoint = "drechtsteden/businessparks/leerpark",
    imageUrl = "/lux/images/drechtsteden/business-parks/Leerpark_foto.png",
    pageComponent = { LeerparkPage() }
)
val nieuweWeg = DrechtstedenTwinModel(
    path = "nieuweweg",
    label = LocalizedText(nl = "Digital twin Nieuwe Weg"),
    applicationArea = DrechtstedenProjectArea.BUSINESS_PARKS,
    entryPoint = "drechtsteden/businessparks/nieuweweg",
    imageUrl = "/lux/images/drechtsteden/business-parks/FeaturedImageNieuweWegPagina.png",
    pageComponent = { NieuweWegPage() }
)
val papendrechtOosteind = DrechtstedenTwinModel(
    path = "papendrechtoosteind",
    label = LocalizedText(nl = "Digital twin Papendrecht Oosteind"),
    applicationArea = DrechtstedenProjectArea.BUSINESS_PARKS,
    entryPoint = "drechtsteden/businessparks/papendrechtoosteind",
    imageUrl = "/lux/images/drechtsteden/business-parks/papendrecht_oosteind.png",
    pageComponent = { PapendrechtPage() }
)
val sliedrechtBusinesspark = DrechtstedenTwinModel(
    path = "sliedrechtbusinesspark",
    label = LocalizedText(nl = "Digital twin Sliedrecht"),
    applicationArea = DrechtstedenProjectArea.BUSINESS_PARKS,
    entryPoint = "drechtsteden/businessparks/sliedrecht",
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