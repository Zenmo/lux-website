package energy.lux.frontend.domains.zenmo.pages.home.what_we_do

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.*
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.components.PlaceholderText
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.P

private val services = listOf(
    ServiceItem(
        icon = { MdiGroup() },
        titleText = LocalizedText(
            en = "Research Projects",
            nl = "Onderzoeksprojecten",
        )
    ),
    ServiceItem(
        icon = { MdiAutoGraph() },
        titleText = LocalizedText(
            en = "Energy Consulting",
            nl = "Energie Advies",
        ),
    ),
    ServiceItem(
        icon = { MdiLightbulb() },
        titleText = LocalizedText(
            en = "Interactive Models",
            nl = "Interactieve Modellen",
        ),
    ),
    ServiceItem(
        icon = { MdiBolt() },
        titleText = LocalizedText(
            en = "Grid Optimization",
            nl = "Netwerk Optimalisatie",
        ),
    ),
    ServiceItem(
        icon = { MdiBarChart() },
        titleText = LocalizedText(
            nl = "Lorem ipsum ",
        ),
    ),
    ServiceItem(
        icon = { MdiBarChart() },
        titleText = LocalizedText(
            nl = "Lorem ipsum ",
        ),
    ),
)

@Composable
fun WhatWeDoSection() {
    SectionContainer(
        modifier = Modifier.backgroundColor(SitePalette.light.overlay)
            .textAlign(TextAlign.Center)
    ) {
        HeaderText(
            enText = "What we do",
            nlText = "Wat we doen",
        )
        P(
            Modifier.width(50.percent).toAttrs()
        ) { PlaceholderText() }
        SimpleGrid(
            numColumns(base = 1, md = 2, lg = 3, xl = 3, xxl = 3),
            modifier = ServicesGridStyle.toModifier()
                .gap(1.cssRem)
                .alignItems(AlignItems.Center)
        ) {
            services.forEach { ServiceCard(it) }
        }
    }
}