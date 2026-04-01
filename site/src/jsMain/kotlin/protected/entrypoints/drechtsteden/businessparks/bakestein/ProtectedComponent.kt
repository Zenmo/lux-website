package energy.lux.frontend.protected.entrypoints.drechtsteden.businessparks.bakestein

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import nieuweWegApiKey
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Bakestein")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("19fcb3e6-bfaa-4f22-81b3-701b36456acc"),
        apiKey = nieuweWegApiKey,
    )
}
