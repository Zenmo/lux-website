package energy.lux.frontend.core.services.localization

import com.varabyte.kobweb.navigation.Router
import web.window.window
import kotlin.text.get

interface LanguageChangeHandler {
    fun next()
    fun setLanguage(newLanguage: Language)
}


class DefaultLanguageChangeHandler(
    private val router: Router,
    private val languageManager: LanguageManager = LanguageManager
) : LanguageChangeHandler {
    override fun next() {
        val currentLanguage = languageManager.language.value
        val newLanguage = Language.toggleLanguage(currentLanguage)
        setLanguage(newLanguage)
    }

    override fun setLanguage(newLanguage: Language) {
        val previousLanguage = languageManager.language.value
        languageManager.setLanguage(newLanguage)

        val oldPath = window.location.pathname
        val newPath = oldPath.replace(
            Regex("^/${previousLanguage.shortCode}/(?<rest>.*)")
        ) {
            "/${newLanguage.shortCode}/${it.groups["rest"]?.value ?: ""}"
        }

        if (newPath != oldPath) {
            router.tryRoutingTo(newPath)
        }
    }
}