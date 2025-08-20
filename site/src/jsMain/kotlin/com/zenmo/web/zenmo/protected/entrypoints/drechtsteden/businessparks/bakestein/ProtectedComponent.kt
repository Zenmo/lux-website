package com.zenmo.web.zenmo.protected.entrypoints.drechtsteden.businessparks.bakestein

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import org.jetbrains.compose.web.css.cssRem
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Bakestein")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("19fcb3e6-bfaa-4f22-81b3-701b36456acc"),
        apiKey = Uuid.parse("ea154877-192c-41ff-a4e4-d39fa54803b1"),
        modifier = Modifier.maxWidth(90.cssRem).margin(topBottom = 4.cssRem)
    )
}
