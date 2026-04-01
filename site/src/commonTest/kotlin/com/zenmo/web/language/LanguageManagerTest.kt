package com.zenmo.web.language

import energy.lux.frontend.core.services.localization.Language
import energy.lux.frontend.core.services.localization.LanguageManager
import kotlin.test.Test
import kotlin.test.assertEquals


class LanguageManagerTest {
    @Test
    fun TogglesLanguageFromEnglishToDutch() {
        LanguageManager.setLanguage(Language.English)
        LanguageManager.toggleLanguage()
        assertEquals(Language.Dutch, LanguageManager.language.value)
    }

}