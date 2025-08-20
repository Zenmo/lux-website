package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.businessparks

import com.varabyte.kobweb.core.init.InitKobwebContext
import com.zenmo.web.zenmo.domains.lux.components.model.DrechtstedenTwinModel


fun businessParksRouting(
    ctx: InitKobwebContext
) {
    val path = "/business-parks"
    with(ctx.router) {
        register("$path/${DrechtstedenTwinModel.AmbachtseZoom.name}") { AmbachtsePage() }
        register("$path/${DrechtstedenTwinModel.AmstelwijckBusinesspark.name}") { AmstelwijckPage() }
        register("$path/${DrechtstedenTwinModel.Antoniapolder.name}") { AntoniapolderPage() }
        register("$path/${DrechtstedenTwinModel.Bakestein.name}") { BakesteinPage() }
        register("$path/${DrechtstedenTwinModel.DeGeer.name}") { DeGeerPage() }
        register("$path/${DrechtstedenTwinModel.DeStaart.name}") { DeStaartPage() }
        register("$path/${DrechtstedenTwinModel.DordtseKil12AmstelwijckWest.name}") { DordtseKilIPage() }
        register("$path/${DrechtstedenTwinModel.DordtseKil34.name}") { DordtseKilIIIPage() }
        register("$path/${DrechtstedenTwinModel.GrooteLindtV2.name}") { LindtPage() }
        register("$path/${DrechtstedenTwinModel.Leerpark.name}") { LeerparkPage() }
        register("$path/${DrechtstedenTwinModel.NieuweWeg.name}") { NieuweWegPage() }
        register("$path/${DrechtstedenTwinModel.PapendrechtOosteind.name}") { PapendrechtPage() }
        register("$path/${DrechtstedenTwinModel.SliedrechtBusinesspark.name}") { SliedrechtPage() }
    }

}