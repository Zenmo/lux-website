package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.core.models.Route
import com.zenmo.web.zenmo.core.models.RoutedMenuItem
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.core.PrivateTwinModel
import com.zenmo.web.zenmo.domains.lux.core.TwinModelCard
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.PrivateSubdomainModel
import com.zenmo.web.zenmo.domains.lux.core.toTwinModelCardItem
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.DrechtstedenProjectArea
import com.zenmo.web.zenmo.pages.SiteGlobals
import kotlinx.browser.window

data class DrechtstedenTwinModel(
    val projectPath: String,
    override val path: String = "${applicationArea.path}$projectPath",
    override val label: LocalizedText,
    override val applicationArea: DrechtstedenProjectArea,
    override val imageUrl: String,
    override val entryPoint: String,
    override val pageComponent: @Composable () -> Unit,
) : Route, TwinModelCard, PrivateTwinModel {

    private val protocol = window.location.protocol

    override val url: String
        get() = "${protocol}//${PrivateSubdomainModel.DRECHTSTEDEN.subdomain}.${SiteGlobals.LUX_DOMAIN}$path"
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
