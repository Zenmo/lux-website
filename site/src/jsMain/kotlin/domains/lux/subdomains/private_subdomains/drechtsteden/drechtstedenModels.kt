package energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden

import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.pages.businessparks.drechtstedenBusinessParkModels
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.pages.municipalities.drechtstedenMunicipalityModels
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.pages.residential_neighborhoods.drechtstedenNeighbourhoodsModels
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.pages.residential_region.resRegionModels

val drechtstedenModels =
    resRegionModels +
            drechtstedenNeighbourhoodsModels +
            drechtstedenBusinessParkModels +
            drechtstedenMunicipalityModels
