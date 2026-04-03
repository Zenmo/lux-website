package energy.lux.frontend.domains.lux.core

import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.sections.application_fields.ApplicationArea
import kotlin.uuid.Uuid

/**
 * UI-facing representation of a twin model used in grids,
 * search, and navigation cards.
 * @see TwinModelCardItem
 */
interface TwinModelCard {
    val label: LocalizedText
    val imageUrl: String
    val url: String
    val applicationArea: ApplicationArea
    val modelId: Uuid

    // Tokens used for searching/filtering twin models.
    val searchTokens: List<String>
        get() = listOf(
            label.en,
            label.nl,
        )
}

val TwinModelCard.isPrivate get() = this is PrivateTwinModel
