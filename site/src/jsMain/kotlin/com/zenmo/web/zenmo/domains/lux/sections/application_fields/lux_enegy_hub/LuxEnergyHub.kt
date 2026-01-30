package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub.components.DidYouKNowSection
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub.components.EfficientSupport
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub.components.LuxEnergyHubHero
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub.components.energy_hub_process.EnergyHubProcessSection


@OptIn(DelicateApi::class)
@Composable
fun LuxEnergyHub() {
    Column {
        LuxEnergyHubHero()
        DidYouKNowSection()
        EnergyHubProcessSection()
        EfficientSupport()
    }
}