package com.zenmo.web.zenmo.core.services.anyLogicModels

import energy.lux.site.shared.AnyLogicModel

data class ModelsUiState(
    val models: List<AnyLogicModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)