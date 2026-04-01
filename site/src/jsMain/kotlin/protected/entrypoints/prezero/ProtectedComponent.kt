package energy.lux.frontend.protected.entrypoints.prezero

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("PreZero")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("72d47601-ffb6-4b66-b7a1-81cb289c6f4e"),
        // AnyLogic user prezero@zenmo.com
        apiKey = Uuid.parse("8063e871-ae49-4b90-aabf-4e724c11f088"),
    )
}
