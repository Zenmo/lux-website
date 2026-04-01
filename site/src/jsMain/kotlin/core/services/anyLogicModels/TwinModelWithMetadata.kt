package energy.lux.frontend.core.services.anyLogicModels

import energy.lux.frontend.domains.lux.core.TwinModelCardItem
import kotlin.js.Date

data class TwinModelWithMetadata(
    val twinModel: TwinModelCardItem,
    val lastModifiedDate: Date?
)