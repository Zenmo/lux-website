package com.zenmo.web.zenmo.domains.lux.sections.application_fields.lux_business.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.silk.components.icons.mdi.MdiMovie
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.components.LuxSectionContainer
import com.zenmo.web.zenmo.domains.lux.widgets.VisualContentPlaceholder
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import org.jetbrains.compose.web.css.px

@Composable
fun LuxBusinessDemoVideo() {
    LuxSectionContainer {
        HeaderText(
            enText = "LUX Business In Action",
            nlText = "LUX Bedrijf In Actie",
        )

        VisualContentPlaceholder(
            descriptionText = LocalizedText(
                en = "Come back soon to see the demo movie!",
                nl = "Kom snel terug om de demo movie te zien!"
            ),
            icon = {
                MdiMovie(Modifier.fontSize(32.px))
            }
        )
    }
}
