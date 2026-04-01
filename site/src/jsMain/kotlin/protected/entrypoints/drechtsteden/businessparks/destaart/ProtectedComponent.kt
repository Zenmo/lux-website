package energy.lux.frontend.protected.entrypoints.drechtsteden.businessparks.destaart

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.frontend.protected.entrypoints.drechtsteden.drechtstedenApiKey
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("De Staart")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("b2275ee1-18bb-46d8-9e40-5b45b0295b33"),
        apiKey = drechtstedenApiKey,
    )
}
