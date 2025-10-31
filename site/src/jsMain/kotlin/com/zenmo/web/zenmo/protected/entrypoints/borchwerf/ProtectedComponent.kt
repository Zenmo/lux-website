package com.zenmo.web.zenmo.protected.entrypoints.borchwerf


import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Borchwerf")


@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("0ef687d2-3227-47da-b9e1-5ea5751af17d"),
        apiKey = Uuid.parse("d4edb183-a2a3-4b45-9a37-54fb357e3595"),
    )
}