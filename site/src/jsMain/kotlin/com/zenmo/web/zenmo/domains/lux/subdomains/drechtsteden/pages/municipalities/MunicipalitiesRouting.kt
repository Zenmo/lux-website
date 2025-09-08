package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.municipalities

import com.varabyte.kobweb.core.init.InitKobwebContext
import com.zenmo.web.zenmo.domains.lux.components.model.DrechtstedenTwinModel


fun municipalitiesRouting(
    ctx: InitKobwebContext,
) {
    val path = "/municipalities"
    with(ctx.router) {
        register("$path/${DrechtstedenTwinModel.Alblasserdam.name}") {
            GemeenteAlblasserdamPage()
        }
        register("$path/${DrechtstedenTwinModel.Hardinxveld.name}") {
            HardinxveldPage()
        }
        register("$path/${DrechtstedenTwinModel.SliedrechtMunicipality.name}") {
            GemeenteSliedrechtPage()
        }
    }
}