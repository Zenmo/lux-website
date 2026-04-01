package energy.lux.frontend.protected.entrypoints.borchwerf


import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Borchwerf")


@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("0ef687d2-3227-47da-b9e1-5ea5751af17d"),
        apiKey = Uuid.parse("870f4d39-d09c-4b29-ba44-f0f8cc740ef9"),
    )
}
