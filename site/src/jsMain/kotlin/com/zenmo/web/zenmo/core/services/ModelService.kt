package com.zenmo.web.zenmo.core.services

import com.varabyte.kobweb.core.AppGlobals
import energy.lux.site.shared.AnyLogicModel
import web.http.fetch
import web.url.URL


sealed class AnyLogicModelsUiState {
    object Loading : AnyLogicModelsUiState()
    data class Success(val models: List<AnyLogicModel>) : AnyLogicModelsUiState()
    data class Error(val message: String) : AnyLogicModelsUiState()
}

interface ModelsDataSource {
    suspend fun getAllModels(): List<AnyLogicModel>
}

class ModelService(
    private val backendUrl: String = AppGlobals.getValue("BACKEND_URL"),
) : ModelsDataSource {
    override suspend fun getAllModels(): List<AnyLogicModel> {
        val response = fetch(URL(backendUrl).apply { pathname = "/api/anylogic-models" })
        if (response.status != 200.toShort()) {
            throw Exception(response.text())
        }
        return AnyLogicModel.listFromJson(response.text())
    }
}

