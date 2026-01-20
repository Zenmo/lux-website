package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden

import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.businessparks.drechtstedenBusinessParkModels
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.municipalities.drechtstedenMunicipalityModels
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.resneighborhoods.drechtstedenResNeighborhoodsModels
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.resregion.resRegionModels

val drechtstedenModels = resRegionModels +
        drechtstedenResNeighborhoodsModels +
        drechtstedenBusinessParkModels +
        drechtstedenMunicipalityModels