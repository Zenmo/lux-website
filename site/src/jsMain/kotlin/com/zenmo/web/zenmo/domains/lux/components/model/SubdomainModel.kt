package com.zenmo.web.zenmo.domains.lux.components.model

import com.zenmo.web.zenmo.domains.lux.sections.application_fields.ApplicationArea

//  SUBDOMAIN MODELS
sealed class SubdomainModel(
    title: String,
    image: String,
    entryPoint: String = "",
    isPrivate: Boolean,
    val applicationArea: ApplicationArea,
) : TwinModel(title, entryPoint, image, isPrivate) {
    override fun url(path: String, protocol: String, luxDomain: String): String {
        return "${protocol}//${title.lowercase()}.$luxDomain"
    }

    data object Drechtsteden : SubdomainModel(
        "drechtsteden",
        "/img/drechtsteden-rivier.jpg",
        "drechtsteden",
        isPrivate = true,
        applicationArea = ApplicationArea.LUX_REGION
    )

    data object Empowered : SubdomainModel(
        "EmPowerEd",
        image = "",
        isPrivate = false,
        applicationArea = ApplicationArea.LUX_REGION,
    )

    data object Genius : SubdomainModel(
        "genius",
        "/lux/images/models/genius.png",
        "genius",
        isPrivate = true,
        applicationArea = ApplicationArea.LUX_ENERGY_HUB
    )

    data object Hessenpoort : SubdomainModel(
        "hessenpoort",
        "/lux/images/models/hessenpoort.png",
        "hessenpoort",
        isPrivate = true,
        applicationArea = ApplicationArea.LUX_ENERGY_HUB
    )

    data object KasAlsEnergiebron : SubdomainModel(
        "kasalsenergiebron",
        "/lux/images/models/kasals.png",
        "kasalsenergiebron",
        isPrivate = true,
        applicationArea = ApplicationArea.LUX_ENERGY_HUB
    )

    data object Brabant : SubdomainModel(
        "brabant",
        "/lux/images/models/brabant.png",
        isPrivate = false,
        applicationArea = ApplicationArea.LUX_REGION
    )

    data object Nederland : SubdomainModel(
        "nederland",
        "/lux/images/models/nederland.png",
        isPrivate = false,
        applicationArea = ApplicationArea.LUX_REGION
    )


    data object Hilversum : SubdomainModel(
        "hilversum",
        "/lux/images/models/hilversum.png",
        isPrivate = false,
        applicationArea = ApplicationArea.LUX_REGION //todo confirm ApplicationField
    )

    data object Bunderbuurten : SubdomainModel(
        "bunderbuurten",
        "/lux/images/models/bunderbuurten.png",
        isPrivate = false,
        applicationArea = ApplicationArea.LUX_RESIDENTIAL_AREA
    )

    data object Loenen : SubdomainModel(
        "loenen",
        "/lux/images/models/loenen.png",
        isPrivate = false,
        applicationArea = ApplicationArea.LUX_RESIDENTIAL_AREA
    )

    data object RotterdamDenHaag : SubdomainModel(
        "rotterdamdenhaag",
        "/lux/images/models/rotterdam.png",
        isPrivate = false,
        applicationArea = ApplicationArea.LUX_REGION
    )

    data object Vruchtenbuurt : SubdomainModel(
        "vruchtenbuurt",
        "/lux/images/models/vruchtenbuurt.png",
        isPrivate = false,
        applicationArea = ApplicationArea.LUX_RESIDENTIAL_AREA
    )

    data object Kronenberg : SubdomainModel(
        "kronenberg",
        "/lux/images/kronenberg/Skyline-Kronenberg-Jan-Janssen-square.jpg",
        isPrivate = false,
        applicationArea = ApplicationArea.LUX_RESIDENTIAL_AREA
    )

    data object Cognizant : SubdomainModel(
        "cognizant",
        "/lux/images/models/cognizant.png",
        isPrivate = false,
        applicationArea = ApplicationArea.LUX_COMPANY
    )

    data object PreZero : SubdomainModel(
        "prezero",
        "/lux/images/models/prezero.png",
        "prezero",
        isPrivate = true,
        applicationArea = ApplicationArea.LUX_COMPANY
    )

    data object Amersfoort : SubdomainModel(
        "amersfoort",
        "/lux/images/models/amersfoort.jpg",
        isPrivate = false,
        applicationArea = ApplicationArea.LUX_RESIDENTIAL_AREA
    )

    data object Borchwerf : SubdomainModel(
        "borchwerf",
        "/lux/images/models/borchwerf.png",
        "borchwerf",
        isPrivate = true,
        applicationArea = ApplicationArea.LUX_RESIDENTIAL_AREA
    )

    data object Veenendaal : SubdomainModel(
        "veenendaal",
        "/lux/images/models/veenendaal.jpg",
        isPrivate = false,
        applicationArea = ApplicationArea.LUX_RESIDENTIAL_AREA
    )

    companion object {
        val allModels = listOf(
            Drechtsteden,
            Empowered,
            Genius,
            Brabant,
            Nederland,
            Hessenpoort,
            KasAlsEnergiebron,
            Kronenberg,
            Hilversum,
            Bunderbuurten,
            Loenen,
            RotterdamDenHaag,
            Vruchtenbuurt,
            Cognizant,
            PreZero,
            Amersfoort,
            Borchwerf,
            Veenendaal,
        )
        val publicSubdomains = allModels.filter { !it.isPrivate }
        val privateSubdomains = allModels.filter { it.isPrivate }
    }
}
