package energy.lux.frontend.domains.lux.sections.luxmodels

import energy.lux.frontend.domains.lux.core.model.subdomain.subdomainModels
import energy.lux.frontend.domains.lux.core.toTwinModelCardItem
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.drechtsteden.drechtstedenModels
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.ossTwinModels

val allLuxModels = (subdomainModels + drechtstedenModels + ossTwinModels)
    .map { it.toTwinModelCardItem() }