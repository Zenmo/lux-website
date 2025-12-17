package energy.lux.site.frontend.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.silk.components.icons.mdi.MdiOpenInNew
import com.zenmo.web.zenmo.pages.SiteGlobals
import com.zenmo.web.zenmo.theme.SitePalette
import kotlinx.browser.window
import org.jetbrains.compose.web.css.cssRem

@Composable
fun ZenmoInlineLink() {
    Row(Modifier.color(SitePalette.light.primary).gap(0.25.cssRem)) {
        val protocol = window.location.protocol
        InlineLink(
            destinationUrl = "$protocol//${SiteGlobals.ZENMO_DOMAIN}",
            enLinkText = "Zenmo Simulations",
            nlLinkText = "Zenmo Simulations",
        )
        MdiOpenInNew()
    }
}