package energy.lux.frontend.protected.entrypoints.drechtsteden.businessparks.groote

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Groote Lindt v2")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("96a551f4-8e56-4fc5-8b5c-babfddf92ac4"),
        apiKey = Uuid.parse("ebfb347e-fc20-4d9b-b004-e07172759372"),
    )
}
