package energy.lux.frontend.protected.entrypoints.drechtsteden.businessparks.nieuweweg

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import nieuweWegApiKey
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Nieuwe Weg")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("57f0e77f-b609-4487-badc-9167e53f6a24"),
        apiKey = nieuweWegApiKey,
    )
}
