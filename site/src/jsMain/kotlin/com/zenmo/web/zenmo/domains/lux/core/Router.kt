package com.zenmo.web.zenmo.domains.lux.core

import com.varabyte.kobweb.navigation.Router
import com.zenmo.web.zenmo.components.widgets.CatchAllPage

fun createLuxRouter(): Router = Router()
    .also { it.registerLuxCatchAllPage() }

fun Router.registerLuxCatchAllPage() {
    this.register("/{...catch-all}") { CatchAllPage() }
}
