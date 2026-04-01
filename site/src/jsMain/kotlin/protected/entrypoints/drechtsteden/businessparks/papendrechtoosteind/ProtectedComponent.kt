package energy.lux.frontend.protected.entrypoints.drechtsteden.businessparks.papendrechtoosteind

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.frontend.protected.entrypoints.drechtsteden.drechtstedenApiKey
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Papendrecht Oosteind")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("0ef34b9d-4887-451c-bb51-2d991b8f07ff"),
        apiKey = drechtstedenApiKey,
    )
}
