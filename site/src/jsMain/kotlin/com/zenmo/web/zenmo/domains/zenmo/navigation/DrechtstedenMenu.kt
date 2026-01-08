package com.zenmo.web.zenmo.domains.zenmo.navigation

import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.businessparks.businessParksPath
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.resneighborhoods.resNeighbourhoodsPath
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.resregion.resRegionPath

object DrechtstedenMenu {
    val items = listOf(
        MenuItem.Simple(path = "/", title = LocalizedText("Drechtsteden", "Drechtsteden")),
        MenuItem.Simple(path = resRegionPath, title = LocalizedText("Res Region", "Res Regio")),
        MenuItem.Simple(
            path = resNeighbourhoodsPath,
            title = LocalizedText("Res Neighborhoods", "Woonwijken")
        ),
        MenuItem.Simple(
            path = businessParksPath,
            title = LocalizedText("Business Parks", "Bedrijventerreinen")
        )
    )
}