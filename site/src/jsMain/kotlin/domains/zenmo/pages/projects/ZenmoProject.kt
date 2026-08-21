package energy.lux.frontend.domains.zenmo.pages.projects

import energy.lux.frontend.core.services.localization.LocalizedText

data class ZenmoProject(
    val imageUrl: String = "",
    val url: String = "",
    val categoryText: LocalizedText = LocalizedText(""),
    val titleText: LocalizedText = LocalizedText(""),
    val descriptionText: LocalizedText = LocalizedText(""),
)