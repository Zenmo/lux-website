package energy.lux.frontend.protected.entrypoints.drechtsteden.resneighborhoods.overtspoor

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.frontend.protected.entrypoints.drechtsteden.drechtstedenApiKey
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Over 't Spoor")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("612143ff-eedc-4f36-8606-13d4c4d710a7"),
        apiKey = drechtstedenApiKey,
    )
}
