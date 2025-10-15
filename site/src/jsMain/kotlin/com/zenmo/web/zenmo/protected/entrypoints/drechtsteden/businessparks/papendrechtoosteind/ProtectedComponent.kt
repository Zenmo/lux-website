package com.zenmo.web.zenmo.protected.entrypoints.drechtsteden.businessparks.papendrechtoosteind

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Papendrecht Oosteind")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("0ef34b9d-4887-451c-bb51-2d991b8f07ff"),
        apiKey = Uuid.parse("633268fe-104e-4dfd-a91b-9257c781ae69"),
    )
}
