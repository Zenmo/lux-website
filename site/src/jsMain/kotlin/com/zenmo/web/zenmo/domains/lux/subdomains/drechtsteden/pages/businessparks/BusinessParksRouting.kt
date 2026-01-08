package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.businessparks

import com.varabyte.kobweb.core.init.InitKobwebContext
import com.zenmo.web.zenmo.domains.lux.components.model.DrechtstedenBusinessPark


fun businessParksRouting(
    ctx: InitKobwebContext,
    basePath: String,
) {
    with(ctx.router) {
        register("$basePath/${DrechtstedenBusinessPark.AmbachtseZoom.name}") { AmbachtsePage() }
        register("$basePath/${DrechtstedenBusinessPark.AmstelwijckBusinesspark.name}") { AmstelwijckPage() }
        register("$basePath/${DrechtstedenBusinessPark.Antoniapolder.name}") { AntoniapolderPage() }
        register("$basePath/${DrechtstedenBusinessPark.Bakestein.name}") { BakesteinPage() }
        register("$basePath/${DrechtstedenBusinessPark.DeGeer.name}") { DeGeerPage() }
        register("$basePath/${DrechtstedenBusinessPark.DeStaart.name}") { DeStaartPage() }
        register("$basePath/${DrechtstedenBusinessPark.DordtseKil12AmstelwijckWest.name}") { DordtseKilIPage() }
        register("$basePath/${DrechtstedenBusinessPark.DordtseKil34.name}") { DordtseKilIIIPage() }
        register("$basePath/${DrechtstedenBusinessPark.GrooteLindtV2.name}") { LindtPage() }
        register("$basePath/${DrechtstedenBusinessPark.Leerpark.name}") { LeerparkPage() }
        register("$basePath/${DrechtstedenBusinessPark.NieuweWeg.name}") { NieuweWegPage() }
        register("$basePath/${DrechtstedenBusinessPark.PapendrechtOosteind.name}") { PapendrechtPage() }
        register("$basePath/${DrechtstedenBusinessPark.SliedrechtBusinesspark.name}") { SliedrechtPage() }
    }

}