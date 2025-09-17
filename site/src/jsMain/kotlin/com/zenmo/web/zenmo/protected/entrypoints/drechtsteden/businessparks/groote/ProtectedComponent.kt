package com.zenmo.web.zenmo.protected.entrypoints.drechtsteden.businessparks.groote

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Groote Lindt v2")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("96a551f4-8e56-4fc5-8b5c-babfddf92ac4"),
        apiKey = Uuid.parse("6dee8524-adbf-4433-aae7-c3846d252854"),
    )
}
