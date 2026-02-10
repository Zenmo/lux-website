package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_enegy_hub.components.energy_hub_process

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.components.ApplicationAreaVideo
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.cssRem


@Composable
fun EnergyHubProcessSection() {
    LuxSectionContainer(
        modifier = Modifier.alignItems(AlignItems.FlexStart),
    ) {
        HeaderText(
            enText = "The Process",
            nlText = "Het Proces",
        )
        Column(
            modifier = Modifier.gap(2.cssRem)
        ) {
            Step01()
            Step02()
            //todo use Hessenpoort video
            ApplicationAreaVideo(
                videoTitle = LocalizedText(
                    en = "Hessenpoort Example (Public Data)",
                    nl = "Hessenpoort Voorbeeld (Openbare Data)"
                ),
            )
            Step03()
            Step04()
        }
    }
}
