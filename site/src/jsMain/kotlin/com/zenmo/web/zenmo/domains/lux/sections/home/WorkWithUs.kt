package com.zenmo.web.zenmo.domains.lux.sections.home

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.sections.LuxSectionContainerStyleVariant
import com.zenmo.web.zenmo.domains.lux.styles.verticalLinearBackground
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.dom.P


@Composable
fun WorkWithUs() {
    SectionContainer(
        variant = LuxSectionContainerStyleVariant,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalLinearBackground()
            .color(Colors.White)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            HeaderText(
                enText = "Lets work together!",
                nlText = "Laten we samenwerken!",
            )
            P {
                LangText(
                    en = "Independent, scientifically sound, and ready to solve grid congestion.",
                    nl = "Onafhankelijk, wetenschappelijk onderbouwd en klaar om netcongestie op te lossen."
                )
            }
            Link(
                path = "/book-demo",
                variant = UndecoratedLinkVariant.then(UncoloredLinkVariant),
                modifier = Modifier
                    .background(SitePalette.light.secondary).color(Colors.Black)
                    .padding(leftRight = 2.25.em, topBottom = 1.1.em)
                    .luxBorderRadius()
            ) {
                LangText(
                    en = "Contact us",
                    nl = "Neem contact op",
                )
            }
        }
    }
}