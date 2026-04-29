package energy.lux.frontend.core.models

data class StaticRoute(
    override val pageComponent: PageComponent,
    override val path: String
) : Route