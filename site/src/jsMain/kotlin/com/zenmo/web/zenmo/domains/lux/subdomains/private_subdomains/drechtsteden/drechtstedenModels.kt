package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden

import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages.businessparks.drechtstedenBusinessParkModels
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages.municipalities.drechtstedenMunicipalityModels
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages.resneighborhoods.drechtstedenNeighbourhoodsModels
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages.resregion.resRegionModels

val drechtstedenModels =
    resRegionModels +
            drechtstedenNeighbourhoodsModels +
            drechtstedenBusinessParkModels +
            drechtstedenMunicipalityModels
