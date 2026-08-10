package energy.lux.frontend.domains.zenmo.pages.models

import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.core.TwinModelCard

data class ShowcasedModel(
    val model: TwinModelCard,
    val description: LocalizedText = LocalizedText(
        nl = """
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et 
            dolore magna aliqua.
        """.trimIndent(),
    ),
)