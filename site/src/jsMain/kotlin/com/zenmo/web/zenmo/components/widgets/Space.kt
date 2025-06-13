package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Text

@Composable
fun Space() {
    // non-breaking space
    Text("\u00A0")
}
