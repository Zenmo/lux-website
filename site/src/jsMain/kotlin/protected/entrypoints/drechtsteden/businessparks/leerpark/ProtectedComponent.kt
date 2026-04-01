package energy.lux.frontend.protected.entrypoints.drechtsteden.businessparks.leerpark

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.frontend.protected.entrypoints.drechtsteden.drechtstedenApiKey
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Leerpark")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("54711b02-60db-4336-b20a-b7ac9940b3dc"),
        apiKey = drechtstedenApiKey,
    )
}
