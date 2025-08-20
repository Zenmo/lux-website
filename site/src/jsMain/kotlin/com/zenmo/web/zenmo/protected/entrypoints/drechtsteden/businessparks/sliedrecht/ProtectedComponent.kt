package com.zenmo.web.zenmo.protected.entrypoints.drechtsteden.businessparks.sliedrecht

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import org.jetbrains.compose.web.css.cssRem
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Sliedrecht")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("51df1e41-81ed-48a3-af5c-631a74f5cabf"),
        apiKey = Uuid.parse("f11396d8-0100-484e-aac9-7289b92a40d3"),
        modifier = Modifier.maxWidth(90.cssRem).margin(topBottom = 4.cssRem)
    )
}
