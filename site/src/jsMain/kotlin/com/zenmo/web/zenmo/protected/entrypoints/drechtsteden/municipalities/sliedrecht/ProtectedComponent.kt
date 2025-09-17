package com.zenmo.web.zenmo.protected.entrypoints.drechtsteden.municipalities.sliedrecht

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Gemeente Sliedrecht")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("e62f7668-a52c-47d2-aae6-e89717ddb5a7"),
        apiKey = Uuid.parse("633268fe-104e-4dfd-a91b-9257c781ae69"),
    )
}
