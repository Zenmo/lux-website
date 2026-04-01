package energy.lux.frontend.protected.entrypoints.drechtsteden.businessparks.antoniapolder

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Antoniapolder")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("4f86e085-34f3-4b45-891b-8c9789711a91"),
        apiKey = Uuid.parse("a2915972-51f3-4fe5-876f-581b8c1ccc73"),
    )
}
