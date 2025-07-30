package com.zenmo.web.zenmo.domains.lux.pages

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.layouts.PageLayout
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.LuxHeader


@Composable
fun LuxEnergyLayout(
    content: @Composable () -> Unit
) {
    PageLayout(
        header = { LuxHeader() },
        footer = {},
        title = ""
    ) {
        content()
    }
}