package com.zenmo.web.zenmo.domains.lux.components.model

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.zenmo.web.zenmo.pages.SiteGlobals
import kotlinx.browser.window
import org.jetbrains.compose.web.css.cssRem

@Composable
fun TwinModelsGrid(
    models: List<TwinModel>,
    path: String,
) {
    SimpleGrid(
        numColumns = numColumns(base = 1, sm = 2, md = 2, lg = minOf(models.size, 3), xl = minOf(models.size, 3)),
        modifier = Modifier.Companion.gap(2.cssRem)
    ) {
        val luxDomain = SiteGlobals.LUX_DOMAIN
        val protocol = window.location.protocol

        models.forEach { model ->
            ModelCardLink(
                url = model.url(path, protocol, luxDomain),
                model = model,
            )
        }
    }
}