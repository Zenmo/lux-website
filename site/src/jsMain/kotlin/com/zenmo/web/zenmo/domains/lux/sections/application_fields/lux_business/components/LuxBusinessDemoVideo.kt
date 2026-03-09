package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_business.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.components.ApplicationAreaVideo
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import org.jetbrains.compose.web.css.cssRem

@Composable
fun LuxBusinessDemoVideo() {
    LuxSectionContainer(
        Modifier
            .gap(1.cssRem)
    ) {
        SubHeaderText(
            enText = "LUX Business In Action",
            nlText = "LUX Bedrijf In Actie",
        )
        ApplicationAreaVideo(
            videoTitle = LocalizedText(
                en = "Interactive Dashboard Walkthrough",
                nl = "Interactieve Dashboard Walkthrough"
            ),
        )
    }
}
