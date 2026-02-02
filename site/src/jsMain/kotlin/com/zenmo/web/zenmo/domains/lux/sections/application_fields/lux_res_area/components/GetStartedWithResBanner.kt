package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_res_area.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.components.ApplicationAreaCTAButton
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette


@Composable
fun GetStartedWithResBanner() {
    LuxSectionContainer(
        modifier = Modifier.background(SitePalette.light.primary)
            .color(Colors.White)
    ) {
        HeaderText(
            enText = "Want to know more?",
            nlText = "Wil je meer weten?",
        )

        ApplicationAreaCTAButton(
            text = LocalizedText(
                en = "Get Started",
                nl = "Aan de slag"
            ),
            bgColor = SitePalette.light.secondary,
            textColor = Colors.Black
        )
    }
}