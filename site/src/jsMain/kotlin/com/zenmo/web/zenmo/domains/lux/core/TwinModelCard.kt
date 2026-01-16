package com.zenmo.web.zenmo.domains.lux.core

import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.sections.application_fields.ApplicationArea

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

    // Tokens used for searching/filtering twin models.
    val searchTokens: List<String>
        get() = listOf(
            label.en,
            label.nl,
        )
}

val TwinModelCard.isPrivate get() = this is PrivateTwinModel
