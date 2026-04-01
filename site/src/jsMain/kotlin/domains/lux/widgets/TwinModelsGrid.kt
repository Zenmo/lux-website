package energy.lux.frontend.domains.lux.widgets

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import energy.lux.frontend.core.services.anyLogicModels.LocalModelsViewModel
import energy.lux.frontend.domains.lux.core.TwinModelCardItem
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent

@Composable
fun TwinModelsGrid(
    models: List<TwinModelCardItem>,
) {
    val viewModel = LocalModelsViewModel.current
    val uiState by viewModel.uiState.collectAsState()

    val modelsWithDate = remember(models, uiState.models) {
        viewModel.addDateToTwinModels(models)
    }

    if (models.isEmpty()) {
        HeaderText(
            enText = "No models available yet.",
            nlText = "Nog geen modellen beschikbaar."
        )
    }
    SimpleGrid(
        numColumns = numColumns(
            base = 1,
            sm = 2,
            md = minOf(models.size, 3),
            lg = minOf(models.size, 4),
            xl = minOf(models.size, 4)
        ),
        modifier = Modifier.gap(2.cssRem)
    ) {
        modelsWithDate.forEach { model ->
            ModelCard(
                model = model.twinModel,
                showLock = model.twinModel.isPrivate,
                lastModifiedDate = model.lastModifiedDate,
                modifier = Modifier.minHeight(100.percent)
            )
        }
    }
}