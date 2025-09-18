package com.zenmo.web.zenmo.domains.lux.components.model

import com.zenmo.web.zenmo.domains.lux.sections.application_fields.ApplicationField

//  SUBDOMAIN MODELS
sealed class SubdomainModel(
    title: String,
    image: String,
    entryPoint: String = "",
    val isPrivate: Boolean,
    val applicationField: ApplicationField,
) : TwinModel(title, entryPoint, image) {
    override fun url(path: String, protocol: String, luxDomain: String): String {
        return "${protocol}//${title.lowercase()}.$luxDomain"
    }

    data object Drechtsteden : SubdomainModel(
        "drechtsteden",
        "/img/drechtsteden-rivier.jpg",
        "drechtsteden",
        isPrivate = true,
        applicationField = ApplicationField.LUX_REGION
    )

    data object Genius : SubdomainModel(
        "genius",
        "/lux/images/models/genius.png",
        "genius",
        isPrivate = true,
        applicationField = ApplicationField.LUX_ENERGY_HUB
    )

    data object Hessenpoort : SubdomainModel(
        "hessenpoort",
        "/lux/images/models/hessenpoort.png",
        "hessenpoort",
        isPrivate = true,
        applicationField = ApplicationField.LUX_ENERGY_HUB
    )

    data object KasAlsEnergiebron : SubdomainModel(
        "kasalsenergiebron",
        "/lux/images/models/kasals.png",
        "kasalsenergiebron",
        isPrivate = true,
        applicationField = ApplicationField.LUX_ENERGY_HUB
    )

    data object Brabant : SubdomainModel(
        "brabant",
        "/lux/images/models/brabant.png",
        isPrivate = false,
        applicationField = ApplicationField.LUX_REGION
    )

    data object Nederland : SubdomainModel(
        "nederland",
        "/lux/images/models/nederland.png",
        isPrivate = false,
        applicationField = ApplicationField.LUX_REGION
    )


    data object Hilversum : SubdomainModel(
        "hilversum",
        "/lux/images/models/hilversum.png",
        isPrivate = false,
        applicationField = ApplicationField.LUX_REGION //todo confirm ApplicationField
    )

    data object Bunderbuurten : SubdomainModel(
        "bunderbuurten",
        "/lux/images/models/bunderbuurten.png",
        isPrivate = false,
        applicationField = ApplicationField.LUX_RESIDENTIAL_AREA
    )

    data object Loenen : SubdomainModel(
        "loenen",
        "/lux/images/models/loenen.png",
        isPrivate = false,
        applicationField = ApplicationField.LUX_RESIDENTIAL_AREA
    )

    data object RotterdamDenHaag : SubdomainModel(
        "rotterdamdenhaag",
        "/lux/images/models/rotterdam.png",
        isPrivate = false,
        applicationField = ApplicationField.LUX_REGION //todo confirm ApplicationField
    )

    data object Vruchtenbuurt : SubdomainModel(
        "vruchtenbuurt",
        "/lux/images/models/vruchtenbuurt.png",
        isPrivate = false,
        applicationField = ApplicationField.LUX_RESIDENTIAL_AREA
    )

    data object Cognizant : SubdomainModel(
        "cognizant",
        "/lux/images/models/cognizant.png",
        isPrivate = false,
        applicationField = ApplicationField.LUX_COMPANY
    )

    data object PreZero : SubdomainModel(
        "prezero",
        "/lux/images/models/prezero.png",
        "prezero",
        isPrivate = true,
        applicationField = ApplicationField.LUX_COMPANY
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