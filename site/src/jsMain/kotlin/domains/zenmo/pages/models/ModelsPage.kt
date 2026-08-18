package energy.lux.frontend.domains.zenmo.pages.models

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignSelf
import energy.lux.frontend.components.widgets.SectionContainer
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.core.services.localization.localizedUrl
import energy.lux.frontend.domains.lux.sections.nav_header.luxModelsMenuItem
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.domains.zenmo.components.layouts.ZenmoPageLayout
import energy.lux.frontend.domains.zenmo.sections.nav_header.zenmoModelsMenuItem
import energy.lux.frontend.domains.zenmo.widgets.MoreInfoLink
import energy.lux.frontend.pages.SiteGlobals
import org.jetbrains.compose.web.css.AlignSelf

@Composable
fun ModelsPage() {
    ZenmoPageLayout(zenmoModelsMenuItem.route.label) {
        SectionContainer {
            HeaderText(enText = "Interactive energy models", nlText = "Interactieve energiemodellen")
            ShowcaseModelsGrid()
            MoreInfoLink(
                url = localizedUrl(SiteGlobals.LUX_DOMAIN, luxModelsMenuItem.route.path),
                text = LocalizedText(
                    en = "See more models",
                    nl = "Bekijk meer modellen"
                ),
                modifier = Modifier.alignSelf(AlignSelf.FlexEnd),
            )
        }
    }
}