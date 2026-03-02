package com.zenmo.web.zenmo.core.models

import com.zenmo.web.zenmo.core.services.localization.LocalizedText

interface SimpleMenuItem {
    /**
     * URL ready to be passed to a Link composable or anchor element.
     * Includes the locale prefix /en /nl if applicable.
     */
    val url: String
    val label: LocalizedText
}
