package energy.lux.frontend.protected.entrypoints.drechtsteden.resneighborhoods.kerkbuurt

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.frontend.protected.entrypoints.drechtsteden.drechtstedenApiKey
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Kerkbuurt")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("a8d6e6ae-8a4c-4685-9195-33b9cd986c48"),
        apiKey = drechtstedenApiKey,
    )
}
