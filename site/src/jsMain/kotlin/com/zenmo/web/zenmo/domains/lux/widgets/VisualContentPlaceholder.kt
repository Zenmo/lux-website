package com.zenmo.web.zenmo.domains.lux.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.BoxShadow
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLan
import com.varabyte.kobweb.silk.theme.shapes.Circle
import com.varabyte.kobweb.silk.theme.shapes.clip
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.P


@Composable
fun VisualContentPlaceholder(
    descriptionText: LocalizedText = LocalizedText(
        en = "Come back soon to see the interactive model!",
        nl = "Kom snel terug om het interactieve model te zien!"
    ),
    icon: @Composable () -> Unit = {
        MdiLan(Modifier.fontSize(32.px))
    },
) {
    Box(
        modifier = Modifier
            .minHeight(45.vh)
            .fillMaxWidth()
            .background(Colors.White)
            .boxShadow(
                BoxShadow.of(0.px, 6.px, 20.px, 0.px, rgba(0, 0, 0, 0.19f))
            )
            .luxBorderRadius(LuxCornerRadius.xl),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Box(
                Modifier
                    .size(64.px)
                    .background(SitePalette.light.primary.lightened(0.85f))
                    .color(SitePalette.light.primary)
                    .clip(shape = Circle()),
                contentAlignment = Alignment.Center
            ) {
                icon()
            }
            P(
                Modifier
                    .color(SitePalette.light.primary)
                    .maxWidth(300.px)
                    .textAlign(TextAlign.Center)
                    .toAttrs()
            ) {
                LangText(
                    en = descriptionText.en,
                    nl = descriptionText.nl
                )
            }
        }
    }
}