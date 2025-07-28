package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.zenmo.web.zenmo.components.widgets.CardLink
import com.zenmo.web.zenmo.domains.lux.subdomains.LuxSubdomains
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.DrechstedenTwin
import com.zenmo.web.zenmo.pages.SiteGlobals
import kotlinx.browser.window
import org.jetbrains.compose.web.css.cssRem

@Composable
fun TwinModelsGrid(
    models: List<DrechstedenTwin>,
    path: String,
) =
    SimpleGrid(
        numColumns = numColumns(base = 1, sm = 2, md = 2, lg = 3, xl = 3),
        modifier = Modifier.Companion.gap(2.cssRem)
    ) {
        val protocol = window.location.protocol
        val url = "${protocol}//${LuxSubdomains.DRECHTSTEDEN.domainName}.${SiteGlobals.LUX_DOMAIN}/$path"

        models.forEach { model ->
            CardLink(
                url = "$url/${model.name}",
                imageUrl = model.image,
                imageAltText = model.title,
                nlTitle = model.title,
                enTitle = model.title,
                modifier = Modifier.Companion.fillMaxHeight(),
            )
        }
    }