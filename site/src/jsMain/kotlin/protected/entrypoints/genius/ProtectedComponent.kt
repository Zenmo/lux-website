package energy.lux.frontend.protected.entrypoints.genius

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Genius")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("42e7ad8d-102f-4a32-808c-65bdd646a52a"),
        apiKey = Uuid.parse("e5936d18-957e-4d79-a039-d84fad2e13ea"),
    )
}
