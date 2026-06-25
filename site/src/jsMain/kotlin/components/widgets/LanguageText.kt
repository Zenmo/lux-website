package energy.lux.frontend.components.widgets

import androidx.compose.runtime.Composable
import energy.lux.frontend.core.services.localization.LocalLanguage
import org.jetbrains.compose.web.dom.Text

@Composable
fun LangText(
    nl: String,
    en: String = nl,
) {
    val language = LocalLanguage.current
    Text(language.translate(en = en, nl = nl))
}