package energy.lux.frontend.core.models

import energy.lux.frontend.core.services.localization.LocalizedText

interface SimpleMenuItem {
    /**
     * URL ready to be passed to a Link composable or anchor element.
     * Includes the locale prefix /en /nl if applicable.
     */
    val url: String
    val label: LocalizedText
}
