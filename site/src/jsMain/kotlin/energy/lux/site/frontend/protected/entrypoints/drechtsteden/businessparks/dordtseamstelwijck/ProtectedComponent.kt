package energy.lux.site.frontend.protected.entrypoints.drechtsteden.businessparks.dordtseamstelwijck

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Dordtse Kil I & II en Amstelwijck West")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("1e473aa2-0581-4584-82cd-1b2d0507d274"),
        apiKey = Uuid.parse("9f281fab-a0bf-4bf5-9baa-b74d9d2fcc89"),
    )
}
