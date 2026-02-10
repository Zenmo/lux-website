package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_res_area

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.components.ApplicationAreaVideo
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_res_area.components.ResAreaPersonalAdvice
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_res_area.components.ResHero
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_res_area.components.UniqueIntegration
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette


@OptIn(DelicateApi::class)
@Composable
fun LuxResidentialArea() {
    Column {
        ResHero()
        LuxSectionContainer(
            modifier = Modifier.background(SitePalette.light.overlay),
        ) {
            HeaderText(
                enText = "See it in action",
                nlText = "Bekijk het in actie"
            )

            //todo use resdential area video
            ApplicationAreaVideo(
                videoTitle = LocalizedText(
                    en = "LUX Residential Area Walkthrough",
                    nl = "LUX Woonwijk Rondleiding"
                ),
            )
            ResAreaPersonalAdvice()
        }
        UniqueIntegration()
    }
}