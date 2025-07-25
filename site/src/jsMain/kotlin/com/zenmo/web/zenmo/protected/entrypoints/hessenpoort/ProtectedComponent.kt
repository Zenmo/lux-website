package com.zenmo.web.zenmo.protected.entrypoints.hessenpoort


import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import energy.lux.site.shared.AccessPolicy
import org.jetbrains.compose.web.css.cssRem
import kotlin.uuid.Uuid

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Hessenpoort")


@JsExport
@Composable
fun ProtectedComponent() {
    AnyLogicEmbed(
        modelId = Uuid.parse("ebade042-5518-4162-8eb5-f55439c67c64"),
        apiKey = Uuid.parse("7c9ad7bc-3189-4796-a34e-9f3caa5c117a"),
        modifier = Modifier.maxWidth(90.cssRem).margin(bottom = 4.cssRem)
    )
}