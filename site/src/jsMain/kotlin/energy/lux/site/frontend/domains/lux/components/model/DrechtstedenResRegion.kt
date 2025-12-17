package energy.lux.site.frontend.domains.lux.components.model

sealed class DrechtstedenResRegion(
    name: String,
    title: String,
    entryPoint: String,
    image: String,
) : DrechtstedenTwinModel(name, title, entryPoint, image) {

    data object DrechtstedenRes : DrechtstedenTwinModel(
        "drechtstedenres",
        "Digital twin Drechtsteden",
        "drechtsteden/resregion/drechtsteden",
        "/lux/images/drechtsteden/res-region/drechtsteden.png"
    )

    companion object {
        val models = listOf(
            DrechtstedenRes,
        )
    }
}