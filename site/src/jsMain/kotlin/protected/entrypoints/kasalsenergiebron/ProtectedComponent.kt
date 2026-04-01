package energy.lux.frontend.protected.entrypoints.kasalsenergiebron

import androidx.compose.runtime.Composable
import energy.lux.frontend.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Kas als Energiebron")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("7dfd7bdd-9882-4c58-bfc2-5aa6e5aac938"),
        apiKey = Uuid.parse("24f0409a-a94a-4d5c-83a1-9757d9161df8"),
    )
}
