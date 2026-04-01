package energy.lux.frontend.components.widgets

import androidx.compose.runtime.Composable
import energy.lux.frontend.core.services.localization.Language
import energy.lux.frontend.core.services.localization.LocalLanguage

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