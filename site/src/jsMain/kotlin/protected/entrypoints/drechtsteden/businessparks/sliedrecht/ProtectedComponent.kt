package energy.lux.frontend.protected.entrypoints.drechtsteden.businessparks.sliedrecht

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Sliedrecht")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("51df1e41-81ed-48a3-af5c-631a74f5cabf"),
        apiKey = Uuid.parse("c6c68b61-c215-41df-8c8c-f4d996e34228"),
    )
}
