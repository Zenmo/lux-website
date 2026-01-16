package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.core.models.Route
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.core.PrivateTwinModel
import com.zenmo.web.zenmo.domains.lux.core.TwinModelCard
import com.zenmo.web.zenmo.domains.lux.core.model.subdomain.drechtsteden
import com.zenmo.web.zenmo.domains.lux.core.toTwinModelCardItem
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.DrechtstedenProjectArea
import com.zenmo.web.zenmo.pages.SiteGlobals
import kotlinx.browser.window

data class DrechtstedenTwinModel(
    override val path: String,
    override val label: LocalizedText,
    override val applicationArea: DrechtstedenProjectArea,
    override val imageUrl: String,
    override val entryPoint: String,
    override val pageComponent: @Composable () -> Unit,
) : Route, TwinModelCard, PrivateTwinModel {

    val projectPath = "${applicationArea.path}/$path"
    private val protocol = window.location.protocol

    override val url: String
        get() = "${protocol}//${drechtsteden.subdomain}.${SiteGlobals.LUX_DOMAIN}$projectPath"
}


fun List<DrechtstedenTwinModel>.toTwinModelCardItems() =
    this.map { it.toTwinModelCardItem() }
