package com.zenmo.web.zenmo.domains.lux.subdomains.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.anyLogicPublicApiKey
import com.zenmo.web.zenmo.theme.SitePalette
import kotlin.uuid.Uuid

@Composable
fun SubdomainModelPage(
    modelId: Uuid,
    apiKey: Uuid = anyLogicPublicApiKey,
    introContent: @Composable () -> Unit = {},
    mediaContent: @Composable () -> Unit = {},
    anylogicRender: @Composable () -> Unit = {
        AnyLogicEmbed(
            modelId = modelId,
            apiKey = apiKey,
        )
    },
    extraContent: @Composable () -> Unit = {},
    footerContent: @Composable () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        LuxSectionContainer {
            introContent()
            mediaContent()
            anylogicRender()
            extraContent()
        }
        LuxSectionContainer(
            modifier = Modifier.backgroundColor(SitePalette.light.overlay)
        ) {
            footerContent()
        }
    }
}