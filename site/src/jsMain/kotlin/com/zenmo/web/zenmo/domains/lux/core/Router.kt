package com.zenmo.web.zenmo.domains.lux.core

import com.varabyte.kobweb.navigation.Router
import com.zenmo.web.zenmo.components.widgets.CatchAllPage
import com.zenmo.web.zenmo.core.services.localization.addHreflangInterceptor

fun createLuxRouter(init: Router.() -> Unit): Router = Router()
    .also {
        it.registerLuxCatchAllPage()
        it.addHreflangInterceptor()
        it.init()
    }

fun Router.registerLuxCatchAllPage() {
    this.register("/{...catch-all}") { CatchAllPage() }
}
