package energy.lux.frontend.protected.entrypoints.drechtsteden.businessparks.ambachtse

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.frontend.protected.entrypoints.drechtsteden.drechtstedenApiKey
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Ambachtse Zoom")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("fc8e83f5-2c0d-4961-b4f9-35069486eca6"),
        apiKey = drechtstedenApiKey,
    )
}
