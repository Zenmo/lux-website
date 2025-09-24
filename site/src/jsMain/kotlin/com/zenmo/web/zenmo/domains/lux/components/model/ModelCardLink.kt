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
import com.zenmo.web.zenmo.components.widgets.CardLink
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.Span

@Composable
fun ModelCardLink(
    model: TwinModel,
    url: String,
    modifier: Modifier = Modifier.Companion.fillMaxHeight(),
) {
    CardLink(
        url = url,
        imageUrl = model.image,
        imageAltText = model.title,
        nlTitle = model.title,
        enTitle = model.title,
        modifier = modifier,
        description = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.Companion.fillMaxWidth()
            ) {
                Span(
                    Modifier.Companion.color(SitePalette.Companion.light.primary)
                        .toAttrs()
                ) {
                    LangText(
                        nl = "Bekijk »",
                        en = "View »",
                    )
                }

                if (model.isPrivate) LockIcon()
            }
        }
    )
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