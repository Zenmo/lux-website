package energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.padding
import energy.lux.frontend.components.widgets.LangText
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.domains.lux.components.LuxSectionContainer
import energy.lux.frontend.domains.lux.core.toTwinModelCardItem
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.OssGisMap
import energy.lux.frontend.domains.lux.subdomains.private_subdomains.oss.ossTwinModels
import energy.lux.frontend.domains.lux.widgets.TwinModelsGrid
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.P


@Composable
fun OssIndex() {
    SectionContainer(
        modifier = Modifier.padding(top = 2.cssRem, bottom = 1.cssRem),
    ) {
        HeaderText(
            enText = "Oss Energy Twins",
            nlText = "Oss Energy Twins",
        )

        P {
            LangText(
                en = "Explore the energy dynamics of this industrial center.",
                nl = "Verken de energiedynamieken van deze industriestad.",
            )
        }
    }

    OssGisMap()

    LuxSectionContainer(
        modifier = Modifier.backgroundColor(SitePalette.light.overlay)
    ) {
        TwinModelsGrid(
            models = ossTwinModels.map {
                it.toTwinModelCardItem()
            }
        )
    }
}
