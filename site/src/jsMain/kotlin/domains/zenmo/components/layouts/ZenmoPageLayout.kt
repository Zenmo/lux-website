package energy.lux.frontend.domains.zenmo.components.layouts

import androidx.compose.runtime.Composable
import energy.lux.frontend.components.layouts.PageLayout
import energy.lux.frontend.core.services.localization.LocalLanguage
import energy.lux.frontend.core.services.localization.LocalizedText


@Composable
fun ZenmoPageLayout(
    pageTitle: LocalizedText,
    content: @Composable () -> Unit,
) = PageLayout(
    title = LocalLanguage.current.translate(pageTitle.en, pageTitle.nl)
) {
    content()
}