package com.zenmo.web.zenmo.domains.lux.components.model

//  SUBDOMAIN MODELS
sealed class SubdomainModel(
    title: String,
    image: String,
    entryPoint: String = "",
    val isPrivate: Boolean,
) : TwinModel(title, entryPoint, image) {
    override fun url(path: String, protocol: String, luxDomain: String): String {
        return "${protocol}//${title.lowercase()}.$luxDomain"
    }

    data object Drechtsteden : SubdomainModel(
        "drechtsteden",
        "/img/drechtsteden-rivier.jpg",
        "drechtsteden",
        isPrivate = true
    )

    data object Genius : SubdomainModel(
        "genius",
        "/lux/images/models/genius.png",
        "genius",
        isPrivate = true
    )

    data object Hessenpoort : SubdomainModel(
        "hessenpoort",
        "/lux/images/models/hessenpoort.png",
        "hessenpoort",
        isPrivate = true
    )

    data object KasAlsEnergiebron : SubdomainModel(
        "kasalsenergiebron",
        "/lux/images/models/kasals.png",
        "kasalsenergiebron",
        isPrivate = true
    )

    data object Brabant : SubdomainModel(
        "brabant",
        "/lux/images/models/brabant.png",
        isPrivate = false
    )

    data object Nederland : SubdomainModel(
        "nederland",
        "/lux/images/models/nederland.png",
        isPrivate = false
    )


    data object Hilversum : SubdomainModel(
        "hilversum",
        "/lux/images/models/hilversum.png",
        isPrivate = false
    )

    data object Bunderbuurten : SubdomainModel(
        "bunderbuurten",
        "/lux/images/models/bunderbuurten.png",
        isPrivate = false
    )

    data object Loenen : SubdomainModel(
        "loenen",
        "/lux/images/models/loenen.png",
        isPrivate = false
    )

    data object RotterdamDenHaag : SubdomainModel(
        "rotterdamdenhaag",
        "/lux/images/models/rotterdam.png",
        isPrivate = false
    )

    data object Vruchtenbuurt : SubdomainModel(
        "vruchtenbuurt",
        "/lux/images/models/vruchtenbuurt.png",
        isPrivate = false
    )

    data object Cognizant : SubdomainModel(
        "cognizant",
        "/lux/images/models/cognizant.png",
        isPrivate = false
    )

    data object PreZero : SubdomainModel(
        "prezero",
        "/lux/images/models/prezero.png",
        "prezero",
        isPrivate = true
    )

    companion object {
        val allModels = listOf(
            Drechtsteden,
            Genius,
            Brabant,
            Nederland,
            Hessenpoort,
            KasAlsEnergiebron,
            Hilversum,
            Bunderbuurten,
            Loenen,
            RotterdamDenHaag,
            Vruchtenbuurt,
            Cognizant,
            PreZero,
        )
        val publicSubdomains = allModels.filter { !it.isPrivate }
        val privateSubdomains = allModels.filter { it.isPrivate }
    }
}