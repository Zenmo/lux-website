package energy.lux.site.frontend.domains.lux.subdomains.brabant.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.theme.SitePalette

@Composable
fun BrabantIndex() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        HeaderText(
            enText = "Brabant",
            nlText = "Brabant",
            modifier = Modifier.color(SitePalette.light.primary)
        )
    }
}