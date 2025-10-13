package com.zenmo.web.zenmo.protected.entrypoints.drechtsteden.municipalities.dordtse

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Dordtse Kil III & IV")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("2f9547eb-e123-4f92-9351-85f739a27ae8"),
        apiKey = Uuid.parse("9f281fab-a0bf-4bf5-9baa-b74d9d2fcc89"),
    )
}
