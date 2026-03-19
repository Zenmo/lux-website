package com.zenmo.web.zenmo.core.services.anyLogicModels

import com.zenmo.web.zenmo.domains.lux.core.TwinModelCardItem
import kotlin.js.Date

data class TwinModelWithMetadata(
    val twinModel: TwinModelCardItem,
    val lastModifiedDate: Date?
)