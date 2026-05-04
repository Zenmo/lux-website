package energy.lux.frontend.core.services.localization

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
