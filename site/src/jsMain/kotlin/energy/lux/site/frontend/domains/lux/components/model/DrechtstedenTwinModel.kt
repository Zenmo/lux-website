package energy.lux.site.frontend.domains.lux.components.model

sealed class DrechtstedenTwinModel(
    val name: String,
    title: String,
    entryPoint: String,
    image: String,
) : TwinModel(
    title,
    entryPoint,
    image,
    isPrivate = true // all Drechtsteden models are private
) {

    override fun url(path: String, protocol: String, luxDomain: String): String {
        val drechtstedenBase = "${protocol}//${SubdomainModel.Drechtsteden.title}.$luxDomain/$path"
        return "$drechtstedenBase/${name}"
    }
}

