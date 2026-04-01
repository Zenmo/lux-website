package energy.lux.frontend.protected.entrypoints.drechtsteden.municipalities.zwijndrecht

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.frontend.protected.entrypoints.drechtsteden.drechtstedenApiKey
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Zwijndrecht")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("a4c15d4b-025a-4169-b948-3ddd75c67091"),
        apiKey = drechtstedenApiKey,
    )
}
