package com.zenmo.web.zenmo.core.services.anyLogicModels

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenmo.web.zenmo.domains.lux.core.PublicTwinModel
import com.zenmo.web.zenmo.domains.lux.core.TwinModelCardItem
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class ModelsViewModel(
    private val service: ModelService = ModelService()
) : ViewModel() {

    val uiState: StateFlow<ModelsUiState>
        field = MutableStateFlow(ModelsUiState())

    init {
        loadModels()
    }

    private fun loadModels() {
        viewModelScope.launch {
            uiState.update { it.copy(isLoading = true, error = null) }

            try {
                val models = service.getAllModels()
                uiState.update { it.copy(models = models, isLoading = false) }
            } catch (e: Exception) {
                uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "Failed to load models"
                    )
                }
            }
        }
    }

    fun addDateToTwinModels(
        twinModelCards: List<TwinModelCardItem>
    ): List<TwinModelWithMetadata> {
        val anyLogicModels = uiState.value.models

        return twinModelCards.map { card ->
            val modelDate = if (card is PublicTwinModel) {
                anyLogicModels.getModelDateForUuid(card.modelId.toString())
            } else null

            TwinModelWithMetadata(
                twinModel = card,
                lastModifiedDate = modelDate
            )
        }
    }
}

val LocalModelsViewModel = staticCompositionLocalOf<ModelsViewModel> {
    error("No ModelsViewModel provided")
}

@Composable
fun ModelsViewModelProvider(content: @Composable () -> Unit) {
    val viewModel = remember { ModelsViewModel() }

    CompositionLocalProvider(LocalModelsViewModel provides viewModel) {
        content()
    }
}

