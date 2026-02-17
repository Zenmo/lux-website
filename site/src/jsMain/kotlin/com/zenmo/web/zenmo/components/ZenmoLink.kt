package com.zenmo.web.zenmo.components

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.InlineLink

@Composable
fun ZenmoLink() {
    InlineLink(
        destinationUrl = "https://zenmo.com.",
        enLinkText = "Zenmo",
        nlLinkText = "Zenmo"
    )
}