package energy.lux.frontend.components.widgets

import androidx.compose.runtime.Composable
import energy.lux.frontend.core.services.localization.LocalLanguage
import energy.lux.frontend.core.services.localization.LocalizedText
import org.jetbrains.compose.web.dom.Text

@Composable
fun LangText(
    nl: String,
    en: String = nl,
) {
    val language = LocalLanguage.current
    Text(language.translate(en = en, nl = nl))
}

@Composable
fun LangText(text: LocalizedText) {
    LangText(nl = text.nl, en = text.en)
}