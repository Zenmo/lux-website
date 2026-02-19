package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_res_area.components.get_lux_neighbourhood

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_res_area.components.UniqueIntegration
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.cssRem


@Composable
fun GetLuxNeighbourhoodSection() {
    LuxSectionContainer(
        modifier = Modifier.alignItems(AlignItems.FlexStart),
    ) {
        HeaderText(
            enText = "Getting the LUX Neighbourhood",
            nlText = "Hoe gaat het in zijn werk",
            textColor = SitePalette.light.primary
        )
        Column(
            modifier = Modifier.gap(2.cssRem)
        ) {
            Step01()
            Step02()
            Step03()
        }
        UniqueIntegration()
    }
}
