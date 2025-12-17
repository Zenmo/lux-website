package energy.lux.site.frontend.domains.lux.subdomains.drechtsteden.pages.resneighborhoods

import com.varabyte.kobweb.core.init.InitKobwebContext
import com.zenmo.web.zenmo.domains.lux.components.model.DrechtstedenResNeighborhood


fun resNeighborhoodsRouting(
    ctx: InitKobwebContext,
) {
    val path = "/res-neighborhoods"
    with(ctx.router) {
        register("$path/${DrechtstedenResNeighborhood.Oostdonk.name}") { Oostdonk() }
        register("$path/${DrechtstedenResNeighborhood.OverTSpoor.name}") { OverTSpoor() }
        register("$path/${DrechtstedenResNeighborhood.Kerkbuurt.name}") { Kerkbuurt() }
    }
}