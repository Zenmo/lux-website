package com.zenmo.web.zenmo.domains.lux.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.zenmo.web.zenmo.domains.lux.components.model.TwinModel
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.pages.SiteGlobals
import kotlinx.browser.window
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent

@Composable
fun TwinModelsGrid(
    models: List<TwinModel>,
    path: String,
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
        modifier = Modifier.Companion.gap(2.cssRem)
    ) {
        val luxDomain = SiteGlobals.LUX_DOMAIN
        val protocol = window.location.protocol

        models.forEach { model ->
            ModelCard(
                url = model.url(path, protocol, luxDomain),
                model = model,
                modifier = Modifier.minHeight(100.percent)
            )
        }
    }
}