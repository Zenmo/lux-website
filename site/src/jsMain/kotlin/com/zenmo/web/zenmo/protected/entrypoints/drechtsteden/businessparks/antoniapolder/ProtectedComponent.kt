package com.zenmo.web.zenmo.protected.entrypoints.drechtsteden.businessparks.antoniapolder

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Antoniapolder")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("4f86e085-34f3-4b45-891b-8c9789711a91"),
        apiKey = Uuid.parse("278606e0-fd79-4916-9003-04cf0432c1cb"),
    )
}
