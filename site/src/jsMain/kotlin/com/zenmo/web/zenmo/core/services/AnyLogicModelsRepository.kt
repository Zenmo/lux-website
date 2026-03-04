package com.zenmo.web.zenmo.core.services

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import energy.lux.site.shared.AnyLogicModel
import kotlin.js.Date

object AnyLogicModelsRepository {
    private val service = ModelService()
    var models by mutableStateOf<List<AnyLogicModel>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    suspend fun loadModelsIfNeeded() {
        if (models.isNotEmpty()) return // already loaded

        isLoading = true
        try {
            models = service.getAllModels()
        } catch (e: Exception) {
            console.error("Failed to load models", e)
        } finally {
            isLoading = false
        }
    }

    fun getDateForUuid(uuid: String): Date? {
        val model = models.find { it.uuid == uuid } ?: return null
        return Date(model.lastModifiedDate)
    }
}