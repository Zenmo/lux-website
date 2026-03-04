package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.core.models.Route
import com.zenmo.web.zenmo.core.models.RoutedMenuItem
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.core.services.localization.localizedUrl
import com.zenmo.web.zenmo.domains.lux.core.PrivateTwinModel
import com.zenmo.web.zenmo.domains.lux.core.TwinModelCard
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.PrivateSubdomainModel
import com.zenmo.web.zenmo.domains.lux.core.toTwinModelCardItem
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.DrechtstedenProjectArea
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.LuxApplicationArea
import com.zenmo.web.zenmo.pages.SiteGlobals

private val drechtstedenFullDomain = "${PrivateSubdomainModel.DRECHTSTEDEN.subdomain}.${SiteGlobals.LUX_DOMAIN}"

data class DrechtstedenTwinModel(
    val projectPath: String,
    override val applicationArea: LuxApplicationArea = LuxApplicationArea.LUX_ENERGY_HUB,
    override val label: LocalizedText,
    override val imageUrl: String,
    override val entryPoint: String,
    override val pageComponent: @Composable () -> Unit,
) : Route, TwinModelCard, PrivateTwinModel {
    override val url: String
        get() = localizedUrl(drechtstedenFullDomain, path)

    override val path: String
        get() = when (applicationArea) {
            LuxApplicationArea.LUX_ENERGY_HUB -> DrechtstedenProjectArea.BUSINESS_PARKS.path
            LuxApplicationArea.LUX_REGION -> DrechtstedenProjectArea.RES_REGION.path
            LuxApplicationArea.LUX_NEIGHBOURHOOD -> DrechtstedenProjectArea.RESIDENTIAL_AREAS.path
            LuxApplicationArea.LUX_BUSINESS -> LuxApplicationArea.LUX_BUSINESS.path
        } + projectPath
}

fun DrechtstedenTwinModel.asRoutedMenuItem() =
    RoutedMenuItem(
        label = label,
        path = path,
        url = url,
        pageComponent = pageComponent,
    )

fun List<DrechtstedenTwinModel>.toTwinModelCardItems() =
    this.map { it.toTwinModelCardItem() }
