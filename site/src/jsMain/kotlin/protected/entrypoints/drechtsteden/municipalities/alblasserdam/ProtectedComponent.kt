package energy.lux.frontend.protected.entrypoints.drechtsteden.municipalities.alblasserdam

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.frontend.protected.entrypoints.drechtsteden.drechtstedenApiKey
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Gemeente Alblasserdam")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("92e0993d-e96d-4f05-9c0b-eb9bbf1d1eb1"),
        apiKey = drechtstedenApiKey,
    )
}
