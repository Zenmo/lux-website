package com.zenmo.web.zenmo.domains.lux.components.model

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLock
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.zenmo.web.zenmo.components.widgets.CardLink
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.pages.SiteGlobals
import com.zenmo.web.zenmo.theme.SitePalette
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.Span

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

            CardLink(
                url = model.url(path, protocol, luxDomain),
                imageUrl = model.image,
                imageAltText = model.title,
                nlTitle = model.title,
                enTitle = model.title,
                modifier = Modifier.Companion.fillMaxHeight(),
                description = {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Span(
                            Modifier.color(SitePalette.light.primary)
                                .toAttrs()
                        ) {
                            LangText(
                                nl = "Bekijk »",
                                en = "View »",
                            )
                        }

                        when (model) {
                            is SubdomainModel -> if (model.isPrivate) LockIcon()
                            is DrechtstedenTwinModel -> LockIcon()
                        }
                    }
                }
            )
        }
    }
}

@Composable
private fun LockIcon() {
    Box(
        Modifier.width(auto)
            .height(auto)
            .background(SitePalette.light.primary)
            .color(Color.white)
            .padding(0.25.cssRem)
            .borderRadius(50.percent),
        contentAlignment = Alignment.Center
    ) {
        MdiLock(Modifier.scale(0.75))
    }
}