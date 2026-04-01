package energy.lux.frontend.protected.entrypoints.hessenpoort


import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Hessenpoort")


@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("ebade042-5518-4162-8eb5-f55439c67c64"),
        apiKey = Uuid.parse("9a865cc7-09c5-4fb0-8fc0-7f4d496b7239"),
    )
}
