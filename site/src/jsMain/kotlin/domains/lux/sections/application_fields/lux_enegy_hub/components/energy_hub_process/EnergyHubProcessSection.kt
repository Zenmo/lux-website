package energy.lux.frontend.domains.lux.sections.application_fields.lux_enegy_hub.components.energy_hub_process

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.textTransform
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.domains.lux.components.LuxSectionContainer
import energy.lux.frontend.domains.lux.sections.application_fields.lux_enegy_hub.components.GetStarted
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.theme.SitePalette
import com.zenmo.web.zenmo.theme.font.HeaderTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import energy.lux.frontend.utils.PublicRes
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text


@Composable
fun EnergyHubProcessSection() {
    LuxSectionContainer(
        modifier = Modifier.alignItems(AlignItems.FlexStart),
    ) {
        H1(
            TextStyle.toModifier(HeaderTextStyle)
                .fontFamily(PublicRes.FontFamilies.HOLON_LINE)
                .textTransform(TextTransform.None)
                .toAttrs()
        ) {
            HeaderText(
                enText = "The Process",
                nlText = "Het Proces",
                textColor = SitePalette.light.primary
            )
            Text(" - ")
            LangText(
                en = "Setting up LUX Energy Hub",
                nl = "Hoe start ik LUX Energy Hub",
            )
        }
        Column(
            modifier = Modifier.gap(2.cssRem)
        ) {
            Step01()
            Step02()
            Step03()
            Step04()
        }
        GetStarted()
    }
}
