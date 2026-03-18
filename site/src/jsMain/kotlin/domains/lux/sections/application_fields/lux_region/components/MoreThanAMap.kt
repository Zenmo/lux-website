package domains.lux.sections.application_fields.lux_region.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.gap
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.domains.lux.components.LuxSectionContainer
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P


@Composable
fun MoreThanAMap() {
    LuxSectionContainer(
        modifier = Modifier
            .background(SitePalette.light.overlay)
            .alignItems(AlignItems.FlexStart)
            .gap(1.cssRem),
    ) {
        HeaderText(
            enText = "More than a map",
            nlText = "Meer dan een kaart",
        )
        Div {
            P {
                LangText(
                    en = """
                        LUX visualizes the energy system on a map, but in the background, it is much more than a map. 
                        It is an interactive tool with a powerful computing core. This computing core can simulate 
                        complex energy dynamics aimed at the smart control of local energy systems.
                    """.trimIndent(),
                    nl = """
                        LUX visualiseert het energiesysteem op een kaart, maar is op de achtergrond veel meer dan een
                        kaart. Het is een interactieve tool met een krachtige rekenkern. Deze rekenkern kan complexe
                        energiedynamieken simuleren gericht op slimme aansturing van lokale energiesystemen.
                    """.trimIndent()
                )
            }

            P {
                LangText(
                    en = """
                        Consider the deployment of neighborhood batteries, home batteries, and smart charging to combat 
                        grid congestion. And the benefits of a district heating network compared to heat pumps for the 
                        electricity grid. We do this by means of agent-based simulation models, in which every 
                        household or neighborhood can control the flexibility options in the home or area based on its 
                        own energy balance or price incentives.
                    """.trimIndent(),
                    nl = """
                        Denk aan het inzetten van buurtbatterijen, thuisbatterijen en slim laden tegen netcongestie. 
                        En de voordelen van een warmtenet ten opzichte van warmtepompen voor het elektriciteitsnet. Dit
                        doen wij door middel van agent-based simulatie modellen, waarin ieder huishouden of buurt op
                        haar eigen energiebalans of prijsprikkels de flexibiliteits-opties in het huis of gebied kan 
                        aansturen.
                    """.trimIndent()
                )
            }
        }
    }
}