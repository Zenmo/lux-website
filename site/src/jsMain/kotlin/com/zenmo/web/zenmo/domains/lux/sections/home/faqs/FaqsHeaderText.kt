package com.zenmo.web.zenmo.domains.lux.sections.home.faqs

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.icons.mdi.IconStyle
import com.varabyte.kobweb.silk.components.icons.mdi.MdiHelp
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P

@Composable
fun FaqsHeaderText() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            MdiHelp(
                Modifier
                    .fontSize(48.px)
                    .color(SitePalette.light.primary).padding(right = 0.5.cssRem),
                style = IconStyle.OUTLINED
            )
            HeaderText(
                enText = "Frequently Asked Questions",
                nlText = "Veelgestelde Vragen",
            )
        }
        P {
            LangText(
                en = "Find answers to common questions about LUX Energy Twin.",
                nl = "Vind antwoorden op veelgestelde vragen over LUX Energy Twin."
            )
        }
    }
}