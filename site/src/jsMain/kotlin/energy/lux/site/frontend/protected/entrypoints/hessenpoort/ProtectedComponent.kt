package energy.lux.site.frontend.protected.entrypoints.hessenpoort


import androidx.compose.runtime.Composable
import energy.lux.site.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Hessenpoort")


@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("ebade042-5518-4162-8eb5-f55439c67c64"),
        apiKey = Uuid.parse("7c9ad7bc-3189-4796-a34e-9f3caa5c117a"),
    )
}