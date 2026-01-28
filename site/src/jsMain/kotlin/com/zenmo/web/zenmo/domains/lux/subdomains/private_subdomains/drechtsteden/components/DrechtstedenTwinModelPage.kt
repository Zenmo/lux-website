package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
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
        HeaderText(
            enText = twin.label.en,
            nlText = twin.label.nl,
            modifier = Modifier.margin(0.cssRem)
        )
        introContent()
    },
    mediaContent = mediaContent,
    footerContent = footerContent,
)