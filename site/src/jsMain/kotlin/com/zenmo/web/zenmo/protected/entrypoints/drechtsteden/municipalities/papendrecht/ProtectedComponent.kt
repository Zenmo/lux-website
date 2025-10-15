package com.zenmo.web.zenmo.protected.entrypoints.drechtsteden.municipalities.papendrecht

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Papendrecht")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("af3272d6-b1a4-49a2-af86-e3f55cc731d9"),
        apiKey = Uuid.parse("633268fe-104e-4dfd-a91b-9257c781ae69"),
    )
}
