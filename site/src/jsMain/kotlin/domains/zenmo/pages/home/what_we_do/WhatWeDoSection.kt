package energy.lux.frontend.domains.zenmo.pages.home.what_we_do

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.columnGap
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import energy.lux.frontend.components.widgets.InlineLink
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.pages.models.constrainedWidth
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun WhatWeDoSection() {
    SectionContainer(
        modifier = Modifier
            .backgroundColor(SitePalette.light.overlay)
            .textAlign(TextAlign.Center)
    ) {
        HeaderText(
            enText = "What we do",
            nlText = "Wat we doen",
        )
        P(Modifier.constrainedWidth(60.percent).toAttrs()) {
            LangText(
                en = """
                    Zenmo simulations stands for Zero-emission energy & mobility simulations. We want to put our
                    knowledge about energy and mobility systems to good use for any organisation that wants to reduce
                    its carbon footprint. We're a spin-out of Eindhoven University of Technology and we're the
                    developers of 
                """.trimIndent(),
                nl = """
                    Zenmo Simulations staat voor Zero-emission energy & mobility simulations. Wij willen onze kennis
                    van energie- en mobiliteitssystemen inzetten voor elke organisatie die haar CO2-voetafdruk wil
                    verkleinen. Wij zijn een spin-out van de Technische Universiteit Eindhoven en we zijn de
                    ontwikkelaar van 
                """.trimIndent(),
            )
            InlineLink(
                destinationUrl = "https://lux.energy",
                enLinkText = "LUX Energy Twin",
                nlLinkText = "LUX Energy Twin"
            )
            Text(".")
        }
        SimpleGrid(
            numColumns(base = 1, md = 2),
            modifier = Modifier
                .constrainedWidth(70.percent)
                .columnGap(4.cssRem),
        ) {
            zenmoServices.forEachIndexed { index, item ->
                val showDivider = index < zenmoServices.size - 2
                ServiceCard(item, showDivider = showDivider)
            }
        }
    }
}