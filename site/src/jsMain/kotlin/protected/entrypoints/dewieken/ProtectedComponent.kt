package energy.lux.frontend.protected.entrypoints.dewieken


import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("De Wieken")


@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("784ed110-8b2c-4bcf-be75-54f69d278ec6"),
        apiKey = Uuid.parse("14b547c1-2a6d-4f63-8675-28a71946e537"),
    )
}
