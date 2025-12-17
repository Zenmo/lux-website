package energy.lux.site.frontend.domains.lux.sections.home.faqs

import com.zenmo.web.zenmo.core.services.localization.LocalizedText

data class FaqItem(
    val question: LocalizedText,
    val answer: LocalizedText? = null, // will be added later
) {
    companion object {
        val faqs = listOf(
            FaqItem(
                question = LocalizedText(
                    en = "How do I apply LUX as a business?",
                    nl = "Hoe pas ik LUX toe als bedrijf?"
                ),
            ),
            FaqItem(
                question = LocalizedText(
                    en = "How do I apply LUX as a policy maker?",
                    nl = "Hoe pas ik LUX toe als beleidsmaker?"
                ),
            ),
            FaqItem(
                question = LocalizedText(
                    en = "How do I apply LUX as a energy cooperation?",
                    nl = "Hoe pas ik LUX toe als energiecoöperatie?"
                ),
            ),
            FaqItem(
                question = LocalizedText(
                    en = "How do I apply LUX as a researcher/consultant?",
                    nl = "Hoe pas ik LUX toe als onderzoeker/adviseur?"
                ),
            ),
            FaqItem(
                question = LocalizedText(
                    en = "How is LUX updated and maintained?",
                    nl = "Hoe wordt LUX bijgewerkt en onderhouden?"
                ),
            ),
            FaqItem(
                question = LocalizedText(
                    en = "Where can I find the code base?",
                    nl = "Waar kan ik de codebase vinden?"
                ),
            ),
            FaqItem(
                question = LocalizedText(
                    en = "How does the LUX model work?",
                    nl = "Hoe werkt het LUX-model?"
                ),
            ),
            FaqItem(
                question = LocalizedText(
                    en = "Is there additional software that works with LUX?",
                    nl = "Is er aanvullende software die met LUX werkt?"
                ),
            ),
            FaqItem(
                question = LocalizedText(
                    en = "What data goes into LUX?",
                    nl = "Welke gegevens worden in LUX verwerkt?"
                ),
            ),
            FaqItem(
                question = LocalizedText(
                    en = "How do I upload data into LUX?",
                    nl = "Hoe upload ik gegevens in LUX?"
                ),
            ),
            FaqItem(
                question = LocalizedText(
                    en = "How is the electricity grid implemented in LUX?",
                    nl = "Hoe is het elektriciteitsnet geïmplementeerd in LUX?"
                ),
            ),
        )
    }
}