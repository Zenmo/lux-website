package energy.lux.frontend.protected.entrypoints.vaanpark


import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Vaanpark")


@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("b72013ef-c6b4-4171-afef-754e547b723f"),
        // AnyLogic user vaanpark@zenmo.com
        apiKey = Uuid.parse("324393c6-7c67-4e5f-a84c-ef3c2ae1629f"),
    )
}
