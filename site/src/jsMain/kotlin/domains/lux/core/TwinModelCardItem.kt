package energy.lux.frontend.domains.lux.core

import energy.lux.frontend.core.services.localization.LocalizedText
import energy.lux.frontend.domains.lux.sections.application_fields.ApplicationArea
import kotlin.uuid.Uuid

data class TwinModelCardItem(
    override val label: LocalizedText,
    override val imageUrl: String,
    override val url: String,
    override val applicationArea: ApplicationArea,
    override val modelId: Uuid = Uuid.NIL,
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
    modelId = modelId,
    // infers privacy from interface type
    isPrivate = this is PrivateTwinModel
)