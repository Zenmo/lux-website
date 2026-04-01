package energy.lux.frontend.protected.entrypoints.bijsterhuizen


import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Bijsterhuizen")


@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("66624cc5-eb5e-447e-82bf-9b0fa1bfcf7d"),
        apiKey = Uuid.parse("ea85dbe9-ffde-49f4-a46a-e07f740ee4b9"),
    )
}
