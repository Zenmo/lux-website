package energy.lux.frontend.protected.entrypoints.drechtsteden.resneighborhoods.oostdonk

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.frontend.protected.entrypoints.drechtsteden.drechtstedenApiKey
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Oostdonk")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("3b4289ea-d2b8-4887-95bf-bf293fc34263"),
        apiKey = drechtstedenApiKey,
    )
}
