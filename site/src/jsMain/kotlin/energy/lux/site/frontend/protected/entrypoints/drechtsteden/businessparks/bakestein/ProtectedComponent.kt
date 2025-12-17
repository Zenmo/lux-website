package energy.lux.site.frontend.protected.entrypoints.drechtsteden.businessparks.bakestein

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Bakestein")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("19fcb3e6-bfaa-4f22-81b3-701b36456acc"),
        apiKey = Uuid.parse("ea154877-192c-41ff-a4e4-d39fa54803b1"),
    )
}
