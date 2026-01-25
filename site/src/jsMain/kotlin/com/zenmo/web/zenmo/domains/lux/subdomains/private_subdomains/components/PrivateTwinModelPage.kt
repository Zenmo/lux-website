package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.components

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.subdomains.components.SubdomainModelPage
import kotlin.uuid.Uuid

@Composable
fun PrivateTwinModelPage(
    entryPoint: String,
    imageUrl: String,
    introContent: @Composable () -> Unit = {},
    mediaContent: @Composable () -> Unit = {},
    extraContent: @Composable () -> Unit = {},
    footerContent: @Composable () -> Unit,
) = SubdomainModelPage(
    modelId = Uuid.NIL,
    introContent = introContent,
    mediaContent = mediaContent,
    anylogicRender = {
        ModelWrapper(
            imgUrl = imageUrl,
            entryPoint = entryPoint,
        )
    },
    extraContent = extraContent,
    footerContent = footerContent,
)