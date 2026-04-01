package energy.lux.frontend.protected.entrypoints.drechtsteden.municipalities.hardinxveld

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.frontend.protected.entrypoints.drechtsteden.drechtstedenApiKey
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Gemeente Hardinxveld-Giessendam")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("87d8b189-bcc4-4e37-ba44-3ee1e242985a"),
        apiKey = drechtstedenApiKey,
    )
}
