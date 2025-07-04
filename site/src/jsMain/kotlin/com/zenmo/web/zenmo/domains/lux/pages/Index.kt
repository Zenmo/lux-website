package com.zenmo.web.zenmo.domains.lux.pages

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.layouts.PageLayout
import com.zenmo.web.zenmo.domains.lux.sections.home.HomePage
import com.zenmo.web.zenmo.domains.lux.sections.luxmodels.LuxModels
import com.zenmo.web.zenmo.domains.lux.sections.nav_header.LuxHeader
import com.zenmo.web.zenmo.domains.lux.sections.products.LuxProducts


@Composable
fun LuxEnergy() {
    PageLayout(
        header = { LuxHeader() },
        footer = {},
        title = ""
    ) {
        HomePage()
        LuxProducts()
        LuxModels()
    }
}