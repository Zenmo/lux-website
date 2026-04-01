package energy.lux.frontend.protected.entrypoints.drechtsteden.businessparks.degeer

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import nieuweWegApiKey
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("De Geer")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("f8ceaf4d-5d2e-48e6-8b7e-e95874c0d1a3"),
        apiKey = nieuweWegApiKey,
    )
}
