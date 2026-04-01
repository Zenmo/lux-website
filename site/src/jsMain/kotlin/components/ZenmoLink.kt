package energy.lux.frontend.components

import androidx.compose.runtime.Composable
import energy.lux.frontend.components.widgets.InlineLink

@Composable
fun ZenmoLink() {
    InlineLink(
        destinationUrl = "https://zenmo.com.",
        enLinkText = "Zenmo",
        nlLinkText = "Zenmo"
    )
}