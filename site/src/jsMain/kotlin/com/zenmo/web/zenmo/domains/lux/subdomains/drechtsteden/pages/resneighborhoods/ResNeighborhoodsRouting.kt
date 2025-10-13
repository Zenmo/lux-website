package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.resneighborhoods

import com.varabyte.kobweb.core.init.InitKobwebContext
import com.zenmo.web.zenmo.domains.lux.components.model.DrechtstedenTwinModel


fun resNeighborhoodsRouting(
    ctx: InitKobwebContext,
) {
    val path = "/res-neighborhoods"
    with(ctx.router) {
        register("$path/${DrechtstedenTwinModel.Oostdonk.name}") { Oostdonk() }
        register("$path/${DrechtstedenTwinModel.OverTSpoor.name}") { OverTSpoor() }
    }
}