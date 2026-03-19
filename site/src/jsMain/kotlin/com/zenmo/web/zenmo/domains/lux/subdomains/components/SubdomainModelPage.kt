package com.zenmo.web.zenmo.domains.lux.subdomains.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.zenmo.web.zenmo.core.services.anyLogicModels.LocalModelsViewModel
import com.zenmo.web.zenmo.core.services.anyLogicModels.getModelDateForUuid
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
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                val modelsUiState by LocalModelsViewModel.current.uiState.collectAsState()
                val lastModifiedDate = modelsUiState.models.getModelDateForUuid(modelId.toString())

                if (lastModifiedDate != null) {
                    ModelLastUpdatedLabel(lastModifiedDate)
                }
                anylogicRender()
            }
            extraContent()
        }
        LuxSectionContainer(
            modifier = Modifier.backgroundColor(SitePalette.light.overlay)
        ) {
            footerContent()
        }
    }
}