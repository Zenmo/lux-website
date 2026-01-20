package com.zenmo.web.zenmo.domains.lux.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.zenmo.web.zenmo.domains.lux.core.TwinModelCardItem
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent

@Composable
fun TwinModelsGrid(
    models: List<TwinModelCardItem>,
) {
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
        models.forEach { model ->
            ModelCard(
                model = model,
                showLock = model.isPrivate,
                modifier = Modifier.minHeight(100.percent)
            )
        }
    }
}