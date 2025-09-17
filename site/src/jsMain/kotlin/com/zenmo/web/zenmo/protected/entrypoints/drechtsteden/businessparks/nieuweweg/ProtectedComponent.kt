package com.zenmo.web.zenmo.protected.entrypoints.drechtsteden.businessparks.nieuweweg

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Nieuwe Weg")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("57f0e77f-b609-4487-badc-9167e53f6a24"),
        apiKey = Uuid.parse("ea154877-192c-41ff-a4e4-d39fa54803b1"),
    )
}
