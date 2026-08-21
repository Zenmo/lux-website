package energy.lux.frontend.domains.zenmo.pages.models

import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.core.TwinModelCard

data class ShowcasedModel(
    val model: TwinModelCard,
    val description: LocalizedText,
)