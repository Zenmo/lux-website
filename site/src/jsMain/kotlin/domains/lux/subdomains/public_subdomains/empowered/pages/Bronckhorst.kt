package energy.lux.frontend.domains.lux.subdomains.public_subdomains.empowered.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.padding
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.domains.lux.sections.LuxSectionContainerStyleVariant
import energy.lux.frontend.domains.lux.widgets.headings.SubHeaderText
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.P

@Composable
fun Bronckhorst() {
    SectionContainer(
        variant = LuxSectionContainerStyleVariant
    ) {
        SubHeaderText(
            modifier = Modifier.padding(top = 2.cssRem),
            enText = "Bronckhorst",
            nlText = "Bronckhorst",
        )

        P {
            LangText(
                nl = "Kom binnenkort terug om meer te zien.",
                en = "Come back soon to see more.",
            )
        }
    }
}
