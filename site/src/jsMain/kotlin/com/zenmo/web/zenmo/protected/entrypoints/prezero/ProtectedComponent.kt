package com.zenmo.web.zenmo.protected.entrypoints.prezero

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("PreZero")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("72d47601-ffb6-4b66-b7a1-81cb289c6f4e"),
        apiKey = Uuid.parse("aec12288-c1ec-4dee-89f6-ef4238fd860c"), //todo use api key for prezero
    )
}