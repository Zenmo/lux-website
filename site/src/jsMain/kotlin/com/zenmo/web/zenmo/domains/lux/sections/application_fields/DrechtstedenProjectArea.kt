package com.zenmo.web.zenmo.domains.lux.sections.application_fields

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.core.models.Route
import com.zenmo.web.zenmo.core.models.SimpleMenuItem
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.businessparks.BusinessParksPage
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.resneighborhoods.ResNeighborhoodsPage
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.resregion.ResRegionPage

enum class DrechtstedenProjectArea(
    override val label: LocalizedText,
    override val areaTitle: LocalizedText = label,
    override val path: String,
    override val url: String = path,
    override val pageComponent: @Composable () -> Unit,
) : Route, SimpleMenuItem, ApplicationArea {
    RES_REGION(
        path = "/res-region",
        label = LocalizedText("Residential Region", "Woonregio"),
        pageComponent = { ResRegionPage() }
    ),
    RES_NEIGHBORHOODS(
        path = "/res-neighborhoods",
        label = LocalizedText("Residential Neighborhoods", "Woonwijken"),
        pageComponent = { ResNeighborhoodsPage() }
    ),
    BUSINESS_PARKS(
        path = "/business-parks",
        label = LocalizedText("Business Parks", "Bedrijventerreinen"),
        pageComponent = { BusinessParksPage() }
    ),
}