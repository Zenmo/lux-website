package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.municipalities

import com.varabyte.kobweb.core.init.InitKobwebContext
import com.zenmo.web.zenmo.domains.lux.components.model.DrechtstedenMunicipality


fun municipalitiesRouting(
    ctx: InitKobwebContext,
    basePath: String,
) {
    with(ctx.router) {
        register("$basePath/${DrechtstedenMunicipality.Alblasserdam.name}") {
            GemeenteAlblasserdamPage()
        }
        register("$basePath/${DrechtstedenMunicipality.Hardinxveld.name}") {
            HardinxveldPage()
        }
        register("$basePath/${DrechtstedenMunicipality.SliedrechtMunicipality.name}") {
            GemeenteSliedrechtPage()
        }
        register("$basePath/${DrechtstedenMunicipality.Dordrecht.name}") { Dordrecht() }
        register("$basePath/${DrechtstedenMunicipality.Papendrecht.name}") { Papendrecht() }
        register("$basePath/${DrechtstedenMunicipality.Zwijndrecht.name}") { Zwijndrecht() }
        register("$basePath/${DrechtstedenMunicipality.HendrikIdoAmbacht.name}") { HendrikIdoAmbacht() }
    }
}