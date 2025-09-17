package com.zenmo.web.zenmo.protected.entrypoints.genius

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Genius")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("42e7ad8d-102f-4a32-808c-65bdd646a52a"),
        apiKey = Uuid.parse("6764ad7a-0c33-4a0e-bd98-8255e8966419"),
    )
}
