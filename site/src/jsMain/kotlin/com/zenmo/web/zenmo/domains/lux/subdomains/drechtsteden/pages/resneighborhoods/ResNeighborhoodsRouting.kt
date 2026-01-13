package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.resneighborhoods

import com.varabyte.kobweb.core.init.InitKobwebContext
import com.zenmo.web.zenmo.domains.lux.components.model.DrechtstedenResNeighborhood


fun resNeighborhoodsRouting(
    ctx: InitKobwebContext,
    basePath: String,
) {
    with(ctx.router) {
        register("$basePath/${DrechtstedenResNeighborhood.Oostdonk.name}") { Oostdonk() }
        register("$basePath/${DrechtstedenResNeighborhood.OverTSpoor.name}") { OverTSpoor() }
        register("$basePath/${DrechtstedenResNeighborhood.Kerkbuurt.name}") { Kerkbuurt() }
    }
}