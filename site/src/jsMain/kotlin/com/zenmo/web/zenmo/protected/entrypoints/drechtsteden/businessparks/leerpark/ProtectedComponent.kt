package com.zenmo.web.zenmo.protected.entrypoints.drechtsteden.businessparks.leerpark

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import org.jetbrains.compose.web.css.cssRem
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Leerpark")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("54711b02-60db-4336-b20a-b7ac9940b3dc"),
        apiKey = Uuid.parse("633268fe-104e-4dfd-a91b-9257c781ae69"),
        modifier = Modifier.maxWidth(90.cssRem).margin(topBottom = 4.cssRem)
    )
}