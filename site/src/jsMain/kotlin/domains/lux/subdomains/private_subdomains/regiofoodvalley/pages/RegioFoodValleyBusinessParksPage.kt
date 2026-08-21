package energy.lux.frontend.domains.lux.subdomains.private_subdomains.regiofoodvalley.pages

import androidx.compose.runtime.Composable
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.regiofoodvalley.regiofoodvalleyBusinessParksMenuItem
import energy.lux.frontend.domains.lux.widgets.headings.SubHeaderText
import org.jetbrains.compose.web.dom.P

@Composable
fun RegioFoodValleyBusinessParksPage() {
    SectionContainer {
        SubHeaderText(regiofoodvalleyBusinessParksMenuItem.route.label)
        P {
            LangText(
                nl = "Kom binnenkort terug om meer te zien.",
                en = "Come back soon to see more.",
            )
        }
    }
}