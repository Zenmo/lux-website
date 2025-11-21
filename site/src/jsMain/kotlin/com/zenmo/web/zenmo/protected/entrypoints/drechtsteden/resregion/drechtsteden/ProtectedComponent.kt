package com.zenmo.web.zenmo.protected.entrypoints.drechtsteden.resregion.drechtsteden

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Drechtsteden")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("fc879bf3-c6ae-41f5-90f6-af2726e03da7"),
        apiKey = Uuid.parse("633268fe-104e-4dfd-a91b-9257c781ae69"),
    )
}
