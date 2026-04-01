package energy.lux.frontend.protected.entrypoints.drechtsteden.resregion.drechtsteden

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.frontend.protected.entrypoints.drechtsteden.drechtstedenApiKey
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Drechtsteden")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("fc879bf3-c6ae-41f5-90f6-af2726e03da7"),
        apiKey = drechtstedenApiKey,
    )
}
