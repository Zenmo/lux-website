package com.zenmo.web.zenmo.core.services

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import energy.lux.site.shared.AnyLogicModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


data class ModelsUiState(
    val models: List<AnyLogicModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

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

