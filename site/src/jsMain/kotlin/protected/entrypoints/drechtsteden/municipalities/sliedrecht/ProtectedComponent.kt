package energy.lux.frontend.protected.entrypoints.drechtsteden.municipalities.sliedrecht

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.frontend.protected.entrypoints.drechtsteden.drechtstedenApiKey
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Gemeente Sliedrecht")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("e62f7668-a52c-47d2-aae6-e89717ddb5a7"),
        apiKey = drechtstedenApiKey,
    )
}
