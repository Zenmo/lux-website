package energy.lux.frontend.domains.lux.core

import com.varabyte.kobweb.navigation.Router
import energy.lux.frontend.components.widgets.CatchAllPage
import energy.lux.frontend.core.services.localization.addHreflangInterceptor

fun createLuxRouter(init: Router.() -> Unit): Router = Router()
    .also {
        it.registerLuxCatchAllPage()
        it.addHreflangInterceptor()
        it.init()
    }

fun Router.registerLuxCatchAllPage() {
    this.register("/{...catch-all}") { CatchAllPage() }
}
