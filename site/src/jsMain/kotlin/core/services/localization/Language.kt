package energy.lux.frontend.core.services.localization

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.compositionLocalOf


sealed class Language {
    abstract fun translate(en: String?, nl: String?): String
    abstract val shortCode: String

    data object Dutch : Language() {
        override fun translate(en: String?, nl: String?): String = nl ?: en ?: ""
        override val shortCode = "nl"
    }

    data object English : Language() {
        override fun translate(en: String?, nl: String?): String = en ?: nl ?: ""
        override val shortCode = "en"
    }

    companion object {
        fun toggleLanguage(current: Language): Language = when (current) {
            English -> Dutch
            Dutch -> English
        }

        fun fromNavigatorCodesToLanguage(codes: List<String>): Language {
            codes.forEach { code ->
                when {
                    code.startsWith(English.shortCode) -> return English
                    code.startsWith(Dutch.shortCode) -> return Dutch
                }
            }

            return Dutch
        }

        fun fromShortcodeToLanguage(code: String): Language? = when (code) {
            English.shortCode -> English
            Dutch.shortCode -> Dutch
            else -> null
        }
    }
}

val LocalLanguage = compositionLocalOf<Language> { error("Unknown Language") }

@Composable
fun LanguageProvider(content: @Composable () -> Unit) {
    val language = LanguageManager.language.collectAsState()

    CompositionLocalProvider(LocalLanguage provides language.value) {
        content()
    }
}
