package energy.lux.frontend.protected.entrypoints.drechtsteden.businessparks.dordtse

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.frontend.protected.entrypoints.drechtsteden.drechtstedenApiKey
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Dordtse Kil III & IV")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("2f9547eb-e123-4f92-9351-85f739a27ae8"),
        apiKey = drechtstedenApiKey,
    )
}
