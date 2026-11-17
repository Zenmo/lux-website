package energy.lux.frontend.domains.zenmo.components.layouts

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gridRow
import energy.lux.frontend.components.layouts.PageLayout
import energy.lux.frontend.core.services.localization.LocalLanguage
import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.zenmo.sections.footer.ZenmoFooter
import energy.lux.frontend.domains.zenmo.sections.nav_header.NavHeader
import energy.lux.frontend.domains.zenmo.sections.nav_header.zenmoNavMenu


@Composable
fun ZenmoPageLayout(
    pageTitle: LocalizedText,
    content: @Composable () -> Unit,
) = PageLayout(
    title = LocalLanguage.current.translate(pageTitle.en, pageTitle.nl),
    header = { NavHeader(zenmoNavMenu) },
    footer = { ZenmoFooter(Modifier.gridRow(2)) },
) {
    content()
}