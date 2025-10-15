package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.municipalities

import com.varabyte.kobweb.core.init.InitKobwebContext
import com.zenmo.web.zenmo.domains.lux.components.model.DrechtstedenTwinModel


fun municipalitiesRouting(
    ctx: InitKobwebContext,
) {
    val path = "/business-parks"
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
        register("$path/${DrechtstedenTwinModel.Dordrecht.name}") { Dordrecht() }
        register("$path/${DrechtstedenTwinModel.Papendrecht.name}") { Papendrecht() }
        register("$path/${DrechtstedenTwinModel.Zwijndrecht.name}") { Zwijndrecht() }
        register("$path/${DrechtstedenTwinModel.HendrikIdoAmbacht.name}") { HendrikIdoAmbacht() }
    }
}