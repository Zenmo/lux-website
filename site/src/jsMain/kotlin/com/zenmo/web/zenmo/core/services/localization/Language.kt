package com.zenmo.web.zenmo.core.services.localization

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

        fun fromCodeToLanguage(code: String): Language = when {
            code.startsWith("en", ignoreCase = true) -> English
            else -> Dutch
        }

        fun fromUrlPathCodeToLanguage(code: String): Language? = when (code) {
            "en" -> English
            "nl" -> Dutch
            else -> null
        }
    }
}

val LocalLanguage = compositionLocalOf<Language> { error("Unknown Language") }
