package energy.lux.frontend.protected.entrypoints.drechtsteden.businessparks.amstelwijck

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.frontend.protected.entrypoints.drechtsteden.drechtstedenApiKey
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Amstelwijck Businesspark")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("266253e0-16b4-44de-baac-51641f99e34b"),
        apiKey = drechtstedenApiKey,
    )
}
