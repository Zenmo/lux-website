package com.zenmo.web.zenmo.core.services.anyLogicModels

import energy.lux.site.shared.AnyLogicModel
import kotlin.js.Date

fun List<AnyLogicModel>.getModelDateForUuid(uuid: String): Date? {
    val model = this.find { it.uuid == uuid }
    return model?.let { Date(it.lastModifiedDate) }
}