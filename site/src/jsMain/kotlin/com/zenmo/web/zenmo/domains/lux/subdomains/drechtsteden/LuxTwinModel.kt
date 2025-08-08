package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden


sealed class LuxTwinModel(
    val title: String,
    val entryPoint: String?,
    val image: String
) {
    /**
     * a default URL builder that can be used to generate URLs for the models.
     * can be overridden in subclasses if the routing differs
     */
    open fun url(path: String, protocol: String, luxDomain: String): String {
        val drechtstedenBase = "${protocol}//${SubdomainModel.Drechtsteden.title}.$luxDomain/$path"
        return "$drechtstedenBase/${title.lowercase()}"
    }

    // RES REGION MODELS
    sealed class ResRegionModel(title: String, entryPoint: String, image: String) :
        LuxTwinModel(title, entryPoint, image) {
        data object Pmiek : ResRegionModel(
            "Digital twin Drechtsteden - PMIEK",
            "drechtsteden/resregion/pmiek",
            "/lux/images/drechtsteden/res-region/pmiek.png"
        )

        data object Warmtetransitie : ResRegionModel(
            "Digital twin Drechtsteden - Warmtetransitie",
            "drechtsteden/resregion/warmtetransitie",
            "/lux/images/drechtsteden/res-region/warmtetransitie.png"
        )

        data object DrechtstedenRes : ResRegionModel(
            "Digital twin Drechtsteden",
            "drechtsteden/resregion/drechtsteden",
            "/lux/images/drechtsteden/res-region/drechtsteden.png"
        )
    }

    //  MUNICIPAL REGION MODELS
    sealed class MunicipalRegionModel(title: String, entryPoint: String, image: String) :
        LuxTwinModel(title, entryPoint, image) {
        data object Alblasserdam : MunicipalRegionModel(
            "Digital twin Gemeente Alblasserdam",
            "drechtsteden/municipalities/alblasserdam",
            "/lux/images/drechtsteden/municipalities/Gemeente_Alblasserdam_foto.png"
        )

        data object Hardinxveld : MunicipalRegionModel(
            "Digital twin Gemeente Hardinxveld-Giessendam",
            "drechtsteden/municipalities/hardinxveld",
            "/lux/images/drechtsteden/municipalities/Gemeente_Hardinxveld-Giessendam_foto.png"
        )

        data object SliedrechtMunicipality : MunicipalRegionModel(
            "Digital twin Gemeente Sliedrecht",
            "drechtsteden/municipalities/sliedrecht",
            "/lux/images/drechtsteden/municipalities/Gemeente_Sliedrecht_foto.png"
        )
    }

    //  BUSINESS PARK MODELS
    sealed class BusinessParkModel(title: String, entryPoint: String, image: String) :
        LuxTwinModel(title, entryPoint, image) {
        data object AmbachtseZoom : BusinessParkModel(
            "Digital twin Ambachtse Zoom",
            "drechtsteden/businessparks/ambachtse",
            "/lux/images/drechtsteden/business-parks/ambachtsezoom.png"
        )

        data object AmstelwijckBusinesspark : BusinessParkModel(
            "Digital twin Amstelwijck Businesspark",
            "drechtsteden/businessparks/amstelwijck",
            "/lux/images/drechtsteden/business-parks/Amstelwijck_businesspark_foto.png"
        )

        data object Antoniapolder : BusinessParkModel(
            "Digital twin Antoniapolder",
            "drechtsteden/businessparks/antoniapolder",
            "/lux/images/drechtsteden/business-parks/antoniapolder.png"
        )

        data object Bakestein : BusinessParkModel(
            "Digital twin Bakestein",
            "drechtsteden/businessparks/bakestein",
            "/lux/images/drechtsteden/business-parks/bakestein.png"
        )

        data object DeGeer : BusinessParkModel(
            "Digital twin De Geer",
            "drechtsteden/businessparks/degeer",
            "/lux/images/drechtsteden/business-parks/de_geer.png"
        )

        data object DeStaart : BusinessParkModel(
            "Digital twin De Staart",
            "drechtsteden/businessparks/destaart",
            "/lux/images/drechtsteden/business-parks/de-staart.jpg"
        )

        data object DordtseKil12AmstelwijckWest : BusinessParkModel(
            "Digital twin Dordtse Kil I & II en Amstelwijck West",
            "drechtsteden/businessparks/dordtseamstelwijck",
            "/lux/images/drechtsteden/business-parks/dordtsekil12enAmstelwijckWest_foto.png"
        )

        data object DordtseKil34 : BusinessParkModel(
            "Digital twin Dordtse Kil III & IV",
            "drechtsteden/businessparks/dordtse",
            "/lux/images/drechtsteden/business-parks/dordtsekil34.png"
        )

        data object GrooteLindtV2 : BusinessParkModel(
            "Digital twin Groote Lindt v2",
            "drechtsteden/businessparks/groote",
            "/lux/images/drechtsteden/business-parks/Groote-Lindt.png"
        )

        data object Leerpark : BusinessParkModel(
            "Digital twin Leerpark",
            "drechtsteden/businessparks/leerpark",
            "/lux/images/drechtsteden/business-parks/Leerpark_foto.png"
        )

        data object NieuweWeg : BusinessParkModel(
            "Digital twin Nieuwe Weg",
            "drechtsteden/businessparks/nieuweweg",
            "/lux/images/drechtsteden/business-parks/FeaturedImageNieuweWegPagina.png"
        )

        data object PapendrechtOosteind : BusinessParkModel(
            "Digital twin Papendrecht Oosteind",
            "drechtsteden/businessparks/papendrecht",
            "/lux/images/drechtsteden/business-parks/papendrecht_oosteind.png"
        )

        data object SliedrechtBusinesspark : BusinessParkModel(
            "Digital twin Sliedrecht",
            "drechtsteden/businessparks/sliedrecht",
            "/lux/images/drechtsteden/business-parks/FeaturedImageSliedrechtPagina.png"
        )
    }

    //  SUBDOMAIN MODELS
    sealed class SubdomainModel(
        title: String,
        image: String,
        val isPrivate: Boolean
    ) : LuxTwinModel(title, null, image) {
        override fun url(path: String, protocol: String, luxDomain: String): String {
            return "${protocol}//${title.lowercase()}.$luxDomain"
        }

        data object Drechtsteden : SubdomainModel(
            "drechtsteden",
            "/img/drechtsteden-rivier.jpg",
            isPrivate = true
        )

        data object Genius : SubdomainModel(
            "genius",
            "/lux/images/models/genius.png",
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


        data object Hessenpoort : SubdomainModel(
            "hessenpoort",
            "/lux/images/models/hessenpoort.png",
            isPrivate = true
        )

        data object KasAlsEnergiebron : SubdomainModel(
            "kasalsenergiebron",
            "/lux/images/models/kasals.png",
            isPrivate = true
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

    }

    companion object {
        /** a flat list of all models */
        val allModels: List<LuxTwinModel> = listOf(
            ResRegionModel.Pmiek,
            ResRegionModel.Warmtetransitie,
            ResRegionModel.DrechtstedenRes,

            MunicipalRegionModel.Alblasserdam,
            MunicipalRegionModel.Hardinxveld,
            MunicipalRegionModel.SliedrechtMunicipality,

            BusinessParkModel.AmbachtseZoom,
            BusinessParkModel.AmstelwijckBusinesspark,
            BusinessParkModel.Antoniapolder,
            BusinessParkModel.Bakestein,
            BusinessParkModel.DeGeer,
            BusinessParkModel.DeStaart,
            BusinessParkModel.DordtseKil12AmstelwijckWest,
            BusinessParkModel.DordtseKil34,
            BusinessParkModel.GrooteLindtV2,
            BusinessParkModel.Leerpark,
            BusinessParkModel.NieuweWeg,
            BusinessParkModel.PapendrechtOosteind,
            BusinessParkModel.SliedrechtBusinesspark,

            SubdomainModel.Drechtsteden,
            SubdomainModel.Genius,
            SubdomainModel.Brabant,
            SubdomainModel.Nederland,
            SubdomainModel.Hessenpoort,
            SubdomainModel.KasAlsEnergiebron,
            SubdomainModel.Hilversum,
            SubdomainModel.Bunderbuurten,
            SubdomainModel.Loenen,
            SubdomainModel.RotterdamDenHaag,
            SubdomainModel.Vruchtenbuurt
        )

        // filter helpers for convenience
        val resRegionModels = allModels.filterIsInstance<ResRegionModel>()
        val municipalModels = allModels.filterIsInstance<MunicipalRegionModel>()
        val businessParkModels = allModels.filterIsInstance<BusinessParkModel>()
        val subdomainModels = allModels.filterIsInstance<SubdomainModel>()
        val publicSubdomains = subdomainModels.filter { !it.isPrivate }
        val privateSubdomains = subdomainModels.filter { it.isPrivate }
    }
}
