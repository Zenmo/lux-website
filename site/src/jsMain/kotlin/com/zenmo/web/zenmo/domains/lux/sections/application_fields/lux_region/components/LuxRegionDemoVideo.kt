package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_region.components

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.components.ApplicationAreaVideo
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText


@Composable
fun LuxRegionDemoVideo() {
    LuxSectionContainer {
        HeaderText(
            enText = "See the dashboard",
            nlText = "Bekijk het dashboard",
        )

        //todo use RES Region Drechtsteden and Brabant video
        ApplicationAreaVideo(
            videoTitle = LocalizedText(
                en = "RES Region Drechtsteden and Brabant",
                nl = "RES Regio Drechtsteden en Brabant",
            ),
        )
    }
}