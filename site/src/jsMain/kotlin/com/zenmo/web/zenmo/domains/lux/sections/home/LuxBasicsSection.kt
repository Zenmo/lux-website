package com.zenmo.web.zenmo.domains.lux.sections.home

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.LuxSpecificColorHues
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.P


@Composable
fun LuxBasicsSection(
    breakpoint: Breakpoint
) {
    SectionContainer(
        variant = LuxSectionContainerStyleVariant,
        modifier = Modifier.background(LuxSpecificColorHues().luxBlackRussian)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .gap(1.cssRem)
                .flexWrap(FlexWrap.Wrap),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top,
        ) {
            Column(
                modifier = Modifier
                    .width(30.percent)
                    .thenIf(breakpoint < Breakpoint.MD, Modifier.fillMaxWidth())
                    .thenIf(breakpoint > Breakpoint.LG, Modifier.width(40.percent))
                    .color(Colors.White)
                    .margin(0.cssRem)
                    .flexWrap(FlexWrap.Wrap)
            ) {
                HeaderText(
                    enText = "LUX Basics",
                    nlText = "LUX Basics",
                )
                P {
                    LangText(
                        en = "Know the basics of LUX",
                        nl = "Vertrouwd raken met de basisprincipes van LUX"
                    )
                }
            }

            LuxFlipCards()
        }
    }
}


