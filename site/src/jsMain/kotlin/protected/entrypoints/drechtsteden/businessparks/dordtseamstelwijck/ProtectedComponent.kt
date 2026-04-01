package energy.lux.frontend.protected.entrypoints.drechtsteden.businessparks.dordtseamstelwijck

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.frontend.protected.entrypoints.drechtsteden.drechtstedenApiKey
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Dordtse Kil I & II en Amstelwijck West")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("1e473aa2-0581-4584-82cd-1b2d0507d274"),
        apiKey = drechtstedenApiKey,
    )
}
