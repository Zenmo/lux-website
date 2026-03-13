package com.zenmo.web.zenmo.domains.lux.widgets

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.core.services.localization.LocalLanguage
import kotlin.js.Date

@Composable
fun Date.localizedDateText(
    options: Date.LocaleOptions = js("{month: 'short', year: 'numeric'}")
): String {
    val currentLanguage = LocalLanguage.current
    return this.toLocaleString(currentLanguage.shortCode, options)
}