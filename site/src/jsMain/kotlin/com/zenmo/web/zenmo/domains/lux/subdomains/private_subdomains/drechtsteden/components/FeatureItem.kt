package com.zenmo.web.zenmo.domains.lux.subdomains.private_subdomains.drechtsteden.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.OverflowWrap
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.zenmo.web.zenmo.core.services.localization.LocalizedText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.LuxCornerRadius
import com.zenmo.web.zenmo.theme.styles.luxBorderRadius
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

@Composable
fun FeatureItem(
    text: LocalizedText,
    icon: @Composable () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.px)
            .gap(12.px)
            .luxBorderRadius(LuxCornerRadius.lg)
            .border(1.px, LineStyle.Solid, Colors.LightGrey)
    ) {
        Box(
            Modifier
                .flexShrink(0)
                .size(38.px)
                .luxBorderRadius()
                .background(SitePalette.light.primary.lightened(0.9f))
                .color(SitePalette.light.primary),
            contentAlignment = Alignment.Center
        ) {
            icon()
        }
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.CenterStart
        ) {
            HeaderText(
                enText = text.en,
                nlText = text.nl,
                modifier = Modifier
                    .fontSize(1.cssRem)
                    .overflowWrap(OverflowWrap.Anywhere),
            )
        }
    }
}