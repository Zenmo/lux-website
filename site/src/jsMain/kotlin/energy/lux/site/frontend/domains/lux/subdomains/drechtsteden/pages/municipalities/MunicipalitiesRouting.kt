package energy.lux.site.frontend.domains.lux.subdomains.drechtsteden.pages.municipalities

import com.varabyte.kobweb.core.init.InitKobwebContext
import com.zenmo.web.zenmo.domains.lux.components.model.DrechtstedenMunicipality


fun municipalitiesRouting(
    ctx: InitKobwebContext,
) {
    val path = "/business-parks"
    with(ctx.router) {
        register("$path/${DrechtstedenMunicipality.Alblasserdam.name}") {
            GemeenteAlblasserdamPage()
        }
        register("$path/${DrechtstedenMunicipality.Hardinxveld.name}") {
            HardinxveldPage()
        }
        register("$path/${DrechtstedenMunicipality.SliedrechtMunicipality.name}") {
            GemeenteSliedrechtPage()
        }
        register("$path/${DrechtstedenMunicipality.Dordrecht.name}") { Dordrecht() }
        register("$path/${DrechtstedenMunicipality.Papendrecht.name}") { Papendrecht() }
        register("$path/${DrechtstedenMunicipality.Zwijndrecht.name}") { Zwijndrecht() }
        register("$path/${DrechtstedenMunicipality.HendrikIdoAmbacht.name}") { HendrikIdoAmbacht() }
    }
}