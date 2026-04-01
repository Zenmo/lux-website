package energy.lux.frontend.domains.lux.core

import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.sections.application_fields.ApplicationArea

data class TwinModelCardItem(
    override val label: LocalizedText,
    override val imageUrl: String,
    override val url: String,
    override val applicationArea: ApplicationArea,
    val isPrivate: Boolean
) : TwinModelCard


/**
 * Projects a domain twin model into a UI card model
 */
fun TwinModelCard.toTwinModelCardItem() = TwinModelCardItem(
    label = label,
    imageUrl = imageUrl,
    url = url,
    applicationArea = applicationArea,
    // infers privacy from interface type
    isPrivate = this is PrivateTwinModel
)