package com.zenmo.web.zenmo.domains.lux.subdomains.empowered

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.layouts.PageLayout
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.LuxHeader

@Composable
fun EmpoweredLayout(
    content: @Composable () -> Unit,
) {
    PageLayout(
        header = { LuxHeader() },
        footer = {},
        title = "Empowered",
    ) {
        content()
    }
}
