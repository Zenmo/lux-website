package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.components.PrivateTwinModelPage
import com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.DrechtstedenTwinModel
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import org.jetbrains.compose.web.css.cssRem

@Composable
fun DrechtstedenTwinModelPage(
    twin: DrechtstedenTwinModel,
    introContent: @Composable () -> Unit = {},
    mediaContent: @Composable () -> Unit = {},
    footerContent: @Composable () -> Unit,
) = PrivateTwinModelPage(
    entryPoint = twin.entryPoint,
    imageUrl = twin.imageUrl,
    introContent = {
        Column(
            Modifier.fillMaxWidth()
                .gap(1.cssRem)
        ) {
            HeaderText(
                enText = twin.label.en,
                nlText = twin.label.nl,
            )
            introContent()
        }
    },
    mediaContent = mediaContent,
    footerContent = footerContent,
)