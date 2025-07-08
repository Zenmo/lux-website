package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.core.services.localization.Language
import com.zenmo.web.zenmo.core.services.localization.LocalLanguage

@Composable
fun LangBlock(
    en: (@Composable () -> Unit)? = null,
    nl: (@Composable () -> Unit)? = null,
) {
    val language = LocalLanguage.current
    when (language) {
        Language.English -> en?.invoke()
        Language.Dutch -> nl?.invoke()
    }
}