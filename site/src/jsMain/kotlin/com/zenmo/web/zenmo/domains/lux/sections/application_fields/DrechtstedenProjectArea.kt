package com.zenmo.web.zenmo.domains.lux.sections.application_fields

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.core.models.Route
import com.zenmo.web.zenmo.core.models.SimpleMenuItem
import com.zenmo.web.zenmo.core.services.localization.LocalizedText

enum class DrechtstedenProjectArea(
    override val label: LocalizedText,
    override val areaTitle: LocalizedText = label,
    override val path: String,
    override val url: String = path,
    override val pageComponent: @Composable () -> Unit,
) : Route, SimpleMenuItem, ApplicationArea {
    RES_REGION(
        path = "/region",
        label = LocalizedText(en = "Region", nl = "Regio"),
        pageComponent = { com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages.resregion.DrechtstedenRegioIndex() }
    ),
    RES_NEIGHBORHOODS(
        path = "/res-neighborhoods",
        label = LocalizedText(en = "Residential Neighborhoods", nl = "Woonwijken"),
        pageComponent = { com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages.resneighborhoods.ResNeighborhoodsPage() }
    ),
    BUSINESS_PARKS(
        path = "/business-parks",
        label = LocalizedText(en = "Business Parks", nl = "Bedrijventerreinen"),
        pageComponent = { com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.pages.businessparks.BusinessParksPage() }
    ),
}