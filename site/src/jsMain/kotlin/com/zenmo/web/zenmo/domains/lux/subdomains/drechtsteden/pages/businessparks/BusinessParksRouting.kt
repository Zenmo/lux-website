package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.businessparks

import com.varabyte.kobweb.core.init.InitKobwebContext
import com.zenmo.web.zenmo.domains.lux.components.model.DrechtstedenBusinessPark


fun businessParksRouting(
    ctx: InitKobwebContext
) {
    val path = "/business-parks"
    with(ctx.router) {
        register("$path/${DrechtstedenBusinessPark.AmbachtseZoom.name}") { AmbachtsePage() }
        register("$path/${DrechtstedenBusinessPark.AmstelwijckBusinesspark.name}") { AmstelwijckPage() }
        register("$path/${DrechtstedenBusinessPark.Antoniapolder.name}") { AntoniapolderPage() }
        register("$path/${DrechtstedenBusinessPark.Bakestein.name}") { BakesteinPage() }
        register("$path/${DrechtstedenBusinessPark.DeGeer.name}") { DeGeerPage() }
        register("$path/${DrechtstedenBusinessPark.DeStaart.name}") { DeStaartPage() }
        register("$path/${DrechtstedenBusinessPark.DordtseKil12AmstelwijckWest.name}") { DordtseKilIPage() }
        register("$path/${DrechtstedenBusinessPark.DordtseKil34.name}") { DordtseKilIIIPage() }
        register("$path/${DrechtstedenBusinessPark.GrooteLindtV2.name}") { LindtPage() }
        register("$path/${DrechtstedenBusinessPark.Leerpark.name}") { LeerparkPage() }
        register("$path/${DrechtstedenBusinessPark.NieuweWeg.name}") { NieuweWegPage() }
        register("$path/${DrechtstedenBusinessPark.PapendrechtOosteind.name}") { PapendrechtPage() }
        register("$path/${DrechtstedenBusinessPark.SliedrechtBusinesspark.name}") { SliedrechtPage() }
    }

}