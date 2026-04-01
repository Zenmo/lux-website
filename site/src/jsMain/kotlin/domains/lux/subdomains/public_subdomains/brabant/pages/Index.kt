package energy.lux.frontend.domains.lux.subdomains.public_subdomains.brabant.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import energy.lux.frontend.domains.lux.widgets.headings.HeaderText
import energy.lux.frontend.theme.SitePalette

@Composable
fun BrabantIndex() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        HeaderText(
            enText = "Brabant",
            nlText = "Brabant",
            textColor = SitePalette.light.primary
        )
    }
}