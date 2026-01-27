package com.zenmo.web.zenmo.domains.lux.subdomains.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.icons.mdi.MdiPlayArrow
import com.zenmo.web.zenmo.components.widgets.LangText
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba

@Composable
fun StartAnylogicSimulationOverlay(
    onSimulateClick: () -> Unit,
    enabled: Boolean,
) {
    Box(
        Modifier
            .fillMaxSize()
            .position(Position.Absolute)
            .background(rgba(225, 225, 225, 0f))
            .backdropFilter(blur(10.px)),
        contentAlignment = Alignment.Center
    ) {
        Button(
            modifier = Modifier
                .fontWeight(FontWeight.Normal),
            onClick = { onSimulateClick() },
            enabled = enabled,
        ) {
            Row(
                modifier = Modifier.gap(0.5.cssRem),
                verticalAlignment = Alignment.CenterVertically
            ) {
                MdiPlayArrow()
                LangText(
                    en = "Start Simulation",
                    nl = "Start Simulatie",
                )
            }
        }
    }
}