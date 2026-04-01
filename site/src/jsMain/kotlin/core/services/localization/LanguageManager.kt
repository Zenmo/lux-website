package energy.lux.frontend.core.services.localization

import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.w3c.dom.HTMLElement


/**
 * Singleton object to manage the website's language responsibly.
 */
object LanguageManager {
    private const val LANGUAGE_MODE_KEY = "zenmo:site-lang"

    /** backing property for the current language state,
    initialized with the language from
    - local storage,
    - navigator, or
    - URL parameters */
    private val _language = MutableStateFlow(getLanguage())

    val language: StateFlow<Language> = _language.asStateFlow()

    private fun getLanguageFromLocalStorage(): Language? {
        val storedLang = window.localStorage.getItem(LANGUAGE_MODE_KEY)
        return storedLang?.let { Language.fromShortcodeToLanguage(it) }
    }

    private fun getLanguageFromPath(): Language? {
        val firstPathComponent = window.location.pathname.split("/").getOrNull(1)
        return firstPathComponent?.let { Language.fromShortcodeToLanguage(it) }
    }

    private fun getLanguageFromNavigator(): Language {
        val languageCodes = window.navigator.languages.toList()
        return Language.fromNavigatorCodesToLanguage(languageCodes)
    }

    private fun getLanguage(): Language {
        return getLanguageFromPath()
            ?: getLanguageFromLocalStorage()
            ?: getLanguageFromNavigator()
    }

    //Update current language, local storage and html "lang" attribute to reflect the change.
    // making this publicly available for testing purposes
    fun setLanguage(newLanguage: Language) {
        _language.value = newLanguage
        val langCode = newLanguage.shortCode
        window.localStorage.setItem(LANGUAGE_MODE_KEY, langCode)
        val htmlElement = document.documentElement as HTMLElement
        htmlElement.lang = langCode
    }

    fun toggleLanguage() = setLanguage(Language.toggleLanguage(_language.value))
}
