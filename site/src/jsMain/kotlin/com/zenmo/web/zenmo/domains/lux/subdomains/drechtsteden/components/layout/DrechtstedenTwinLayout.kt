package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components.layout

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.layouts.PageLayout
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.LuxHeader

@Composable
fun DrechtstedenTwinLayout(
    title: String,
    content: @Composable () -> Unit,
) {
    PageLayout(
        header = { LuxHeader() },
        footer = {},
        title = "Drechtsteden - $title",
    ) {
        content()
    }
}
