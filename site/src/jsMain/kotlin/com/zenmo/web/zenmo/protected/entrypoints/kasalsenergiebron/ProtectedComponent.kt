package com.zenmo.web.zenmo.protected.entrypoints.kasalsenergiebron

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import org.jetbrains.compose.web.css.cssRem
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Kas als Energiebron")

@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("7dfd7bdd-9882-4c58-bfc2-5aa6e5aac938"),
        apiKey = Uuid.parse("aec12288-c1ec-4dee-89f6-ef4238fd860c"),
        modifier = Modifier.maxWidth(90.cssRem).margin(bottom = 4.cssRem)
    )
}