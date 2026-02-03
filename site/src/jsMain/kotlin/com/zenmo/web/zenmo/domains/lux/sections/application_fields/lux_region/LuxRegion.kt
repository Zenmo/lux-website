package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_region

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_region.components.*


@Composable
fun LuxRegion() {
    Column {
        LuxRegionHero()
        MoreThanAMap()
        LuxRegionDemoVideo()
        WhatIfScenarios()
        MultiScaleAnalysis()
        ConsistentInterface()
    }
}