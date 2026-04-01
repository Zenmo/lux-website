package energy.lux.frontend.components.widgets

import androidx.compose.runtime.Composable
import energy.lux.frontend.core.services.localization.LocalLanguage
import org.jetbrains.compose.web.dom.Text

@Composable
fun LangText(
    en: String? = null,
    nl: String? = null,
) {
    val language = LocalLanguage.current
    Text(language.translate(en = en, nl = nl))
}


