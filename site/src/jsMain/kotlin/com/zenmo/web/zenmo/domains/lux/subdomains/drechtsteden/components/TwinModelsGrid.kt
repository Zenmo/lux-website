package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.zenmo.web.zenmo.components.widgets.CardLink
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.LuxTwinModel
import com.zenmo.web.zenmo.pages.SiteGlobals
import com.zenmo.web.zenmo.theme.SitePalette
import kotlinx.browser.window
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Span

@Composable
fun TwinModelsGrid(
    models: List<LuxTwinModel>,
    path: String,
) {
    SimpleGrid(
        numColumns = numColumns(base = 1, sm = 2, md = 2, lg = 3, xl = 3),
        modifier = Modifier.Companion.gap(2.cssRem)
    ) {
        val luxDomain = SiteGlobals.LUX_DOMAIN
        val protocol = window.location.protocol

        models.forEach { model ->

            CardLink(
                url = model.url(path, protocol, luxDomain),
                imageUrl = model.image,
                imageAltText = model.title,
                nlTitle = model.title,
                enTitle = model.title,
                modifier = Modifier.Companion.fillMaxHeight(),
                description = {
                    Span(
                        Modifier.color(SitePalette.light.primary)
                            .toAttrs()
                    ) {
                        LangText(
                            nl = "Bekijk »",
                            en = "View »",
                        )
                    }
                }
            )
        }
    }
}
