package com.zenmo.web.zenmo.domains.lux.components.model

sealed class DrechtstedenResNeighborhood(
    name: String,
    title: String,
    entryPoint: String,
    image: String,
) : DrechtstedenTwinModel(name, title, entryPoint, image) {

    data object OverTSpoor : DrechtstedenTwinModel(
        "overtspoor",
        "Digital twin Over 't Spoor",
        "drechtsteden/resneighborhoods/overtspoor",
        "/lux/images/drechtsteden/resneighborhoods/over_t_spoor.png"
    )

    data object Oostdonk : DrechtstedenTwinModel(
        "oostdonk",
        "Digital twin Oostdonk",
        "drechtsteden/resneighborhoods/oostdonk",
        "/lux/images/drechtsteden/resneighborhoods/oostdonk.png"
    )

    data object Kerkbuurt : DrechtstedenTwinModel(
        "kerkbuurt",
        "Digital twin Kerkbuurt",
        "drechtsteden/resneighborhoods/kerkbuurt",
        "/lux/images/drechtsteden/resneighborhoods/kerkbuurt.png"
    )

    companion object {
        val models = listOf(
            OverTSpoor,
            Oostdonk,
            Kerkbuurt
        )
    }
}